package edu.iu.bolabanj.c322spring2024homework2.repository;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class InventoryRepositoryTest {

    @Test
    void addGuitar() throws IOException {
        edu.iu.bolabanj.c322spring2024homework2.respository.InventoryRepository inventoryRepository = new edu.iu.bolabanj.c322spring2024homework2.respository.InventoryRepository();
        inventoryRepository.addGuitar(new edu.iu.bolabanj.c322spring2024homework2.model.Guitar("123", 1000, "Fender", "Stratocaster", "electric", "maple", "maple"));
        edu.iu.bolabanj.c322spring2024homework2.model.Guitar actual = inventoryRepository.getGuitar("123");
        assertEquals("123", actual.getSerialNumber());

        edu.iu.bolabanj.c322spring2024homework2.respository.InventoryRepository inventoryRepository2 = new edu.iu.bolabanj.c322spring2024homework2.respository.InventoryRepository();
        inventoryRepository2.addGuitar(new edu.iu.bolabanj.c322spring2024homework2.model.Guitar("456", 1000, "Fender", "Stratocaster", "electric", "maple", "maple"));
        edu.iu.bolabanj.c322spring2024homework2.model.Guitar actual2 = inventoryRepository2.getGuitar("456");
        assertEquals("456", actual2.getSerialNumber());


    }

    @Test
    void getGuitar() throws IOException {
        edu.iu.bolabanj.c322spring2024homework2.respository.InventoryRepository inventoryRepository = new edu.iu.bolabanj.c322spring2024homework2.respository.InventoryRepository();
        try {
            inventoryRepository.addGuitar(new edu.iu.bolabanj.c322spring2024homework2.model.Guitar("123", 1000, "Fender", "Stratocaster", "electric", "maple", "maple"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        edu.iu.bolabanj.c322spring2024homework2.model.Guitar actual = inventoryRepository.getGuitar("123");
        assertEquals("123", actual.getSerialNumber());
    }

    @Test
    void search() {
        edu.iu.bolabanj.c322spring2024homework2.respository.InventoryRepository inventoryRepository = new edu.iu.bolabanj.c322spring2024homework2.respository.InventoryRepository();
        try {
            inventoryRepository.addGuitar(new edu.iu.bolabanj.c322spring2024homework2.model.Guitar("123", 1000, "Fender", "Stratocaster", "electric", "maple", "maple"));
            inventoryRepository.addGuitar(new edu.iu.bolabanj.c322spring2024homework2.model.Guitar("456", 1000, "Fender", "Stratocaster", "electric", "maple", "maple"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}