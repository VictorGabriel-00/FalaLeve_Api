package controller;

import interfaces.GerirProntuario;
import interfaces.GerirUsuario;
import model.Medico;
import model.Usuario;
import model.UsuarioNaoVerbal;

import java.util.Scanner;

public class ColetarDados {
    GerarIdUsuario gerarIdUsuario = new GerarIdUsuario();
    Scanner input = new Scanner(System.in);
    Usuario usuario;
    UsuarioNaoVerbal usuarioNaoVerbal;


    public void DadosBasicos(GerirUsuario lista) {
        usuario = new Usuario(); // inicie a variavel

        String nome,email,senha; // os dados basicos da interface
        int data; // escolha do tipo de usuario

        System.out.println("Informe o nome do Usuario: ");
        nome = input.nextLine();
        System.out.println("Informe o email do Usuario: ");
        email = input.nextLine();
        System.out.println("Crie uma senha para o Usuario : ");
        senha = input.next();
        usuario.setSenha(senha);
        usuario.verificarSenha(senha);
        while(usuario.opSenha.equals("Tente novamente")){
            System.out.println("Crie uma senha com mais de 5 caracter: ");
            senha = input.next();
            usuario.setSenha(senha);
            usuario.verificarSenha(senha);
        }
        System.out.println("informe a data de nascimento do Usuario(Apenas numeros): ");
        data = input.nextInt();
        usuario.dataNascimento(data);



        usuario.setNome(nome);
        usuario.setEmail(email);
        lista.addusuario(usuario);


    }

    public void criarUsuarioNaoVerbal(GerirProntuario prontuario) {

        usuarioNaoVerbal = new UsuarioNaoVerbal();
        String cor,son,animacao;
        int grau,tamanho;

        System.out.println("Monte seu Prontuario: ");
        System.out.println("Informe qual o Grau da sua neurodivergencia: ");
        grau = input.nextInt();
        input.nextLine();
        System.out.println("Informe cores que são agradaveis para voce: ");
        cor = input.nextLine();
        System.out.println("Informe os sons que voce gosta de ouvir: ");
        son = input.next();
        System.out.println("Informe o Tamano de fonte que voce acha confortavel: ");
        tamanho = input.nextInt();;
        input.nextLine();
        System.out.println("Informe se vc gosta dos movimentos com ou sem animalção: ");
        animacao = input.nextLine();

        usuarioNaoVerbal.setGrau(grau);
        usuarioNaoVerbal.setCor(cor);
        usuarioNaoVerbal.setSon(son);
        usuarioNaoVerbal.setFonteTamanho(tamanho);
        usuarioNaoVerbal.setAnimacao(animacao);
        prontuario.addProntuario(usuarioNaoVerbal);
    }


    public void criarUsuarioParenteResponsavel(){

    }


    public void criarUsuarioMedico(){
        Medico medico = new Medico();
        String crm;

        System.out.println("Informe o CRM do medico: ");
        crm = input.next();

        medico.setCrm(crm);
    }

    public void id(){
        String idPerma;
        idPerma = gerarIdUsuario.GerenciarIdUsuario();
        usuario.setIdUsuario(idPerma);
    }










}
