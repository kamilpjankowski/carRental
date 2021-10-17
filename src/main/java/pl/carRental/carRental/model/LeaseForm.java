package pl.carRental.carRental.model;

import java.util.ArrayList;
import java.util.List;

public class LeaseForm {

    private double cost;
    private long clientId;
    private  long carId;
    private boolean completed;

    private List<Car> availableCars;
    private List<Client> clients;

    public LeaseForm() {
    }

    public LeaseForm(List<Car> availableCars, List<Client> clients) {
        availableCars = new ArrayList<Car>();
        clients = new ArrayList<Client>();
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public List<Car> getAvailableCars() {
        return availableCars;
    }

    public void setAvailableCars(List<Car> availableCars) {
        this.availableCars = availableCars;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

}
