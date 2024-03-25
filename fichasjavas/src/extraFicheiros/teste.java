package extraFicheiros;

import java.util.Calendar;
import java.util.Scanner;

import static extraFicheiros.exercicio_03.*;
import static ficha_07.BibliotecaFiles.countDateDays;

public class teste {
    public static void main(String[] args) {
        String inicio = "12/1/2023";
        String fim = "31/12/2024";
        String testeString = "jhzhgzhjghgasdghasdhasgdhasgdhagsd\naghsaghsaghfdaghfdghafsdghadfadsasdasad\nsasjdhashdgadshdaadsh89127389asjhdasdgadadsasdadadadashjgdahgdahgdhuagadgsyu712639bshdgasuhdgahdaadsghahfdad";

        Scanner input = new Scanner(testeString);
        input.next();
        for(int i = 0; i < testeString.length(); i++){
            for (int k = 100009; k > 0; k--){
                if (k == 1){
                    System.out.print(testeString.charAt(i));
                }
            }
        }
    }
}
