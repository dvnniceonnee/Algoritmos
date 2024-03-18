package extraFicheiros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.Scanner;

public class exercicio_01 {
    public static void newFileFiltred(File ficheiro, String wordSearched) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(ficheiro);
        boolean fileValid = false;
        try{
            PrintWriter newFile = new PrintWriter("fichasjavas/files/ficha_extraFicheiros/exercicio_01_copy.txt");
            while (fileScanner.hasNextLine()) {
                String linha = fileScanner.nextLine();
                String[] file = linha.split(" ");
                boolean wordExists = false;
                for (int i = 0; i < file.length; i++) {
                    String word1 = file[i].split(",")[0];
                    word1 = word1.split("\\.")[0];
                    if (word1.equalsIgnoreCase(wordSearched)) {
                        wordExists = true;
                    }
                }
                if(wordExists){
                    newFile.println(linha);
                    newFile.println();
                }
            }
            newFile.close();
        }
        catch (FileNotFoundException ex1){
            System.out.println("File not created!");
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        File ficheiro = new File("fichasjavas/files/ficha_extraFicheiros/exercicio_01.txt");
        Scanner input = new Scanner(System.in);
        System.out.println("**** Programa de linhas ****");
        System.out.print("\nEscolha a palavra que deseja procurar : ");
        String word = input.next() + input.nextLine();
        System.out.println(word);
        newFileFiltred(ficheiro, word);
    }
}

