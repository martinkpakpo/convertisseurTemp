/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zestetpun;

import java.util.Scanner;

/**
 *
 * @author Martin KPAKPO
 */
public class ZesteTpUn {
    
    public static double arrondi(double A, int B) {
        return (double) ( (int) (A * Math.pow(10, B) + .5)) / Math.pow(10, B);
    }
    
    public double celsiusToF(double temperature){ 
        double value = (double)((9/5)*temperature+32);
        return arrondi(value, 2);
    }
    
    public double FTocelsuis(double temperature){
        double value = (double)(((temperature-32)*5)/9);
        return arrondi(value, 2);
    }
    
    public void acceuil(){
        System.out.println("TEMPERATURE CONVERTER");
        System.out.println("---------------------");
        System.out.println("choose the conversion mode");
        System.out.println("1 - Fahrenheit to Celsius");
        System.out.println("2 - Celsius to Fahrenheit");
    }

    public void demarrage(int choice, double temperature){
        double result=0;
        if(choice!=1 && choice!=2 ){
            System.err.println("Choose a value between 1 or 2");
        }else{
            if(choice==1){
                result = this.FTocelsuis(temperature);
                System.out.println(temperature+"°F to Celsius value is "+result+"°C");
            }else{
                if (choice==2) {
                    result = this.celsiusToF(temperature);
                    System.out.println(temperature+"°C to Fahrenheit value is "+result+"°F");
                } 
            }
        }        
   }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String resp="O";
        do {            
            ZesteTpUn Execution = new ZesteTpUn();
            int choice=0;
            do {   
                Execution.acceuil();
                Scanner sc = new Scanner(System.in);
                choice = sc.nextInt();
            } while (choice!=1 && choice!=2);
            System.out.println("Enter the value to convert");
            double temperature;
            Scanner sc_ = new Scanner(System.in);
            temperature = sc_.nextDouble();
            double resultat;
            Execution.demarrage(choice, temperature);
            resp="P";
            do {            
                System.out.println("Do you want to continue? O/N");
                Scanner sc__ = new Scanner(System.in);
                resp = sc__.nextLine(); 
            } while (resp.toUpperCase().charAt(0)!='O' && resp.toUpperCase().charAt(0)!='N');
        } while (resp.toUpperCase().charAt(0)=='O');
    }
    
}
