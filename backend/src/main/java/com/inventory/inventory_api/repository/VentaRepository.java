package com.inventory.inventory_api.repository;

import com.inventory.inventory_api.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Long> {
}
