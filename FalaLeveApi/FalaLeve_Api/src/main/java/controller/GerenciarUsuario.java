package controller;

import interfaces.GerirProntuario;
import interfaces.GerirUsuario;
import model.Medico;
import model.Usuario;
import repository.RepositorioUsuarioLista;
import repository.RepositorioUsuarioProntuario;

import java.util.Scanner;


public class GerenciarUsuario{
    Usuario medico = new Medico();
    ColetarDados escolhaUsuario = new ColetarDados();
    GerirUsuario lista = new RepositorioUsuarioLista();
    GerirProntuario prontuario = new RepositorioUsuarioProntuario();
    Scanner input = new Scanner(System.in);
    public int escolhaTipo;


    public void criarUsuario() {

        System.out.println("Informe o Tipo de Usuario deseja Criar: ");
        System.out.println("1 - Usuario Não Verbal");
        System.out.println("2 - Parente Responsavel");
        System.out.println("3 - Medico");
        System.out.print("Escolha uma das opções: ");
        escolhaTipo= input.nextInt();

        switch (escolhaTipo){
            case 1:
                escolhaUsuario.criarUsuarioNaoVerbal(prontuario);
                break;
            case 2:
                escolhaUsuario.criarUsuarioParenteResponsavel();
                break;
            case 3:
                escolhaUsuario.criarUsuarioMedico();
                break;
            default:
                System.out.println("Usuario não encontrado");
                break;
        }
    }


    public void listarUsuario(GerirUsuario lista, GerirProntuario prontuario) {
        System.out.println("Usuarios cadastrados: \n " + ((RepositorioUsuarioLista) lista).listarUsuarios());
        if (escolhaTipo == 3) {
                System.out.println("CRM: " + ((Medico)medico).getCrm());
            } else if (escolhaTipo == 1) {
            System.out.println("Prontuario:\n " + ((RepositorioUsuarioProntuario) prontuario).prontuarioUsuario());
        }
    }


    public void removerUsuario(GerirUsuario lista) {
        System.out.println("Digite o email do usuário que deseja remover:");
        String email = input.next();

        lista.removerusuario(email);
        System.out.println("Operação concluída");
    }

}