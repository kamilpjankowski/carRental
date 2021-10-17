package pl.carRental.carRental.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "lease")
public class Lease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    private double cost;
    boolean completed;

    @OneToOne
    @JoinColumn(name = "client_id", nullable = false)
    Client client;

    @OneToOne
    @JoinColumn(name = "car_id", nullable = false)
    Car car;

    public Lease() {
    }

    public Lease(double cost, boolean completed, Client client, Car car) {
        this.cost = cost;
        this.completed = completed;
        this.client = client;
        this.car = car;
    }

    public long getId() {
        return id;
    }



    public void setId(long id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}
