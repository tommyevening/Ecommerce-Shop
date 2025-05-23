package pja.tpo.ecommerceshop.Service;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pja.tpo.ecommerceshop.DTOs.ClientGetDTO;
import pja.tpo.ecommerceshop.Model.Address;
import pja.tpo.ecommerceshop.Model.Client;
import pja.tpo.ecommerceshop.DTOs.ClientCreateDTO;
import pja.tpo.ecommerceshop.Repository.AddressRepository;
import pja.tpo.ecommerceshop.Repository.ClientRepository;
import pja.tpo.ecommerceshop.Repository.OrderRepository;
import pja.tpo.ecommerceshop.Specification.ClientSpecification;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;
    private final OrderRepository orderRepository;

    ClientService(ClientRepository clientRepository, AddressRepository addressRepository, OrderRepository orderRepository) {
        this.clientRepository = clientRepository;
        this.addressRepository = addressRepository;
        this.orderRepository = orderRepository;
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

    public List<ClientGetDTO> searchClients(String firstName, String lastName, String email, String phoneNumber, String street) {
        Specification<Client> specification = Specification
                .where(ClientSpecification.hasFirstName(firstName))
                .and(ClientSpecification.hasLastName(lastName))
                .and(ClientSpecification.hasEmail(email))
                .and(ClientSpecification.hasPhoneNumber(phoneNumber))
                .and(ClientSpecification.hasAddress(street));

        return clientRepository.findAll(specification).stream()
                .map(client -> new ClientGetDTO(client.getId(),
                        client.getFirstName(),
                        client.getLastName(),
                        client.getEmail(),
                        client.getPhoneNumber(),
                        client.getAdress().getStreet()
                ))
                .collect(Collectors.toList());
    }

    public void updateClient(Long id, ClientGetDTO client) {
        Client clientToUpdate = clientRepository.findClientById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        clientToUpdate.setFirstName(client.getFirstName());
        clientToUpdate.setLastName(client.getLastName());
        clientToUpdate.setEmail(client.getEmail());
        clientToUpdate.setPhoneNumber(client.getPhoneNumber());

        Address address = clientToUpdate.getAdress();
        if (address != null) clientToUpdate.setAdress(address);

        clientRepository.save(clientToUpdate);
    }

    @Transactional
    public void deleteClient(Long clientId) {
        orderRepository.deleteByClientId(clientId);
        clientRepository.deleteById(clientId);
    }

}
