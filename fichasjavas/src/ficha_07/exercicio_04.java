package ficha_07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class exercicio_04 {
    public static void main(String[] args) throws FileNotFoundException {

        try
        {
            Scanner scannerFicheiro = new Scanner(new File("fichasjavas/files/ficha_07/exercicio_04.csv"));
            while (scannerFicheiro.hasNextLine())
            {
                String linha = scannerFicheiro.nextLine();
                String[] linhaImprimir = linha.split(";");

                for (int i = 0; i < linhaImprimir.length; i++)
                {
                    System.out.print(linhaImprimir[i] + "       ");
                }
                System.out.println();
            }

        }catch (Exception ex1)
        {
            System.out.println("Ficheiro invalido!");
        }

    }
}
