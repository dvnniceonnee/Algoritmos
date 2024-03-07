package ficha_06;

public class exercicio_05 {
    public static int maiorNumero(int[] array) { // retorna o maior numero do array
        int maior = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > maior) {
                maior = array[i];
            }
        }
        return maior;
    }

    public static int menorNumero(int[] array) { // retorna o menor numero do array
        int menor = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < menor) {
                menor = array[i];
            }
        }
        return menor;
    }

    public static boolean crescente(int[] array) // verificar se a ordem dos numeros do array está crescente
    {
        boolean cresce = true;
        int numeroAnterior = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < numeroAnterior) {
                cresce = false;
            }
        }
        return cresce;
    }

}
