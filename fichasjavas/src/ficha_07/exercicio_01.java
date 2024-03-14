package ficha_07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class exercicio_01 {
    public static void main(String[] args) throws FileNotFoundException {

        File ficheiro =  new File("fichasjavas/files/exercicio_01_Alternativa01.txt");
        Scanner scannerFile = new Scanner(ficheiro);

        while (scannerFile.hasNextLine())
        {
            System.out.println(scannerFile.nextLine());
        }

        scannerFile.close();
    }
}
