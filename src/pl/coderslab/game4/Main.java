package pl.coderslab.game4;

import pl.coderslab.Services.Services;


public class Main {

    public static void main(String[] args) {
        System.out.println("");
        String userChoice = Services.getString("What's Your dice choice?: ", "Try again");
        dataAnalise(userChoice);

    }


    public static void dataAnalise(String kindOfDice){

        int numberOfThrows = 0;
        int option = 0;
        int indexOfD =0;
        int diceShape = 0;
        int result = 0;

        //Split String with - or +
        String[] parts = kindOfDice.split("(?=-)");
        if(parts.length<2){
            parts = kindOfDice.split("(?=\\+)");
        }

        //get int value of 'option'
        try{
            option = Integer.parseInt(parts[1]);
        } catch (Exception e){

        }
        System.out.println("Option: "+option);

        String[] diceKind = new String[parts[0].length()];
        for(int i=0; i< parts[0].length(); i++) {
            String str = "" + kindOfDice.charAt(i);
            diceKind[i] = str;
        }


        //Get Index of D
        for (int i=0; i<parts[0].length(); i++){
            if (diceKind[i].equalsIgnoreCase("D")) {
                indexOfD = i;
            }
        }

        //Get Number of Throws
        if(indexOfD == 0){
            numberOfThrows = 1;
        } else {
            String numberOfThrowsInString = "";
            for (int i=0; i<indexOfD; i++){
                numberOfThrowsInString +=  diceKind[i];
            }
            numberOfThrows = Integer.parseInt(numberOfThrowsInString);
        }

        System.out.println("Number of throws: "+numberOfThrows);

        //Get Dice Shape
        String diceShapeInString ="";
        for (int i = indexOfD+1; i<diceKind.length;i++){
            diceShapeInString += diceKind[i];
        }
        try{

            diceShape = Integer.parseInt(diceShapeInString);
        }catch (Exception e){

        }
        System.out.println("Dice shape: "+diceShape);
        //userThrows(numberOfThrows, diceShape);
        System.out.println("Your throws:");
        result = userThrows(numberOfThrows, diceShape)+option;
        System.out.println("Result: "+result);

    }

    public static int userThrows(int numberOfThrows, int diceShape){
        int result = 0;
        for (int i=1; i< numberOfThrows+1; i++ ){
            result += diceShape(diceShape);
        }
        return result;
    }

    public static int diceShape(int diceShape){
        int min = 1;
        int dice = Services.randomInt(min, diceShape);
        System.out.println(dice);
        return dice;
    }
}
