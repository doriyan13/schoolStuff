package com.company;
import java.util.Scanner;

public class Class02 {
    //Example of 'complex' program, as of right now:
    public static void UserValidation(){
        //The Teacher is advicing to use finals like this:
        final String WELCOME_MESSAGE ="Welcome! ~ come and join us";
        final String ENTER_USERNAME ="Please enter username:";
        final String ENTER_PASSWORD = "Please enter password:";
        final String GUEST_MESSAGE = "Hello Guest! Please check-in";
        final String USER_MESSAGE_FIRST = "Hello";
        final String USER_MESSAGE_SECOND = "Let's start going!";
        final String ERROR_MESSAGE = "Error! please enter different password!";
        final int MIN_LENGTH = 8;

        System.out.println(WELCOME_MESSAGE);
        System.out.println(ENTER_USERNAME);
        Scanner input = new Scanner(System.in);
        String username = input.next();
        //if(username.equals("guest") || username.equals("GUEST")){
        if(username.equalsIgnoreCase("guest")){ //more efficient way!
            System.out.println(GUEST_MESSAGE);
        }
        else {
            System.out.println(ENTER_PASSWORD);
            String password = input.next(); //we want to get the first word only!
            int passwordLength = password.length();
            char firstLetter = password.charAt(0); //Getting the first letter of the String
            char lastLetter = password.charAt(passwordLength - 1); //Getting the last letter of the String

            //if i have alot of conditions, it's prefered to create them as boolean variables and then just colide them-
            boolean check1 = passwordLength >= MIN_LENGTH;
            boolean check2 = passwordLength%2 ==0;
            boolean check3 = firstLetter >= 'A' && firstLetter <= 'Z'; //checking the first letter is a Big Letter!
            boolean check4 = lastLetter >= '0' && lastLetter <= '9'; //checking the last letter is a num

            if(check1 && check2 && check3 && check4){
                System.out.println(USER_MESSAGE_FIRST +" "+ username+ " "+USER_MESSAGE_SECOND);
            }
            else {
                System.out.println(ERROR_MESSAGE);
            }
        }


    }

    public static void main(String[] args){
        // The exalization is by ASCII code
        char let1 = 'x';
        //let1 = let1 +5;// - this an Error!
        let1 = (char) (let1+ 5); // this is legal thing to do!
        boolean test = let1>10;
        System.out.println((int)let1);
        System.out.println(test);
        System.out.println(++let1); // this is legal thing to do!
        System.out.println(--let1); // this is legal thing to do!
    }
}
