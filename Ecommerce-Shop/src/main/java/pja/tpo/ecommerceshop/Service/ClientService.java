package pja.tpo.ecommerceshop.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pja.tpo.ecommerceshop.Model.Address;
import pja.tpo.ecommerceshop.Model.Client;
import pja.tpo.ecommerceshop.DTOs.ClientCreateDTO;
import pja.tpo.ecommerceshop.Repository.AddressRepository;
import pja.tpo.ecommerceshop.Repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;

    ClientService(ClientRepository clientRepository, AddressRepository addressRepository) {
        this.clientRepository = clientRepository;
        this.addressRepository = addressRepository;
    }

    public Client getClientById(Long id) {
        return clientRepository.findClientById(id).orElse(null);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Transactional
    public Client createClient(ClientCreateDTO clientCreateDTO) {
        Address address = new Address();
        address.setStreet(clientCreateDTO.getStreet());
        address.setCity(clientCreateDTO.getCity());
        address.setPostalCode(clientCreateDTO.getPostalCode());
        address.setCountry(clientCreateDTO.getCountry());

        Address savedAddress = addressRepository.save(address);

        Client client = new Client();
        client.setFirstName(clientCreateDTO.getFirstName());
        client.setLastName(clientCreateDTO.getLastName());
        client.setEmail(clientCreateDTO.getEmail());
        client.setPhoneNumber(clientCreateDTO.getPhoneNumber());
        client.setAdress(savedAddress);

        return clientRepository.save(client);
    }

}
