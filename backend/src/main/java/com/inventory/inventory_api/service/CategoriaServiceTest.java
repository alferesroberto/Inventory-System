package com.inventory.inventory_api.service;

import com.inventory.inventory_api.entity.Categoria;
import com.inventory.inventory_api.repository.CategoriaRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoriaServiceTest {

    @Mock
    private CategoriaRepository repository;

    @InjectMocks
    private CategoriaService service;

    @Test
    void listarCategorias() {

        Categoria c = new Categoria();
        c.setNombre("Tecnologia");

        when(repository.findAll()).thenReturn(List.of(c));

        List<Categoria> result = service.listar();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getNombre()).isEqualTo("Tecnologia");
    }
}
