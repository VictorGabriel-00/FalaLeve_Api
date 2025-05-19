package controller;

import interfaces.GerirParenteResponsavel;
import interfaces.GerirProntuario;
import interfaces.GerirUsuario;
import model.Medico;
import model.ParenteResponsavel;
import model.Usuario;
import model.UsuarioNaoVerbal;
import repository.*;

import java.util.Scanner;

public class ColetarDados {
    GerarIdUsuario gerarIdUsuario = new GerarIdUsuario();
    Scanner input = new Scanner(System.in);

    public Usuario DadosBasicos(RepositorioUsuarioLista lista, Usuario usuario) {
        usuario = new Usuario();

        String nome,email,senha;
        int data;

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
        input.nextLine();



        usuario.setNome(nome);
        usuario.setEmail(email);
        lista.addusuario(usuario);

        return usuario;

    }

    public UsuarioNaoVerbal criarUsuarioNaoVerbal(RepositorioUsuarioProntuario prontuario) {
        UsuarioNaoVerbal usuarioNaoVerbal = new UsuarioNaoVerbal();
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
        gerarIdUsuario.GerenciarIdUsuario("Usuario Nao Verbal");
        return usuarioNaoVerbal;
    }


    public ParenteResponsavel criarUsuarioParenteResponsavel(RepositorioParenteResponsavel listaParente) {
        ParenteResponsavel usuarioParente = new ParenteResponsavel();
        String nomeParente, emailParentesco,senhaParentesco;
        int data;

        System.out.println("Informe o nome do parente: ");
        nomeParente = input.nextLine();
        System.out.println("informe o email do parente: ");
        emailParentesco = input.nextLine();
        System.out.println("Crie uma senha para o parente: ");
        senhaParentesco = input.nextLine();
        usuarioParente.setSenhaParente(senhaParentesco);
        usuarioParente.verificarSenha(senhaParentesco);
        while(usuarioParente.opSenhaParente.equals("Tente novamente")){
            System.out.println("Crie uma senha com mais de 5 caracter: ");
            senhaParentesco = input.next();
            usuarioParente.setSenhaParente(senhaParentesco);
            usuarioParente.verificarSenha(senhaParentesco);
        }
        System.out.println("Informe a data de aniversario do parente: ");
        data = input.nextInt();
        usuarioParente.dataNascimento(data);

       usuarioParente.setNomeParente(nomeParente);
       usuarioParente.setEmailParente(emailParentesco);
       usuarioParente.setSenhaParente(senhaParentesco);
       usuarioParente.dataNascimento(data);
       listaParente.addParenteResponsavel(usuarioParente);
       gerarIdUsuario.GerenciarIdUsuario("Parente Responsavel");


       return usuarioParente;
    }


    public Medico criarUsuarioMedico(RepositorioMedico listaMedico) {
        Medico usuarioMedico = new Medico();
        String crm;

        System.out.println("Informe o CRM do medico: ");
        crm = input.next();
        gerarIdUsuario.GerenciarIdUsuario("Medico");
        usuarioMedico.setCrm(crm);
        listaMedico.addMedico(usuarioMedico);

        return usuarioMedico;
    }

}
