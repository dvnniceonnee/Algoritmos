package ficha_02;

import java.sql.SQLOutput;
import java.util.Scanner;

public class exercicio_15 {
    public static void main(String[] args) {
        // Importar o Scanner para reconhecer o input na consola
        Scanner input = new Scanner(System.in);

        // Declarar as variaveis
        int num1, num2, num3;
        String ordemCrescente, ordemDecrescente, escolhaOrdem;

        // Ler as variaveis e atribui las as mesmas
        System.out.println("Introduza 3 numeros aleatorios : ");
        num1 = input.nextInt();
        num2 = input.nextInt();
        num3 = input.nextInt();

        // Ler a variavel e atribuir a variavel da escolhe do utilizador
        System.out.println("Introduza que tipo de ordem dos numero deseja (Crescente = C ou Decrescente = D)");
        escolhaOrdem = input.next();

        if (!escolhaOrdem.equals("C") && !escolhaOrdem.equals("D"))
        {
            System.out.println("A escolha introduzida nao e valida!");
        }
        else
        {
            // verificar o numero menor e o numero maior
            if (num1 < num2 && num1 < num3 && num2 < num3) {
                ordemCrescente = (num1 + " " + num2 + " " +  num3);
                ordemDecrescente = (num3 + " " + num2 + " " + num1);
            } else {
                if (num2 < num3 && num3 < num1) {
                    ordemCrescente = (num2  + " " + num3 + " " + num1);
                    ordemDecrescente = (num1 + " " +  num3 + " " +  num2);
                }
                else {
                    if (num2 < num3 && num3 > num1){
                        ordemCrescente = (num2 + " " +  num1 + " " + num3);
                        ordemDecrescente = (num3 + " " +  num1 + " " +  num2);
                    }
                    else
                    {
                        if (num3 < num2 && num2 < num1)
                        {
                            ordemCrescente = (num3 + " " + num2 + " " +  num1);
                            ordemDecrescente = (num1 + " " +  num2 + " " + num3);
                        }
                        else
                        {
                            ordemCrescente = (num3 + " " + num1 +  " " + num2);
                            ordemDecrescente = (num2 + " " +  num3 + " " + num3);
                        }
                    }
                }
            }
            switch (escolhaOrdem)
            {
                // Apresentar a string acima declarada consoante a escolha do utilizador
                case "C":
                    System.out.println(ordemCrescente);
                    break;
                case "D" :
                    System.out.println(ordemDecrescente);
                    break;
            }
        }


    }
}
