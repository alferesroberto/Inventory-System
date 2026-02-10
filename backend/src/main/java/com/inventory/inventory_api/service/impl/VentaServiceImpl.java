package com.inventory.inventory_api.service.impl;

import com.inventory.inventory_api.dto.*;
import com.inventory.inventory_api.entity.*;
import com.inventory.inventory_api.repository.*;
import com.inventory.inventory_api.service.VentaService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VentaServiceImpl implements VentaService {

    private final ProductoRepository productoRepository;
    private final VentaRepository ventaRepository;

    @Override
    @Transactional
    public VentaResponseDTO procesarVenta(VentaRequestDTO request) {

        Venta venta = new Venta();
        venta.setFechaVenta(LocalDateTime.now());

        List<DetalleVenta> detalles = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;

        for (ItemVentaDTO item : request.items()) {

            Producto producto = productoRepository.findById(item.productoId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            if (producto.getStockActual() < item.cantidad()) {
                throw new RuntimeException(
                        "Stock insuficiente para producto: " + producto.getNombre()
                );
            }

            producto.setStockActual(
                    producto.getStockActual() - item.cantidad()
            );

            DetalleVenta detalle = DetalleVenta.builder()
                    .producto(producto)
                    .cantidad(item.cantidad())
                    .precioUnitario(producto.getPrecio())
                    .build();

            detalles.add(detalle);

            total = total.add(
                    producto.getPrecio().multiply(
                            BigDecimal.valueOf(item.cantidad())
                    )
            );
        }

        venta.setTotal(total);
        venta.setDetalles(detalles);

        detalles.forEach(d -> d.setVenta(venta));

        Venta guardada = ventaRepository.save(venta);

        return mapToDTO(guardada);
    }

    private VentaResponseDTO mapToDTO(Venta venta) {

        List<VentaDetalleResponseDTO> detalleDTOs =
                venta.getDetalles()
                        .stream()
                        .map(d -> new VentaDetalleResponseDTO(
                                d.getProducto().getNombre(),
                                d.getCantidad(),
                                d.getPrecioUnitario()
                        ))
                        .toList();

        return new VentaResponseDTO(
                venta.getId(),
                venta.getFechaVenta(),
                venta.getTotal(),
                detalleDTOs
        );
    }
}
