package ficha_06;

public class exercicio_03 {
    public static boolean par(int num) // verificar se é um numero par
    {
        if (num % 2 == 0) {
            return true;
        } else
            return false;
    }

    public static boolean positivo(int num) { // Verificar se é um numero positivo
        if (num >= 0)
            return true;
        else
            return false;
    }

    public static boolean primo(int num) { // verificar se é um numero primo
        boolean primoounao = true;
        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                primoounao = false;
        }
        return primoounao;
    }

    public static boolean perfeito(int num) { // verificar se é um numero perfeito
        boolean perfeitoounao = false;
        int soma = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                soma = soma + i;
            }
        }
        if (soma == num)
            perfeitoounao = true;
        return perfeitoounao;
    }

    public static boolean triangulo(int num) { // verificar se é um numero triangular
        boolean numerotriangular = false;
        int soma = 0;
        for (int i = 1; i < num; i++) {
            soma = soma + i;
            if (soma == num) {
                numerotriangular = true;
                i = num;
            }
        }
        return numerotriangular;
    }
}
