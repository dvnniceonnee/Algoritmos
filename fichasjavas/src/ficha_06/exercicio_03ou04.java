package ficha_06;

import java.util.Scanner;

public class exercicio_03ou04 {
    public static boolean par(int num) {
        if (num % 2 == 0) {
            return true;
        } else
            return false;
    }

    public static boolean positivo(int num) {
        if (num >= 0)
            return true;
        else
            return false;
    }

    public static boolean primo(int num) {
        boolean primoounao = true;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                primoounao = false;
            }
        }
        return primoounao;
    }

    public static boolean perfeito(int num) {
        boolean perfeitoounao;
        int soma = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                soma = soma + i;
            }
        }
        if (soma == num)
            return true;
        else
            return false;
    }

    public static boolean numerotriangulo(int num) {
        boolean triangulo = false;
        int soma = 0;
        for (int i = 1; i < num; i++) {
            soma = soma + i;
            if (num == soma) {
                triangulo = true;
                i = num;
            }
        }
        return triangulo;
    }
}
