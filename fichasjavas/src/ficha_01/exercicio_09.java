package ficha_01;

import java.util.Scanner;

public class exercicio_09 {
    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);

        // variaveis com valores inseridos
        double codigoFuncionario, diasTrabalhados;

        //variaveis de valores de salario e impostos
        double vencimentoBaseDia = 40, subsAlimentaçãoDia = 5, irs = 0.1, segurançaSocialFunc = 0.11, segurançaSocialEmp = 0.2375;

        // variaveis para calculo de salario e impostos
        double salarioTotalIliquido, subsAlimentaçãoTotal, irsImposto, segurançaSocialImpostoFunc, segurancaSocialImpostoEmp, salarioLiquido;

        System.out.println("Olá, vamos ver quanto ganhou este mes :)");

        System.out.println("Qual é o numero do funcionário ? ");
        codigoFuncionario = input.nextDouble();

        System.out.println("Quantos dias trabalhou o funcionário numero " + codigoFuncionario);
        diasTrabalhados = input.nextDouble();

        salarioTotalIliquido = (diasTrabalhados * vencimentoBaseDia) + (diasTrabalhados * subsAlimentaçãoDia);
        subsAlimentaçãoTotal = diasTrabalhados * subsAlimentaçãoDia;
        irsImposto = salarioTotalIliquido * irs;
        segurancaSocialImpostoEmp = salarioTotalIliquido * segurançaSocialEmp;
        segurançaSocialImpostoFunc = salarioTotalIliquido * segurançaSocialFunc;
        salarioLiquido = salarioTotalIliquido - (segurancaSocialImpostoEmp + segurançaSocialImpostoFunc + irsImposto);

        System.out.println("O valor total iliquido sem impostos é " + salarioTotalIliquido);
        System.out.println("Ao fim de " + diasTrabalhados + " dias trabalhados tem a receber " + subsAlimentaçãoTotal + " de subsidio de alimentação");
        System.out.println("Vai ser entregue ao estado um total de IRS de " + irsImposto);
        System.out.println("A empresa vai pagar de impostos de segurança social a quantia de " + segurancaSocialImpostoEmp + "euros");
        System.out.println("O funcionário tem de pagar " + segurançaSocialImpostoFunc );
        System.out.println("Após os impostos vai receber um total de : " + salarioLiquido + " euros :)");






    }
}
