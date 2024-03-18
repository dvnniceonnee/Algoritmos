package extraFicheiros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class exercicio_02 {

    /**
     * Função que transforma um ficheiro de texto numa array, sem espaços, enters "."  ou ","
     * @param ficheiro a ser lido
     * @return um array com todas as palavras sem "." ou ","
     * @throws FileNotFoundException
     */
    public static String[] wholefileOnArray(File ficheiro) throws FileNotFoundException {
        Scanner file = new Scanner(ficheiro);

        String[] fileArray = new String[0];

        while (file.hasNextLine()) {
            String[] linha = file.nextLine().split(" ");
            if (linha[0].length() != 0) {
                if (fileArray.length == 0) {
                    for (int i = 0; i < linha.length; i++) {
                        linha[i] = linha[i].split(",")[0].split("\\.")[0].split("\n")[0];// retira "," e "." e "\n"
                    }
                    fileArray = linha;
                } else {
                    String[] temp = new String[fileArray.length + linha.length];
                    for (int i = 0; i < fileArray.length; i++) {
                        temp[i] = fileArray[i];
                    }
                    for (int i = 0; i < linha.length; i++) {
                        temp[i + fileArray.length] = linha[i].split(",")[0].split("\\.")[0].split("\n")[0];
                    }
                    fileArray = temp;
                }
            }
        }
        return fileArray;
    }

    /**
     * Função que imprime a palavra ou as palavras mais usadas num ficheiro de texto
     * @param arrayFicheiro o ficheiro tem de ser transformado num array para esta função funcionar e não pode conter espaços, enters ou caracteres
     * @param wordsCounting o numero total de palavras que queremos saber (n - 1 caso só queiramos saber a palavra mais usada)
     * @throws FileNotFoundException
     */
    public static void printMostWords(String[] arrayFicheiro, int wordsCounting) throws FileNotFoundException {

        String[] fileArray = arrayFicheiro;
        String[][] tenWordsMostUses = new String[wordsCounting][2]; // matriz com as 10 palavras mais usadas

        for (int u = 0; u < tenWordsMostUses.length; u++ ){
            int contadorPalavras = 0;
            String wordMostUsed = "";
            for (int i = 0; i < fileArray.length; i++) {
                int wordCounter = 0;
                for (int k = i + 1; k < fileArray.length; k++) {
                    if (fileArray[i].equalsIgnoreCase(fileArray[k])) {
                        wordCounter++;
                    }
                }
                if (wordCounter > contadorPalavras) {
                    contadorPalavras = wordCounter;
                    wordMostUsed = fileArray[i];
                }
            }
            contadorPalavras++; // a primeira palavra da palavra mais usada nao é contada, portanto temos de incrementar mais um
            tenWordsMostUses[u][0] = wordMostUsed; // linha na matriz das 10 palavras mais usadas
            tenWordsMostUses[u][1] = Integer.toString(contadorPalavras); // quantas vezes essa palavra foi usada

            String[] temp = new String[fileArray.length - (contadorPalavras)];
            int contadorRemovedor = 0; // conta quantas vezes a palavra vai ser removida
            for (int i = 0; i < fileArray.length; i++){

                if (fileArray[i] != null && fileArray[i].equalsIgnoreCase(wordMostUsed) ){
                    contadorRemovedor++;
                }
                else {
                    temp[i-contadorRemovedor] = fileArray[i];
                }
            }
            fileArray = temp;
        }
        for (int i = 0; i < tenWordsMostUses.length; i++){
            System.out.println(i+1 + ". " + tenWordsMostUses[i][0] + "\t - " + tenWordsMostUses[i][1] + " vezes");
        }

    }

    public static void main(String[] args) {
        File ficheiro = new File("fichasjavas/files/ficha_extraFicheiros/exercicio_02.txt");

        Scanner input = new Scanner(System.in);
        System.out.print("Introduza o numero de palavras mais usadas que deseja procurar : ");
        int numero = input.nextInt();
        try{
            printMostWords(wholefileOnArray(ficheiro), numero);
        }catch (FileNotFoundException ex1){
            System.out.println("Ficheiro nao validado!");
        }

    }
}
