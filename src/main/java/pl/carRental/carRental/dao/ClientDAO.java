package pl.carRental.carRental.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.carRental.carRental.model.Client;

@Repository
public interface ClientDAO extends JpaRepository<Client,Long> {
}
