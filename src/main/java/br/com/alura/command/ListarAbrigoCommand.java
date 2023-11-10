package br.com.alura.command;

import java.io.IOException;

import br.com.alura.client.ClientHttp;
import br.com.alura.services.AbrigoService;

public class ListarAbrigoCommand implements Command {

    @Override
    public void execute() {
        ClientHttp client = new ClientHttp();
        AbrigoService abrigoService = new AbrigoService(client);

        try {
            abrigoService.listarAbrigo();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
}