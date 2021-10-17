package pl.carRental.carRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.carRental.carRental.model.Car;
import pl.carRental.carRental.model.Client;
import pl.carRental.carRental.service.ClientService;

@Controller
public class ClientController {

    ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping("/addClient")
    public String addClient(Model model) {
        Client client = new Client();
        model.addAttribute("client",client);
        return "add_client"; //html template
    }

    @PostMapping("/saveClient")
    public String saveClient(Client client) {
        clientService.addClient(client);
        return "redirect:/index";
    }
}
