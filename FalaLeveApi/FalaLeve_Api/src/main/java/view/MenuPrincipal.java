package view;

import model.Medico;
import model.Usuario;
import model.UsuarioNaoVerbal;

import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Menu menu = new Menu();

        do {
            menu.menu();
        }while (menu.opMenu != 4);

        System.out.println("Menu encerrado com sucesso");
    }
}

