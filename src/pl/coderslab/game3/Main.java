package pl.coderslab.game3;

import pl.coderslab.Services.Services;

public class Main {
    public static void main(String[] args) {

        int min = 0;
        int max = 1000;
        System.out.println("Think about some number between "+min+" and "+max+" . I will guess it in max.10 guesses.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
        }
        guessing(min, max);
    }

    static void guessing( int min, int max){

        String userAnswer = null;
        int counter = 0;

        do {
            int guess = ((max - min) / 2) + min;
            System.out.println("My guess is: "+guess);
            userAnswer = Services.getString("Did I guessed? (Answer: 'Yes', 'Too low', 'Too high'): ", "Try again ");
            if(userAnswer.equalsIgnoreCase("Yes")){
                counter += 1;
                System.out.println("I won in "+counter+" guesses!!!");
            } else if(userAnswer.equalsIgnoreCase("Too high")){
                counter += 1;
                max = guess;
            } else if(userAnswer.equalsIgnoreCase("Too low")){
                counter += 1;
                min = guess;
            } else {
                System.out.println("Don't cheat!");
            }
        } while (!userAnswer.equalsIgnoreCase("Yes"));

    }

}
