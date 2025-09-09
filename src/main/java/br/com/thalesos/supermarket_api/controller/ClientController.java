package br.com.thalesos.supermarket_api.controller;

import br.com.thalesos.supermarket_api.dto.ClientRequestDTO;
import br.com.thalesos.supermarket_api.dto.ClientResponseDTO;
import br.com.thalesos.supermarket_api.model.Client;
import br.com.thalesos.supermarket_api.service.ClientService;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public List<ClientResponseDTO> getAllClient(){

        List<Client> clients = clientService.getAllClient();
        List<ClientResponseDTO> responseDTOList =  new ArrayList<>();

        for (Client client : clients) {

            ClientResponseDTO  responseDTO= new ClientResponseDTO(
                    client.getId(),
                    client.getName()
            );

            responseDTOList.add(responseDTO);
        }
        return responseDTOList;

    }

    @PostMapping("/clients")
    public ClientResponseDTO addClient(@RequestBody ClientRequestDTO requestDTO) {

        Client newClient = new Client();
        newClient.setName(requestDTO.name());

        Client savedClient = clientService.addClient(newClient);

        return  new ClientResponseDTO(
                savedClient.getId(),
                savedClient.getName()
        );
    }

    @PutMapping("/clients/{id}")
    public ClientResponseDTO updateClientById (@PathVariable int id, @RequestBody ClientRequestDTO requestDTO){

        Client clientDetails =  new Client();
        clientDetails.setName(requestDTO.name());

        Client updateClient = clientService.updateClientById(id, clientDetails);

        if (updateClient != null){
            return new ClientResponseDTO(
                    updateClient.getId(),
                    updateClient.getName()
            );
        }
        return null;

    }

    @DeleteMapping("/clients/{id}")
    public void deleteClientById (@PathVariable int id){
        clientService.deleteClientById(id);
    }



}
