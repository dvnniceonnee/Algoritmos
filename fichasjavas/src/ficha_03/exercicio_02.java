package ficha_03;

public class exercicio_02 {
    public static void main(String[] args) {
        // Declarar variaveis
        int number = 1;

        while (number <= 400 ) // Enquanto o numero for menor do que 400
        {
            if((number % 2) == 0) // Verificar se é par
            {
                System.out.println("- " + number); // Apresenta o numero porque é par
            }
            number = ++number;
        }
    }
}
