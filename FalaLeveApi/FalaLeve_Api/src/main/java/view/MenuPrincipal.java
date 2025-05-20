package view;

import model.Medico;
import model.Usuario;
import model.UsuarioNaoVerbal;
import repository.RepositorioIdUsuario;
import repository.RepositorioUsuarioLista;

import java.util.Scanner;

public class MenuPrincipal {
    static RepositorioIdUsuario repositorioIdUsuario = new RepositorioIdUsuario();
    static RepositorioUsuarioLista lista = new RepositorioUsuarioLista();
    public static int escolhaTipo;

    public static void main(String[] args) {
        Menu menu = new Menu();

        do {
            menu.menu(repositorioIdUsuario, lista);
        }while (menu.opMenu != 5);

        System.out.println("Menu encerrado com sucesso");
    }
}

