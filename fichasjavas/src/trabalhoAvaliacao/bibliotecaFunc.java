package trabalhoAvaliacao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class bibliotecaFunc {

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
            int[] numberLinCol = numeroLinhasEcolunas(ficheiro, charDelimitador);
            matriz = turnFileIntomatriz(ficheiro, numberLinCol[0], numberLinCol[1], cabecalhoRetirar, charDelimitador);
        } catch (FileNotFoundException ex1) {
            System.out.println("Ficheiro " + ficheiro.getName() + " nao foi lido!");
        }
        return matriz;
    }

    /**
     * Metodo que permite imprimir o conteúdo de um ficheiro na consola
     * @param pathFile caminho do ficheiro
     * @throws FileNotFoundException
     */
    public static void printFile(String pathFile) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(pathFile));
        while (fileScanner.hasNextLine()){
            System.out.println(fileScanner.nextLine());
        }
        fileScanner.close();
    }

    /**
     * retorna o numero de linhas e colunas de um ficheiro
     *
     * @param ficheiro
     * @return um array com 2 posições [0] - quantidade de linhas [1] quantidade de colunas
     */
    public static int[] numeroLinhasEcolunas(File ficheiro, String delimitador) throws FileNotFoundException {
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
     *
     * @param ficheiro  (ficheiro a ser lido)
     * @param linhas    ( numero de linhas do ficheiro)
     * @param colunas   (numero de colunas do ficheiro)
     * @param cabecalho booleanda para perguntar se quer retirar o cabecalho (true = retira , false = nao retira)
     * @return uma matriz com a informação toda do ficheiro
     */
    public static String[][] turnFileIntomatriz(File ficheiro, int linhas, int colunas, boolean cabecalho, String delimitador) {
        String[][] matrizFile = new String[0][0];
        try {
            Scanner scanFile = new Scanner(ficheiro);
            if (cabecalho) {
                scanFile.nextLine(); // retira a primeira linha do ficheiro caso o booleano "cabecalho seja true"
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
     * Função que retorna se um especifico dado existe numa dada matriz
     *
     * @param matriz              Recebe uma matriz
     * @param dataInfo            Recebe uma String com o dado a pesquisar
     * @param colunaDadoPesquisar recebe a coluna onde irá estar o dado
     * @return booelano a referir se existe o dado (true = existe; false = nao existe)
     */
    public static boolean searchIfExistsOnMatriz(String[][] matriz, String dataInfo, int colunaDadoPesquisar) {
        boolean clienteExiste = false;
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][colunaDadoPesquisar].equals(dataInfo)) { // caso o dado na coluna "i" seja igual ao dado esse mesmo dado existe
                clienteExiste = true;
                i = matriz.length; // termina o loop porque ja verificamos que existe
            }
        }
        return clienteExiste;
    }

    /**
     * Função que retorna a linha de uma matriz onde o dado passado se encontra
     *
     * @param matriz              Recebe uma matriz
     * @param searchData          recebe qual o dado que estamos a pesquisar
     * @param colunaDadoPesquisar coluna onde irá estar o dado a pesquisar
     * @return array completo com as informaçoes da linha do dado
     */
    public static String[] searchForDataArray(String[][] matriz, String searchData, int colunaDadoPesquisar) {
        int linhaInfo = 0;
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][colunaDadoPesquisar].equals(searchData)) { // caso o dado seja igual verifica o numero dessa linha e retorna essa linha
                linhaInfo = i;  // index da linha onde está o dado
                i = matriz.length; // termina o loop
            }
        }
        return matriz[linhaInfo];
    }

}
