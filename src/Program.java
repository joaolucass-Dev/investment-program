import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main (String[] args){
        Locale.setDefault(Locale.US);
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("======Invest Script=====");
            boolean repeat = true;
            while(repeat){
                System.out.println("Salário recebido: ");
                double salary = sc.nextDouble();
                System.out.printf("Sua Carteira de investimento: R$ %.2f%n", salary * 0.36);
                System.out.printf("Sua Carteira de lazer: R$ %.2f%n", salary * 0.06);
                System.out.printf("Sua Carteira de compras: R$ %.2f%n", salary *  0.18);
                System.out.printf("Saldo final pra uso pessoal/contas: R$ %.2f%n", salary * 0.40 );
                repeat = questionLoop(sc);
            }
        } catch (Exception e) {
            System.out.println("Apenas números, por favor!");
        }
    }

    public static boolean questionLoop(Scanner sc){
        System.out.println("Deseja continuar?");
        System.out.println("1- Continuar");
        System.out.println("2 - Sair");
        int questionStop = sc.nextInt();
        sc.nextLine();
        if(questionStop == 1){
            System.out.println("Ok, Qual o novo valor? ");
            return true;
        }
        return false;
    }
}
