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
            matriz = turnFileIntoMatriz(ficheiro, numberLinCol[0], numberLinCol[1], cabecalhoRetirar, charDelimitador);
        } catch (Exception ex1) {
            System.out.println("\t\t!! Ficheiro " + ficheiro.getName() + " sem conteudo ou inexistente !!");
        }
        return matriz;
    }

    /**
     * Metodo que permite imprimir o conteúdo de um ficheiro na consola
     *
     * @param pathFile caminho do ficheiro
     * @throws FileNotFoundException
     */
    public static void printFile(String pathFile) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(pathFile));
        if(fileScanner.hasNextLine()){
            while (fileScanner.hasNextLine()) {
                System.out.println("\t" + fileScanner.nextLine());
            }
        }
        else {
            System.out.println("\t\t!!!! "+ pathFile + " sem conteúdo !!!!");
        }
        fileScanner.close();
    }

    /**
     * retorna o numero de linhas e colunas de um ficheiro
     *
     * @param ficheiro
     * @return um array com 2 posições <br> [0] - quantidade de linhas <br> [1] - quantidade de colunas
     */
    public static int[] numeroLinhasEcolunas(File ficheiro, String delimitador) throws FileNotFoundException {
        int[] lineColumns = new int[2];
        Scanner scanFile = new Scanner(ficheiro);
        lineColumns[0] = 1;
        lineColumns[1] = scanFile.nextLine().split(delimitador).length;
        while (scanFile.hasNextLine()) {
            scanFile.nextLine();
            lineColumns[0]++;
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
    public static String[][] turnFileIntoMatriz(File ficheiro, int linhas, int colunas, boolean cabecalho, String delimitador) {
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
            System.out.println("Erro ficheiro" + ex1.getMessage() + ex1.getCause());
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
            if (matriz[i][colunaDadoPesquisar].equalsIgnoreCase(dataInfo)) { // caso o dado na coluna "i" seja igual ao dado esse mesmo dado existe
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

    /**
     * Função para pesquisar uma matriz por um dado em cada linha e retorna uma matriz só com as linhas em que tenham esse dado
     *
     * @param matriz          matriz que vamos pesquisar o dado
     * @param searchData      dado que vamos usar para pesquisar
     * @param colDataToSearch coluna da matriz onde estarà esse dado
     * @return matriz filtrada com a pesquisa de dados
     */
    public static String[][] searchForDataMatriz(String[][] matriz, String searchData, int colDataToSearch) {
        int linhaInfo = 0;
        String[][] lineReturn = new String[0][0];  // declaração da matriz que vai ser declarada
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][colDataToSearch].equalsIgnoreCase(searchData)) {                         // caso o dado que estamos á procura esteja na linha da matriz durante a iteração
                String[][] temp = new String[lineReturn.length + 1][matriz[0].length];   // matriz temporaria com o acrescimo de uma linha
                if (lineReturn.length == 0) {                                            // caso a matriz que vai ser retornada ainda nao tiver linhas só adicionamos a linha
                    for (int k = 0; k < temp[0].length; k++) {
                        temp[0][k] = matriz[i][k];
                    }
                } else {
                    for (int j = 0; j < lineReturn.length; j++) {                         // matriz já contem mais do que uma linha portanto vamos iterar a matriz e adicionar tudo o que ela tem menos a linha nova
                        for (int k = 0; k < lineReturn[0].length; k++) {
                            temp[j][k] = lineReturn[j][k];
                        }
                    }
                    for (int k = 0; k < lineReturn[0].length; k++) {
                        temp[lineReturn.length][k] = matriz[i][k];                        // adiciono a linha nova em ultimo lugar
                    }
                }
                lineReturn = temp;
            }
        }
        return lineReturn;
    }

    /**
     * Função que retorna uma matriz com a linha de dados adicionada
     *
     * @param arrayToAdd     dados a adicionar á matriz em forma de array (numero de colunas tem de ser o mesmo do que o numero de colunas da matriz)
     * @param originalMatriz matriz onde vao ser adicionados os dados (matriz pode conter 0 linhas)
     * @return uma matriz com os dados novos inseridos
     */
    public static String[][] addLineToMatriz(String[] arrayToAdd, String[][] originalMatriz) {
        String[][] temp = new String[originalMatriz.length + 1][arrayToAdd.length];
        if (originalMatriz.length > 0) {
            for (int i = 0; i < originalMatriz.length; i++) {
                for (int k = 0; k < originalMatriz[0].length; k++) {
                    temp[i][k] = originalMatriz[i][k];
                }
            }
        }
        for (int i = 0; i < arrayToAdd.length; i++) {
            temp[originalMatriz.length][i] = arrayToAdd[i];
        }
        return temp;
    }

    /**
     * Função para adicionar um elemento novo a uma array
     *
     * @param originalArray array onde vai ser adicionado um novo elemento
     * @param elementToAdd  String com o elemento a ser adicionado
     * @return array com mais uma linha em que vai conter o novo elemento
     */
    public static String[] addElementToArray(String[] originalArray, String elementToAdd) {
        String[] temp = new String[originalArray.length + 1];
        if (originalArray.length == 0) {
            temp[0] = elementToAdd;
        } else {
            for (int i = 0; i < originalArray.length; i++) {
                temp[i] = originalArray[i];
            }
            temp[originalArray.length] = elementToAdd;
        }
        return temp;
    }

    /**
     * Função para adicionar um elemento novo a uma array de ints
     *
     * @param originalArray array onde vai ser adicionado um novo elemento
     * @param elementToAdd  String com o elemento a ser adicionado
     * @return array com mais uma linha em que vai conter o novo elemento
     */
    public static int[] addElementToArrayInt(int[] originalArray, int elementToAdd) {
        int[] temp = new int[originalArray.length + 1];
        if (originalArray.length == 0) {
            temp[0] = elementToAdd;
        } else {
            for (int i = 0; i < originalArray.length; i++) {
                temp[i] = originalArray[i];
            }
            temp[originalArray.length] = elementToAdd;
        }
        return temp;
    }

    /**
     * Função que permite remover uma linha de uma matriz (<u>necessita de verificar antes se a linha existe - <strong color="blue">searchIfExistsOnMatriz</strong></u>)
     *
     * @param matriz     de dados de onde vai ser removida a linha
     * @param dado       informação que vai estar na linha que vai ser removida
     * @param colunaDado coluna onde vai estar o dado que foi dado por parametro
     * @return uma matriz nova com a linha apagada
     */
    public static String[][] deleteLineOnMatriz(String[][] matriz, String dado, int colunaDado) {
        String[][] temp = new String[matriz.length - 1][matriz[0].length];
        int countingLines = 0;
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][colunaDado].equals(dado)) {    // caso encontre a linha onde está o dado da linha que é para remover nao a adiciona à nova matriz
                countingLines++;
            } else {
                for (int k = 0; k < matriz[0].length; k++) {
                    temp[i - countingLines][k] = matriz[i][k];
                }
            }
        }
        return temp;
    }

    /**
     * Função para remover um elemento de um array
     *
     * @param array onde vai ser removido o elemento
     * @param dado  dado do elemento que vai ser removido
     * @return array com menos um elemento (elemento no qual é o que tinha o dado passado por parametro)
     */
    public static String[] deleteElementOnArray(String[] array, String dado) {
        String[] temp = new String[array.length - 1];
        int countingLines = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(dado)) {    // caso encontre o elemento onde está o dado nao adiciona ao novo array
                countingLines++;
            } else {
                temp[i - countingLines] = array[i];
            }
        }
        return temp;
    }

    /**
     * Função que retira os dados de uma coluna e os representa num array sem repetições
     *
     * @param matriz - recebe uma matriz preenchida
     * @param num    - recebe o numero da coluna que queremos retirar os dados
     * @return um array com os dados sem repetição dos mesmos
     */
    public static String[] columnDataWithoutRep(String[][] matriz, int num) {
        String[] listaGen = new String[0];
        for (int i = 0; i < matriz.length; i++) {
            if (i == 0) {  // o primeiro elemento que encontrar entra na array porque ainda nao há repetições
                listaGen = addElementToArray(listaGen, matriz[i][num]);
            } else {
                boolean entra = true;
                for (int k = 0; k < listaGen.length; k++) { // como existe mais do que 1 elemento no array neste ponto ele verifica se o elemento da coluna que estamos a pesquisar já existe
                    if (listaGen[k].equals(matriz[i][num])) {
                        entra = false;  // se já existir na array o booleano fica true
                        k = listaGen.length;
                    }
                }
                if (entra) {
                    listaGen = addElementToArray(listaGen, matriz[i][num]);
                }
            }
        }
        return listaGen;
    }

}
