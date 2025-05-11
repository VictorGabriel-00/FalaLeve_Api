package controller;

import model.Medico;
import model.Usuario;
import repository.GerirUsuario;

import java.util.Scanner;

public class GerenciarUsuario implements GerirUsuario {
    Usuario usuarioMedico = new Medico();
    Usuario usuario = new Usuario();
    Scanner input = new Scanner(System.in);
    public static String op;

    public String escolha(){
        GerenciarUsuario grUsuario = new GerenciarUsuario();
        System.out.println("Informe qual o tipo de usuario que deseja adicionar(Medico,Parente Responsavel,Usuario Não Verbal):");
        op = input.nextLine();
        grUsuario.addusuario(null,null,null,0);
        return op;
    }


    @Override
    public void addusuario(String nome, String email, String senha, int dataAnicersario) {
        System.out.println("Informe o nome do Usuario: ");
        nome = input.nextLine();
        System.out.println("Informe o email do Usuario: ");
        email = input.nextLine();
        System.out.println("Crie uma senha para o Usuario: ");
        senha = input.nextLine();
        usuario.setSenha(senha);
        usuario.verificarSenha(senha);

        while(usuario.op == "Tente novamente"){
            System.out.println("Senha muito fraca, tente novamente");
            senha = input.nextLine();
            usuario.verificarSenha(senha);
        }

        System.out.println("Informe a data de aniversario do Usuario(Apenas numeros): ");
        dataAnicersario = input.nextInt();

        usuario.nome = nome;
        usuario.setEmail(email);


        if(op.equalsIgnoreCase("Medico")){
            System.out.println("Informe o CRM do Medico: ");
            String crm = input.next();
        }

    }

    @Override
    public void removerusuario(String email, String senha) {

    }

    @Override
    public void editusuario(String email, String senha) {

    }

    @Override
    public void listarusuario(String email, String senha) {

    }
}
