
package bmi;
import java.util.Scanner;

public class BMI {

    public static void main(String[] args) {
     // create inputs
        Scanner input =new Scanner(System.in);
        System.out.printf("Enter your name : ");
        String name=input.next();
       // System.out.println(name);
        // age
        System.out.printf("Enter your age : ");
        int age=input.nextInt();
       // System.out.println(age);
        //wight kg
        System.out.printf("Enter your wight : ");
        double weight=input.nextDouble();
        //System.out.println(wight);
        //legnth
        System.out.printf("Enter your length : ");
        double Length=input.nextDouble();
        //System.out.println(Length);
         
          double BMI =weight /(Length/100*Length/100);
          
          //display information of the user 
           System.out.printf("----------Information of %s----------%n", name);
          System.out.printf("Name : %s%n", name);
           System.out.printf("Age : %d years%n", age);
            System.out.printf("weight: %.2f kg%n", weight);
             System.out.printf("Length : %.2fcm%n", Length);
              System.out.printf("BMI : %.4f%n", BMI);
          
          
        
    }
    
}
