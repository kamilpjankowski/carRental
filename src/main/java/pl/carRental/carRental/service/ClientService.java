package pl.carRental.carRental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.carRental.carRental.dao.CarDAO;
import pl.carRental.carRental.dao.ClientDAO;
import pl.carRental.carRental.model.Car;
import pl.carRental.carRental.model.Client;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientDAO clientDAO;

    public List<Client> getAllClients()
    {
        return clientDAO.findAll();
    }
    public void addClient(Client client)
    {
        clientDAO.save(client);
    }
    public Client findClient(long id)
    {
        return clientDAO.findById(id).get();
    }
    public void deleteClient(long id)
    {
        clientDAO.deleteById(id);
    }
}
