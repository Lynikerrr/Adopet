package br.com.alura.command;

import java.io.IOException;

import br.com.alura.client.ClientHttp;
import br.com.alura.services.AbrigoService;

public class CadastrarAbrigoCommand implements Command {

    @Override
    public void execute() {

        try {
            ClientHttp client = new ClientHttp();
            AbrigoService abrigoService = new AbrigoService(client);

            abrigoService.cadastrarAbrigo();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

}
