package pl.carRental.carRental.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.carRental.carRental.model.Car;

@Repository
public interface CarDAO extends JpaRepository<Car,Long> {
}
