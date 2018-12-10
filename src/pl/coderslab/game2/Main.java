package pl.coderslab.game2;
import pl.coderslab.Services.Services;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----* Welcome to Lotto *-----");
        System.out.println("Choose 6 different numbers between 1 and 49 ");
        Integer[] userShots = shots(6);
        Integer[] lotto = lottoArray(6);
        compare(lotto, userShots);
    }

    static void compare(Integer[] arr1, Integer[] arr2 ){
        int counter = 0;
        for( int i=0; i < arr1.length; i++ ){
            for (int j=0; j< arr2.length; j++){
                if(arr1[i]==arr2[j]){
                    counter += 1;
                }
            }
        }

        if(counter<3){
            System.out.println("It's not Your lucky day. ");
        } else if (counter >2){
            System.out.println("You won! You have "+counter+ " matching shots!!!");
        }
    }

    static Integer[] shots(int numberOfshots){

        Integer[] shots = new Integer[numberOfshots];
        int i =0;

        while (i<shots.length){

                shots[i] = Services.shot("Enter Your " + (i + 1) + ". lucky number: ", "Is not a number! Try again: ");

                if(shots[i]<0 || shots[i]>50){
                    System.out.println("Your number is out of range. Try again.");
                    i--;
                }

                for (int j = 0; j< i; j++){

                    if(shots[i]==shots[j]){
                        System.out.println("You have already chosen this number. Try again.");
                        i--;
                    }
                }


            i++;
        }

        Arrays.sort(shots);
        System.out.println("");
        System.out.println("Yours numbers: ");
        System.out.println(Arrays.toString(shots));
        return shots;
    }

    static Integer[] lottoArray(int lotto){
        Integer[] lottoArr = new Integer[49];
        for(int i = 0; i < lottoArr.length; i++){
            lottoArr[i] = i +1;
        }
        Collections.shuffle(Arrays.asList(lottoArr));
        lottoArr = Arrays.copyOf(lottoArr, lotto);
        Arrays.sort(lottoArr);

        System.out.println("");
        System.out.println("Lotto numbers:");
        System.out.println(Arrays.toString(lottoArr));
        return lottoArr;
    }

}
