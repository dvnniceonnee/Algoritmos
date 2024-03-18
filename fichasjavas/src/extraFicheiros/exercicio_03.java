package extraFicheiros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static ficha_07.BibliotecaFiles.*;

public class exercicio_03 {

    public static void menuPrincipal() {
        System.out.print("1. Gerir base de dados \n" +
                "2. Consultar Clientes \n" +
                "3. Consultar Quartos Disponíveis \n" +
                "4. Consultar Reservas \n" +
                "5. Registar Nova Reserva\n" +
                "6. Dashboard de Analise\n" +
                "7. Galeria\n" +
                "8. Sair\n");
    }


    /**
     * Array com os caminhos dos ficheiro
     * 0 - login
     * 1 - ficheiro clients
     * 2 - ficheiro temas
     * 3 - ficheiro quartos
     * 4 - ficheiro produtos
     * 5 - ficheiro reservas
     * 6 - ficheiro reservas
     * 7 - ficheiro servicos
     * 8 - galeria spa
     * 9 - galeria quarto
     * 10 - galeria fachada
     */
    public static String[] ficheirosHotel() {
        String[] ficheirosDoHotel = {"fichasjavas/files/ficha_extraFicheiros/Ex_03 Hotel Temático/loginHotel.txt",
                "fichasjavas/files/ficha_extraFicheiros/Ex_03 Hotel Temático/clientesHotel.csv",
                "fichasjavas/files/ficha_extraFicheiros/Ex_03 Hotel Temático/temasHotel.csv",
                "fichasjavas/files/ficha_extraFicheiros/Ex_03 Hotel Temático/quartosHotel.csv",
                "fichasjavas/files/ficha_extraFicheiros/Ex_03 Hotel Temático/produtosHotel.csv",
                "fichasjavas/files/ficha_extraFicheiros/Ex_03 Hotel Temático/reservasHotel.csv",
                "fichasjavas/files/ficha_extraFicheiros/Ex_03 Hotel Temático/servicoQuartoHotel.csv",
                "fichasjavas/files/ficha_extraFicheiros/Ex_03 Hotel Temático/galeriaSpaHotel.txt",
                "fichasjavas/files/ficha_extraFicheiros/Ex_03 Hotel Temático/galeriaQuartoHotel.txt",
                "fichasjavas/files/ficha_extraFicheiros/Ex_03 Hotel Temático/galeriaFachadaHotel.txt"};
        return ficheirosDoHotel;
    }

    /**
     * Função para retornar uma lista de dados consoante a pesquisa indica pelo utilizar
     *
     * @param matriz recebe uma matriz com os dados que queremos pesquisar das musicas
     * @param user   String com o username a verificar
     * @param pass   String com a password a verificar
     * @return booleano a dizer se o utilizar é valido ou não
     */
    public static boolean loginValido(String[][] matriz, String user, String pass) {
        boolean userValido = false;

        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0].equals(user)) {
                if (matriz[i][1].equals(pass)) {
                    userValido = true;
                }
            }
        }
        return userValido;

    }

    public static String[][] leituraFicheiroMatriz(File ficheiro, boolean cabecalhoRetirar, String charDelimitador) throws FileNotFoundException {
        String[][] matriz = new String[0][0];
        try{
            int[] numberLinCol = numeroLinhasColunas(ficheiro,";");
            matriz = matrizDados(ficheiro,numberLinCol[0],numberLinCol[1],cabecalhoRetirar, charDelimitador);
        }catch (FileNotFoundException ex1){
            System.out.println("Ficheiro "+ ficheiro.getName() + " nao foi lido!");
        }
        return matriz;
    }
    public static void menuGerirClientes() {
        int opcao = 0;
        do {
            System.out.println("\n1. Adicionar um cliente\n" +
                    "2. Atualizar um cliente\n" +
                    "3. Sair\n");
            switch (opcao) {
                case 1:
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }while (opcao != 3);
    }

    public static void menuGestaoBaseDados() {
        int opcao = 0;
        do {
            System.out.println("\n1. Gerir clientes\n" +
                    "2. Gerir Temas\n" +
                    "3. Gerir Quartos\n" +
                    "4. Gerir Administradores\n" +
                    "5. Gerir Produtos\n" +
                    "6. Sair\n");
            switch (opcao) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 6);

    }

    public static String[][] matrizAuthentication;
    public static String[][] matrizClientes;

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("**** Gestão do Solverde ****");
        Scanner input = new Scanner(System.in);
        File ficheiroAuth = new File(ficheirosHotel()[0]);
        try {
            matrizAuthentication = leituraFicheiroMatriz(ficheiroAuth, false, ";");
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro dados login corrompido!");
        }
        boolean authentication = false;
        do {
            System.out.print("\nUsername : ");
            String userName = input.next() + input.nextLine();
            System.out.print("\nPassword : ");
            String password = input.nextLine();
            if (loginValido(matrizAuthentication, userName, password)) {
                authentication = true;
                System.out.println("\n +++ Utilizador " + userName + " autenticado com sucesso! +++");
            } else {
                System.out.println("Username ou password incorretas!");
            }
        } while (!authentication);
        matrizClientes = leituraFicheiroMatriz(new File(ficheirosHotel()[1]), false, ";");

        int opcao = 0;
        do {
            menuPrincipal();
            System.out.print("\nO que seja realizar : ");
            try {
                opcao = input.nextInt();
            } catch (InputMismatchException ex1) {
                opcao = 0;
            }
            switch (opcao) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opção inválido!");
            }

        } while (opcao != 8);
    }
}
