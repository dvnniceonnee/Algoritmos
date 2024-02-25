package ficha_03_for;

public class exercicio_01 {
    public static void main(String[] args) {
        // Declarar Variaveis
        int numero;

        System.out.println("<<<<< Programa de numeros >>>>>\n");

        // Para o numero, enquanto que seja menor ou igual a 250 e começa no 1
        // Acrescenta 1 sempre que dá print
        for (numero = 1; numero <= 250; numero++)
        {
            System.out.println("- " +  numero);
        }

        System.out.println("\n<<<<< Fim de Programa >>>>>");
    }
}
