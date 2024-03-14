package ficha_07;

import java.io.File;
import java.util.Scanner;

public class exercicio_07 {
    public static void main(String[] args) {
        Scanner scannerFiles = new Scanner("");
        boolean ficheiroValido = true;
        try
        {
            File ficheiro = new File("fichasjavas/files/exercicio_07.txt");
            scannerFiles = new Scanner(ficheiro) ;
        }
        catch (Exception ex1)
        {
            System.out.println("Ficheiro invalido!");
            ficheiroValido = false;
        }

        if (ficheiroValido)
        {
            int contadorLinhas = 0;
            int contadorPalavras = 0;
            while (scannerFiles.hasNextLine())
            {
                ++contadorLinhas;
                String[] linha = scannerFiles.nextLine().split(" ");
                contadorPalavras += linha.length;
            }

            System.out.println("Numero de linhas : " + contadorLinhas);
            System.out.println("Numero de palavras : " + contadorPalavras);
        }
    }
}
