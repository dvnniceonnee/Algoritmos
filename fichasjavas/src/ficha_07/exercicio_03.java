package ficha_07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class exercicio_03 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scannerFicheiro = new Scanner(new File("fichasjavas/files/ficha_07/exercicio_03_Alternativa01.txt"));

        File ficheiroNew = new File("fichasjavas/files/exercicio_03_copiado.txt");
        PrintWriter writerFicheiro = new PrintWriter(ficheiroNew);

        while (scannerFicheiro.hasNextLine()) {
            String nextLine = scannerFicheiro.nextLine();
            writerFicheiro.println(nextLine);
            System.out.println(nextLine);

        }
        scannerFicheiro.close();
        writerFicheiro.close();
    }
}
