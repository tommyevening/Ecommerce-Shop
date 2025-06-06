package pja.tpo.ecommerceshop.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pja.tpo.ecommerceshop.DTOs.ClientGetDTO;
import pja.tpo.ecommerceshop.Model.Client;
import pja.tpo.ecommerceshop.DTOs.ClientCreateDTO;
import pja.tpo.ecommerceshop.Service.ClientService;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Client client = clientService.getClientById(id);
        return ResponseEntity.ok(client);
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody ClientCreateDTO client) {
        Client createdClient = clientService.createClient(client);
        return ResponseEntity.ok(createdClient);
    }

    @GetMapping("/search")
    public String searchClients(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String address,
            Model model) {
        List<ClientGetDTO> clients = clientService.searchClients(firstName, lastName, email, phoneNumber, address);
        model.addAttribute("clients", clients);
        return "searchClient";
    }


    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody ClientGetDTO client) {
        try{
            clientService.updateClient(id, client);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/add")
    public String registerClient(@ModelAttribute("clientCreateDTO") ClientCreateDTO clientCreateDTO, Model model) {
        model.addAttribute("clientCreateDTO", clientCreateDTO);
        clientService.createClient(clientCreateDTO);
        return "redirect:/clients/search";
    }

}
