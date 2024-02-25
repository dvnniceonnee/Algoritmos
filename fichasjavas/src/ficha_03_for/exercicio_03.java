package ficha_03_for;

public class exercicio_03 {
    public static void main(String[] args) {
        // Declarar Variaveis
        int number;

        System.out.println("<<<<< Programa de numeros impares >>>>>\n");

        for (number = 1; number <= 750; number++) // Para o number, enquanto for menor do que 750, correr o codigo e acrescenta 1
        {
            if (number >= 531) // Como coloquei o inicio a numero 1, verificar se quando é corrido o codigo o numero é maior do que 531
            {
                if ((number % 2) != 0 ) // Caso o numero seja impar (o resto a diivir por 2 nao da 0, correr o seguinte codigo
                {
                    System.out.println("- " + number);
                }
            }
        }

        System.out.println("\n <<<<< Fim de Programa >>>>>");
    }
}
