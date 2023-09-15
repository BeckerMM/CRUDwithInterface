package interacao;

import java.util.Scanner;

public class Interacao {

    private static Scanner sc = new Scanner(System.in);

    public void print(String value){
        System.out.println(value);
    }

    public int  printInt(String value) {
        System.out.println(value);
        return sc.nextInt();
    }

    public double printDouble(String value){
        System.out.println(value);
        return sc.nextDouble();
    }
    public String printString (String value){
        System.out.println(value);
        return sc.next();
    }
}
