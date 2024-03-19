package extraFicheiros;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
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
        matrizClientes = addLine(novaLinha, matrizClientes);
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
        matrizTemas = addLine(novaLinha, matrizTemas);
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
        matrizTemas = addLine(novaLinha, matrizQuartos);
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
        matrizProdutos = addLine(linhaNova, matrizProdutos);
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
                    if(searchIfExistsOnMatriz(matrizClientes,id,0 )){
                        cliente = searchForDataArray(matrizClientes, id,0);
                        clienteExiste = true;
                    }
                    break;
                case 2:
                    System.out.print("Introduza qual o telemovel a procurar : ");
                    String telemovel = input.next() + input.nextLine();
                    if(searchIfExistsOnMatriz(matrizClientes,telemovel,3 )){
                        cliente = searchForDataArray(matrizClientes, telemovel,3);
                        clienteExiste = true;
                    }
                    break;
                case 3:
                    System.out.print("Introduza qual o email a procurar : ");
                    String email = input.next() + input.nextLine();
                    if (searchIfExistsOnMatriz(matrizClientes,email,4 )){
                        cliente = searchForDataArray(matrizClientes, email,4);
                        clienteExiste = true;
                    }
                    break;
            }
            if(clienteExiste){
                System.out.println("Id : " + cliente[0] + "\nNome: " + cliente[1] + "\nData Nascimento : " + cliente[2] + "\nTelemovel : " + cliente[3] + "\nEmail : " + cliente[4] + "\n");
            }

        } while (opcao != 4);
    }

    /**
     * Função que determina se uma data está dentro ou incluso de um intervalo de datas
     * @param date1 data do inicio do intervalo
     * @param date2 data do fim do intervalo
     * @param dateToCheck data a verificar
     * @return booleano (true - está dentro do intervalo ; false = não está dentro do intervalo)
     */
    public static boolean dateBetween(String date1, String date2, String dateToCheck){
        String[] data = dateToCheck.split("/");
        int diaAtual = Integer.parseInt(data[0]), mesAtual = Integer.parseInt(data[1]), anoAtual = Integer.parseInt(data[2]);

        String[] dataInicioReserva = date1.split("/");
        String[] dataFimReserva = date2.split("/");
        int diaInicioReserva = Integer.parseInt(dataInicioReserva[0]), mesInicioReserva = Integer.parseInt(dataInicioReserva[1]), anoInicioReserva =  Integer.parseInt(dataInicioReserva[2]);
        int diaFimReserva = Integer.parseInt(dataFimReserva[0]), mesFimReserva = Integer.parseInt(dataFimReserva[1]), anoFimReserva =  Integer.parseInt(dataFimReserva[2]);

        boolean dataAtualDepoisInicio = false;
        boolean dataAtualAntesFim = false;
        if (anoAtual > anoInicioReserva ){
            dataAtualDepoisInicio = true;
        }
        else if (anoAtual == anoInicioReserva){
            if (mesAtual > mesInicioReserva){
                dataAtualDepoisInicio = true;
            }
            else if (mesAtual == mesInicioReserva){
                if (diaAtual >= diaInicioReserva){
                    dataAtualDepoisInicio = true;
                }
            }
        }
        if (anoAtual < anoFimReserva){
            dataAtualAntesFim = true;
        }
        else if (anoAtual == anoFimReserva){
            if (mesAtual < mesFimReserva){
                dataAtualAntesFim = true;
            }
            else  if(mesAtual == mesFimReserva){
                if (diaAtual <= diaFimReserva)
                    dataAtualAntesFim = true;
            }
        }
        if (dataAtualAntesFim && dataAtualDepoisInicio){
            return true;
        }
        return false;
    }

    /**
     * Função que retorna um array com todos os quartos que estão reservados
     * @param matriz matriz com as reservas todas
     * @param nowDate data atual
     * @return array com os numeros dos quartos que estão com uma reserva ativa
     */
    public static String[] reservedRooms(String[][] matriz, String nowDate){
        String[] reservedRooms = new String[0];
        for(int i = 0; i < matriz.length; i++){
            if (dateBetween(matriz[i][1], matriz[i][2], nowDate)){
                String[] temp = new String[reservedRooms.length +1];
                if (reservedRooms.length == 0){
                    temp[0] = matriz[i][4];
                }
                else {
                    for (int k = 0; k < reservedRooms.length; k++){
                        temp[k] = reservedRooms[k];
                    }
                    temp[reservedRooms.length] = matriz[i][4];
                }
                reservedRooms = temp;
            }
        }
        return  reservedRooms;
    }

    /**
     * Função que permite ver consoante as datas das reservas quais os quartos disponiveis
     */
    public static void availableRooms(){
        String[] roomsReservedAtive = reservedRooms(matrizReservas, dataAtual);
        matrizQuartosDispoveis = matrizQuartos;
        System.out.println();
        for(int i = 0; i < roomsReservedAtive.length; i++){
            if (searchIfExistsOnMatriz(matrizQuartosDispoveis,roomsReservedAtive[i], 0 )){
                matrizQuartosDispoveis = deleteLine(matrizQuartosDispoveis, roomsReservedAtive[i],0 );
            }
        }
    }
    public static void menuReservas(Scanner input){
        int opcao = 0;
        do{
            System.out.println("1. Pesquisar todos os quartos disponiveis \n2. Pesquisar quartos disponiveis por tema \n3. Pesquisar quartos disponiveis por tipo \n4. Sair");
            System.out.print("\nEscolha o que deseja efetuar :");
            try{
                opcao = input.nextInt();
            }
            catch (InputMismatchException ex1){
                opcao = 0;
                input.next();
            }
            switch (opcao){
                case 1:
                    for (int i = 0; i < matrizQuartosDispoveis.length; i++){
                        String tema = searchForDataArray(matrizTemas, matrizQuartosDispoveis[i][1], 0)[1];
                        System.out.print("\nNumero : " + matrizQuartosDispoveis[i][0] + "\t |\t Tema : " + tema + "\t |\t Tipo : " + matrizQuartosDispoveis[i][2]);
                    }
                    System.out.println("\n");
                    break;
                case 2:
                    for(int i = 1; i < matrizTemas.length; i++){
                        System.out.println(i + ":: " + matrizTemas[i-1][1] + "\t Preço :: " + matrizTemas[i-1][2]);
                    }
                    System.out.println("0. Sair");
                    System.out.print("\nIntroduza o tema que deseja procurar : ");
                    int opcaoTema = 0;
                    do {
                        try {
                            opcao = input.nextInt();
                            String tema = matrizTemas[opcaoTema-1][0];
                            String[] rooms = new String[0];
                            if (searchIfExistsOnMatriz(matrizQuartosDispoveis, tema, 1)){
                                rooms = pesquisaDadosEspecificos(matrizQuartosDispoveis, tema, 1);
                            }
                        } catch (InputMismatchException ex1) {
                            opcaoTema = 999;
                            System.out.println("Tema inválido!");
                            input.next();
                        }
                    }while (opcaoTema != 0);

                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }while (opcao != 4);
    }

    public static String dataAtual = "19/03/2024";
    public static String[][] matrizAuthentication;
    public static String[][] matrizClientes;
    public static String[][] matrizTemas;
    public static String[][] matrizQuartos;
    public static String[][] matrizQuartosDispoveis;
    public static String[][] matrizProdutos;
    public static String[][] matrizReservas;

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
        matrizProdutos = leituraFicheiroMatriz(new File(ficheirosHotel()[5]), false,";");
        matrizReservas = leituraFicheiroMatriz(new File(ficheirosHotel()[4]), false, ";");
        availableRooms();
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
                    menuReservas(input);
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
