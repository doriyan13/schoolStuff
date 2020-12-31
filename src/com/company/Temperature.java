package com.company;
import java.util.Scanner;
/* Name of the Class -  Temperature.java
   Name of the writer - Doriyan Esterin.
   Date -               29/10/20.
   The purpose of this class - The class is getting an input of a letter (K/F/C) and 1 real number,
                               and will return the transformed values of the 3 different types (one in each line).
   ground rules for this program -
    1.) The input will be legal in all the options - the char will be K/F/C and the number will be a legal real number.
    2.) You can't use numbers in the calculations only finals.
    3.) You can add an explanation message for the client to understand what he need to input.
*/
public class Temperature {

    public static void main(String[] args) {
        // Define all the finals for the program -
        final double KELVIN_ABSOLUTE_ZERO_IN_CELSIUS = -273.15; // Used to add or subtract as part of the formula to transform to Kelvin from Celsius or from Kelvin to Fahernheit.
        final double FREEZING_POINT_IN_FAHRENHEIT = 32; // Used to add or subtract as part of the formula to transform to Fahrenheit from Kelvin or from Fahrenheit to Celsius.
        final double RATIO_MULTIPLIER_FROM_KELVIN_TO_FAHRENHEIT = (9/5.0); // Used to multiple as part of the formula to transform to Fahrenheit.
        final double RATIO_MULTIPLIER_FROM_FAHRENHEIT_TO_CELSIUS = (5/9.0); // Used to multiple as part of the formula to transform to Celsius.
        final String START_MESSAGE = "Please enter 1 letter for the type of temperature (C/F/K) and 1 real number -";
        // Define an object of the class Scanner to be able to get input from the user -
        Scanner input = new Scanner (System.in);
        // Define the variables that will hold the final Celsius / Kelvin / Fahrenheit temperature.
        double celsius, kelvin, fahrenheit;
        // Display a message that explain what the client need to input -
        System.out.println(START_MESSAGE);
        // Getting the input of the type of temperature & the chosen temperature -
        char temperature_type = (input.next()).charAt(0);
        double chosen_temperature = input.nextDouble();

        if(temperature_type == 'K'){ // Kelvin temperature was chosen -
            kelvin = chosen_temperature;
            fahrenheit = RATIO_MULTIPLIER_FROM_KELVIN_TO_FAHRENHEIT * (kelvin + KELVIN_ABSOLUTE_ZERO_IN_CELSIUS) +FREEZING_POINT_IN_FAHRENHEIT;
            celsius = RATIO_MULTIPLIER_FROM_FAHRENHEIT_TO_CELSIUS * (fahrenheit - FREEZING_POINT_IN_FAHRENHEIT);
        }else if(temperature_type == 'F'){ // Fahrenheit temperature was chosen -
            fahrenheit = chosen_temperature;
            celsius = RATIO_MULTIPLIER_FROM_FAHRENHEIT_TO_CELSIUS * (fahrenheit - FREEZING_POINT_IN_FAHRENHEIT);
            kelvin =celsius - KELVIN_ABSOLUTE_ZERO_IN_CELSIUS;
        }else{ // Celsius temperature was chosen -
            celsius = chosen_temperature;
            kelvin = celsius - KELVIN_ABSOLUTE_ZERO_IN_CELSIUS;
            fahrenheit = RATIO_MULTIPLIER_FROM_KELVIN_TO_FAHRENHEIT * (kelvin + KELVIN_ABSOLUTE_ZERO_IN_CELSIUS) +FREEZING_POINT_IN_FAHRENHEIT;
        }
        // Creating the final String of each kind of temperature -
        String kelvin_display = kelvin + " K";
        String fahrenheit_display = fahrenheit + " F";
        String celsius_display = celsius + " C";
        // Output the final result -
        System.out.println(celsius_display+ "\n"+ fahrenheit_display+"\n"+kelvin_display);
    }
}
