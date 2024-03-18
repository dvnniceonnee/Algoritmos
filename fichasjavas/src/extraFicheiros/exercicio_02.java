package extraFicheiros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class exercicio_02 {
    public static void printMostUsedWord() throws FileNotFoundException {
        Scanner file = new Scanner(new File("fichasjavas/files/ficha_extraFicheiros/exercicio_02.txt"));

        String[] fileArray = new String[0];

        while (file.hasNextLine()) {
            String[] linha = file.nextLine().split(" ");
            if (linha[0].length() != 0) {
                if (fileArray.length == 0) {
                    for (int i = 0; i < linha.length; i++) {
                        linha[i] = linha[i].split(",")[0].split("\\.")[0].split("\n")[0];
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

        System.out.println("A palavra mais usada é : " + wordMostUsed);
        System.out.println("Foi usada " + contadorPalavras + " vezes!");
    }

    public static void main(String[] args) {
        try{
            printMostUsedWord();
        }catch (FileNotFoundException ex1){
            System.out.println("Ficheiro nao validado!");
        }

    }
}
