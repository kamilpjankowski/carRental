package pl.carRental.carRental.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.carRental.carRental.model.Lease;

@Repository
public interface LeaseDAO extends JpaRepository<Lease,Long> {
}
