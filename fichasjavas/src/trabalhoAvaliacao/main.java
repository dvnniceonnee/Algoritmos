package trabalhoAvaliacao;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

import static trabalhoAvaliacao.bibliotecaFunc.*;


public class main {

    /**
     * Lista dos caminhos dos ficheiros necessários para o programa
     *
     * @return Array [0] logins file <br> [1] clients file <br> [2] sales file <br> [3] copyright file <br> [4] categories file <br> [5] graphic callOfduty  <br>
     * [6] graphic fifa <br> [7] graphic hollowKnight <br> [8] graphic hollowKnight <br> [9] graphic minecraft <br> [10] graphic mortalKombat <br> [10] graphic overcooked
     * <br> [10] graphic witcher3
     */
    public static String[] filesPaths() {
        String file1 = "fichasjavas/src/trabalhoAvaliacao/files/GameStart_Admins.csv";
        String file2 = "fichasjavas/src/trabalhoAvaliacao/files/GameStart_Clientes.csv";
        String file3 = "fichasjavas/src/trabalhoAvaliacao/files/GameStart_Vendas.csv";
        String file4 = "fichasjavas/src/trabalhoAvaliacao/files/GameStart_Copyright.txt";
        String file5 = "fichasjavas/src/trabalhoAvaliacao/files/GameStart_Categorias.csv";
        String file6 = "fichasjavas/src/trabalhoAvaliacao/files/CatalogoGrafico/callOfDuty.txt";
        String file7 = "fichasjavas/src/trabalhoAvaliacao/files/CatalogoGrafico/fifa.txt";
        String file8 = "fichasjavas/src/trabalhoAvaliacao/files/CatalogoGrafico/hollowKnight.txt";
        String file9 = "fichasjavas/src/trabalhoAvaliacao/files/CatalogoGrafico/minecraft.txt";
        String file10 = "fichasjavas/src/trabalhoAvaliacao/files/CatalogoGrafico/mortalKombat.txt";
        String file11 = "fichasjavas/src/trabalhoAvaliacao/files/CatalogoGrafico/overcooked.txt";
        String file12 = "fichasjavas/src/trabalhoAvaliacao/files/CatalogoGrafico/witcher3.txt";
        String[] files = {file1, file2, file3, file4, file5, file6, file7, file8, file9, file10, file11, file12};
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

    // ------------------- Secção Administradores -------------------------
    // ------------------- Secção Administradores -------------------------
    // ------------------- Secção Administradores -------------------------
    // ------------------- Secção Administradores -------------------------
    public static String opcoesMenuAdmin() {
        String menu = "\n1. Consulta de Ficheiros" +
                "\n2. Total de vendas" +
                "\n3. Total de Lucro" +
                "\n4. Pesquisar um cliente" +
                "\n5. Pesquisar o jogo mais caro" +
                "\n6. Pesquisar os melhores clientes" +
                "\n7. Pesquisar a melhor categoria" +
                "\n8. Pesquisa de vendas" +
                "\n9. Pesquisar o top(5) dos jogos com mais lucro" +
                "\n10. Pesquisar o bottom(5) dos jogos com menos lucro" +
                "\n 0. Sair";
        return menu;
    }

    public static void menuConsultaFicheiros(Scanner input) throws FileNotFoundException {
        int opcao = 0;
        do {
            System.out.println("1. Imprimir ficheiro das vendas\n2. Imprimir ficheiro dos clientes\n3. Imprimir ficheiro das categorias\n4. Sair");
            try {
                opcao = input.nextInt();
            } catch (InputMismatchException ex1) {
                opcao = 0;
                input.next();
            }
            switch (opcao) {
                case 1:
                    printFile(filesPaths()[2]);
                    break;
                case 2:
                    printFile(filesPaths()[1]);
                    break;
                case 3:
                    printFile(filesPaths()[4]);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
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
                if(!lucroVendas){                   // parte na iteração só necessita de correr uma primeira vez para calcular o lucro total e o total de faturamento nas vendas da loja
                    valorfaturado += Double.parseDouble(matrizVendas[k][5]);    // valor da venda na linha "k" que vai adicionar ao valor total faturado da loja
                    lucroTotal += statisticsVenda(matrizVendas[k][0])[1];       // lucro da venda na linha "k" que vai adicionar ao lucro total faturado da loja
                    if (valorfaturado > jogoMaisCaroValor) {                    // condicional para verificar qual é o jogo mais caro
                        jogoMaisCaroValor = valorfaturado;
                        jogoMaisCaro = matrizVendas[k][4];
                    }
                }
                    // usamos este iterador para verificar qual a categoria que deu mais lucro
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
     * @return matriz por ordem decrescente (coluna [0] = id do cliente <br> coluna [1] = valor gasto pelo id cliente dessa linha) <br>
     * 1º Linha da matriz contém o cliente que mais gastou e assim sucessivamente
     */
    public static String[][] listaClientesOrdemGasto() {
        String[][] clientesPorOrdemGasto = new String[0][];
        String[][] temp = matrizClientes;
        for (int i = 0; i < matrizClientes.length; i++) {  // basicamente vamos iterar todos os clientes porque queremos uma lista por ordem decrescente dos gastos de todos os clientes
            double valorTotalGasto = 0;  //
            String idClienteMaisGastador = "";
            for (int k = 0; k < temp.length; k++) {
                String[][] matrizVendasDoCliente = searchForDataMatriz(matrizVendas, temp[k][0], 1);
                double valorGastoCliente = 0;
                for (int e = 0; e < matrizVendasDoCliente.length; e++) {
                    valorGastoCliente += statisticsVenda(matrizVendasDoCliente[e][0])[0];
                }
                if (valorGastoCliente > valorTotalGasto) {
                    valorTotalGasto = valorGastoCliente;
                    idClienteMaisGastador = temp[k][0];
                }
            }
            String[] clienteGastos = {idClienteMaisGastador, String.valueOf(valorTotalGasto)};
            clientesPorOrdemGasto = addLineToMatriz(clienteGastos, clientesPorOrdemGasto);
            temp = deleteLine(temp, idClienteMaisGastador, 0);
        }
        return clientesPorOrdemGasto;
    }

    public static void menuAdmin(Scanner input) throws FileNotFoundException {
        int opcaoAdmin = -1;
        do {
            System.out.println(opcoesMenuAdmin());
            System.out.print("Introduza o que deseja efetuar : ");
            try {
                opcaoAdmin = input.nextInt();
            } catch (InputMismatchException ex1) {
                opcaoAdmin = -1;
            }
            switch (opcaoAdmin) {
                case 0:
                    break;
                case 1:
                    menuConsultaFicheiros(input);
                    break;
                case 2:
                    System.out.println("\n Foram feitas " + matrizVendas.length + " vendas!");
                    System.out.println(" Com um valor total de : " + statisticsAllVendas()[0] + "\n");
                    break;
                case 3:
                    System.out.println("\n Lucro total das vendas: " + statisticsAllVendas()[1]);
                    break;
                case 4:
                    int idUtilizador = 0;
                    do {
                        System.out.print("Introduza o id de cliente : ");
                        try {
                            idUtilizador = input.nextInt();
                            if (!searchIfExistsOnMatriz(matrizClientes, String.valueOf(idUtilizador), 0)) {
                                System.out.println(espacos + "!!!!  Cliente inexistente  !!!!");
                                idUtilizador = 0;
                            }
                        } catch (InputMismatchException ex1) {
                            input.next();
                            System.out.println(espacos + "!!!! ID Introduzido inválido !!!!");
                        }
                    } while (idUtilizador == 0);
                    String[] infoClient = searchForDataArray(matrizClientes, String.valueOf(idUtilizador), 0);
                    System.out.println(espacos + "\n ID : " + infoClient[0] + "\n Nome : " + infoClient[1] + "\n Numero de telemovel : " + infoClient[2] + "\n Email : " + infoClient[3]);
                    break;
                case 5: // Jogo mais caro
                    String jogoMaiscaro = statisticsAllVendas()[2];
                    System.out.println(espacos + "\nO jogo mais caro é " + jogoMaiscaro + "\n" + espacos + "$$$$$ Clientes que o compraram $$$$");
                    String[][] matrizVendasJogoMaisCaro = searchForDataMatriz(matrizVendas, jogoMaiscaro, 4);           // procura na matriz das vendas quais as vendas que contem o jogo mais caro apenas
                    for (int i = 0; i < matrizVendasJogoMaisCaro.length; i++) {
                        String[] clienteVenda = searchForDataArray(matrizClientes, matrizVendasJogoMaisCaro[i][1], 0);
                        System.out.println("\t" + "ID : " + clienteVenda[0] + "\t & Nome : " + clienteVenda[1]);
                    }
                    break;
                case 6: // Clientes/Cliente mais gastador
                    String[][] clientesMaisGastadores = listaClientesOrdemGasto();
                    String[][] maisGastadores = searchForDataMatriz(clientesMaisGastadores, clientesMaisGastadores[0][1], 1);  // retorna o primeiro cliente que gastou mais e o resto que tenha gasto igual ao primeiro
                    for (int i = 0; i < maisGastadores.length; i++) {
                        String[][] vendasDoCliente = searchForDataMatriz(matrizVendas, maisGastadores[i][0], 1);
                        String[] clienteInfo = searchForDataArray(matrizClientes, maisGastadores[i][0], 0);
                        System.out.println("\n\t" + (i + 1) + ".Cliente *** Nome : " + clienteInfo[1] + "\t Contacto : " + clienteInfo[2] + "\t Email : " + clienteInfo[3]);
                        System.out.println("\n\t ***** Jogos Compradados pelo " + clienteInfo[1] + " *****");
                        String[] jogosComprados = columnDataWithoutRep(vendasDoCliente, 4);
                        for (int k = 0; k < jogosComprados.length; k++){
                            System.out.println("\t" + k+1 + ". " + jogosComprados[k]);
                        }
                    }
                    break;
                case 7:
                    System.out.println("\n\tA categoria mais lucrativa é : " + statisticsAllVendas()[4]);
                    System.out.println("\tLucrou um total de " + statisticsAllVendas()[3] + "euros");
                    break;
                case 8:
                    System.out.println("\nIntroduza o nome do jogo que deseja pesquisar : ");
                    String nomeJogo = input.next() + input.nextLine();
                    if(searchIfExistsOnMatriz(matrizVendas, nomeJogo,4))
                    {
                        String[][] vendasDoJogo = searchForDataMatriz(matrizVendas, nomeJogo, 4);
                        String[] clientesDoJogo = columnDataWithoutRep(vendasDoJogo, 1);
                        System.out.println("\n\t ***** Clientes que compraram o jogo " + nomeJogo + " *****\n");
                        for (int i = 0; i < clientesDoJogo.length; i++){
                            String[] infoDoClient = searchForDataArray(matrizClientes, clientesDoJogo[i],0 );
                            System.out.println("\t" + (i + 1) + " # Nome : "+infoDoClient[1] + "\t Email : " + infoDoClient[3] + "\t Contacto : " + infoDoClient[2]);
                        }
                    }
                    break;
                case 9:
                    break;
                case 10:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcaoAdmin != 0);
    }

    public static String espacos = "     ";
    public static String[][] matrizLogins;
    public static String[][] matrizVendas;
    public static String[][] matrizCategorias;
    public static String[][] matrizClientes;


    public static void main(String[] args) throws FileNotFoundException {
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
                    System.out.println("\n!!!!!!!! Opção inválida !!!!!!!!");
                }
                if (opcaoAdminOuCliente != 1 && opcaoAdminOuCliente != 2) {
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
                    break;
            }
        }
    }
}
