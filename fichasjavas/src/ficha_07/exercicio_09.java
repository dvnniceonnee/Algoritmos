package ficha_07;

import java.io.File;
import java.util.Scanner;


public class exercicio_09 {

    public static String menu() {
        String menuOpcoes = "";
        menuOpcoes = "1. Pesquisar musicas por genero\n" +
                "2. Pesquisar por um artista\n" +
                "3. Pesquisar a musica com maior duração\n" +
                "4. Pesquisar musicas com maior duração de um valor\n";
        return menuOpcoes;
    }

    /**
     * retorna o numero de linhas e colunas de um ficheiro
     *
     * @param ficheiro
     * @return um array com 2 posições [0] - quantidade de linhas [1] quantidade de colunas
     */
    public static int[] numeroLinhasColunas(File ficheiro) {
        int[] lineColumns = new int[2];
        try {
            Scanner scanFile = new Scanner(ficheiro);
            lineColumns[0] = 1;
            lineColumns[1] = scanFile.nextLine().split(",").length;
            while (scanFile.hasNextLine()) {
                scanFile.nextLine();
                lineColumns[0] = lineColumns[0] + 1;
            }
            scanFile.close();
            return lineColumns;
        } catch (Exception ex1) {
            System.out.println("Erro na leitura do ficheiro;");
        }
        return lineColumns;
    }

    /**
     * Recebe um ficheiro e lê os dados em forma de matriz (retira o cabeçalho)
     *
     * @param ficheiro (ficheiro a ser lido)
     * @param linhas   ( numero de linhas do ficheiro)
     * @param colunas  (numero de colunas do ficheiro)
     * @return uma matriz com apenas a informação abaixo do cabeçalho
     */
    public static String[][] matrizMusicas(File ficheiro, int linhas, int colunas) {
        String[][] matrizFile = new String[linhas-1][colunas];
        try {
            Scanner scanFile = new Scanner(ficheiro);
            scanFile.nextLine(); // retira a primeira linha do ficheiro
            for (int i = 0; i < linhas - 1 ; i++) {
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

    public static String[] listaDadosColuna(String[][] matriz) {
        String[] listaGen = new String[1];
        for (int i = 0; i < matriz.length; i++) {
            if (i == 0) {
                listaGen[0] = matriz[i][2];
            } else {
                boolean entrar = false;
                for (int k = 0; k < listaGen.length; k++) {
                    if (listaGen[k].equals(matriz[i][2])) {
                        entrar = true;
                    }
                }
                if (!entrar) {
                    String[] temp = new String[listaGen.length + 1];
                    for (int j = 0; j < listaGen.length; j++) {
                        temp[j] = listaGen[j];
                    }
                    temp[listaGen.length] = matriz[i][2];
                    listaGen = temp;
                }
            }
        }
        return listaGen;
    }

    public static void main(String[] args) {
        File musicas = new File("");
        boolean valido = true;
        try {
            musicas = new File("fichasjavas/files/exercicio_09.csv");
        } catch (Exception ex2) {
            System.out.println(ex2.getMessage());
            valido = false;
        }

        if (valido) {
            int[] quantLinhasCol = numeroLinhasColunas(musicas);
            int linhas = quantLinhasCol[0];
            int colunas = quantLinhasCol[1];
            String[][] matrizMusics = matrizMusicas(musicas, linhas, colunas);
            String[] listaGeneros = listaDadosColuna(matrizMusics);
            for (int i = 0; i < listaGeneros.length; i++)
                System.out.println(listaGeneros[i]);
        }

    }
}
