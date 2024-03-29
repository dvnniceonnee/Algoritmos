package trabalhoAvaliacao;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import static trabalhoAvaliacao.bibliotecaFunc.*;


public class main {

    /**
     * Lista dos caminhos dos ficheiros necessários para o programa
     *
     * @return Array [0] logins file <br> [1] clients file <br> [2] sales file <br> [3] copyright file <br> [4] categories file <br> [5] graphic callOfduty  <br>
     * [6] graphic fifa <br> [7] graphic hollowKnight <br> [8] graphic minecraft <br> [9] graphic mortalKombat <br> [10] graphic overcooked <br> [11] graphic witcher3 <br> [12] copyright file
     */
    public static String[] filesPaths() {
        String file1 = "fichasjavas/files/filesAvaliacao/GameStart_Admins.csv";
        String file2 = "fichasjavas/files/filesAvaliacao/GameStart_Clientes.csv";
        String file3 = "fichasjavas/files/filesAvaliacao/GameStart_Vendas.csv";
        String file4 = "fichasjavas/files/filesAvaliacao/GameStart_Copyright.txt";
        String file5 = "fichasjavas/files/filesAvaliacao/GameStart_Categorias.csv";
        String file6 = "fichasjavas/files/filesAvaliacao/CatalogoGrafico/callOfDuty.txt";
        String file7 = "fichasjavas/files/filesAvaliacao/CatalogoGrafico/fifa.txt";
        String file8 = "fichasjavas/files/filesAvaliacao/CatalogoGrafico/hollowKnight.txt";
        String file9 = "fichasjavas/files/filesAvaliacao/CatalogoGrafico/minecraft.txt";
        String file10 = "fichasjavas/files/filesAvaliacao/CatalogoGrafico/mortalKombat.txt";
        String file11 = "fichasjavas/files/filesAvaliacao/CatalogoGrafico/overcooked.txt";
        String file12 = "fichasjavas/files/filesAvaliacao/CatalogoGrafico/witcher3.txt";
        String file13 = "fichasjavas/files/filesAvaliacao/GameStart_Copyright.txt";
        String[] files = {file1, file2, file3, file4, file5, file6, file7, file8, file9, file10, file11, file12, file13};
        return files;
    }

    /**
     * Método que verifica se todos os ficheiros iniciais necessários estão válidos
     *
     * @throws FileNotFoundException
     */
    public static void checkAllFiles() throws FileNotFoundException {
        for (int i = 0; i < filesPaths().length; i++) {
            Scanner fileScanner = new Scanner(new File(filesPaths()[i]));           // o ficheiro entra no scanner
            fileScanner.close();                                                    // fecha o scanner para o próximo ficheiro
        }
    }

