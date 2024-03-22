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
     * @throws FileNotFoundException
     */
    public static void checkAllFiles() throws FileNotFoundException {
        for (int i = 0; i < filesPaths().length; i++) {
            Scanner fileScanner = new Scanner(new File(filesPaths()[i]));           // o ficheiro entra no scanner
            fileScanner.close();                                                    // fecha o scanner para o próximo ficheiro
        }
    }
    public static boolean loginAdminValid(Scanner input){
        System.out.print("Introduza o username : ");
        String username = input.next() + input.nextLine();
        System.out.print("Introduza a password : ");
        String password = input.nextLine();
        if (searchIfExistsOnMatriz(matrizLogins, username, 0)){
            String passwordUser = searchForDataArray(matrizLogins, username, 0)[1];
            if (passwordUser.equals(password)){
                return true;
            }
        }
        return false;
    }

    public static String opcoesMenuAdmin(){
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
        do{
            System.out.println("1. Imprimir ficheiro das vendas\n2. Imprimir ficheiro dos clientes\n3. Imprimir ficheiro das categorias\n4. Sair");
            try{
                opcao = input.nextInt();
            }catch (InputMismatchException ex1){
                opcao = 0;
                input.next();
            }
            switch (opcao){
                case 1 :
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
        }while (opcao != 4);
    }

    public static double profitVenda(String idVenda){
        String[] infoVenda = searchForDataArray(matrizVendas,idVenda, 0 );
        double percentagemLucro = Double.parseDouble(searchForDataArray(matrizCategorias, infoVenda[3], 0)[1]);
        double valorVenda = Double.parseDouble(infoVenda[5]);
        return  valorVenda * (percentagemLucro/100);
    }
    public static void menuAdmin(Scanner input) throws FileNotFoundException {
        int opcaoAdmin = -1;
        do{
            System.out.println(opcoesMenuAdmin());
            System.out.print("Introduza o que deseja efetuar : ");
            try{
                opcaoAdmin = input.nextInt();
            }catch (InputMismatchException ex1){
                opcaoAdmin = -1;
            }
            switch (opcaoAdmin){
                case 0:
                    break;
                case 1 :
                    menuConsultaFicheiros(input);
                    break;
                case 2:
                    double valorTotal = 0;
                    for (int i = 0; i < matrizVendas.length; i ++){
                        valorTotal += Double.parseDouble(matrizVendas[i][5]);
                    }
                    System.out.println("\n Foram feitas " + matrizVendas.length + " vendas!");
                    System.out.println(" Com um valor total de : " + valorTotal + "\n");
                    break;
                case 3:
                    double lucroTotal = 0;
                    for (int i = 0; i < matrizVendas.length; i++){
                        lucroTotal += profitVenda(matrizVendas[i][0]);
                    }
                    System.out.println("\n Lucro total : " + lucroTotal);
                    break;
                case 4:
                    int idUtilizador = 0;
                    do{
                        System.out.print("Introduza o id de cliente : ");
                        try{
                            idUtilizador = input.nextInt();
                            if(!searchIfExistsOnMatriz(matrizClientes, String.valueOf(idUtilizador), 0)){
                                System.out.println("Cliente inexistente!");
                                idUtilizador = 0;
                            }
                        }catch (InputMismatchException ex1){
                            System.out.println("Id Introduzido invalido!");
                        }
                    }while (idUtilizador == 0);
                    String[] infoClient = searchForDataArray(matrizClientes, String.valueOf(idUtilizador), 0);
                    System.out.println("\n ID : " + infoClient[0] + "\n Nome : " + infoClient[1] + "\n Numero de telemovel : " + infoClient[2] + "\n Email : " + infoClient[3]);
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
                default:
                    System.out.println("Opção inválida!");
            }
        }while (opcaoAdmin != 0);
    }

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
            switch (opcaoAdminOuCliente){
                case 1 :
                    boolean loginValid = loginAdminValid(input);
                    while (!loginValid) {
                        System.out.println("Username/password inválido!");
                        loginValid = loginAdminValid(input);
                    }
                    if (loginValid){
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
