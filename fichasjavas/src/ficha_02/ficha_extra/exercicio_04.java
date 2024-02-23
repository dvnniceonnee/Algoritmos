package ficha_02.ficha_extra;

import java.util.Scanner;

public class exercicio_04 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner input =  new Scanner(System.in);

        // Declarar variaveis
        String letra;

        // Ler variavel introduzida pelo utilizador
        System.out.print("Introduza uma letra para verificar se é vogal ou não : ");
        letra = input.next();

        // verificar se a letra é maiuscula
        if (letra.toLowerCase().equals(letra))
        {
            System.out.println("A letra introduzida necessita de ser maiuscula!");
        }
        // caso seja maiuscula verificar se é vogal (A + E + I + O + U)
        else
        {
            switch (letra){
                case "A" :
                    System.out.println("A letra introduzida é uma vogal !");
                    break;
                case "E" :
                    System.out.println("A letra introduzia é uma vogal !");
                    break;
                case "I" :
                    System.out.println("A letra introduzida é uma vogal !");
                    break;
                case "O" :
                    System.out.println("A letra introduzida é uma vogal !");
                    break;
                case "U" :
                    System.out.println("A letra introduzida é uma vogal !");
                    break;
                default:
                    System.out.println("A letra introduzida é uma consoante !");
            }
        }
    }
}
