package br.com.thalesos.supermarket_api.service;

import br.com.thalesos.supermarket_api.model.Client;
import br.com.thalesos.supermarket_api.model.ShoppingCart;
import br.com.thalesos.supermarket_api.repository.ClientRepository;
import br.com.thalesos.supermarket_api.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ShoppingCartRepository shoppingCartRepository;

    public ClientService(ClientRepository clientRepository, ShoppingCartRepository shoppingCartRepository) {
        this.clientRepository = clientRepository;
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public List<Client> getAllClient(){
        return clientRepository.findAll();
    }

    public Client addClient(Client client){
        Client savedClient =  clientRepository.save(client);
        ShoppingCart newCart = new ShoppingCart();
        newCart.setClient(savedClient);
        shoppingCartRepository.save(newCart);
        return savedClient;
    }

    public Client updateClientById(int id, Client newClientDetails){
        Optional<Client> optionalClient = clientRepository.findById(id);

        if (optionalClient.isPresent()){
            Client clientToUpdate = optionalClient.get();
            clientToUpdate.setName(newClientDetails.getName());

            return clientRepository.save(clientToUpdate);
        }
        return null;
    }

    public void deleteClientById(int id){
        clientRepository.deleteById(id);

    }

}
