package br.com.alura.services;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.alura.client.ClientHttp;
import br.com.alura.domain.Abrigo;

public class AbrigoService {

    private ClientHttp client;

    public AbrigoService(ClientHttp client) {
        this.client = client;
    }

    ClientHttp clientHttp = new ClientHttp();

    public void listarAbrigo() throws IOException, InterruptedException {

        String uri = "http://localhost:8080/abrigos";
        HttpResponse<String> response = client.dispararGET(uri);
        String responseBody = response.body();
        Abrigo[] abrigos = new ObjectMapper().readValue(responseBody, Abrigo[].class);
        List<Abrigo> abrigoList = Arrays.stream(abrigos).toList();
        if (abrigoList.isEmpty()) {
            System.out.println("Não há abrigos cadastrados");
        } else {
            mostrarAbrigos(abrigoList);
        }

    }

    private void mostrarAbrigos(List<Abrigo> abrigos){
        System.out.println("Abrigos cadastrados: ");
            for (Abrigo abrigo : abrigos) {

                long id = abrigo.getId();
                String nome = abrigo.getNome();
                System.out.println(id + " - " + nome);
            }

    }

    public void cadastrarAbrigo() throws IOException, InterruptedException {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o nome do abrigo:");
        String nome = teclado.nextLine();
        System.out.println("Digite o telefone do abrigo:");
        String telefone = teclado.nextLine();
        System.out.println("Digite o email do abrigo:");
        String email = teclado.nextLine();

        Abrigo abrigo = new Abrigo(nome, telefone, email);

        String uri = "http://localhost:8080/abrigos";
        HttpResponse<String> response = client.dispararPOST(uri, abrigo);
        int statusCode = response.statusCode();
        String responseBody = response.body();
        if (statusCode == 200) {
            System.out.println("Abrigo cadastrado com sucesso!");
            System.out.println(responseBody);
        } else if (statusCode == 400 || statusCode == 500) {
            System.out.println("Erro ao cadastrar o abrigo:");
            System.out.println(responseBody);
        }
        teclado.close();
    }
}
