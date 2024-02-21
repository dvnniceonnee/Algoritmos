package ficha_02;

import java.util.Scanner;

public class exercicio_11 {
    public static void main(String[] args) {
        // Importar o Scanner
        Scanner  input =  new Scanner(System.in);

        // Declarar as variaveis necessarias
        double saldoAtual, montanteMov;

        // Ler as variaveis
        System.out.println("Ola bom dia, vamos verificar a sua conta bancária !");
        System.out.println("Introduza o seu saldo");
        saldoAtual = input.nextDouble();
        System.out.println("O seu saldo e : " + saldoAtual);
        System.out.println("Introduza o movimente que deseja realizar : ");
        montanteMov = input.nextDouble();

        // Verificar qual o saldo e saldo posterior (usar if)
        if (saldoAtual + montanteMov >= 0){
            saldoAtual = saldoAtual + montanteMov;
            System.out.println("O seu saldo atual é de : " + saldoAtual);
        }
        else
        {
            saldoAtual = saldoAtual + montanteMov;
            System.out.println("Operação invalida, saldo insuficiente");
        }
    }
}
