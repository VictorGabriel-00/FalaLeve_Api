package view;

import model.Medico;
import model.Usuario;

import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        Usuario medico = new Medico();
        Usuario usuarioNaoVerbal = new Usuario();
        Scanner input = new Scanner(System.in);
        int op;
        op = 0;
    while(op != 4){
        System.out.println("Informe os dados abaixo:");
        System.out.println("1 - Adicionar um usuario");
        System.out.println("2 - Remover um Usuario");
        System.out.println("3 - Listar um usuario");
        System.out.println("4 - encerrar menu");
        System.out.print("Escolha uma opção: ");
        op = input.nextInt();

        switch (op) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                System.out.println("Opção invalida !!");
                break;
        }
    }
        System.out.println("Menu encerrado com sucesso");
    }
}

