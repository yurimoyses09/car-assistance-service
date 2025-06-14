package com.moyses.api_system_car;

import com.moyses.api_system_car.domain.model.Car;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarModelTest {

    @Test
    void mustCreateCarWithCorrectDataAndGettersMustWork(){
        UUID id = UUID.randomUUID();
        UUID idUser = UUID.randomUUID();

        Car car = new Car(id, "Fiat Uno", 2020, "ABC-1234", idUser);

        assertEquals(id, car.getId());
        assertEquals(idUser, car.getIdUser());
        assertEquals("Fiat Uno", car.getModel());
        assertEquals(2020, car.getYear());
        assertEquals("ABC-1234", car.getPlate());
    }

    @Test
    void mustChangeDataWithSetters(){
        Car car = new Car(UUID.randomUUID(), "Fiat Uno", 2020, "ABC-1234", UUID.randomUUID());

        UUID newId = UUID.randomUUID();
        UUID newIdUser = UUID.randomUUID();

        car.setId(newId);
        car.setIdUser(newIdUser);
        car.setModel("Fiat Argo");

        car.setYear(2021);
        car.setPlate("DEF-5678");

        assertEquals(newId, car.getId());
        assertEquals(newIdUser, car.getIdUser());
        assertEquals("Fiat Argo", car.getModel());
        assertEquals(2021, car.getYear());
        assertEquals("DEF-5678", car.getPlate());
    }
}
