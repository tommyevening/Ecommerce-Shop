package pja.tpo.ecommerceshop.Service;

import org.springframework.stereotype.Service;
import pja.tpo.ecommerceshop.Model.Client;
import pja.tpo.ecommerceshop.Repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client getClientById(Long id) {
        return clientRepository.findClientById(id).orElse(null);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }


}
