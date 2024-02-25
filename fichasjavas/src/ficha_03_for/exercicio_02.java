package ficha_03_for;

public class exercicio_02 {
    public static void main(String[] args) {
        // Declarar Variaveis
        int numero;

        System.out.println("<<<<< Programa de numeros >>>>\n");

        for(numero = 1; numero <= 400; numero++) // Para o numero = 1, enquanto for menor do que 400, realizar o codigo, e acrescenta 1
        {
            if ((numero % 2) == 0)
            {
                System.out.println("- " + numero);
            }
        }

        System.out.println("\n <<<<< Fim de Programa >>>>> ");
    }
}
