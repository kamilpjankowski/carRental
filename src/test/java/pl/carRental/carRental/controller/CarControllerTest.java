package pl.carRental.carRental.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import pl.carRental.carRental.dao.CarDAO;
import pl.carRental.carRental.model.Car;
import pl.carRental.carRental.model.CarStatus;
import pl.carRental.carRental.service.CarService;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
public class CarControllerTest {

    @Mock
    @Autowired(required = true)
    CarService carService;
    @Autowired
    private MockMvc mvc;


    @Test
    public void shouldAddCar() throws Exception {
        Car car = new Car();
        car.setId(1);
        car.setBrand("Ford");
        car.setModel("Focus");
        car.setColor("red");
        car.setCost(123);
        car.setStatus(CarStatus.AVAILABLE);
        Car car2 = new Car();
        car2.setId(2);
        car2.setBrand("Ford");
        car2.setModel("Focus");
        car2.setColor("red");
        car2.setCost(123);
        car2.setStatus(CarStatus.AVAILABLE);
        carService.addCar(car);
        carService.addCar(car2);
        System.out.println(carService.findCar(1).getColor());


    }


//    @Test
//    void shouldAddCarToList() throws Exception {
//
//        Car car = new Car();
//        car.setId(1);
//        car.setBrand("Ford");
//        car.setModel("Mustang");
//        car.setColor("red");
//        car.setCost(120);
//        car.setStatus(CarStatus.AVAILABLE);
//        carService.addCar(car);
//
//
//        Assertions.assertNotNull(carService.findCar(1));
////        String uri = "/addCar";
////        mockMvc.perform(post(uri))
////                .andExpect(MockMvcResultMatchers.jsonPath("$.brand").value(car.getBrand()))
////                .andExpect(MockMvcResultMatchers.status().isOk())
////        .andDo(MockMvcResultHandlers.print());
//
//
//    }
//
////    @Test
////    void shouldRemoveCarFromList() throws Exception {
////
////
////        mockMvc.perform(MockMvcRequestBuilders.get("/deleteCar/1"))
////                .andDo(MockMvcResultHandlers.print())
////                .andExpect(MockMvcResultMatchers.status().is(200));
////    }


}