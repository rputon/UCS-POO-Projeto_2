package br.ucs.poo.cinema.main;

import java.util.Scanner;

public class Help {
	private static String erro = "Valor informado é inválido";
	
	/*---- Integer ---------------------------------------------------------------------------------- */
	public static int returnInt(Scanner in, String print){
        int value =0;
        boolean test = false;

        do{
            try{
                System.out.println(print);
                value = in.nextInt();
                in.nextLine();

                test = true;
                break;
            } catch(Exception e){
                System.out.println(erro);
                in.next();
            }
        }while(test == false);
        return value;
    }
	
	/*---- Double ---------------------------------------------------------------------------------- */
    public static double returnDouble(Scanner in, String print){
        double value = 0;
        boolean test = false;

        do{
            try{
                System.out.println(print);
                value = in.nextDouble();

                test = true;
                break;
            }catch (Exception e){
                System.out.println(erro);
                in.next();
            }

        }while (test == false);
        return value;
    }
    
    /*---- String ---------------------------------------------------------------------------------- */
    public static String returnString(Scanner in, String print, int cod) {
        String value = "";
        boolean test = false;

        do {
            System.out.println(print);
            value = in.nextLine();

            if (!value.matches(".*\\d.*") && !value.matches(".*[-!@#$%^&´~*()\\[\\]+=<>?/{}|].*")) {
                test = true;
                break;
            }
            else{
                System.out.println(erro);
            }
        } while (test == false);
        return value;
    }
    
    /*---- Char ---------------------------------------------------------------------------------- */
    public static char returnChar(Scanner in, String print){
        char value = ' ';
        boolean test = false;

        do{
            System.out.println(print);
            value = Character.toUpperCase(in.next().charAt(0));
            in.nextLine();
            if(value == 'S' || value == 'N'){
                test = true;
                break;
            } else {
                System.out.println(erro);
            }   
        }while(test == false);
        return value;
    }
    
}
