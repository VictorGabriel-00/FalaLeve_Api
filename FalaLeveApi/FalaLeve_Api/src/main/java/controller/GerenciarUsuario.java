package controller;

import model.Medico;
import model.Usuario;
import repository.GerirUsuario;
import view.Menu;

import java.util.Scanner;

public class GerenciarUsuario implements GerirUsuario {
    GerarIdUsuario gerarIdUsuario = new GerarIdUsuario();
    Usuario Medico = new Medico();
    Usuario usuario = new Usuario();
    Scanner input = new Scanner(System.in);
    public static String op;

    public String escolha(){
        GerenciarUsuario grUsuario = new GerenciarUsuario();
        System.out.println("Informe qual o tipo de usuario que deseja adicionar(Medico,Parente Responsavel,Usuario Não Verbal):");
        op = input.nextLine();
        grUsuario.addusuario(null,null,0,0);
        return op;
    }


    @Override
    public void addusuario(String nome, String email, int senha, int dataAnicersario) {
        System.out.println("Informe o nome do Usuario: ");
        nome = input.nextLine();
        System.out.println("Informe o email do Usuario: ");
        email = input.nextLine();
        System.out.println("Crie uma senha para o Usuario (Apenas Numeros): ");
        senha = input.nextInt();
        usuario.setSenha(senha);
        usuario.verificarSenha(senha);

        while(usuario.op == "Tente novamente"){
            System.out.print("Crie uma senha com mais de 5 digitos: ");
            senha = input.nextInt();
            usuario.setSenha(senha);
            usuario.verificarSenha(senha);
        }

        System.out.println("Informe a data de aniversario do Usuario(Apenas numeros): ");
        dataAnicersario = input.nextInt();

        usuario.nome = nome;
        gerarIdUsuario.nome = nome;
        usuario.setEmail(email);


        if(op.equalsIgnoreCase("Medico")){
            System.out.println("Informe o CRM do Medico: ");
            String crmU = input.next();
            ((Medico)Medico).setCrm(crmU);

        }

    }

    @Override
    public void removerusuario(String email, int senha) {

    }

    @Override
    public void editusuario(String email, int senha) {

    }



    @Override
    public void listarusuario(String email, int senha) {
        GerenciarUsuario idUsuario = new GerenciarUsuario();
        String idPerma;
        idPerma = gerarIdUsuario.GerenciarIdUsuario();


            System.out.println("Id: " + idPerma);
            System.out.println("Nome: " + usuario.nome);
            System.out.println("Email: " + usuario.getEmail());
            System.out.println("Data de Aniversario: " + usuario.DataAniversario);

            if (op.equalsIgnoreCase("Medico")) {
                System.out.println("CRM: " + ((Medico) Medico).getCrm());
            }
        }
    }

