package ficha_03;

public class exercicio_03 {
    public static void main(String[] args) {

        // Declarar Variaveis
        int number = 1;

        while (number <= 750) // Enquanto o numero for menor ou igual a 750 realizar as condiçoes abaixo
        {
            if (number < 531) // Verificar se o numero está dentro do intervalo de 531 e 750
            {
                number = ++number; // Como nao está incrementa 1 até estar
            }
            else
            {
                if ((number % 2) != 0) // verificar se é impar atraves de verificar se o resto a dividir por 2 nao dá 0
                {
                    System.out.println("- " + number); // Apresenta o numero porque é impar
                    number = ++number; // Incremento para passar ao proximo numero
                }
                else
                {
                    number = ++number; // É par portanto Incremento para passar ao proximo numero
                }
            }
        }
    }
}
