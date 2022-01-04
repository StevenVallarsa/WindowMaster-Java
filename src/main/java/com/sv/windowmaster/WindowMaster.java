/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.sv.windowmaster;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author: Steven Vallarsa
 *   email: stevenvallarsa@gmail.com
 *    date: 2022-01-04
 * purpose: Practice using Scanner to input data, convert it into doubles
 *          from Strings, then output calculations from those doubles.
 */
public class WindowMaster {
    
    public static void main(String[] args) {
        
        final double costOfWindowPerSquareFoot = 3.5;
        final double costOfTrimPerLinearFoot = 2.25;
        
        double height = getInput("What is the height of the window (in feet)?");
        double width = getInput("What is the width of the window (in feet)?");
        
        double area = height * width;
        double perimiter = 2 * (height + width);
        
        double totalWindowCost = area * costOfWindowPerSquareFoot;
        double totalTrimCost = perimiter * costOfTrimPerLinearFoot;
        
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        
        System.out.printf("The cost of %.1fsf of window will be: %10s%n", 
                area, currency.format(totalWindowCost));
        System.out.printf("The cost of %.1flf of trim will be: %12s%n", 
                perimiter, currency.format(totalTrimCost));
        System.out.printf("Your total will be: %28s%n", 
                currency.format(totalTrimCost + totalWindowCost));
    }
    
    private static double getInput(String text) {
        
        Scanner scanner = new Scanner(System.in);
        
        // keep asking user for proper input
        while (true) {
            
            try {
                System.out.println(text);
                double dimention = Double.parseDouble(scanner.nextLine());
                if (dimention < 0.5 || dimention > 10) {
                    throw new Exception("That number wasn't in range. Please try again.");
                }
                return dimention;
                
            } catch (NumberFormatException e) {
                System.out.println("That wasn't a proper number. Please try again.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
