package br.com.alura.command;

import java.io.IOException;

import br.com.alura.client.ClientHttp;
import br.com.alura.services.PetService;

public class ImportarPetsCommand implements Command {
    
    @Override

    public void execute(){
        try {
             ClientHttp client = new ClientHttp();
            PetService petService = new PetService(client);

            petService.importarPets();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
