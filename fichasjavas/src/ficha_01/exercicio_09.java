package ficha_01;

import java.util.Scanner;

public class exercicio_09 {
    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);

        // variaveis com valores inseridos
        int codigoFuncionario, diasTrabalhados;

        //variaveis de valores de salario e impostos
        double vencimentoBaseDia = 40, subsAlimentacaoDia = 5, irs = 0.1, segurancaSocialFunc = 0.11, segurancaSocialEmp = 0.2375;

        // variavel para calculo de salario e impostos
        double calculoValoresSalario;

        System.out.println("Olá, vamos ver quanto ganhou este mes :)");

        System.out.println("Qual é o numero do funcionário ? ");
        codigoFuncionario = input.nextInt();

        System.out.println("Quantos dias trabalhou o funcionário numero " + codigoFuncionario);
        diasTrabalhados = input.nextInt();

        // Calculo do Salario Iliquido
        calculoValoresSalario = (diasTrabalhados * vencimentoBaseDia) + (diasTrabalhados * subsAlimentacaoDia);
        System.out.println("O valor total iliquido sem impostos é " + calculoValoresSalario);

        // Calculo e apresentação do subsidio de alimentação
        calculoValoresSalario = diasTrabalhados * subsAlimentacaoDia;
        System.out.println("Ao fim de " + diasTrabalhados + " dias trabalhados tem a receber " + calculoValoresSalario + " euros " +  " de subsidio de alimentação");

        // Calculo e apresentação do Imposto de IRS
        calculoValoresSalario = (( (diasTrabalhados * vencimentoBaseDia) + (diasTrabalhados * subsAlimentacaoDia) ) * (1 - segurancaSocialFunc) )* irs;
        System.out.println("Vai ser entregue ao estado um total de IRS de " + calculoValoresSalario + " euros");

        // calculo e apresentação do imposto de segurança social para a empresa
        calculoValoresSalario = ((diasTrabalhados * vencimentoBaseDia) + (diasTrabalhados * subsAlimentacaoDia)) * segurancaSocialEmp;
        System.out.println("A empresa vai pagar de impostos de segurança social a quantia de " + calculoValoresSalario + "euros");

        // calculo e apresentação do imposto de segurança social para o funcionario
        calculoValoresSalario = ((diasTrabalhados * vencimentoBaseDia) + (diasTrabalhados * subsAlimentacaoDia)) * segurancaSocialFunc;
        System.out.println("O funcionario " + codigoFuncionario + " vai pagar de impostos de segurança social a quantia de " + calculoValoresSalario + "euros");

        // Calculo e apresentação do salario liquido
        calculoValoresSalario = ((diasTrabalhados * vencimentoBaseDia) + (diasTrabalhados * subsAlimentacaoDia)) - ((( (diasTrabalhados * vencimentoBaseDia) + (diasTrabalhados * subsAlimentacaoDia) ) * (1 - segurancaSocialFunc) )* irs) - (((diasTrabalhados * vencimentoBaseDia) + (diasTrabalhados * subsAlimentacaoDia)) * segurancaSocialFunc);
        System.out.println("Após os impostos vai receber um total de : " + calculoValoresSalario + " euros :)");






    }
}
