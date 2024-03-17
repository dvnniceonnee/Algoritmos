package ficha_07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BibliotecaFiles {

    /**
     * retorna o numero de linhas e colunas de um ficheiro
     *
     * @param ficheiro
     * @return um array com 2 posições [0] - quantidade de linhas [1] quantidade de colunas
     */
    public static int[] numeroLinhasColunas(File ficheiro) throws FileNotFoundException {
        int[] lineColumns = new int[2];
        Scanner scanFile = new Scanner(ficheiro);
        lineColumns[0] = 1;
        lineColumns[1] = scanFile.nextLine().split(",").length;
        while (scanFile.hasNextLine()) {
            scanFile.nextLine();
            lineColumns[0] = lineColumns[0] + 1;
        }
        scanFile.close();
        return lineColumns;
    }

    /**
     * Recebe um ficheiro e lê os dados em forma de matriz (retira o cabeçalho)
     * @param ficheiro (ficheiro a ser lido)
     * @param linhas   ( numero de linhas do ficheiro)
     * @param colunas  (numero de colunas do ficheiro)
     * @param cabecalho booleanda para perguntar se quer retirar o cabecalho (true = retira , false = nao retira)
     * @return uma matriz com apenas a informação abaixo do cabeçalho
     */
    public static String[][] matrizDados(File ficheiro, int linhas, int colunas, boolean cabecalho) {
        String[][] matrizFile = new String[linhas - 1][colunas];
        try {
            Scanner scanFile = new Scanner(ficheiro);
            if (cabecalho) {
                scanFile.nextLine(); // retira a primeira linha do ficheiro
            }
            for (int i = 0; i < linhas - 1; i++) {
                String[] linhasFile = scanFile.nextLine().split(",");
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
}
