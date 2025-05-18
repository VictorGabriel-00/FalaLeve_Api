package controller;

import interfaces.GerirParenteResponsavel;
import interfaces.GerirProntuario;
import interfaces.GerirUsuario;
import model.Medico;
import model.Usuario;
import model.UsuarioNaoVerbal;
import repository.RepositorioParenteResponsavel;
import repository.RepositorioUsuarioLista;
import repository.RepositorioUsuarioProntuario;
import view.MenuPrincipal;

import java.util.Scanner;


public class GerenciarUsuario{
    RepositorioParenteResponsavel listaParente = new RepositorioParenteResponsavel();
    Medico usuarioMedico = new Medico();
    UsuarioNaoVerbal usuarioNaoVerbal = new UsuarioNaoVerbal();
    Usuario usuario = new Usuario();
    MenuPrincipal menuPrincipal = new MenuPrincipal();
    ColetarDados coletarDados = new ColetarDados();
    GerirUsuario lista = new RepositorioUsuarioLista();
    RepositorioUsuarioProntuario prontuario = new RepositorioUsuarioProntuario();
    private Usuario usuarioAtual;
    private int escolhaTipo;
    Scanner input = new Scanner(System.in);


    public void criarUsuario() {

        System.out.println("Informe o Tipo de Usuario deseja Criar: ");
        System.out.println("1 - Usuario Não Verbal");
        System.out.println("2 - Parente Responsavel");
        System.out.println("3 - Medico");
        System.out.print("Escolha uma das opções: ");
        escolhaTipo = input.nextInt();
        input.nextLine();

        switch (escolhaTipo) {
            case 1:
                coletarDados.criarUsuarioNaoVerbal(prontuario, usuarioNaoVerbal);
                break;
            case 2:
                coletarDados.criarUsuarioParenteResponsavel(listaParente);
                break;
            case 3:
                coletarDados.criarUsuarioMedico(usuarioMedico);
                break;
            default:
                System.out.println("Opção inválida");
        }

       if(usuarioAtual != null) {
           System.out.println("Usuario criado com sucesso");
       }

    }


    public void listarUsuario(RepositorioUsuarioLista lista, RepositorioParenteResponsavel listaParente, RepositorioUsuarioProntuario prontuario) {
        System.out.println("Lista de Usuarios: \n" + ((RepositorioUsuarioLista)lista).listarUsuarios());

        if(escolhaTipo == 3){
            System.out.println("CRM: " + usuarioMedico.getCrm());
        } else if (escolhaTipo == 2) {
            System.out.println("Parente Cadastrado: \n" + ((RepositorioParenteResponsavel)listaParente).listarParenteResponsavel());
        }else{
            System.out.println("Prontuario: \n" + ((RepositorioUsuarioProntuario)prontuario).prontuarioUsuario());
        }

        menuPrincipal.main(null);

    }


    public void removerUsuario(RepositorioUsuarioLista lista) {
        System.out.println("Digite o email do usuário que deseja remover:");
        String email = input.next();

        lista.removerusuario(email);
        System.out.println("Operação concluída");
        menuPrincipal.main(null);
    }

}