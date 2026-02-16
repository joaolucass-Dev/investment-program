import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main (String[] args){
        Locale.setDefault(Locale.US);
        try(Scanner sc = new Scanner(System.in)){
            boolean repeat;
            boolean repeatMenu = true;
            while(repeatMenu){
                System.out.println("======Financial Organization Meu======");
                System.out.println("1- Usar calculo padrão 50/30/20");
                System.out.println("2- De acordo com sua realidade");
                System.out.println("3- Sair");
                int choose = sc.nextInt();
                switch (choose){
                    case 1:
                        repeat = true;
                        while(repeat){
                            System.out.println("Salário recebido: ");
                            double salary = sc.nextDouble();
                            System.out.printf("Saldo para uso Essencial: R$ %.2f%n", salary * 0.50 );
                            System.out.printf("Sua Carteira de investimento: R$ %.2f%n", salary * 0.30);
                            System.out.printf("Sua Carteira de vontades: R$ %.2f%n", salary * 0.20);
                            repeat = questionLoop(sc);
                        }
                        break;

                    case 2:
                        repeat = true;
                        while(repeat){
                            double percent = 100;
                            System.out.println("Quantos % você irá separar para o uso essencial?");
                            double essential = sc.nextDouble();
                            percent -= essential;
                            System.out.println("Sobrou para dividir: %" + percent);
                            essential /= 100;

                            if(percent >= 0 && percent < 100){
                                System.out.println("Quantos % você irá separar para o investimento?");
                                double investiment = sc.nextDouble();
                                percent -= investiment;
                                System.out.println("Sobrou para dividir: %" + percent);
                                investiment /=  100;
                                if(percent >= 0 && percent < 100) {
                                    System.out.println("Quantos % você irá separar para o lazer/compras?");
                                    double desires =  sc.nextDouble();
                                    percent -= desires;
                                    if(percent == 0){
                                        System.out.println("Salário recebido: ");
                                        double salary = sc.nextDouble();


                                        System.out.printf("Saldo para uso Essencial: R$ %.2f%n", essential * salary );
                                        System.out.printf("Sua Carteira de investimento: R$ %.2f%n", investiment * salary);
                                        System.out.printf("Sua Carteira de vontades: R$ %.2f%n", desires / 100 * salary);
                                    }
                                    else if(percent > 0){
                                        System.out.println("Sobrou %" + percent + " Deixarei automaticamente em lazer, ok?");
                                        percent = desires + percent;
                                        percent /= 100;

                                        System.out.println("Salário recebido: ");
                                        double salary = sc.nextDouble();

                                        System.out.printf("Saldo para uso Essencial: R$ %.2f%n", essential * salary );
                                        System.out.printf("Sua Carteira de investimento: R$ %.2f%n", investiment * salary);
                                        System.out.printf("Sua Carteira de vontades: R$ %.2f%n", percent * salary);

                                    }
                                    else{
                                        System.out.println("vc ultrapassou!");
                                    }
                                }
                                else{
                                    System.out.println("vc ultrapassou!");
                                }

                            }
                            else{
                                System.out.println("vc ultrapassou!");
                            }
                            repeat = questionLoop(sc);
                        }
                        break;

                    default:
                        System.out.println("Até a próxima!");
                        repeatMenu = false;
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Apenas números, por favor!");
        }
    }

    public static boolean questionLoop(Scanner sc){
        System.out.println("Deseja continuar?");
        System.out.println("1- Continuar");
        System.out.println("2 - Sair para o menu");
        int questionStop = sc.nextInt();
        sc.nextLine();
        if(questionStop == 1){
            System.out.println("Ok, Qual o novo valor? ");
            return true;
        }
        return false;
    }
}
