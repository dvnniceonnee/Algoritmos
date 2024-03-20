package extraFicheiros;

import java.util.Calendar;
import static extraFicheiros.exercicio_03.*;
import static ficha_07.BibliotecaFiles.countDateDays;

public class teste {
    public static void main(String[] args) {
        String inicio = "30/12/2023";
        String fim = "01/03/2024";

        System.out.println(countDateDays(inicio, fim));
    }
}
