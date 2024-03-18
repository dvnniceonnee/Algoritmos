package ficha_07;

import java.io.File;
import java.util.Scanner;

public class exercicio_05 {
    public static void main(String[] args) {
        try
        {
            Scanner ficheiro = new Scanner(new File("fichasjavas/files/ficha_07/exercicio_05_31.txt"));
            int numero =0 ;
            while (ficheiro.hasNextInt())
            {
                numero += ficheiro.nextInt();
            }
            System.out.println(numero);
        }catch (Exception ex1)
        {
            System.out.println("Ficheiro Inválido!");
        }
    }
}
