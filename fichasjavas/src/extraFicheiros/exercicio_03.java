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

    /**
     * Função que permite a leitura de um ficheiro e retorna uma matriz com as informações todas do ficheiro(incluindo o cabeçalho caso o queira)
     * @param ficheiro file a ler
     * @param cabecalhoRetirar booleano (true retira, false não retira)
     * @param charDelimitador string que determina o char delimitador
     * @return uma matriz com os dados do ficheiro
     * @throws FileNotFoundException
     */
    public static String[][] leituraFicheiroMatriz(File ficheiro, boolean cabecalhoRetirar, String charDelimitador) throws FileNotFoundException {
        String[][] matriz = new String[0][0];
        try {
            int[] numberLinCol = numeroLinhasColunas(ficheiro, ";");
            matriz = matrizDados(ficheiro, numberLinCol[0], numberLinCol[1], cabecalhoRetirar, charDelimitador);
        } catch (FileNotFoundException ex1) {
            System.out.println("Ficheiro " + ficheiro.getName() + " nao foi lido!");
        }
        return matriz;
    }

    /**
     * Função que permite editar os dados de um especifico formando na matriz principal o que posteriormente pode ser guardado no ficheiro
     * @param dados recebe uma matriz com os dados todos dos formandos para editar um especifico
     * @param teclado recebe um scanner
     * @throws FileNotFoundException
     */
    public static void editarCliente(String[][] dados, Scanner teclado) throws FileNotFoundException {
        Scanner input1 = teclado;
        System.out.print("Introduza o id do cliente a editar : ");
        String idClient = input1.next() + input1.nextLine();
        boolean matriculaExiste = infoClient(dados, idClient, 0);
        if (matriculaExiste) {
            int opcao = 0;
            do {
                System.out.println("\n1. Telemovel\n2. Email \n4. Sair");
                System.out.print("\nIntroduza o que deseja editar :  ");
                try {
                    opcao = input1.nextInt();
                } catch (InputMismatchException ex1) {
                    input1.next();
                }
                String nome = "", email = "";
                switch (opcao) {
                    case 1:
                        System.out.print("\nIntroduza o novo nome : ");
                        nome = input1.next() + input1.nextLine();
                        break;
                    case 2:
                        System.out.print("\nIntroduza o novo email : ");
                        email = input1.next() + input1.nextLine();
                        break;
                    default:
                        System.out.println("Opção Inválida!");
                }
                for (int i = 0; i < dados.length; i++) {
                    if (dados[i][0].equals(idClient)) {
                        switch (opcao) {
                            case 1:
                                dados[i][1] = nome;
                                break;
                            case 2:
                                dados[i][4] = email;
                                break;
                        }
                    }
                }
            } while (opcao != 4);
        }
    }

    /**
     * Função que adiciona uma linha nova à matriz atual e posteriormente adiciona ao ficheiro caso o utilizar o desejar
     * @param dados matriz que ainda nao tem a linha do novo formando adicionada
     * @throws FileNotFoundException caso nao exista ficheiro a função lança uma exceção
     * @return Matriz atualizada com o cliente novo
     */
    public static String[][] criarCliente(String[][] dados) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.print("\nIndique o nome do cliente que deseja criar : ");
        String nome = input.next() + input.nextLine();
        System.out.print("\nIndique o telemovel do cliente : ");
        boolean telemovelValido = false;
        String telemovel = "";
        do{
            try{
                telemovel = input.nextLine();
                Integer.parseInt(telemovel);
                telemovelValido = true;
            }catch (InputMismatchException ex1){
                System.out.println("Telemovel Inválido!");
            }
        }while (!telemovelValido);
        System.out.print("\nIndique o email do " + nome + " :");
        String email = input.next() +  input.nextLine();
        boolean idadeValida = false;
        String dataNascimento = "";
        do {
            System.out.print("\nIndique a data de nascimento do " + nome);
            try {
                System.out.print("\n Ano de Nascimento: ");
                int ano = input.nextInt();
                System.out.print("\n Mês de Nascimento: ");
                int mes = input.nextInt();
                System.out.print("\n Dia de Nascimento: ");
                int dia = input.nextInt();
                idadeValida = true;
                dataNascimento = dia + "-" + mes + "-" + ano;
            } catch (Exception ex1) {
                System.out.println("Data de nascimento inválida!");
            }
        } while ((!idadeValida));

        String[][] matrizTemp = new String[dados.length + 1][dados[0].length];
        for (int i = 0; i < dados.length; i++) {
            for (int k = 0; k < dados[0].length; k++) {
                matrizTemp[i][k] = dados[i][k];
            }
        }
        matrizTemp[dados.length][0] = "C-00" + matrizTemp.length;
        matrizTemp[dados.length][1] = nome;
        matrizTemp[dados.length][2] = dataNascimento;
        matrizTemp[dados.length][3] = telemovel;
        matrizTemp[dados.length][4] = email;
        return matrizTemp;
    }

    public static void menuGerirClientes(Scanner teclado) throws FileNotFoundException {
        int opcao = 0;
        do {
            System.out.println("\n1. Adicionar um cliente\n" +
                    "2. Atualizar um cliente\n" +
                    "3. Sair\n");
            System.out.print("\nEscolha o que deseja efetuar:");
            try{
                opcao = teclado.nextInt();
            }catch (InputMismatchException ex1){
                opcao = 0;
                teclado.next();
            }
            switch (opcao) {
                case 1:
                    try {
                        matrizClientes = criarCliente(matrizClientes);
                    } catch (FileNotFoundException ex1) {
                        System.out.println("Ficheiro dos clientes Corrompido!");
                    }
                    System.out.print("Deseja guardar os dados em ficheiro (s/n) ?");
                    String opcaoGuardar = teclado.next();
                    switch (opcaoGuardar) {
                        case "s":
                            saveDataFile(ficheirosHotel()[1], matrizClientes, ";");
                            System.out.println("*** Ficheiro Atualizado! ***");
                            break;
                        case "n":
                            break;
                        default:
                            System.out.println("Opção Invalida! Ficheiros nao guardados!");
                    }
                    break;
                case 2:
                    editarCliente(matrizClientes, teclado);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 3);
    }
    public static void menuGestaoBaseDados() throws FileNotFoundException {
        int opcao = 0;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("\n1. Gerir clientes\n" +
                    "2. Gerir Temas\n" +
                    "3. Gerir Quartos\n" +
                    "4. Gerir Administradores\n" +
                    "5. Gerir Produtos\n" +
                    "6. Sair\n");
            System.out.print("Escolha o que deseja realizar : ");
            try{
                opcao = input.nextInt();
            }catch (InputMismatchException ex1){
                opcao = 0;
                input.next();
            }
            switch (opcao) {
                case 1:
                    menuGerirClientes(input);
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
                    menuGestaoBaseDados();
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
                case 8:
                    break;
                default:
                    System.out.println("Opção inválido!");
            }

        } while (opcao != 8);
    }
}
