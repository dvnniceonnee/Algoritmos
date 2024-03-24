package extraFicheiros;

import java.util.Calendar;
import java.util.Scanner;

import static extraFicheiros.exercicio_03.*;
import static ficha_07.BibliotecaFiles.countDateDays;

public class teste {
    public static void main(String[] args) {
        String inicio = "12/1/2023";
        String fim = "31/12/2024";

        System.out.println(countDateDays(inicio, fim));
    }
}
