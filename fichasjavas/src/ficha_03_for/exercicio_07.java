package ficha_03_for;

public class exercicio_07 {
    public static void main(String[] args) {
        // Declarar as variaveis
        int number, somatorio = 0;

        System.out.println("<<<<< Programa automatico de soma >>>>>\n");

        for (number = 1; number <= 100; number++)
        {
            System.out.println("- " + number);
            somatorio = somatorio + number;
        }
        System.out.println("\n O somatorio : " + somatorio);
    }
}
