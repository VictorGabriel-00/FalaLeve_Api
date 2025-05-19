package controller;

import interfaces.GerirParenteResponsavel;
import interfaces.GerirProntuario;
import interfaces.GerirUsuario;
import model.Medico;
import model.Usuario;
import model.UsuarioNaoVerbal;
import repository.*;
import view.MenuPrincipal;

import java.util.Scanner;


public class GerenciarUsuario{
    RepositorioMedico listaMedico = new RepositorioMedico();
    RepositorioParenteResponsavel listaParente = new RepositorioParenteResponsavel();
    MenuPrincipal menuPrincipal = new MenuPrincipal();
    ColetarDados coletarDados = new ColetarDados();
    RepositorioUsuarioProntuario prontuario = new RepositorioUsuarioProntuario();
    private Usuario usuarioAtual;
    private int escolhaTipo;
    Scanner input = new Scanner(System.in);


    public void criarUsuario(RepositorioIdUsuario listaIdUsuario) {

        System.out.println("Informe o Tipo de Usuario deseja Criar: ");
        System.out.println("1 - Usuario Não Verbal");
        System.out.println("2 - Parente Responsavel");
        System.out.println("3 - Medico");
        System.out.print("Escolha uma das opções: ");
        escolhaTipo = input.nextInt();
        input.nextLine();

        switch (escolhaTipo) {
            case 1:
                coletarDados.criarUsuarioNaoVerbal(prontuario,listaIdUsuario);
                break;
            case 2:
                coletarDados.criarUsuarioParenteResponsavel(listaParente,listaIdUsuario);
                break;
            case 3:
                coletarDados.criarUsuarioMedico(listaMedico,listaIdUsuario);
                break;
            default:
                System.out.println("Opção inválida");
        }

       if(usuarioAtual != null) {
           System.out.println("Usuario criado com sucesso");
       }

    }


    public void listarUsuario(RepositorioUsuarioLista lista, RepositorioIdUsuario repositorioIdUsuario) {
        System.out.println("Id do Usuario:\n" + ((RepositorioIdUsuario)repositorioIdUsuario).listaIdUsuario());
        System.out.println("Lista de Usuarios: \n" + ((RepositorioUsuarioLista)lista).listarUsuarios());

        if(escolhaTipo == 3){
            System.out.println(((RepositorioMedico)listaMedico).listarMedicos());
        } else if (escolhaTipo == 2) {
            System.out.println("Parente Cadastrado: \n" + ((RepositorioParenteResponsavel)listaParente).listarParenteResponsavel());
        }else{
            System.out.println("Prontuario: \n" + ((RepositorioUsuarioProntuario)prontuario).prontuarioUsuario());
        }

        menuPrincipal.main(null);

    }


    public void editarUsuario(RepositorioIdUsuario listaIdUsuario) {
        int editarTipoUsuario;
        System.out.println("Informe o tipo do usuario que deseja editar: ");
        System.out.println("1 - Usuario Não Verbal");
        System.out.println("2 - Parente Responsavel");
        System.out.println("3 - Medico");
        editarTipoUsuario = input.nextInt();

        switch (editarTipoUsuario){
            case 1:
                System.out.println("Criando um novo prontuario para o usuario não verbal");
                coletarDados.criarUsuarioNaoVerbal(prontuario, listaIdUsuario);
                break;
            case 2:
                System.out.println("Criando um novo prontuario para o parente responsavel");
                coletarDados.criarUsuarioParenteResponsavel(listaParente, listaIdUsuario);
                break;
            case 3:
                System.out.println("Criando um novo prontuario para o medico");
                coletarDados.criarUsuarioMedico(listaMedico, listaIdUsuario);
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }

        menuPrincipal.main(null);
    }

    public void removerUsuario(RepositorioUsuarioLista lista) {
        System.out.println("Digite o email do usuário que deseja remover:");
        String email = input.next();

        lista.removerusuario(email);
        System.out.println("Operação concluída");
        menuPrincipal.main(null);
    }

}