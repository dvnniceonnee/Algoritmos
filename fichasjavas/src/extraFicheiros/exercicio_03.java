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
                "8. Guardar dados\n" +
                "9. Sair");
    }

    /**
     * Array com os caminhos dos ficheiro
     * 0 - login
     * 1 - ficheiro clients
     * 2 - ficheiro temas
     * 3 - ficheiro quartos
     * 4 - ficheiro reservas
     * 5 - ficheiro produtos
     * 6 - ficheiro serviços
     * 7 - ficheiro galeria Spa
     * 8 - galeria galeriaQuarto
     * 9 - galeria galeriaFachada
     */
    public static String[] ficheirosHotel() {
        String[] ficheirosDoHotel = {"fichasjavas/files/ficha_extraFicheiros/Ex_03 Hotel Temático/loginHotel.txt", // 0
                "fichasjavas/files/ficha_extraFicheiros/Ex_03 Hotel Temático/clientesHotel.csv", // 1
                "fichasjavas/files/ficha_extraFicheiros/Ex_03 Hotel Temático/temasHotel.csv", // 2
                "fichasjavas/files/ficha_extraFicheiros/Ex_03 Hotel Temático/quartosHotel.csv", // 3
                "fichasjavas/files/ficha_extraFicheiros/Ex_03 Hotel Temático/reservasHotel.csv", // 4
                "fichasjavas/files/ficha_extraFicheiros/Ex_03 Hotel Temático/produtosHotel.csv", // 5
                "fichasjavas/files/ficha_extraFicheiros/Ex_03 Hotel Temático/servicoQuartoHotel.csv", // 6
                "fichasjavas/files/ficha_extraFicheiros/Ex_03 Hotel Temático/galeriaSpaHotel.txt", // 7
                "fichasjavas/files/ficha_extraFicheiros/Ex_03 Hotel Temático/galeriaQuartoHotel.txt", // 8
                "fichasjavas/files/ficha_extraFicheiros/Ex_03 Hotel Temático/galeriaFachadaHotel.txt"}; // 9
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
     *
     * @param ficheiro         file a ler
     * @param cabecalhoRetirar booleano (true retira, false não retira)
     * @param charDelimitador  string que determina o char delimitador
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
     *
     * @param dados   recebe uma matriz com os dados todos dos formandos para editar um especifico
     * @param teclado recebe um scanner
     * @throws FileNotFoundException
     */
    public static void editarCliente(String[][] dados, Scanner teclado) throws FileNotFoundException {
        Scanner input1 = teclado;
        System.out.print("Introduza o id do cliente a editar : ");
        String idClient = input1.next() + input1.nextLine();
        boolean idExiste = searchIfExistsOnMatriz(dados, idClient, 0);
        if (idExiste) {
            String[] infoClient = searchForDataArray(matrizClientes, idClient, 0);
            System.out.println("ID [ " + infoClient[0] + " ] ");
            System.out.println("Nome : " + infoClient[1]);
            System.out.println("Data de Nascimento : " + infoClient[2]);
            System.out.println("Nº Telemovel : " + infoClient[3]);
            System.out.println("eMail : " + infoClient[4]);
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
     *
     * @param dados matriz que ainda nao tem a linha do novo formando adicionada
     * @return Matriz atualizada com o cliente novo
     * @throws FileNotFoundException caso nao exista ficheiro a função lança uma exceção
     */
    public static void criarCliente(String[][] dados) {
        Scanner input = new Scanner(System.in);
        System.out.print("\nIndique o nome do cliente que deseja criar : ");
        String nome = input.next() + input.nextLine();
        System.out.print("\nIndique o telemovel do cliente : ");
        boolean telemovelValido = false;
        String telemovel = "";
        do {
            try {
                telemovel = input.nextLine();
                Integer.parseInt(telemovel);
                telemovelValido = true;
            } catch (InputMismatchException ex1) {
                System.out.println("Telemovel Inválido!");
            }
        } while (!telemovelValido);
        System.out.print("\nIndique o email do " + nome + " :");
        String email = input.next() + input.nextLine();
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

        String[] novaLinha = {incrementID(dados[dados.length - 1][0], "-", 1), nome, dataNascimento, telemovel, email};
        matrizClientes = addLineToMatriz(novaLinha, matrizClientes);
    }

    public static void askSaveData(Scanner teclado, String pathFile, String[][] matriz, String delimitador) throws FileNotFoundException {
        System.out.print("Deseja guardar os dados em ficheiro (s/n) ?");
        String opcaoGuardar = teclado.next();
        switch (opcaoGuardar) {
            case "s":
                saveDataFile(pathFile, matriz, delimitador);
                System.out.println("*** Ficheiro Atualizado! ***");
                break;
            case "n":
                break;
            default:
                System.out.println("Opção Invalida! Ficheiros nao guardados!");
        }
    }

    /**
     * Função que permite adicionar um tema à matriz dos temas
     *
     * @param teclado scanner
     */
    public static void novoTema(Scanner teclado) {
        System.out.print("\nIntroduza novo do novo tema:");
        String nomeTema = teclado.next() + teclado.nextLine();
        String preco = "";
        boolean precoValido = false;
        while (!precoValido) {
            try {
                System.out.print("\n Introduza o preço multiplicador : ");
                preco = teclado.nextLine();
                Double.parseDouble(preco);
                precoValido = true;
            } catch (Exception ex1) {
                System.out.println("\n!!! Valor introduzido inválido !!!");
            }
        }
        String id = incrementID(matrizTemas[matrizTemas.length - 1][0], "-", 1);
        String[] novaLinha = {id, nomeTema, preco};
        matrizTemas = addLineToMatriz(novaLinha, matrizTemas);
    }

    /**
     * Função que permite adicionar um quarto pedindo ao utilizar os campos necessários
     *
     * @param teclado para pedir ao utilizador as informações
     */
    public static void novoQuarto(Scanner teclado) {
        System.out.print("Introduza o tema do novo quarto (numero): ");
        String temaQuarto = teclado.next();
        boolean temaValido = false;
        while (!searchMatriz(matrizTemas, "t-0" + temaQuarto, 0)) {
            System.out.println("Tema inválido!");
            System.out.print("Introduza o tema do novo quarto (numero): ");
            temaQuarto = teclado.next();
        }
        temaQuarto = "t-0" + temaQuarto;
        System.out.print("\n 1. SINGLE \n2. DOUBLE\n3. SUITE \nTipo do quarto : ");
        String tipoQuarto = "";
        boolean tipoQuartoValido = false;
        do {
            int opcaoTipoQuarto = 0;
            try {
                opcaoTipoQuarto = teclado.nextInt();
            } catch (InputMismatchException ex1) {
                System.out.println("Tipo de quarto inválido!");
            }
            switch (opcaoTipoQuarto) {
                case 1:
                    tipoQuarto = "SINGLE";
                    tipoQuartoValido = true;
                    break;
                case 2:
                    tipoQuarto = "DOUBLE";
                    tipoQuartoValido = true;
                    break;
                case 3:
                    tipoQuarto = "SUITE";
                    tipoQuartoValido = true;
                    break;
                default:
                    System.out.println("Opção Invalida");

            }
        } while (!tipoQuartoValido);
        String[] novaLinha = {incrementID(matrizQuartos[matrizQuartos.length - 1][0], " ", 0), temaQuarto, tipoQuarto};
        matrizTemas = addLineToMatriz(novaLinha, matrizQuartos);
    }

    /**
     * Função que permite adicionar um novo produto à matriz dos produtos
     *
     * @param teclado scanner input
     */
    public static void newProduct(Scanner teclado) {
        System.out.print("Introduza o nome do produto novo : ");
        String nome = teclado.next() + teclado.nextLine();
        while (searchMatriz(matrizProdutos, nome, 1)) {
            System.out.println("Nome do produto já existente!");
            System.out.print("Introduza o nome do produto novo : ");
            nome = teclado.nextLine();
        }
        boolean precoValido = false;
        String preco = "";
        while (!precoValido) {
            System.out.print("Introduza o preço do produto: ");
            preco = teclado.nextLine();
            try {
                Double.parseDouble(preco);
                precoValido = true;
            } catch (Exception ex1) {
                System.out.println("Preço introduzido inválido!");
            }
        }
        String id = incrementID(matrizProdutos[matrizProdutos.length - 1][0], "-", 1);
        String[] linhaNova = {id, nome, preco};
        matrizProdutos = addLineToMatriz(linhaNova, matrizProdutos);
    }

    /**
     * Função para apgar ou criar um novo utilizador na base de dados
     *
     * @param neworDelete (1- cria   , 2 - apaga)
     * @param input       scanner
     */
    public static void userNeworDelete(int neworDelete, Scanner input) {
        if (neworDelete == 1) {
            System.out.print("Introduza o nick do user novo : ");
            String username = input.next() + input.nextLine();
            boolean userExiste = false;
            while (searchMatriz(matrizAuthentication, username, 0)) {
                System.out.println("User name já existe!");
                System.out.print("Introduza o nick do user novo : ");
                username = input.next() + input.nextLine();
            }
            System.out.print("\nIntroduza a password do " + username + " : ");
            String password = input.nextLine();

            String[][] temp = new String[matrizAuthentication.length + 1][matrizQuartos[0].length];
            for (int i = 0; i < matrizAuthentication.length; i++) {
                for (int k = 0; k < matrizAuthentication[0].length; k++) {
                    temp[i][k] = matrizAuthentication[i][k];
                }
            }
            temp[matrizAuthentication.length][0] = username;
            temp[matrizAuthentication.length][1] = password;

            matrizAuthentication = temp;
        } else {
            System.out.print("Introduza o user para apgar : ");
            String username = input.next() + input.nextLine();
            boolean userExiste = false;
            while (!searchIfExistsOnMatriz(matrizAuthentication, username, 0)) {
                System.out.println("User name nao existe!");
                System.out.print("Introduza o username para apagar : ");
                username = input.next() + input.nextLine();
            }

            matrizAuthentication = deleteLine(matrizAuthentication, username, 0);
        }
    }

    public static void menuGerirClientes(Scanner teclado) throws FileNotFoundException {
        int opcao = 0;
        do {
            System.out.println("\n1. Adicionar um cliente\n" +
                    "2. Atualizar um cliente\n" +
                    "3. Sair\n");
            System.out.print("\nEscolha o que deseja efetuar:");
            try {
                opcao = teclado.nextInt();
            } catch (InputMismatchException ex1) {
                opcao = 0;
                teclado.next();
            }
            switch (opcao) {
                case 1:
                    criarCliente(matrizClientes);
                    askSaveData(teclado, ficheirosHotel()[1], matrizClientes, ";");
                    break;
                case 2:
                    editarCliente(matrizClientes, teclado);
                    askSaveData(teclado, ficheirosHotel()[1], matrizClientes, ";");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 3);
    }

    public static void gestaoAdmins(Scanner input) throws FileNotFoundException {
        int opcao = 0;
        do {
            System.out.println("\n1. Criar novas credencias \n2. Apagar credencias\n3. Sair");
            System.out.print("\nEscolha o que deseja realizar : ");
            boolean opcaoValida = false;
            while (!opcaoValida) {
                try {
                    opcao = input.nextInt();
                    opcaoValida = true;
                } catch (InputMismatchException ex1) {
                    input.next();
                }
            }
            switch (opcao) {
                case 1:
                    userNeworDelete(1, input);
                    askSaveData(input, ficheirosHotel()[0], matrizAuthentication, ";");
                    break;
                case 2:
                    userNeworDelete(2, input);
                    askSaveData(input, ficheirosHotel()[0], matrizAuthentication, ";");
                    break;
                case 3:
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
                    "2. Adicionar Temas\n" +
                    "3. Adicionar Quartos\n" +
                    "4. Gerir Administradores\n" +
                    "5. Gerir Produtos\n" +
                    "6. Sair\n");
            System.out.print("Escolha o que deseja realizar : ");
            try {
                opcao = input.nextInt();
            } catch (InputMismatchException ex1) {
                opcao = 0;
                input.next();
            }
            switch (opcao) {
                case 1:
                    menuGerirClientes(input);
                    break;
                case 2:
                    novoTema(input);
                    askSaveData(input, ficheirosHotel()[2], matrizTemas, ";");
                    break;
                case 3:
                    novoQuarto(input);
                    askSaveData(input, ficheirosHotel()[3], matrizQuartos, ";");
                    break;
                case 4:
                    gestaoAdmins(input);
                    askSaveData(input, ficheirosHotel()[0], matrizAuthentication, ";");
                    break;
                case 5:
                    newProduct(input);
                    askSaveData(input, ficheirosHotel()[4], matrizProdutos, ";");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 6);
    }

    public static void menuConsultClients(Scanner input) {
        int opcao = 0;
        do {
            System.out.println("1. Consultar Clientes por ID\n2. Consultar clientes por telemovel\n3. Consultar clientes por email\n4. Sair");
            try {
                opcao = input.nextInt();
            } catch (InputMismatchException ex1) {
                opcao = 0;
                input.next();
            }
            boolean clienteExiste = false;
            String[] cliente = new String[0];
            switch (opcao) {
                case 1:
                    System.out.print("Introduza qual o ID a procurar : ");
                    String id = input.next() + input.nextLine();
                    if (searchIfExistsOnMatriz(matrizClientes, id, 0)) {
                        cliente = searchForDataArray(matrizClientes, id, 0);
                        clienteExiste = true;
                    }
                    break;
                case 2:
                    System.out.print("Introduza qual o telemovel a procurar : ");
                    String telemovel = input.next() + input.nextLine();
                    if (searchIfExistsOnMatriz(matrizClientes, telemovel, 3)) {
                        cliente = searchForDataArray(matrizClientes, telemovel, 3);
                        clienteExiste = true;
                    }
                    break;
                case 3:
                    System.out.print("Introduza qual o email a procurar : ");
                    String email = input.next() + input.nextLine();
                    if (searchIfExistsOnMatriz(matrizClientes, email, 4)) {
                        cliente = searchForDataArray(matrizClientes, email, 4);
                        clienteExiste = true;
                    }
                    break;
            }
            if (clienteExiste) {
                System.out.println("Id : " + cliente[0] + "\nNome: " + cliente[1] + "\nData Nascimento : " + cliente[2] + "\nTelemovel : " + cliente[3] + "\nEmail : " + cliente[4] + "\n");
            }

        } while (opcao != 4);
    }


    /**
     * Função que retorna um array com todos os quartos que estão reservados
     *
     * @param matriz  matriz com as reservas todas
     * @param nowDate data atual
     * @return array com os numeros dos quartos que estão com uma reserva ativa
     */
    public static String[] reservedRooms(String[][] matriz, String nowDate) {
        String[] reservedRooms = new String[0];
        for (int i = 0; i < matriz.length; i++) {
            if (dateBetween(matriz[i][1], matriz[i][2], nowDate)) {
                String[] temp = new String[reservedRooms.length + 1];
                if (reservedRooms.length == 0) {
                    temp[0] = matriz[i][4];
                } else {
                    for (int k = 0; k < reservedRooms.length; k++) {
                        temp[k] = reservedRooms[k];
                    }
                    temp[reservedRooms.length] = matriz[i][4];
                }
                reservedRooms = temp;
            }
        }
        return reservedRooms;
    }

    /**
     * Função que permite ver consoante as datas das reservas quais os quartos disponiveis
     */
    public static void availableRooms() {
        String[] roomsReservedAtive = reservedRooms(matrizReservas, dataAtual);
        matrizQuartosDispoveis = matrizQuartos;
        System.out.println();
        for (int i = 0; i < roomsReservedAtive.length; i++) {
            if (searchIfExistsOnMatriz(matrizQuartosDispoveis, roomsReservedAtive[i], 0)) {
                matrizQuartosDispoveis = deleteLine(matrizQuartosDispoveis, roomsReservedAtive[i], 0);
            }
        }
    }

    public static void menuRooms(Scanner input) {
        int opcao = 0;
        do {
            System.out.println("1. Pesquisar todos os quartos disponiveis \n2. Pesquisar quartos disponiveis por tema \n3. Pesquisar quartos disponiveis por tipo \n4. Sair");
            System.out.print("\nEscolha o que deseja efetuar :");
            try {
                opcao = input.nextInt();
            } catch (InputMismatchException ex1) {
                opcao = 0;
                input.next();
            }
            switch (opcao) {
                case 1:
                    for (int i = 0; i < matrizQuartosDispoveis.length; i++) {
                        String tema = searchForDataArray(matrizTemas, matrizQuartosDispoveis[i][1], 0)[1];
                        System.out.print("\nNumero : " + matrizQuartosDispoveis[i][0] + "\t |\t Tema : " + tema + "\t |\t Tipo : " + matrizQuartosDispoveis[i][2]);
                    }
                    System.out.println("\n");
                    break;
                case 2:
                    int opcaoTema = 0;
                    do {
                        System.out.println();
                        for (int i = 0; i < matrizTemas.length; i++) {
                            System.out.println(i + 1 + " : " + matrizTemas[i][1] + "\t Preço :: " + matrizTemas[i][2]);
                        }
                        System.out.println("0. Sair");
                        System.out.print("\nIntroduza o tema que deseja procurar : ");
                        try {
                            opcaoTema = input.nextInt();
                        } catch (InputMismatchException ex1) {
                            opcaoTema = 999;
                            System.out.println("Tema inválido!");
                        }
                        if (opcaoTema > 0 && opcaoTema < 6) {
                            String tema = matrizTemas[opcaoTema - 1][0];
                            if (searchIfExistsOnMatriz(matrizQuartosDispoveis, tema, 1)) {
                                String[][] roomsByTheme = searchForDataMatriz(matrizQuartosDispoveis, tema, 1);
                                for (int i = 0; i < roomsByTheme.length; i++) {
                                    tema = searchForDataArray(matrizTemas, roomsByTheme[i][1], 0)[1];
                                    System.out.print("\nNumero : " + roomsByTheme[i][0] + "\t |\t Tema : " + tema + "\t |\t Tipo : " + roomsByTheme[i][2]);
                                }
                            }
                        }
                    } while (opcaoTema != 0);
                    break;
                case 3:
                    int opcaoTipo = 0;
                    do {
                        System.out.println();
                        String[] roomsTypes = listaDadosColuna(matrizQuartos, 2);
                        for (int i = 0; i < roomsTypes.length; i++) {
                            System.out.println(i + 1 + " : " + roomsTypes[i]);
                        }
                        System.out.println("0. Sair");
                        System.out.print("\nIntroduza o tipo que deseja procurar : ");
                        try {
                            opcaoTipo = input.nextInt();
                        } catch (InputMismatchException ex1) {
                            opcaoTipo = roomsTypes.length + 1;
                            System.out.println("Tema inválido!");
                        }
                        if (opcaoTipo > 0 && opcaoTipo < roomsTypes.length + 1) {
                            String roomType = roomsTypes[opcaoTipo - 1];
                            if (searchIfExistsOnMatriz(matrizQuartosDispoveis, roomType, 2)) {
                                String[][] roomsByTheme = searchForDataMatriz(matrizQuartosDispoveis, roomType, 2);
                                for (int i = 0; i < roomsByTheme.length; i++) {
                                    String theme = searchForDataArray(matrizTemas, roomsByTheme[i][1], 0)[1];
                                    System.out.print("\nNumero : " + roomsByTheme[i][0] + "\t |\t Tema : " + theme + "\t |\t Tipo : " + roomsByTheme[i][2]);
                                }

                            }
                        }
                        System.out.println();
                    } while (opcaoTipo != 0);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
    }

    /**
     * Função que retorna as reservas ativas
     */
    public static void ativeReservations() {
        matrizReservasAtivas = new String[0][matrizReservas[0].length];
        int contadorLinhas = 0;
        for (int i = 0; i < matrizReservas.length; i++) {
            if (dateBetween(matrizReservas[i][1], matrizReservas[i][2], dataAtual)) {
                String[] arrayToAdd = matrizReservas[i];
                matrizReservasAtivas = addLineToMatriz(arrayToAdd, matrizReservasAtivas);
            }
        }
    }

    /**
     * Função que retorna as reservas todas que contém uma data de fim inferior á data atual
     */
    public static void futureReservations() {
        String[][] temp = new String[0][0];
        for (int i = 0; i < matrizReservas.length; i++) {
            if (dateBefore(matrizReservas[i][2], dataAtual)) {
                temp = addLineToMatriz(matrizReservas[i], temp);
            }
        }
        matrizReservasFuturas = temp;
    }

    /**
     * metodo para atribuir uma matriz com as reservas antigas (reservas que terminaram antes do dia atual) á matriz das matrizReservasAntigas
     */
    public static void oldReservations() {
        String[][] temp = new String[0][0];
        for (int i = 0; i < matrizReservas.length; i++) {
            if (!dateBefore(matrizReservas[i][2], dataAtual)) {
                temp = addLineToMatriz(matrizReservas[i], temp);
            }
        }
        matrizReservasAntigas = temp;
    }

    public static void menuReservations(Scanner input) {
        int opcao = 0;
        do {
            System.out.println("1. Consultar o histórico de reservas até à data atual (" + dataAtual + ")\n" +
                    "2. Consultar Reservas Ativas \n 3. Sair");
            try {
                opcao = input.nextInt();
            } catch (InputMismatchException ex1) {
                opcao = 0;
            }
            switch (opcao) {
                case 1:
                    for (int i = 0; i < matrizReservas.length; i++) {
                        if (!dateBefore(matrizReservas[i][2], dataAtual)) {
                            System.out.println("Reserva : " + matrizReservas[i][0] + "\t Data Inicio : " + matrizReservas[i][1] + "\t Data Fim : " + matrizReservas[i][2] +
                                    "\t Cliente : " + matrizReservas[i][3] + "\t Quarto : " + matrizReservas[i][4]);
                        }
                    }
                    break;
                case 2:
                    if (matrizReservasAtivas.length > 0) {
                        for (int i = 0; i < matrizReservasAtivas.length; i++) {
                            System.out.println("Reserva : " + matrizReservasAtivas[i][0] + "\t Data Inicio : " + matrizReservasAtivas[i][1] + "\t Data Fim : " + matrizReservasAtivas[i][2] +
                                    "\t Cliente : " + matrizReservasAtivas[i][3] + "\t Quarto : " + matrizReservasAtivas[i][4]);
                        }
                    } else {
                        System.out.println("Nao existem reservas ativas!");
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 3);
    }

    /**
     * Função para pedir uma data que vai ser retornada numa string com o formato (dd/mm/yyyy)
     *
     * @param input scanner
     * @return String com a data num formato (dd/mm/yyyy)
     */
    public static String askForData(Scanner input) {
        int dia = 0;
        while (dia == 0) {
            System.out.print("Introduza o dia : ");
            try {
                dia = input.nextInt();
                if (dia <= 0 || dia > 31) {
                    dia = 0;
                    System.out.println("Dia introduzido inválido!");
                }
            } catch (InputMismatchException ex1) {
                System.out.println("Dia introduzido inválido!");
                input.next();
            }
        }
        int mes = 0;
        while (mes == 0) {
            System.out.print("Introduza o mes : ");
            try {
                mes = input.nextInt();
                if (mes <= 0 || mes > 12) {
                    System.out.println("Mes introduzido inválido!");
                    mes = 0;
                }
            } catch (InputMismatchException ex1) {
                System.out.println("Mes introduzido inválido!");
                input.next();
            }
        }

        int ano = 0;
        while (ano == 0) {
            System.out.print("Introduza o ano : ");
            try {
                ano = input.nextInt();
                if (ano <= 0 || ano > 9999) {
                    ano = 0;
                    System.out.println("Ano introduzido inválido!");
                }
            } catch (InputMismatchException ex1) {
                System.out.println("Ano introduzido inválido!");
                input.next();
            }
        }
        String diaString = dia + "";
        String mesString = mes + "";
        if (dia < 10) {
            diaString = "0" + dia;
        }
        if (mes < 10) {
            mesString = "0" + mes;
        }
        return diaString + "/" + mesString + "/" + ano;
    }

    public static void newReserve(Scanner input) {
        boolean validReserve = false;
        do {
            System.out.print("Introduza o numero de quarto : ");
            String roomNumber = input.next() + input.nextLine();
            while (!searchIfExistsOnMatriz(matrizQuartos, roomNumber, 0)) {
                System.out.println("Numero de quarto nao encontrado!");
                roomNumber = input.next() + input.nextLine();
            }
            System.out.print("Introduza o id do ciente : ");
            String idClient = input.next() + input.nextLine();
            while (!searchIfExistsOnMatriz(matrizClientes, idClient, 0)) {
                System.out.println("Cliente não encontrado");
                System.out.print("Introduza o id do ciente : ");
                idClient = input.nextLine();
            }
            System.out.println("\n*** Data de inicio da reserva ***");
            String dataReservaInicio = askForData(input);
            System.out.println(dataReservaInicio);
            System.out.println("\n*** Data de fim da reserva ***");
            String dataReservaFim = askForData(input);
            System.out.println(dataReservaFim);
            boolean datevalid = true;
            if (searchIfExistsOnMatriz(matrizReservasFuturas, roomNumber, 4)) {
                String[][] matrizReservasFuturasTemp = searchForDataMatriz(matrizReservasFuturas, roomNumber, 4);
                for (int i = 0; i < matrizReservasFuturasTemp.length; i++) {
                    if (dateBetween(matrizReservasFuturasTemp[i][1], matrizReservasFuturasTemp[i][2], dataReservaInicio)) {
                        datevalid = false;
                        i = matrizReservasFuturasTemp.length;
                    } else if (dateBetween(matrizReservasFuturasTemp[i][1], matrizReservasFuturasTemp[i][2], dataReservaFim)) {
                        datevalid = false;
                        i = matrizReservasFuturasTemp.length;
                    }
                }
            } else if (searchIfExistsOnMatriz(matrizReservasAtivas, roomNumber, 4)) {
                String[][] matrizReservasAtivasTemp = searchForDataMatriz(matrizReservasFuturas, roomNumber, 4);
                for (int i = 0; i < matrizReservasAtivasTemp.length; i++) {
                    if (dateBetween(matrizReservasAtivasTemp[i][1], matrizReservasAtivasTemp[i][2], dataReservaInicio)) {
                        datevalid = false;
                        i = matrizReservasAtivasTemp.length;
                    } else if (dateBetween(matrizReservasAtivasTemp[i][1], matrizReservasAtivasTemp[i][2], dataReservaFim)) {
                        datevalid = false;
                        i = matrizReservasAtivasTemp.length;
                    }
                }
            }

            if (!datevalid) {
                validReserve = false;
                System.out.println("Datas inseridas já se encontram ocupadas! Insere novos dados para a reserva!");
            } else {
                validReserve = true;
                String[] newReserve = {incrementID(matrizReservas[matrizReservas.length - 1][0], "-a", 1), dataReservaInicio, dataReservaFim, idClient, roomNumber};
                matrizReservas = addLineToMatriz(newReserve, matrizReservas);
                System.out.println("++++ Reserva Inserida ++++");
            }
        } while (!validReserve);
    }

    /**
     * Metodo para salvar os dados todos nos ficheiros correspondentes
     *
     * @throws FileNotFoundException
     */
    public static void saveAllFiles() throws FileNotFoundException {
        saveDataFile(ficheirosHotel()[0], matrizAuthentication, ";");
        saveDataFile(ficheirosHotel()[1], matrizClientes, ";");
        saveDataFile(ficheirosHotel()[2], matrizTemas, ";");
        saveDataFile(ficheirosHotel()[3], matrizQuartos, ";");
        saveDataFile(ficheirosHotel()[4], matrizReservas, ";");
        saveDataFile(ficheirosHotel()[5], matrizProdutos, ";");
    }

    /**
     * metodo para calcular o total em euros de todos os serviços que a reserva gastou
     *
     * @param reservaId String com o id da reserva
     * @return double com o total em euros
     */
    public static double reservaServicosGastosValor(String reservaId) {
        double valorGasto = 0;
        String[][] servicosReserva = searchForDataMatriz(matrizServicosQuartos, reservaId, 1);
        for (int i = 0; i < servicosReserva.length; i++) {
            int qtdproduto = Integer.parseInt(servicosReserva[i][3]);
            double gorjeta = Integer.parseInt(servicosReserva[i][4]);
            String[] produto = searchForDataArray(matrizProdutos, servicosReserva[i][2], 0);
            double precoProduto = Double.parseDouble(produto[2]);
            valorGasto += (qtdproduto * precoProduto) + gorjeta;
        }
        return valorGasto;
    }

    /**
     * Metodo para retornar os anos das datas de inicio da lista da matrizReservasAntigas
     * @return array com a lista de anos sem repetições (2022, 2023, 2024)
     */
    public static String[] checkSalesYears(){
        String[] yearsArray = new String[0];
        for (int i = 0; i < matrizReservasAntigas.length; i++){
            String year = matrizReservasAntigas[i][1].split("/")[2];
            boolean yearExiste = false;
            for(int j = 0; j < yearsArray.length; j++){
                if (year.equals(yearsArray[j])){
                    yearExiste = true;
                }
            }
            if (!yearExiste){
                String[] temp = new String[yearsArray.length +1];
                if (yearsArray.length == 0){
                    temp[0] = year;
                }
                else {
                    for (int k = 0; k < yearsArray.length; k++){
                        temp[k] = yearsArray[k];
                    }
                    temp[yearsArray.length] = year;
                }
                yearsArray = temp;
            }
        }
        return yearsArray;
    }

    /**
     * Função que retorna um valor total da receita de um dado ano passado por string
     *
     * @param ano String com o ano que desejamos procurar
     * @return double com o valor total em euros da receita do ano em questão
     */
    public static double valorReceitaPorAno(String ano) {
        double valorTotal = 0;
        for (int i = 0; i < matrizReservasAntigas.length; i++) {
            if (dateBetween("01/01/" + ano, "30/12/" + ano, matrizReservasAntigas[i][1])) {
                String[] quarto = searchForDataArray(matrizQuartos, matrizReservasAntigas[i][4], 0);          // array com as informaçoes do quarto
                double multiplicador = Double.parseDouble(searchForDataArray(matrizTemas, quarto[1], 0)[2]);    // multiplicador do tema
                int precoQuarto = 0;
                for (int k = 0; k < tipoQuartos.length; k++) {
                    if (tipoQuartos[k].equalsIgnoreCase(quarto[2])) {
                        precoQuarto = precosTipoQuarto[k];
                    }
                }
                int dias = countDateDays(matrizReservasAntigas[i][1], matrizReservasAntigas[i][2]);
                valorTotal += (precoQuarto * multiplicador) + reservaServicosGastosValor(matrizReservasAntigas[i][0]);
            }
        }
        return valorTotal;
    }

    public static String menuOpcoesDashBoard() {
        return """

                1. Receita total por ano
                2. Despesa Total por ano
                3. Lucro por anos
                4. Melhor Cliente (Mais gastador em noites e serviços de quarto)
                5. Cliente mais consumista (Mais gastador em serviços de quarto)
                6. Cliente mais presente
                7. Tema mais procurado
                8. Tema mais lucrativo
                9. Tema menos lucrativo
                10. Produto/Serviço mais procurado
                11. Produto/Serviço menos procurado
                12. Produto/Serviço mais lucrativo
                """;
    }

    public static void menuDashboard(Scanner input) {
        int opcao = 0;
        String[] yearsSales = checkSalesYears();
        for(int i = 0; i< yearsSales.length; i++){
            System.out.println(yearsSales[i]);
        }
        do {
            System.out.print(menuOpcoesDashBoard());
            System.out.print("\nO que seja realizar : ");
            try {
                opcao = input.nextInt();
            } catch (InputMismatchException ex1) {
                opcao = 0;
            }
            switch (opcao) {
                case 1:
                    for (int i = 0; i < yearsSales.length; i++){
                        Double totalano = valorReceitaPorAno(yearsSales[i]);
                        System.out.println("." + yearsSales[i] + " : " + totalano);
                    }
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
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                default:
                    System.out.println("Opção inválido!");
            }
        } while (opcao != 13);

    }

    public static String[] tipoQuartos = {"SINGLE", "DOUBLE", "SUITE"};
    public static int[] precosTipoQuarto = {95, 110, 250};
    public static String dataAtual = "08/03/2024";
    public static String[][] matrizAuthentication;
    public static String[][] matrizClientes;
    public static String[][] matrizTemas;
    public static String[][] matrizQuartos;
    public static String[][] matrizQuartosDispoveis;
    public static String[][] matrizProdutos;
    public static String[][] matrizReservas;
    public static String[][] matrizReservasAtivas;
    public static String[][] matrizReservasFuturas;
    public static String[][] matrizReservasAntigas;
    public static String[][] matrizServicosQuartos;

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
        matrizTemas = leituraFicheiroMatriz(new File(ficheirosHotel()[2]), false, ";");
        matrizQuartos = leituraFicheiroMatriz(new File(ficheirosHotel()[3]), false, ";");
        matrizProdutos = leituraFicheiroMatriz(new File(ficheirosHotel()[5]), false, ";");
        matrizReservas = leituraFicheiroMatriz(new File(ficheirosHotel()[4]), false, ";");
        matrizServicosQuartos = leituraFicheiroMatriz(new File(ficheirosHotel()[6]), false, ";");
        availableRooms();
        ativeReservations();
        futureReservations();
        oldReservations();
        checkSalesYears();
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
                    menuConsultClients(input);
                    break;
                case 3:
                    menuRooms(input);
                    break;
                case 4:
                    menuReservations(input);
                    break;
                case 5:
                    newReserve(input);
                    break;
                case 6:
                    menuDashboard(input);
                    break;
                case 7:
                    break;
                case 8:
                    try {
                        saveAllFiles();
                    } catch (FileNotFoundException ex1) {
                        System.out.println("Ficheiros nao guardados!");
                    }
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Opção inválido!");
            }

        } while (opcao != 9);
    }
}
