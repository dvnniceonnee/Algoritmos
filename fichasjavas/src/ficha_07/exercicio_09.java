package ficha_07;

import java.io.File;
import java.util.Scanner;



public class exercicio_09 {

    public static String menu()
    {
        String menuOpcoes = "";
        menuOpcoes = "1. Pesquisar musicas por genero\n"+
                "2. Pesquisar por um artista\n"+
                "3. Pesquisar a musica com maior duração\n"+
                "4. Pesquisar musicas com maior duração de um valor\n";
        return menuOpcoes;
    }

    /**
     * retorna o numero de linhas e colunas de um ficheiro
     * @param ficheiro
     * @return um array com 2 posições [0] - quantidade de linhas [1] quantidade de colunas
     */
    public static int[] numeroLinhasColunas(File ficheiro)
    {
        int lineColumns[] = new int[2];
        try
        {
            Scanner scanFile = new Scanner(ficheiro);
            lineColumns[0] = 1;
            lineColumns[1] = scanFile.nextLine().split(",").length;
            while (scanFile.hasNextLine()){
                scanFile.nextLine();
                lineColumns[0]++;
            }
            scanFile.close();
            return lineColumns;
        }
        catch (Exception ex1){
            System.out.println("Erro na leitura do ficheiro;");
        }
        return  lineColumns;
    }
    /**
     * Recebe um ficheiro e lê os dados em forma de matriz (retira o cabeçalho)
     * @param ficheiro (ficheiro a ser lido)
     * @param linhas ( numero de linhas do ficheiro)
     * @param colunas (numero de colunas do ficheiro)
     * @return uma matriz com apenas a informação abaixo do cabeçalho
     */
    public static String[][] matrizMusicas(File ficheiro, int linhas, int colunas)
    {
        String[][] matrizFile = new String[linhas][colunas];
        Scanner scanFile = new Scanner("");
        try
        {
            scanFile = new Scanner(ficheiro);
        }
        catch (Exception ex1)
        {
            System.out.println("Erro");
        }
        scanFile.nextLine(); // retira a primeira linha do ficheiro
        for (int i = 0; i < linhas; i++)
        {
            String[] linhasFile = scanFile.nextLine().split(",");
            for(int k  = 0; k < colunas; k++)
            {
                matrizFile[i][k] = linhasFile[k];
            }
        }
        scanFile.close();
        return matrizFile;
    }

    public static String[] generos (String[][] matriz)
    {
        String[] listaGen = new String[0];
        for (int i = 0; i< matriz.length; i++)
        {
            for (int k = 0; k < listaGen.length + 1; k++)
            {
                if (!listaGen[k].equals(matriz[i][2]))
                {
                    String[] temp =  new String[listaGen.length + 1];
                    for (int j = 0; j < listaGen.length; j++)
                    {
                        temp[j] = listaGen[j];
                    }
                    temp[listaGen.length] = matriz[i][2];
                    listaGen = temp;
                }
                else {
                    k = listaGen.length;
                }
            }
        }
        return  listaGen;
    }

    public static void main(String[] args) {
        File musicas = new File("");
        boolean valido = true;
        try
        {
            musicas =  new File("fichasjavas/files/exercicio_09.csv");
        }
        catch (Exception ex2){
            System.out.println(ex2.getMessage());
            valido = false;
        }

        if (valido){
            System.out.println("1");
            int[] quantLinhasCol = numeroLinhasColunas(musicas);
            int linhas = quantLinhasCol[0];
            int colunas= quantLinhasCol[1];
            String[][] matrizMusics =  matrizMusicas(musicas, linhas, colunas);
            String[] listaGeneros =  generos(matrizMusics);
            for (int i = 0; i < listaGeneros.length; i++)
                System.out.println(listaGeneros[i]);
        }

    }
}
