package pl.carRental.carRental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.carRental.carRental.dao.CarDAO;
import pl.carRental.carRental.dao.LeaseDAO;
import pl.carRental.carRental.model.Car;
import pl.carRental.carRental.model.Lease;

import java.util.List;

@Service
public class LeaseService {

    @Autowired
    private LeaseDAO leaseDAO;

    public List<Lease> getAllLease()
    {
        return leaseDAO.findAll();
    }
    public void addLease(Lease lease)
    {
        leaseDAO.save(lease);
    }
    public Lease findLease(Long id)
    {
        return leaseDAO.findById(id).get();
    }
    public void deleteLease(Long id)
    {
        leaseDAO.deleteById(id);
    }
}
