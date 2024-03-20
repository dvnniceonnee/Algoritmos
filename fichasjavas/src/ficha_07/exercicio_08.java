package ficha_07;

import java.io.File;
import java.util.Scanner;

public class exercicio_08 {
    public static void main(String[] args) {

        boolean ficheiroValido = true;
        Scanner scannerFile = new Scanner("");
        try{
            scannerFile = new Scanner(new File("fichasjavas/files/ficha_07/exercicio_08.csv"));

        }
        catch (Exception ex1)
        {
            System.out.println(ex1.getMessage());
            ficheiroValido = false;
        }

        if (ficheiroValido)
        {
            String cabecalho = scannerFile.nextLine();
            double somaTotal = 0;
            while (scannerFile.hasNextLine())
            {
                String[] linha = scannerFile.nextLine().split(",");
                double quantidade = Double.parseDouble(linha[2]);
                somaTotal = somaTotal + Double.parseDouble(linha[3]) * quantidade;
            }
            System.out.println("A soma total dos produtos é : " + somaTotal);
        }

        scannerFile.close();
    }
}
