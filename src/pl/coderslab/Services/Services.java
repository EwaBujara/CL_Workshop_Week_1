package pl.coderslab.Services;

import java.util.Random;
import java.util.Scanner;

public class Services {

    static public int randomInt(int min, int max) {
        Random r = new Random();
        int a = r.nextInt((max - min) + 1) + min;
        return a;
    }

    public static String getString(String promptText, String errorText){
        Scanner scan = new Scanner(System.in);
        System.out.println(promptText);
        while (true){
            String answer = scan.nextLine();
            if(answer.length() > 0){
                return answer;
            }else{
                System.out.println(errorText);
            }
        }
    }

    static public int shot(String promptText, String errorText){
        Scanner scan = new Scanner(System.in);
        System.out.print(promptText);

        while (!scan.hasNextInt()){
            scan.next();
            System.out.print(errorText);
        }
        return scan.nextInt();
    }

}