    public static boolean loginAdminValid(Scanner input) {
        System.out.print("Introduza o username : ");
        String username = input.next() + input.nextLine();
        System.out.print("Introduza a password : ");
        String password = input.nextLine();
        if (searchIfExistsOnMatriz(matrizLogins, username, 0)) {
            String passwordUser = searchForDataArray(matrizLogins, username, 0)[1];
            if (passwordUser.equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void printString(String stringTotal){
        Scanner stringScanner = new Scanner(stringTotal);
        String[] conjuntoLinhas = new String[0];
        int tamanhoMaior = 0;
        while (stringScanner.hasNextLine()){
            String proximaLinha = stringScanner.nextLine();
            conjuntoLinhas = addElementToArray(conjuntoLinhas, proximaLinha);
            if(proximaLinha.length() > tamanhoMaior)
                tamanhoMaior = proximaLinha.length();
        }
        System.out.println("\t\n");
        for(int i = 0; i <= tamanhoMaior; i++){
            if(i == 0)
                System.out.print("\t=");
            else
                System.out.print("=");
        }
        System.out.print("\n\t|\n");
        for(int i = 0; i < conjuntoLinhas.length; i++){
            System.out.print("\t\t" + (i) + ". " +  conjuntoLinhas[i] + "\n");
        }
        System.out.println("\t|");
        for(int i = 0; i <= tamanhoMaior; i++){
            if(i == 0)
                System.out.print("\t=");
            else
                System.out.print("=");
        }
    }

    /*
    ------------------- Secção Administradores -------------------------
    ------------------- Secção Administradores -------------------------
    ------------------- Secção Administradores -------------------------
    ------------------- Secção Administradores -------------------------
    */
    public static String opcoesMenuAdmin() {
        String menu = "Sair\n" +
                "Consulta de Ficheiros\n" +
                "Total de vendas\n" +
                "Total de Lucro\n" +
                "Pesquisar um cliente\n" +
                "Pesquisar o jogo mais caro\n" +
                "Pesquisar os melhores clientes\n" +
                "Pesquisar a melhor categoria\n" +
                "Pesquisa de vendas\n" +
                "Pesquisar o top(5) dos jogos com mais lucro\n" +
                "Pesquisar o bottom(5) dos jogos com menos lucro\n";

        return menu;
    }

    /**
     * Função que retorna o valor total faturado da venda e o lucro da mesma
     *
     * @param idVenda o numero da venda para calcular o lucro
     * @return array com os valores <br>
     * [0] = valor faturado total faturado na venda <br>
     * [1] = valor do lucro sobre a venda
     */
    public static double[] statisticsVenda(String idVenda) {
        String[] infoVenda = searchForDataArray(matrizVendas, idVenda, 0);
        double percentagemLucro = Double.parseDouble(searchForDataArray(matrizCategorias, infoVenda[3], 0)[1]);  // procura a percentagem de margem da categoria da venda
        double valorVenda = Double.parseDouble(infoVenda[5]);
        double lucro = valorVenda * (percentagemLucro / 100);
        double[] info = {valorVenda, lucro};
        return info;
    }

    /**
     * Metodo que retorna as estatisticas das vendas
     *
     * @return array de doubles
     * <br> [0] = valor total faturado
     * <br> [1] = valor total de lucro
     * <br> [2] = Nome do jogo mais caro
     * <br> [3] = lucro total da melhor categoria
     * <br> [4] = nome da categoria mais lucrativa
     */
    public static String[] statisticsAllVendas() {
        double valorfaturado = 0;
        double lucroTotal = 0;
        double jogoMaisCaroValor = 0;
        String jogoMaisCaro = "";
        double lucroTotalCategoria = 0;
        String melhorCategoria = "";
        boolean lucroVendas = false;
        for (int i = 0; i < matrizCategorias.length; i++) {
            double categoriaLucro = 0;
            for (int k = 0; k < matrizVendas.length; k++) {
                if (!lucroVendas) {                   // esta parte do iterador só necessita de correr uma primeira vez para calcular o lucro total e o total de faturamento nas vendas da loja
                    valorfaturado += Double.parseDouble(matrizVendas[k][5]);    // valor da venda na linha "k" que vai adicionar ao valor total faturado da loja
                    lucroTotal += statisticsVenda(matrizVendas[k][0])[1];       // lucro da venda na linha "k" que vai adicionar ao lucro total faturado da loja
                    if (valorfaturado > jogoMaisCaroValor) {                    // condicional para verificar qual é o jogo mais caro
                        jogoMaisCaroValor = valorfaturado;
                        jogoMaisCaro = matrizVendas[k][4];
                    }
                }
                // usamos esta parte do iterador para verificar qual a categoria que deu mais lucro
                if (matrizVendas[k][3].equals(matrizCategorias[i][0])) {            // caso a categoria na linha "i" seja igual à da venda adiciona ao lucro desta categoria
                    categoriaLucro += statisticsVenda(matrizVendas[k][0])[1];
                }
                if (categoriaLucro > lucroTotalCategoria) {
                    lucroTotalCategoria = categoriaLucro;
                    melhorCategoria = matrizCategorias[i][0];
                }
            }
            lucroVendas = true;
        }
        String[] statistics = {String.valueOf(valorfaturado), String.valueOf(lucroTotal), jogoMaisCaro, String.valueOf(lucroTotalCategoria), melhorCategoria};
        return statistics;
    }

    /**
     * Função que retorna uma lista dos id's dos clientes por ordem descrescente em termos de gastos na loja assim como o gasto de cada um
     *
     * @return matriz por ordem decrescente <br> coluna [0] = id do cliente <br> coluna [1] = valor gasto pelo id cliente dessa linha <br>
     * 1º Linha da matriz contém o cliente que mais gastou e assim sucessivamente
     */
    public static String[][] listaClientesOrdemGasto() {
        String[][] clientesPorOrdemGasto = new String[0][0];
        String[][] temp = matrizClientes;
        for (int i = 0; i < matrizClientes.length; i++) {  // basicamente vamos iterar todos os clientes porque queremos uma lista por ordem decrescente dos gastos de todos os clientes
            double valorTotalGasto = 0;
            String idClienteMaisGastador = "";
            for (int k = 0; k < temp.length; k++) {         // iterador da matriz clientes mas no final do ciclo antes do proximo ciclo "i" vai ser removido o cliente mais gastador
                String[][] matrizVendasDoCliente = searchForDataMatriz(matrizVendas, temp[k][0], 1);    // matriz com todas as vendas do cliente "k"
                double valorGastoCliente = 0;
                for (int e = 0; e < matrizVendasDoCliente.length; e++) {
                    valorGastoCliente += statisticsVenda(matrizVendasDoCliente[e][0])[0];
                }
                if (valorGastoCliente > valorTotalGasto) {
                    valorTotalGasto = valorGastoCliente;
                    idClienteMaisGastador = temp[k][0];
                }
            }
            if (valorTotalGasto > 0){ // so entram os clientes que fizeram gastos!
                String[] clienteGastos = {idClienteMaisGastador, String.valueOf(valorTotalGasto)};      // linha com o cliente mais gastador que vai ser adicionado sempre que é encontrado o cliente
                clientesPorOrdemGasto = addLineToMatriz(clienteGastos, clientesPorOrdemGasto);          // adiciona a linha clienteGastos á matriz clientesPorOrdemGasto
                temp = deleteLineOnMatriz(temp, idClienteMaisGastador, 0);                      // apanha o cliente para nao aparecer novamente na matriz "temp"
            }
        }
        return clientesPorOrdemGasto;
    }

    /**
     * Função para retornar uma lista por ordem descrescente do lucro que cada jogo fez
     *
     * @return Matriz de todos os jogos com 2 colunas <br>Coluna [0] - Nome do jogo <br> Coluna [1] = String com o lucro do Jogo
     */
    public static String[][] statisticsJogosLucroOrdemDrescente() {
        String[] jogosDaLoja = columnDataWithoutRep(matrizVendas, 4);           // array com todos os jogos sem repetições que estão nas vendas
        String[][] jogosPorOrdemDescrescente = new String[0][0];
        String[] temp = jogosDaLoja;
        for (int i = 0; i < jogosDaLoja.length; i++) {               // vamos iterar todos os jogos da loja pois temos de os colocar por ordem descrescente
            double lucroDoJogo = 0;
            String jogoMaisLucro = "";
            for (int k = 0; k < temp.length; k++) {                  // vamos iterar um array temporario onde vão ser removidos os jogos consoante os adiciona mos ao array "jogosPorOrdemDescrescente" para conseguirmos ter sempre o jogo com mais lucro
                double lucroTemp = 0;
                for (int j = 0; j < matrizVendas.length; j++) {      // iterador de todas a vendas para encontrar as vendas todas de cada jogo
                    if (temp[k].equals(matrizVendas[j][4])) {
                        lucroTemp += statisticsVenda(matrizVendas[j][0])[1];            // adicionamos o lucro de cada venda de um especifico jogo para posteriormente ver qual é o jogo com mais lucro
                    }
                }
                if (lucroTemp > lucroDoJogo) {
                    lucroDoJogo = lucroTemp;
                    jogoMaisLucro = temp[k];
                }
            }
            String[] arrayJogo = {jogoMaisLucro, String.valueOf(lucroDoJogo)};          // linha com o nome do jogo e o lucro
            jogosPorOrdemDescrescente = addLineToMatriz(arrayJogo, jogosPorOrdemDescrescente);      // adicionamos o jogo à matriz "jogosPorOrdemDescrescente"
            temp = deleteElementOnArray(temp, jogoMaisLucro);
        }
        return jogosPorOrdemDescrescente;
    }

    public static void menuConsultaFicheiros(Scanner input) throws FileNotFoundException {
        int opcao = 0;
        do {
            System.out.println("\n1. Imprimir ficheiro das vendas\n2. Imprimir ficheiro dos clientes\n3. Imprimir ficheiro das categorias\n4. Sair");
            try {
                opcao = input.nextInt();
            } catch (InputMismatchException ex1) {
                opcao = 0;
                input.next();
            }
            switch (opcao) {
                case 1:
                    try{
                        printFile(filesPaths()[2]);
                    }catch (FileNotFoundException ex1){
                        System.out.println("Ficheiro não encontrado!");
                    }
                    break;
                case 2:
                    try{
                    printFile(filesPaths()[1]);
                    }catch (FileNotFoundException ex1){
                    System.out.println("Ficheiro não encontrado!");
                    }
                    break;
                case 3:
                    try{
                    printFile(filesPaths()[4]);
                    } catch (FileNotFoundException ex1){
                        System.out.println("Ficheiro não encontrado!");
                    }
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
    }

    public static void menuAdmin(Scanner input) throws FileNotFoundException {
        int opcaoAdmin = -1;
        String[][] jogosEstatisticas = statisticsJogosLucroOrdemDrescente();
        String[] vendasEstatisticas = statisticsAllVendas();
        do {
            printString(opcoesMenuAdmin());
            System.out.print("\n\n\tIntroduza o que deseja efetuar : ");
            try {
                opcaoAdmin = input.nextInt();
            } catch (InputMismatchException ex1) {
                opcaoAdmin = -1;
                input.next();
            }
            switch (opcaoAdmin) {
                case 0:
                    break;
                case 1: // Consulta de ficheiros
                    menuConsultaFicheiros(input);
                    break;
                case 2: // Total de vendas
                    System.out.println("\n\tForam feitas " + matrizVendas.length + " vendas!");
                    System.out.println("\tCom um valor total de : " + vendasEstatisticas[0] + " €");
                    break;
                case 3: // Total de lucro
                    System.out.println("\n\tLucro total das vendas: " + vendasEstatisticas[1] + " €");
                    break;
                case 4: // Pesquisa de clientes
                    int idUtilizador = 0;
                    do {
                        System.out.print("\n\tIntroduza o id de cliente : ");
                        try {
                            idUtilizador = input.nextInt();
                            if (!searchIfExistsOnMatriz(matrizClientes, String.valueOf(idUtilizador), 0)) {
                                System.out.println("\t!!!!  Cliente inexistente  !!!!");
                                idUtilizador = 0;
                            }
                        } catch (InputMismatchException ex1) {
                            input.next();
                            System.out.println("\t!!!! ID Introduzido inválido !!!!");
                        }
                    } while (idUtilizador == 0);
                    String[] infoClient = searchForDataArray(matrizClientes, String.valueOf(idUtilizador), 0);
                    System.out.println("\n\t ID : " + infoClient[0] + "\n\t Nome : " + infoClient[1] + "\n\t Numero de telemovel : " + infoClient[2] + "\n\t Email : " + infoClient[3]);
                    break;
                case 5: // Jogo mais caro
                    System.out.println("\n\tO jogo mais caro é " + vendasEstatisticas[2] + "\n" + "$$$$$ Clientes que o compraram $$$$");
                    String[][] matrizVendasJogoMaisCaro = searchForDataMatriz(matrizVendas, vendasEstatisticas[2], 4);           // procura na matriz das vendas quais as vendas que contem o jogo mais caro apenas
                    for (int i = 0; i < matrizVendasJogoMaisCaro.length; i++) {
                        String[] clienteVenda = searchForDataArray(matrizClientes, matrizVendasJogoMaisCaro[i][1], 0);
                        System.out.println("\t" + "ID : " + clienteVenda[0] + "\t & Nome : " + clienteVenda[1]);
                    }
                    break;
                case 6: // Clientes/Cliente mais gastador
                    String[][] clientesMaisGastadores = listaClientesOrdemGasto();
                    try{
                        String[][] maisGastadores = searchForDataMatriz(clientesMaisGastadores, clientesMaisGastadores[0][1], 1);  // retorna o primeiro cliente que gastou mais e o resto que tenha gasto igual ao primeiro
                        for (int i = 0; i < maisGastadores.length; i++) {
                            String[][] vendasDoCliente = searchForDataMatriz(matrizVendas, maisGastadores[i][0], 1);
                            String[] clienteInfo = searchForDataArray(matrizClientes, maisGastadores[i][0], 0);
                            System.out.println("\n\t" + (i + 1) + ".Cliente *** Nome : " + clienteInfo[1] + "\t Contacto : " + clienteInfo[2] + "\t Email : " + clienteInfo[3]);
                            System.out.println("\t Valor gasto  [" + maisGastadores[i][1] + " €]");
                            System.out.println("\n\t ***** Jogos Compradados pelo " + clienteInfo[1] + " *****");
                            String[] jogosComprados = columnDataWithoutRep(vendasDoCliente, 4);
                            for (int k = 0; k < jogosComprados.length; k++) {
                                System.out.println("\t\t" + (k + 1) + ". " + jogosComprados[k]);
                            }
                        }
                    }catch (ArrayIndexOutOfBoundsException ex1){
                        System.out.println("\n\t\t!!! Não existe melhor/melhores clientes !!!");
                    }

                    break;
                case 7: // categoria mais lucrativa
                    System.out.println("\n\tA categoria mais lucrativa é : " + vendasEstatisticas[4]);
                    System.out.println("\tLucrou um total de " + vendasEstatisticas[3] + "euros");
                    break;
                case 8: // Pesquisa de jogos e clientes que o compraram
                    System.out.println("\nIntroduza o nome do jogo que deseja pesquisar : ");
                    String nomeJogo = input.next() + input.nextLine();
                    if (searchIfExistsOnMatriz(matrizVendas, nomeJogo, 4)) {    // se o jogo existir na loja entramos no bloco
                        String[][] vendasDoJogo = searchForDataMatriz(matrizVendas, nomeJogo, 4);       // pesquisa na matriz das vendas por todas as vendas daquele jogo
                        String[] clientesDoJogo = columnDataWithoutRep(vendasDoJogo, 1);                           // pesquisa de todos os clientes que compraram o jogo sem repetições
                        System.out.println("\n\t ***** Clientes que compraram o jogo " + nomeJogo + " *****\n");
                        for (int i = 0; i < clientesDoJogo.length; i++) {
                            String[] infoDoClient = searchForDataArray(matrizClientes, clientesDoJogo[i], 0);
                            System.out.println("\t" + (i + 1) + " # Nome : " + infoDoClient[1] + "\t Email : " + infoDoClient[3] + "\t Contacto : " + infoDoClient[2]);
                        }
                    } else {
                        System.out.println("\t !!! Jogo inexistente !!!");
                    }
                    break;
                case 9: // Top 5 jogos
                    System.out.println("\n\t\t ***** TOP 5 JOGOS *****");
                    try{
                        for (int i = 0; i < 5; i++) {
                            System.out.println("\t" + (i + 1) + ". " + jogosEstatisticas[i][0] + "\t $$ Lucro : " + jogosEstatisticas[i][1] + " €");
                        }
                    }catch (ArrayIndexOutOfBoundsException ex1){
                        System.out.println("\t\t !!! Não existe vendas !!!");
                    }

                    break;
                case 10: // bottom 5 jogos
                    System.out.println("\n\t\t ***** BOTTOM 5 JOGOS *****");
                    try{
                        for (int i = jogosEstatisticas.length - 1; i >= jogosEstatisticas.length - 6; i--) {
                            System.out.println("\t" + (jogosEstatisticas.length - i) + ". " + jogosEstatisticas[i][0] + "\t $$ Lucro : " + jogosEstatisticas[i][1] + " €");
                        }
                    }catch (ArrayIndexOutOfBoundsException ex1){
                        System.out.println("\t\t !!! Não existe vendas !!!");
                    }
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcaoAdmin != 0);
    }

     /*
    ------------------- Secção Cliente -------------------------
    ------------------- Secção Cliente -------------------------
    ------------------- Secção Cliente -------------------------
    ------------------- Secção Cliente -------------------------
    */

    public static String opcoesMenuCLientes() {
        return  "Sair\n" +
                "Novo Registo\n" +
                "Procura de estacionamento\n" +
                "Pesquisa de jogos\n" +
                "Imprimir Catálogos Graficos\n" +
                "Pesquisa de Editoras\n" +
                "Pesquisa de Categoria\n" +
                "Pesquisa do Jogo mais recente";
    }

    public static String[] opcoesCatalogo() {
        String[] opcoes = {"Call of Duty", "Fifa", "Hollow Knight", "Mortal Kombat", "Overcooked", "Witcher3: Wild Hunt", "Minecraft"};
        return opcoes;
    }

    /**
     * Metodo para pedir o nome, o email, e o contacto
     *
     * @param input
     * @return array com 3 posiçoes <br> posição [0] = nome <br> posiçao [1] = contacto <br> posição [2] = email
     */
    public static String[] newClient(Scanner input) {
        System.out.print("\n\tIntroduza o seu Nome : ");
        String nome = input.next() + input.nextLine();

        long contacto = 0;
        do {
            System.out.print("\n\tIntroduza o seu contacto : ");
            try {
                contacto = input.nextLong();
            } catch (InputMismatchException ex1) {
                System.out.println("\n\t!! Numero inválido !!");
                input.next();
            }
        } while (contacto == 0);
        System.out.print("\n\tIntroduza o seu eMail : ");
        String email = input.next();

        String[] novoCliente = {nome, String.valueOf(contacto), email};
        return novoCliente;
    }

    /**
     * Função que retorna os lugares vagos em forma de array em que cada posição do array é um lugar vago
     *
     * @return array
     */
    public static int[] lugaresVagos() {
        int[] numerosVagos = new int[0];
        int somaTriangulares = 0;
        for (int i = 1; somaTriangulares < 121; i++) {
            somaTriangulares += i;
            if (somaTriangulares % 5 == 0) {
                numerosVagos = addElementToArrayInt(numerosVagos, somaTriangulares);

            }
        }
        return numerosVagos;
    }

    /**
     * Função para imprimir os lugares vagos com padrão gráfico
     */
    public static void printLugaresVagos() {
        int[] lugares = lugaresVagos();
        System.out.println("\n\t\t ***** LUGARES VAGOS *****\n");
        for (int i = 1; i <= 4; i++) {          // graficamente vai ter 4 linhas
            System.out.print("\t");
            for (int k = 0; k < lugares.length; k++) {
                System.out.print("|");
                for (int j = 1; j <= 5; j++) {
                    if (i == 1)
                        System.out.print("_");
                    else if (i == 2 || i == 4) {
                        System.out.print(" ");
                    } else {
                        String lugar = String.valueOf(lugares[k]);
                        if (j == 1 || j == 5) {
                            System.out.print(" ");
                        } else {
                            for (int h = lugar.length(); h < 3; h++) {
                                System.out.print("0");
                            }
                            System.out.print(lugar);
                            j = 4;
                        }
                    }
                }
            }
            System.out.print("|\n");
        }
    }

    public static void printCatalogo(Scanner input) throws FileNotFoundException {
        int opcao = -1;
        do {
            for (int i = 0; i < opcoesCatalogo().length; i++) {
                System.out.print("\n\t" + (i + 1) + ". " + opcoesCatalogo()[i]);
            }
            System.out.println("\n\t0. Sair");
            System.out.print("\tIntroduza qual catalogo deseja imprimir : ");
            try {
                opcao = input.nextInt();
            } catch (InputMismatchException ex1) {
                opcao = -1;
                input.next();
            }
            String pathFile = "";
            switch (opcao) {
                case 1:
                    pathFile = filesPaths()[5];
                    break;
                case 2:
                    pathFile = filesPaths()[6];
                    break;
                case 3:
                    pathFile = filesPaths()[7];
                    break;
                case 4:
                    pathFile = filesPaths()[9];
                    break;
                case 5:
                    pathFile = filesPaths()[10];
                    break;
                case 6:
                    pathFile = filesPaths()[11];
                    break;
                case 7:
                    pathFile = filesPaths()[8];
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\n\t !!! Opção Inválida !!!");
            }
            if(opcao != 0 && opcao != -1){
                 printFile(pathFile);
            }
        } while (opcao != 0);
    }

    /**
     * Metodo para imprimir todos os jogos de cada categoria de uma dada editora (não contém letras sensiveis)
     *
     * @param input Scanner do input do utilizador
     */
    public static void printEditora(Scanner input) {
        int opcao = -1;
        do {
            String[] editorasDisp = columnDataWithoutRep(matrizVendas, 2);              // lista das editoras disponiveis para posteriormente escolher uma

            String editora = "";
            if (editorasDisp.length > 0){
                for (int i = 0; i < editorasDisp.length; i++) {
                    System.out.println("\t" + (i + 1) + ". " + editorasDisp[i]);
                }
                System.out.println("\t 0. Sair");
                System.out.print("\t Introduza a editora (1 - " + editorasDisp.length + ") (0 para Sair) : ");
            }
            else {
                System.out.println("\n\t\t !!! Nao existe editoras !!! \n");
                System.out.println("\t 0. Sair");
            }

            try {
                try {
                    opcao = input.nextInt();
                } catch (InputMismatchException ex1) {
                    opcao = -1;
                    input.next();
                }
                if (opcao != 0)
                    editora = editorasDisp[opcao - 1];
            } catch (ArrayIndexOutOfBoundsException ex1) {
                System.out.println("\t\t !!!! Opção inválida! \n");
                opcao = -1;
            }
            if (opcao != -1 && opcao != 0) {
                String[][] vendasEditora = searchForDataMatriz(matrizVendas, editora, 2);  // Pesquisa de todas as vendas de uma editora
                String[] categoriasEditora = columnDataWithoutRep(vendasEditora, 3);                 // Pesquisa de todas as categorias de uma editora sem repetições
                editora = editora.toUpperCase();
                System.out.println("\n\t~~~~ " + editora + " ~~~~");
                for (int i = 0; i < categoriasEditora.length; i++) {
                    System.out.println("\n\t*** " + categoriasEditora[i] + " ***");
                    String[][] jogosEditora = searchForDataMatriz(vendasEditora, categoriasEditora[i], 3);      // Pesquisa de todos os jogos das vendas em que são da editora que estamos a pesquisar
                    String[] jogosCategoria = columnDataWithoutRep(jogosEditora, 4);                // todos os jogos da categoria da editora [i]
                    for (int k = 0; k < jogosCategoria.length; k++) {
                        System.out.println("\t- " + jogosCategoria[k]);
                    }
                }
            }
        } while (opcao != 0);
    }

    /**
     * Método para imprimir a categoria com os as jogos das editoras da categoria data
     *
     * @param input Scanner
     */
    public static void printCategoria(Scanner input) {
        int opcao = -1;
        do {
            String[] categoriasDispo = columnDataWithoutRep(matrizVendas, 3);
            String categoria = "";
            if (categoriasDispo.length > 0){
                for (int i = 0; i < categoriasDispo.length; i++) {
                    System.out.println("\t" + (i + 1) + ". " + categoriasDispo[i]);
                }
                System.out.println("\t 0. Sair");
                System.out.print("\t Introduza a categoria (1 - " + categoriasDispo.length + ") (0 para Sair) : ");
            }
            else {
                System.out.println("\n\t\t !!! Nao existe categorias !!! \n");
                System.out.println("\t 0. Sair");
            }
            try {
                try {
                    opcao = input.nextInt();
                } catch (InputMismatchException ex1) {
                    opcao = -1;
                    input.next();
                }
                if (opcao != 0)
                    categoria = categoriasDispo[opcao - 1];
            } catch (ArrayIndexOutOfBoundsException ex1) {
                System.out.println("\n\t !!!! Opção inválida! \n");
                opcao = -1;
            }

            if (opcao != -1 && opcao != 0) {
                String[][] listaVendasCategoria = searchForDataMatriz(matrizVendas, categoria, 3);          // lista com as vendas da categoria passada por parametro
                String[] listaEditoras = columnDataWithoutRep(listaVendasCategoria, 2);                              // lista de editoras sem repetições que contém a categoria dada
                categoria = categoria.toUpperCase();
                System.out.println("\n\t~~~~ " + categoria + " ~~~~");
                for (int i = 0; i < listaEditoras.length; i++) {
                    System.out.println("\n\t*** " + listaEditoras[i] + " ***");
                    String[][] jogosCategoriaEditora = searchForDataMatriz(listaVendasCategoria, listaEditoras[i], 2);       // pesquisa de todos os jogos com aquela categoria de uma editora [i]
                    String[] jogosEditora = columnDataWithoutRep(jogosCategoriaEditora, 4);                                            // array com os jogos da editora sem repetições
                    for (int k = 0; k < jogosEditora.length; k++) {
                        System.out.println("\t- " + jogosEditora[k]);
                    }
                }
            }
        } while (opcao != 0);
    }

    public static void menuClientes(Scanner input) throws FileNotFoundException {
        int opcaoCliente = -1;
        do {
            printString(opcoesMenuCLientes());
            System.out.print("\n\t Escolha o que pretende efetuar : ");
            try {
                opcaoCliente = input.nextInt();
            } catch (InputMismatchException ex1) {
                opcaoCliente = -1;
                input.next();
            }
            switch (opcaoCliente) {
                case 1: // Novo registo de cliente
                    String[] novoCliente = newClient(input);
                    System.out.println("\tCliente inserido com sucesso : " + novoCliente[0] + "| " + novoCliente[1] + " | " + novoCliente[2]);
                    break;
                case 2: // Lugares vagos no estacionamento
                    printLugaresVagos();
                    break;
                case 3: // Pesquisa de jogos
                    String[] jogos = columnDataWithoutRep(matrizVendas, 4);
                    if (jogos.length > 0){
                        for (int i = 0; i < jogos.length; i++) {
                            System.out.println("\t" + jogos[i]);
                        }
                    }
                    else
                        System.out.println("\n\t !!!! Não existe jogos !!!!");
                    break;
                case 4: // Imprimir catologos graficos
                    printCatalogo(input);
                    break;
                case 5: // pesquisa de Editoras
                    printEditora(input);
                    break;
                case 6: // Pesquisa de categorias
                    printCategoria(input);
                    break;
                case 7: // Pesquisa do jogo mais recente
                    String[] jogosPorOrdemEntrada = columnDataWithoutRep(matrizVendas, 4);
                    if (jogosPorOrdemEntrada.length > 0 ){
                        System.out.println("\n\t **** Entrada mais recente ****");
                        System.out.println("\t - " + jogosPorOrdemEntrada[jogosPorOrdemEntrada.length - 1]);
                    }
                    else
                        System.out.println("\t\t !!! Não existe jogos !!!");

                    break;
            }
        } while (opcaoCliente != 0);
    }

    /**
     * Função para imprimir uma moldura com conteudo no meio da moldura
     * @throws IOException
     */
    public static void printCopyRight() throws FileNotFoundException {
        File ficheiroCopyRight = new File(filesPaths()[12]);
        int[] linhasColunas = numeroLinhasEcolunas(ficheiroCopyRight, "");
        Scanner scannerCopyRight = new Scanner(ficheiroCopyRight);
        String[] linhas = new String[linhasColunas[0]];
        for(int i = 0; i < linhasColunas[0]; i++){
            linhas[i] = scannerCopyRight.nextLine();
        }
        String titulo = "Desenvolvido por :";
        String nome = "Miguel Madureira";
        String curso = "Software Developer";
        for(int i = 0; i < linhas.length; i++){         // iterador para as linhas do ficheiro de texto com a moldura
            if (i == ((linhasColunas[0]/2) - 2)){           // se i for a 2 linhas anteriores à linha do meio vamos imprimir o titulo
                int tamanhoTitulo = titulo.length();
                for(int k = 0; k < linhas[i].length(); k++){                    // iterador para todos os caracteres da linha "i"
                    if (k == ((linhas[i].length()/2) - (tamanhoTitulo/2))){     // quando chegar ao local centro vamos colocar a string "titulo"
                        System.out.print(titulo);
                        k += tamanhoTitulo - 1;
                    }
                    else {
                        System.out.print(linhas[i].charAt(k));
                    }
                }
                System.out.print("\n");
            }
            else if (i ==  (linhasColunas[0]/2) - 1){               // condicionais com o mesmo codigo no bloco do que na linha (714)
                int tamanhoNome = nome.length();
                for(int k = 0; k < linhas[i].length(); k++){
                    if (k == ((linhas[i].length()/2) - (tamanhoNome/2))){
                        System.out.print(nome);
                        k += tamanhoNome - 1;
                    }
                    else {
                        System.out.print(linhas[i].charAt(k));
                    }
                }
                System.out.print("\n");
            }
            else if (i ==  linhasColunas[0]/2 + 1){
                int tamanhoCurso = curso.length();
                for(int k = 0; k < linhas[i].length(); k++){
                    if (k == ((linhas[i].length()/2) - (tamanhoCurso/2))){
                        System.out.print(curso);
                        k += tamanhoCurso - 1;
                    }
                    else {
                        System.out.print(linhas[i].charAt(k));
                    }
                }
                System.out.print("\n");
            }
            else {
                System.out.println(linhas[i]);
            }
        }
    }

    public static String[][] matrizLogins;
    public static String[][] matrizVendas;
    public static String[][] matrizCategorias;
    public static String[][] matrizClientes;


    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        boolean filesAreValid = false;
        try {
            checkAllFiles();
            filesAreValid = true;
        } catch (FileNotFoundException ex1) {
            System.out.println("Ficheiros corrompidos ou inexistentes! Impossivel de executar o programa!");
        }
        if (filesAreValid) {
            matrizLogins = leituraFicheiroMatriz(new File(filesPaths()[0]), false, ";");
            matrizVendas = leituraFicheiroMatriz(new File(filesPaths()[2]), true, ";");
            matrizCategorias = leituraFicheiroMatriz(new File(filesPaths()[4]), true, ";");
            matrizClientes = leituraFicheiroMatriz(new File(filesPaths()[1]), true, ";");
            System.out.println("**** Game Start Store *****");
            System.out.print("\n1. Admin \n2. Cliente\n3. Sair");
            int opcaoAdminOuCliente = 0;
            while (opcaoAdminOuCliente == 0) {
                System.out.print("\nIntroduza o seu tipo de utilizador (1 ou 2) : ");
                try {
                    opcaoAdminOuCliente = input.nextInt();
                } catch (InputMismatchException ex1) {
                    input.next();
                }
                if (opcaoAdminOuCliente != 1 && opcaoAdminOuCliente != 2 && opcaoAdminOuCliente != 3) {
                    opcaoAdminOuCliente = 0;
                    System.out.println("\n!!!!!!!! Opção inválida !!!!!!!!");
                }
            }
            switch (opcaoAdminOuCliente) {
                case 1:
                    boolean loginValid = loginAdminValid(input);
                    while (!loginValid) {
                        System.out.println("Username/password inválido!");
                        loginValid = loginAdminValid(input);
                    }
                    if (loginValid) {
                        System.out.println("\n***** Bem vindo ******");
                        menuAdmin(input);
                    }
                    break;
                case 2:
                    menuClientes(input);
                    break;
            }
        }
        try{
            printCopyRight();
        }catch (FileNotFoundException ex1){
            System.out.println("\n\tDesenvoldido por :\n\tMiguel Madureira\n\n\tSoftware Developer");
        }

    }
}
