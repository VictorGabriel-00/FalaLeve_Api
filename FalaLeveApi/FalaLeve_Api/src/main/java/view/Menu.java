package view;

import model.Usuario;
import controller.ColetarDados;
import controller.GerenciarUsuario;
import repository.RepositorioIdUsuario;
import repository.RepositorioUsuarioLista;



import java.util.Scanner;

public class Menu {
    Usuario usuario;
    GerenciarUsuario gerenciarUsuario = new GerenciarUsuario();
    ColetarDados coletarDados = new ColetarDados();

    Scanner input = new Scanner(System.in);
    public int opMenu;

    public int menu(RepositorioIdUsuario repositorioIdUsuario, RepositorioUsuarioLista lista) {

        do {
            System.out.println("Menu de Usuario");
            System.out.println("1 - Adicionar um usuario");
            System.out.println("2 - Remover um Usuario");
            System.out.println("3 - Listar um usuario");
            System.out.println("4 - Editar Usuario");
            System.out.println("5 - encerrar menu");
            System.out.print("Escolha uma opção: ");
            opMenu = input.nextInt();
            input.nextLine();
            switch (opMenu) {
                case 1:
                    coletarDados.DadosBasicos(lista, usuario);
                    System.out.println("Usuario Criado com sucesso");
                    break;
                case 2:
                    gerenciarUsuario.removerUsuario(lista, repositorioIdUsuario);
                    break;
                case 3:
                    gerenciarUsuario.listarUsuario(lista, repositorioIdUsuario);
                    break;
                case 4:
                    gerenciarUsuario.editarUsuario(repositorioIdUsuario);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opção Invalida");
                    break;
            }
            if(opMenu != 0){
                gerenciarUsuario.criarUsuario(repositorioIdUsuario);
            }


        }while (opMenu != 5);

        return opMenu;
    }
}
