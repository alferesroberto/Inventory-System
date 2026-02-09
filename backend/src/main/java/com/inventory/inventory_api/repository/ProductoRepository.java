package com.inventory.inventory_api.repository;

import com.inventory.inventory_api.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ProductoRepository extends
        JpaRepository<Producto, Long>,
        JpaSpecificationExecutor<Producto> {

    Optional<Producto> findBySku(String sku);
}
