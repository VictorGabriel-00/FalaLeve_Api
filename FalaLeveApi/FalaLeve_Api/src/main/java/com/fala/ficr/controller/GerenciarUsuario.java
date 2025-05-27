package com.fala.ficr.controller;

import com.fala.ficr.repository.*;
import com.fala.ficr.view.MenuPrincipal;
import java.util.Scanner;

public class GerenciarUsuario{
    RepositorioIdUsuario repositorioIdUsuario = new RepositorioIdUsuario();
    static RepositorioMedico listaMedico = new RepositorioMedico();
    static RepositorioParenteResponsavel listaParente = new RepositorioParenteResponsavel();
    MenuPrincipal menuPrincipal = new MenuPrincipal();
    ColetarDados coletarDados = new ColetarDados();
    static RepositorioUsuarioProntuario prontuario = new RepositorioUsuarioProntuario();

    Scanner input = new Scanner(System.in);

    public void criarUsuario(RepositorioIdUsuario listaIdUsuario) {

        System.out.println("Informe o Tipo de Usuario deseja Criar: ");
        System.out.println("1 - Usuario Não Verbal");
        System.out.println("2 - Parente Responsavel");
        System.out.println("3 - Medico");
        System.out.print("Escolha uma das opções: ");
        menuPrincipal.escolhaTipo = input.nextInt();
        input.nextLine();

        switch (menuPrincipal.escolhaTipo) {
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

    }

    public void listarUsuario(RepositorioUsuarioLista lista, RepositorioIdUsuario repositorioIdUsuario) {
        System.out.println("Id do Usuario:\n" + ((RepositorioIdUsuario)repositorioIdUsuario).listaIdUsuario());
        System.out.println("Lista de Usuarios: \n" + ((RepositorioUsuarioLista)lista).listarUsuarios());

        if(menuPrincipal.escolhaTipo == 3){
            System.out.println("CRM do Medico \n" + ((RepositorioMedico)listaMedico).listarMedicos());
        } else if (menuPrincipal.escolhaTipo == 2) {
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
        System.out.print("Escolha uma das opções: ");
        editarTipoUsuario = input.nextInt();
        input.nextLine();

        if(editarTipoUsuario == 1){
            String idn;
            System.out.println("informe o id do usuario que deseja alterar: ");
            String id = input.next();
            System.out.println("Informe o id do Prontuario: ");
            idn = input.nextLine();
            prontuario.removerProntuario(idn);
            listaIdUsuario.RemoverIdUsuario(id);
        }else if(editarTipoUsuario == 2){
            System.out.println("informe o id do usuario que deseja alterar: ");
            String id = input.next();
            System.out.println("Informe o email do parente cadastrado que deseja alterar: ");
            String emailParente = input.next();
            listaParente.removerParenteResponsavel(emailParente);
            listaIdUsuario.RemoverIdUsuario(id);
        }else if(editarTipoUsuario == 3){
            System.out.println("informe o id do usuario que deseja alterar: ");
            String id = input.next();
            System.out.println("Informe o CRM do medico que deseja alterar: ");
            String crm = input.next();
            listaMedico.removerMedico(crm);
            listaIdUsuario.RemoverIdUsuario(id);
        }

        switch (editarTipoUsuario){
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
                break;
        }
        menuPrincipal.main(null);
    }

    public void removerUsuario(RepositorioUsuarioLista lista, RepositorioIdUsuario repositorioIdUsuario) {
        System.out.println("Digite o email do usuário que deseja remover:");
        String email = input.next();

        if(menuPrincipal.escolhaTipo == 3){
            System.out.println("informe o id do usuario: ");
            String id = input.next();
            System.out.println("Informe o CRM do medico que deseja remover: ");
            String crm = input.next();
            listaMedico.removerMedico(crm);
            repositorioIdUsuario.RemoverIdUsuario(id);
        } else if (menuPrincipal.escolhaTipo == 2) {
            System.out.println("informe o id do usuario: ");
            String id = input.next();
            System.out.println("Informe o email do parente cadastrado: ");
            String emailParente = input.next();

            listaParente.removerParenteResponsavel(emailParente);
            repositorioIdUsuario.RemoverIdUsuario(id);
        } else if (menuPrincipal.escolhaTipo == 1) {
            System.out.println("informe o id do usuario: ");
            String id = input.next();
            System.out.println("informe o id do prontuario: ");
            String idP = input.next();

            prontuario.removerProntuario(idP);
            repositorioIdUsuario.RemoverIdUsuario(id);
        }

        lista.removerusuario(email);
        System.out.println("Operação concluída");
        menuPrincipal.main(null);
    }

}