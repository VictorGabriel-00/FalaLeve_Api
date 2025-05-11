package view;


import controller.GerenciarUsuario;

import java.util.Scanner;

public class Menu {
    GerenciarUsuario grUsuario = new GerenciarUsuario();
    Scanner input = new Scanner(System.in);
    public int op;
    public int menu(){

        do {
            System.out.println("Informe os dados abaixo:");
            System.out.println("1 - Adicionar um usuario");
            System.out.println("2 - Remover um Usuario");
            System.out.println("3 - Listar um usuario");
            System.out.println("4 - encerrar menu");
            System.out.print("Escolha uma opção: ");
            op = input.nextInt();
            switch (op) {
                case 1:
                    grUsuario.escolha();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção Invalida");
                    break;
            }

        }while (op != 4);

        return op;
    }
}
