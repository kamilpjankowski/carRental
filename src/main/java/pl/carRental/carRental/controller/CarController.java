package pl.carRental.carRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.carRental.carRental.model.Car;
import pl.carRental.carRental.model.Lease;
import pl.carRental.carRental.service.CarService;
import pl.carRental.carRental.service.LeaseService;

import java.util.List;

@Controller
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/allCars")
    public String getAllCars(Model model) {
        List<Car> carList = carService.getAllCars();
        model.addAttribute("carList", carList);
        return "car_list"; //html template
    }

    @RequestMapping("/addCar")
    public String addCar(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "add_car"; //html template
    }

    @PostMapping("/saveCar")
    public String saveCar(Car car) {
        carService.addCar(car);
        return "redirect:/allCars";
    }

    @RequestMapping("/deleteCar/{id}")
    public String deleteCar(@PathVariable(name = "id") Long id) {
        carService.deleteCar(id);
        return "redirect:/allCars";
    }

    @RequestMapping("/editCar/{id}")
    public ModelAndView editCar(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_car");
        Car car = carService.findCar(id);
        mav.addObject("car",car);
        return mav;
    }
}
