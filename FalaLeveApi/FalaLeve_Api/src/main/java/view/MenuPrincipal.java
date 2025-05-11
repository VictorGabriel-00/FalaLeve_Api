package view;

import model.Medico;
import model.Usuario;
import model.UsuarioNaoVerbal;

import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Usuario medico = new Medico();
        Usuario usuarioNaoVerbal = new UsuarioNaoVerbal();
        Scanner input = new Scanner(System.in);


        do {
            menu.menu();
        }while (menu.op != 4);

        System.out.println("Menu encerrado com sucesso");
    }
}

