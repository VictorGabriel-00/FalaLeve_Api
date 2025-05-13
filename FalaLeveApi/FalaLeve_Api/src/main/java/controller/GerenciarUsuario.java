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
    Usuario usNaoVerbal;
    Usuario medico = new Medico();
    Usuario usuario;
    Scanner input = new Scanner(System.in);
    public static String op;
    String dataAniversario,nome,email,senha,primeiro,segundo,terceiro,cor,sons,animacao;
    int grau,tamanho;


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
        System.out.println("Crie uma senha para o Usuario : ");
        senha = input.next();
        usuario.setSenha(senha);
        usuario.verificarSenha(senha);

        while(usuario.op == "Tente novamente"){
            System.out.print("Crie uma senha com mais de 5 digitos: ");
            senha = input.next();
            usuario.setSenha(senha);
            usuario.verificarSenha(senha);
        }

        System.out.println("Informe a data de nascimento do Usuario(Apenas numeros): ");
        dataAniversario = input.next();
        String contagem = String.valueOf(dataAniversario);
        primeiro = contagem.substring(0,2);
        segundo = contagem.substring(2,4);
        terceiro = contagem.substring(4, 8);
        dataAniversario = primeiro + "/" + segundo  + "/" + terceiro;
        usuario.setDataAniversario(dataAniversario);


        if(op.equalsIgnoreCase("medico")){
            System.out.println("Informe o CRM do medico: ");
            String crmU = input.next();
            ((Medico) medico).setCrm(crmU);

        }else if(op.equalsIgnoreCase("Usuario Nao Verbal")
                ||op.equalsIgnoreCase("Usuario Não Verbal")){
            usNaoVerbal = new UsuarioNaoVerbal();
            System.out.println("Monte seu Prontuario: ");
            System.out.println("Informe qual o Grau da sua neurodivergencia: ");
            grau = input.nextInt();
            System.out.println("Informe cores que são agradaveis para voce: ");
            cor = input.next();
            cor = input.nextLine();
            System.out.println("Informe os sons que voce gosta de ouvir: ");
            sons = input.next();
            System.out.println("Informe o Tamano de fonte que voce acha confortavel: ");
            tamanho = input.nextInt();;
            System.out.println("Informe se vc gosta dos movimentos com ou sem animalção: ");
            String animacao = input.next();

            ((UsuarioNaoVerbal) usNaoVerbal).setGrau(grau);
            ((UsuarioNaoVerbal) usNaoVerbal).setCor(cor);
            ((UsuarioNaoVerbal) usNaoVerbal).setSon(sons);
            ((UsuarioNaoVerbal) usNaoVerbal).setFonteTamanho(tamanho);
            ((UsuarioNaoVerbal) usNaoVerbal).setAnimacao(animacao);
        }
        String idPerma;
        idPerma = gerarIdUsuario.GerenciarIdUsuario();
        usuario.setIdUsuario(idPerma);
        lista.addusuario(usuario);

    }


    public void listarusuario(GerirUsuario lista) {
        System.out.println("Usuarios cadastrados: \n " + ((RepositorioUsuarioLista) lista).listarUsuarios());
            if (op.equalsIgnoreCase("medico")) {
                System.out.println("CRM: " + ((Medico) medico).getCrm());
            } else if (op.equalsIgnoreCase("Usuario Nao Verbal")
                    ||op.equalsIgnoreCase("Usuario Não Verbal")){
                System.out.println("Prontuario: \n" + ((UsuarioNaoVerbal) usNaoVerbal).getProntuario());

            }
    }



    }

