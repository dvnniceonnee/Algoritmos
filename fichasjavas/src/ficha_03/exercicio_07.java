package ficha_03;

public class exercicio_07 {
    public static void main(String[] args) {
        // Declarar variaveis
        int number = 1, somatorio = 0;

        System.out.println("<<<<< Programa de numeros inteiros >>>>>");

        while (number <= 100) // Enquanto o numero for inferior a 100
        {
            System.out.println("- " +  number); // Apresentar o numero
            somatorio = somatorio + number; // Acrescentar ao somatorio o numero anterior
            number = ++number; // Incremento de 1 para o proximo loop
        }
        System.out.println("- Somatório : " + somatorio + "\n"); // Apresentar o somatorio
        System.out.println("<<<<< Fim de programa >>>>>");

    }
}
