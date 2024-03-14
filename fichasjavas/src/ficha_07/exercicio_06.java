package ficha_07;

import java.io.File;
import java.util.Scanner;

public class exercicio_06 {
    public static void main(String[] args) {
        try
        {
            Scanner ficheiroLer = new Scanner(new File("fichasjavas/files/exercicio_06.txt"));
            String maisVelha = "";
            int maiorIdade  = 0; // pode começar a zero pois nao existe idades menores do que 0
            while (ficheiroLer.hasNextLine())
            {
                String linha1 = ficheiroLer.nextLine();
                String nome = linha1.split(",")[0];
                String linha =  linha1.split(",")[1].split(" ")[0];
                int idade =  Integer.parseInt(linha);
                if (idade > maiorIdade)
                {
                    maiorIdade = idade;
                    maisVelha = nome;
                }
            }
            System.out.println("A pessoa mais velha é : " + maisVelha);
            ficheiroLer.close();
        }
        catch (Exception ex1)
        {
            System.out.println("Algo correu mal na linha : " + ex1);
        }
    }
}
