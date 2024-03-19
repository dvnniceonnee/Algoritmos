package ficha_07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BibliotecaFiles {

    /**
     * retorna o numero de linhas e colunas de um ficheiro
     *
     * @param ficheiro
     * @return um array com 2 posições [0] - quantidade de linhas [1] quantidade de colunas
     */
    public static int[] numeroLinhasColunas(File ficheiro, String delimitador) throws FileNotFoundException {
        int[] lineColumns = new int[2];
        Scanner scanFile = new Scanner(ficheiro);
        lineColumns[0] = 1;
        lineColumns[1] = scanFile.nextLine().split(delimitador).length;
        while (scanFile.hasNextLine()) {
            scanFile.nextLine();
            lineColumns[0] = lineColumns[0] + 1;
        }
        scanFile.close();
        return lineColumns;
    }

    /**
     * Recebe um ficheiro e lê os dados em forma de matriz (retira o cabeçalho caso precise)
     * @param ficheiro (ficheiro a ser lido)
     * @param linhas   ( numero de linhas do ficheiro)
     * @param colunas  (numero de colunas do ficheiro)
     * @param cabecalho booleanda para perguntar se quer retirar o cabecalho (true = retira , false = nao retira)
     * @return uma matriz com a informação toda do ficheiro
     */
    public static String[][] matrizDados(File ficheiro, int linhas, int colunas, boolean cabecalho, String delimitador) {
        String[][] matrizFile = new String[0][0];
        try {
            Scanner scanFile = new Scanner(ficheiro);
            if (cabecalho) {
                scanFile.nextLine(); // retira a primeira linha do ficheiro
                linhas--;
            }
            matrizFile = new String[linhas][colunas];
            for (int i = 0; i < linhas; i++) {
                String[] linhasFile = scanFile.nextLine().split(delimitador);
                for (int k = 0; k < colunas; k++) {
                    matrizFile[i][k] = linhasFile[k];
                }
            }
            scanFile.close();
        } catch (Exception ex1) {
            System.out.println("Erro matriz Musicas" + ex1.getMessage() + ex1.getCause());
        }

        return matrizFile;
    }

    /**
     * Recebe uma matriz e imprime os dados todos por linha (pode ou não imprimir o cabeçalho)
     * @param printMatriz matriz com os dados
     * @param cabecalho booleana para determinar se é para retirar o cabeçalho (true = retira ; false =  nao retira)
     */
    public static void ImprimirDados(String[][] printMatriz, boolean cabecalho) {
        int i = 0;
        if (cabecalho)
            i = 1;
        for(i = i; i < printMatriz.length; i++)
        {
            System.out.println("Nome : " + printMatriz[i][0] + "\t|\t" + printMatriz[i][1]);
        }
        System.out.println("\n");
    }

    /**
     * Função que retira os dados de uma coluna e os representa num array sem repetições
     *
     * @param matriz - recebe uma matriz preenchida
     * @param num    - recebe o numero da coluna que queremos retirar os dados
     * @return um array com os dados sem repetição dos mesmos
     */
    public static String[] listaDadosColuna(String[][] matriz, int num) {
        String[] listaGen = new String[1];
        for (int i = 0; i < matriz.length; i++) {
            if (i == 0) {
                listaGen[0] = matriz[i][num];
            } else {
                boolean entrar = false;
                for (int k = 0; k < listaGen.length; k++) {
                    if (listaGen[k].equals(matriz[i][num])) {
                        entrar = true;
                    }
                }
                if (!entrar) {
                    String[] temp = new String[listaGen.length + 1];
                    for (int j = 0; j < listaGen.length; j++) {
                        temp[j] = listaGen[j];
                    }
                    temp[listaGen.length] = matriz[i][num];
                    listaGen = temp;
                }
            }
        }
        return listaGen;
    }

    /**
     * Função para retornar uma lista de dados consoante a pesquisa indica pelo utilizar
     * @param matriz     recebe uma matriz com os dados que queremos pesquisar das musicas
     * @param dado       a informação do genero ou do artista que pretendemos procurar
     * @param colunaDado a coluna onde vai estar a informação do dado
     * @return um array com os dados todos filtrados pelos parametros
     */
    public static String[] pesquisaDadosEspecificos(String[][] matriz, String dado, int colunaDado) {
        String[] conjuntoDados = new String[0];

        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][colunaDado].equals(dado)) {
                if (conjuntoDados.length == 0) {
                    conjuntoDados = new String[1];
                    conjuntoDados[0] = matriz[i][0];
                } else {
                    String[] temp = new String[conjuntoDados.length + 1];
                    for (int k = 0; k < conjuntoDados.length; k++) {
                        temp[k] = conjuntoDados[k];
                    }
                    temp[conjuntoDados.length] = matriz[i][0];
                    conjuntoDados = temp;
                }
            }
        }
        return conjuntoDados;

    }

    /**
     * Função que permite atualizar um especifico ficheiro consoante uma matriz dada
     * @param filePath caminho do ficheiro a atualizar
     * @param matrizDados conjunto de dados que foram atualizados para inserir no ficheiro
     * @throws FileNotFoundException
     */
    public static void saveDataFile(String filePath, String[][] matrizDados, String delimitador) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File(filePath));
        for (int i = 0; i < matrizDados.length; i++) {
            for(int k = 0; k < matrizDados[0].length; k++){
                if(k == matrizDados[0].length - 1){
                    writer.print(matrizDados[i][k]);
                }
                else {
                    writer.print(matrizDados[i][k] + delimitador);
                }
            }
            if (i < matrizDados.length - 1){
                writer.print("\n");
            }
        }
        writer.close();
    }

    /**
     * Função que imprime as informações de um especifo formando
     *
     * @param matriz    Recebe uma matriz com os dados todos do ficheiro
     * @param dado Recebe uma dado para pesquisar o dado
     * @return booelano a referir se existe o dado ou nao (true = existe; false = nao existe)
     */
    public static boolean searchMatriz(String[][] matriz, String dado, int colunaDadoPesquisar) {
        String[][] formando = new String[0][0];
        int contadorLinhas = 0;
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][colunaDadoPesquisar].equals(dado)) {
                if (contadorLinhas == 0) {
                    String[][] temp = new String[contadorLinhas + 1][matriz[0].length];
                    for (int k = 0; k < matriz[0].length; k++) {
                        temp[contadorLinhas][k] = matriz[i][k];
                    }
                    contadorLinhas++;
                    formando = temp;
                } else {
                    String[][] temp = new String[contadorLinhas + 1][matriz[0].length];
                    for (int k = 0; k < formando.length; k++) {
                        for (int j = 0; j < formando[0].length; j++) {
                            temp[k][j] = formando[k][j];
                        }
                        temp[formando.length][formando[0].length] = matriz[i][2];
                    }
                    contadorLinhas++;
                    formando = temp;
                }
            }
        }
        if (contadorLinhas > 0) {
            String nome = formando[0][0];
            String idMatricula = formando[0][1];
            String cursos = formando[0][2];
            String email = formando[0][3];
            String idade = formando[0][4];
            if (contadorLinhas > 1) {
                for (int i = 1; i < formando.length; i++)
                    cursos += "\t|\t" + formando[i][2];
            }
            System.out.println("Nome : " + nome);
            System.out.println("Matricula : " + idMatricula);
            System.out.println("Curso(s) : " + cursos);
            System.out.println("Email : " + email);
            System.out.println("Idade : " + idade);
            return true;
        } else {
            System.out.println("\n !! Matricula Invalida! Nenhum formando encontrado !!");
            return false;
        }
    }

    /**
     * Função que imprime as informações de um especifo formando
     *
     * @param matriz  Recebe uma matriz com os dados todos do ficheiro
     * @param idCliente Recebe um id de cliente para pesquisar o cliente
     * @return booelano a referir se existe a matricula ou nao (true = existe; false = nao existe)
     */
    public static boolean infoClient(String[][] matriz, String idCliente, int colunaDadoPesquisar) {
        int linhaInfo = 0;
        boolean clienteExiste = false;
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][colunaDadoPesquisar].equals(idCliente)) {
                linhaInfo = i;
                clienteExiste = true;
                i = matriz.length;
            }
        }
        if (clienteExiste) {
            System.out.println("ID [ " + matriz[linhaInfo][0] + " ] ");
            System.out.println("Nome : " + matriz[linhaInfo][1]);
            System.out.println("Data de Nascimento : " + matriz[linhaInfo][2]);
            System.out.println("Nº Telemovel : " + matriz[linhaInfo][3]);
            System.out.println("eMail : " + matriz[linhaInfo][4]);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Função que permite remover uma linha de uma matriz (necessita de verificar antes se a linha existe)
     * @param matriz de dados de onde vai ser removida a linha
     * @param dado informação que vai estar na linha que vai ser apagada
     * @param colunaDado coluna onde vai estar o dado que foi dado por parametro
     * @return uma matriz nova com a linha apagada
     */
    public static String[][] deleteLine(String[][] matriz, String dado, int colunaDado){
        String[][] temp = new String[matriz.length - 1][matriz[0].length];
        int countingLines = 0;
        for (int i = 0; i < temp.length; i++){
            if (matriz[i][colunaDado].equals(dado)){
                countingLines++;
            }
            else {
                for(int k = 0; k < temp[0].length; k++){
                    temp[i][k] = matriz[i+countingLines][k];
                }
            }
        }
        return temp;
    }

    /**
     * Função que verifica o ultimo id de uma tabela numa especifica coluna e incrementa um numero
     * @param lastId String com o ultimo id da tabela
     * @param delimitadorId char que vai delimitar a string de ID's
     * @return String com o id incrementado com o mesmo formato
     */
    public static String incrementID(String lastId, String delimitadorId){
        String[] lastIDArray = lastId.split(delimitadorId);
        String charId = lastIDArray[0];
        int idNumber = Integer.parseInt(lastIDArray[1]);
        return charId + delimitadorId + (idNumber+1);
    }

    /**
     * Função que retorna uma matriz com os dados novos inseridos
     * @param arrayDados dados a adicionar á matriz em forma de array
     * @param matrizToAdd matriz onde vao ser adicionados os dados
     * @return uma matriz com os dados novos inseridos
     */
    public static String[][] addLine(String[] arrayDados, String[][] matrizToAdd){
        String[][] temp = new String[matrizToAdd.length +1][matrizToAdd[0].length];
        for (int i = 0; i < matrizToAdd.length; i++){
            for (int k = 0; k < matrizToAdd[0].length; k++){
                temp[i][k] = matrizToAdd[i][k];
            }
        }
        for (int i = 0; i < arrayDados.length; i++){
            temp[matrizToAdd.length][i] = arrayDados[i];
        }
        return temp;
    }

}

