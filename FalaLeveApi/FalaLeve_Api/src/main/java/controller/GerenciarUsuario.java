package controller;

import model.Medico;
import model.Usuario;
import model.UsuarioNaoVerbal;
import repository.GerirUsuario;
import view.Menu;

import java.util.Scanner;

public class GerenciarUsuario implements GerirUsuario {
    GerarIdUsuario opGeraId = new GerarIdUsuario();
    GerarIdUsuario gerarIdUsuario = new GerarIdUsuario();
    Usuario usNaoVerbal = new UsuarioNaoVerbal();
    Usuario Medico = new Medico();
    Usuario usuario = new Usuario();
    Scanner input = new Scanner(System.in);
    public static String op;

    public String escolha(){
        GerenciarUsuario grUsuario = new GerenciarUsuario();
        System.out.println("Informe qual o tipo de usuario que deseja adicionar(Medico,Parente Responsavel,Usuario Não Verbal):");
        op = input.nextLine();
        opGeraId.op = op;
        grUsuario.addusuario(null,null,0,0);
        return op;
    }


    @Override
    public void addusuario(String nome, String email, int senha, int dataAnicersario) {
        System.out.println("Informe o nome do Usuario: ");
        nome = input.nextLine();
        usuario.nome = nome;
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
        usuario.setEmail(email);


        if(op.equalsIgnoreCase("Medico")){
            System.out.println("Informe o CRM do Medico: ");
            String crmU = input.next();
            ((Medico)Medico).setCrm(crmU);

        }else if(op.equalsIgnoreCase("Usuario Nao Verbal")
                ||op.equalsIgnoreCase("Usuario Não Verbal")){
            System.out.println("Monte seu Prontuario: ");
            System.out.println("Informe qual o Grau da sua neurodivergencia: ");
            int grau = input.nextInt();
            System.out.println("Informe cores que são agradaveis para voce: ");
            String cor = input.next();
            cor = input.nextLine();
            System.out.println("Informe os sons que voce gosta de ouvir: ");
            String sons = input.next();
            System.out.println("Informe o Tamano de fonte que voce acha confortavel: ");
            int tamanho = input.nextInt();;
            System.out.println("Informe se vc gosta dos movimentos com ou sem animalção: ");
            String animacao = input.next();

            usNaoVerbal.nome = nome;
            usNaoVerbal.setEmail(email);
            usNaoVerbal.setSenha(senha);
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
        Usuario usuarioLis = new Usuario();
        String idPerma;
        idPerma = gerarIdUsuario.GerenciarIdUsuario();


            System.out.println("Id: " + idPerma);
            System.out.println("Nome: " + usNaoVerbal.nome);
            System.out.println("Email: " + usuario.getEmail());
            System.out.println("Data de Aniversario: " + usuario.DataAniversario);

            if (op.equalsIgnoreCase("Medico")) {
                System.out.println("CRM: " + ((Medico) Medico).getCrm());
            } else if (op.equalsIgnoreCase("Usuario Nao Verbal")
                    ||op.equalsIgnoreCase("Usuario Não Verbal")){

            }
    }
    }

