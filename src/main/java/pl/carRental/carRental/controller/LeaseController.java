package pl.carRental.carRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.carRental.carRental.model.CarStatus;
import pl.carRental.carRental.model.Lease;
import pl.carRental.carRental.model.LeaseForm;
import pl.carRental.carRental.service.CarService;
import pl.carRental.carRental.service.ClientService;
import pl.carRental.carRental.service.LeaseService;

import java.util.List;

@Controller
public class LeaseController {

    private LeaseService leaseService;
    private ClientService clientService;
    private CarService carService;

    @Autowired
    public LeaseController(LeaseService leaseService, ClientService clientService, CarService carService) {
        this.leaseService = leaseService;
        this.clientService = clientService;
        this.carService = carService;
    }

    @GetMapping("/allLease")
    public String getAllLease(Model model) {
        List<Lease> leaseList = leaseService.getAllLease();
        model.addAttribute("leaseList", leaseList);
        return "lease_list"; //html template
    }


    @RequestMapping("/addLease")
    public String dodajRezerwacje(Model model) {
        LeaseForm leaseForm = new LeaseForm();
        leaseForm.setAvailableCars(carService.getAvailableCars());
        leaseForm.setClients(clientService.getAllClients());
        model.addAttribute("lease", leaseForm);
       // model.addAttribute("1",leaseForm.getCarId());
        return "add_lease";
    }

    @PostMapping("/saveLease")
    public String saveLease(LeaseForm leaseForm) {

        Lease lease = new Lease();
        lease.setCar(carService.findCar(leaseForm.getCarId()));
        lease.setCost(leaseForm.getCost());
        lease.setClient(clientService.findClient(leaseForm.getClientId()));
        lease.setCompleted(false);

        lease.getCar().setStatus(CarStatus.NONAVAILABLE);
        leaseService.addLease(lease);
        return "redirect:/allLease";
    }



    @RequestMapping("/returnLease/{id}")
    public String deleteLease(@PathVariable(name = "id") Long id) {
        leaseService.findLease(id).getCar().setStatus(CarStatus.AVAILABLE);
        leaseService.findLease(id).setCompleted(true);
        leaseService.addLease(leaseService.findLease(id));
        //leaseService.changeStatus(leaseService.findLease(id).setCompleted(true));
        return "redirect:/allLease";
    }

    @RequestMapping("/deleteLease/{id}")
    public String completeLease(@PathVariable(name = "id") Long id)
    {
        leaseService.findLease(id).getCar().setStatus(CarStatus.AVAILABLE);
        leaseService.deleteLease(id);
        return "redirect:/allLease";
    }

}
