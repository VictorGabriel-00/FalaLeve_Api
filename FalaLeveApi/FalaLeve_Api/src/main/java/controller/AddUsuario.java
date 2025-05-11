package controller;


import model.Usuario;

import java.util.Scanner;

public class AddUsuario extends Usuario {
    Scanner input = new Scanner(System.in);
    public String escolhaUMP;

    @Override
    public String escolha(String ump) {
        if(escolhaUMP.equalsIgnoreCase("Medico")) {
            System.out.println("Digite seu nome: ");
            String nome = input.nextLine();
            System.out.println("Digite sua idade: ");
            int idade = input.nextInt();
            System.out.println("Digite seu Email: ");
            String email = input.nextLine();
            System.out.println("Crie uma senha: ");
            String senha = input.next();
            System.out.println("Informe o seu crm:");
            String crm = input.next();



        }
        return ump;
    }

    public String addusuario() {
        Usuario escolhaADD = new AddUsuario();


        System.out.println("Informe para que pessoa esta criando a conta(Medico,Parente Responsavel ou uma Pessoa não verbal: )");
        escolhaUMP = input.next();
        escolhaADD.escolha(escolhaUMP);
        return addusuario();
    }


}
