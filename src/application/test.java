package application;
import java.util.*;
public class test{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("SORTEADOR DE NUMEROS MAIS LEGAL DO MUNDO DE 0 A 9!");
        System.out.println("COOLEST NUMBER DRAWER IN THE WORLD FROM 0 TO 9!");
        System.out.println("confirme para começar:");
        System.out.println("confirm to start:");

        sc.nextLine();
        int num1=0,num2=0,num3=0;
        int o0=0, o1=0, o2=0, o3=0, o4=0, o5=0, o6=0, o7=0, o8=0, o9=0;


        for (int i = 0; i < 10; i++) {


        do{
            num1=rand.nextInt(10);
            System.out.print("|"+num1+"|");
            try {
                Thread.sleep(10); // Adiciona um atraso de 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num2=rand.nextInt(10);
            System.out.print(num2+"|");
            try {
                Thread.sleep(10); // Adiciona um atraso de 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num3=rand.nextInt(10);
            System.out.println(num3+"|");
            try {
                Thread.sleep(10); // Adiciona um atraso de 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            switch (num1) {
                case 0:
                    o0++;
                    break;
                case 1:
                    o1++;
                    break;
                case 2:
                    o2++;
                    break;
                case 3:
                    o3++;
                    break;
                case 4:
                    o4++;
                    break;
                case 5:
                    o5++;
                    break;
                case 6:
                    o6++;
                    break;
                case 7:
                    o7++;
                    break;
                case 8:
                    o8++;
                    break;
                case 9:
                    o9++;
                    break;
            }
            switch (num2) {
                case 0:
                    o0++;
                    break;
                case 1:
                    o1++;
                    break;
                case 2:
                    o2++;
                    break;
                case 3:
                    o3++;
                    break;
                case 4:
                    o4++;
                    break;
                case 5:
                    o5++;
                    break;
                case 6:
                    o6++;
                    break;
                case 7:
                    o7++;
                    break;
                case 8:
                    o8++;
                    break;
                case 9:
                    o9++;
                    break;
            }
            switch (num3) {
                case 0:
                    o0++;
                    break;
                case 1:
                    o1++;
                    break;
                case 2:
                    o2++;
                    break;
                case 3:
                    o3++;
                    break;
                case 4:
                    o4++;
                    break;
                case 5:
                    o5++;
                    break;
                case 6:
                    o6++;
                    break;
                case 7:
                    o7++;
                    break;
                case 8:
                    o8++;
                    break;
                case 9:
                    o9++;
                    break;
            }

        }
        while(num1!=num2 || num2!=num3 || num1!=num3);
            System.out.println("0: " + o0);
            System.out.println("1: " + o1);
            System.out.println("2: " + o2);
            System.out.println("3: " + o3);
            System.out.println("4: " + o4);
            System.out.println("5: " + o5);
            System.out.println("6: " + o6);
            System.out.println("7: " + o7);
            System.out.println("8: " + o8);
            System.out.println("9: " + o9);
            o0=0; o1=0; o2=0; o3=0; o4=0; o5=0; o6=0; o7=0; o8=0; o9=0;
            sc.nextLine();
        }


        sc.close();
    }
}