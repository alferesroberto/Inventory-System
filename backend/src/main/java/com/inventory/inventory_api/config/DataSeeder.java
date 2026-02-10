package com.inventory.inventory_api.config;

import com.inventory.inventory_api.entity.Categoria;
import com.inventory.inventory_api.entity.Producto;
import com.inventory.inventory_api.repository.CategoriaRepository;
import com.inventory.inventory_api.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
@RequiredArgsConstructor
public class DataSeeder {

    private final CategoriaRepository categoriaRepo;
    private final ProductoRepository productoRepo;

    @Bean
    CommandLineRunner initData() {
        return args -> {

            if (categoriaRepo.count() > 0) return;

            Categoria tecnologia = categoriaRepo.save(
                    Categoria.builder()
                            .nombre("Tecnología")
                            .descripcion("Gadgets y electrónicos")
                            .build()
            );

            Categoria hogar = categoriaRepo.save(
                    Categoria.builder()
                            .nombre("Hogar")
                            .descripcion("Productos para casa")
                            .build()
            );

            productoRepo.save(
                    Producto.builder()
                            .sku("TEC-001")
                            .nombre("Laptop Lenovo")
                            .precio(new BigDecimal("1200"))
                            .stockActual(10)
                            .categoria(tecnologia)
                            .build()
            );

            productoRepo.save(
                    Producto.builder()
                            .sku("TEC-002")
                            .nombre("Mouse Logitech")
                            .precio(new BigDecimal("25"))
                            .stockActual(50)
                            .categoria(tecnologia)
                            .build()
            );

            productoRepo.save(
                    Producto.builder()
                            .sku("HOG-001")
                            .nombre("Cafetera")
                            .precio(new BigDecimal("80"))
                            .stockActual(15)
                            .categoria(hogar)
                            .build()
            );

            System.out.println("✔ Datos iniciales cargados");
        };
    }
}

