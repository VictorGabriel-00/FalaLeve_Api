package controller;

import model.Medico;
import model.Usuario;
import model.UsuarioNaoVerbal;
import interfaces.GerirUsuario;
import repository.RepositorioUsuarioLista;

import java.util.Scanner;

public class GerenciarUsuario{
    GerarIdUsuario opGeraId = new GerarIdUsuario();
    GerarIdUsuario gerarIdUsuario = new GerarIdUsuario();
    Usuario usNaoVerbal = new UsuarioNaoVerbal();
    Usuario medico = new Medico();
    Usuario usuario;
    Scanner input = new Scanner(System.in);
    public static String op;
    String nome,email,senha;
    int dataAnicersario;



    public void criarUsuario(GerirUsuario lista) {
        usuario = new Usuario();


        System.out.println("Informe qual o tipo de usuario que deseja adicionar(medico,Parente Responsavel,Usuario Não Verbal):");
        op = input.nextLine();
        opGeraId.op = op;

        System.out.println("Informe o nome do Usuario: ");
        nome = input.nextLine();
        usuario.setNome(nome);
        System.out.println("Informe o email do Usuario: ");
        email = input.nextLine();
        usuario.setEmail(email);
        System.out.println("Crie uma senha para o Usuario (Apenas Numeros): ");
        senha = input.next();
        usuario.setSenha(senha);
        usuario.verificarSenha(senha);

        while(usuario.op == "Tente novamente"){
            System.out.print("Crie uma senha com mais de 5 digitos: ");
            senha = input.next();
            usuario.setSenha(senha);
            usuario.verificarSenha(senha);
        }

        System.out.println("Informe a data de aniversario do Usuario(Apenas numeros): ");
        dataAnicersario = input.nextInt();
        usuario.setDataAniversario(dataAnicersario);


        if(op.equalsIgnoreCase("medico")){
            System.out.println("Informe o CRM do medico: ");
            String crmU = input.next();
            ((Medico) medico).setCrm(crmU);

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

            usNaoVerbal.setNome(nome);
            usNaoVerbal.setEmail(email);
            usNaoVerbal.setSenha(senha);
        }
        String idPerma;
        idPerma = gerarIdUsuario.GerenciarIdUsuario();
        usuario.setIdUsuario(idPerma);
        lista.addusuario(usuario);

    }


    public void listarusuario(GerirUsuario lista) {
        System.out.println("Usuarios cadastrados: " + ((RepositorioUsuarioLista) lista).listarUsuarios());
            if (op.equalsIgnoreCase("medico")) {
                System.out.println("CRM: " + ((Medico) medico).getCrm());
            } else if (op.equalsIgnoreCase("Usuario Nao Verbal")
                    ||op.equalsIgnoreCase("Usuario Não Verbal")){

            }
    }



    }

