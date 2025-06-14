package com.moyses.api_system_car;

import com.moyses.api_system_car.domain.model.User;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserModelTest {

    @Test
    void mustCreateUserWithCorrectDataAndGettersMustWork() {
        UUID id = UUID.randomUUID();

        User user = new User(id, "João Silva", 30, "joao.silva@example.com", "senhaSegura", "Rua 123");

        assertEquals(id, user.getId());
        assertEquals("João Silva", user.getName());
        assertEquals(30, user.getAge());
        assertEquals("joao.silva@example.com", user.getEmail());
        assertEquals("senhaSegura", user.getPassword());
        assertEquals("Rua 123", user.getAddress());
    }

    @Test
    void mustChangeDataWithSetters() {
        User user = new User(UUID.randomUUID(), "João Silva", 30, "joao.silva@example.com", "senhaSegura", "Rua 123");

        UUID newId = UUID.randomUUID();

        user.setId(newId);
        user.setName("Maria Souza");

        user.setAge(25);
        user.setEmail("maria.souza@example.com");

        user.setPassword("senhaMaisSegura");

        user.setAddress("Rua 124");

        assertEquals(newId, user.getId());
        assertEquals("Maria Souza", user.getName());
        assertEquals(25, user.getAge());
        assertEquals("maria.souza@example.com", user.getEmail());
        assertEquals("senhaMaisSegura", user.getPassword());
        assertEquals("Rua 124", user.getAddress());
    }
}
