package pl.carRental.carRental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.carRental.carRental.dao.CarDAO;
import pl.carRental.carRental.model.Car;
import pl.carRental.carRental.model.CarStatus;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private CarDAO carDAO;

    public List<Car> getAllCars()
    {
        return carDAO.findAll();
    }
    public List<Car> getAvailableCars()
    {
        return (List<Car>) carDAO.findAll().stream().filter(car -> car.getStatus().equals(CarStatus.AVAILABLE)).collect(Collectors.toList());
    }
    public void addCar(Car car)
    {
        carDAO.save(car);
    }
    public Car findCar(long id)
    {
        return carDAO.findById(id).get();
    }
    public void deleteCar(long id)
    {
        carDAO.deleteById(id);
    }


}
