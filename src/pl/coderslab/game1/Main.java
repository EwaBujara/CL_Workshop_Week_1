package pl.coderslab.game1;

import pl.coderslab.Services.Services;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello! Guess The Number I'm Thinking Of :)");
        int magicNumber = Services.randomInt(1,100);
        //System.out.println(magicNumber);
        compare(magicNumber);

    }

    static void compare (int magicNumber) {

        int shot;
        do {
            shot = Services.shot("Enter Your shot: ", "Is not a number! Enter again: ");
            if (shot > magicNumber) {
                System.out.print("Too much! => ");
            } else if (shot < magicNumber) {
                System.out.print("Not enough! => ");
            }
        } while (shot != magicNumber);
        System.out.println(" -----* You won!!! *-----");
    }

}
