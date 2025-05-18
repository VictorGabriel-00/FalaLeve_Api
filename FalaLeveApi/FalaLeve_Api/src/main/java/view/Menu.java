package view;

import interfaces.GerirParenteResponsavel;
import model.Usuario;
import controller.ColetarDados;
import controller.GerenciarUsuario;
import interfaces.GerirProntuario;
import interfaces.GerirUsuario;
import repository.RepositorioParenteResponsavel;
import repository.RepositorioUsuarioLista;
import repository.RepositorioUsuarioProntuario;


import java.util.Scanner;

public class Menu {
    Usuario usuario;
    GerenciarUsuario gerenciarUsuario = new GerenciarUsuario();
    ColetarDados coletarDados = new ColetarDados();
    RepositorioUsuarioLista lista = new RepositorioUsuarioLista();
    RepositorioUsuarioProntuario prontuario = new RepositorioUsuarioProntuario();
    RepositorioParenteResponsavel listaParente = new RepositorioParenteResponsavel();
    Scanner input = new Scanner(System.in);
    public int opMenu;

    public int menu(){
        do {
            System.out.println("Menu de Usuario");
            System.out.println("1 - Adicionar um usuario");
            System.out.println("2 - Remover um Usuario");
            System.out.println("3 - Listar um usuario");
            System.out.println("4 - encerrar menu");
            System.out.print("Escolha uma opção: ");
            opMenu = input.nextInt();
            input.nextLine();
            switch (opMenu) {
                case 1:
                    coletarDados.DadosBasicos(lista, usuario);

                    break;
                case 2:
                    gerenciarUsuario.removerUsuario(lista);
                    break;
                case 3:
                    gerenciarUsuario.listarUsuario(lista,listaParente,prontuario);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção Invalida");
                    break;
            }
            if(opMenu != 0){
                gerenciarUsuario.criarUsuario();
            }


        }while (opMenu != 4);

        return opMenu;
    }
}
