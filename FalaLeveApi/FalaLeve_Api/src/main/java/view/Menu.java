package view;

import model.Usuario;
import controller.ColetarDados;
import controller.GerenciarUsuario;
import interfaces.GerirProntuario;
import interfaces.GerirUsuario;
import repository.RepositorioUsuarioLista;
import repository.RepositorioUsuarioProntuario;


import java.util.Scanner;

public class Menu {

    GerenciarUsuario gerenciarUsuario = new GerenciarUsuario();
    ColetarDados coletarDados = new ColetarDados();
    GerirUsuario lista = new RepositorioUsuarioLista();
    GerirProntuario prontuario = new RepositorioUsuarioProntuario();
    Scanner input = new Scanner(System.in);
    public int opMenu;

    public int menu(){
        //so vai inicializar o usuario se ele for nulo


        do {
            System.out.println("1 - Adicionar um usuario");
            System.out.println("2 - Remover um Usuario");
            System.out.println("3 - Listar um usuario");
            System.out.println("4 - encerrar menu");
            System.out.print("Escolha uma opção: ");
            opMenu = input.nextInt();
            input.nextLine();
            switch (opMenu) {
                case 1:
                    coletarDados.DadosBasicos(lista);
                    break;
                case 2:
                    gerenciarUsuario.removerUsuario(lista2);
                    break;
                case 3:
                    gerenciarUsuario.listarUsuario(lista, prontuario);
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
