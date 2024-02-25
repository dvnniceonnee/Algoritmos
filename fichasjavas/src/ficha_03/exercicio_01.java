package ficha_03;

public class exercicio_01 {
    public static void main(String[] args) {
        // declarar variaveis
        int number = 1;

        while (number <= 250) // Enquanto o numero for menor do que 250 imprime o numero e acrescenta 1
        {
            System.out.println("- " + number);
            number = ++number; // incremento de mais 1
        }
    }
}
