package Test;

import java.util.Scanner;
/**
 *
 * @author usuario
 */
public class Utilidades {
    static String rojo="\u001B[31m";
    static String verde="\u001B[32m";
    static String normal="\u001B[30m";
    
    /**
     * Metodo que muestra el mensaje de pulsar una letra.
     */
    static void pulsarTecla(){
        System.out.println("Pulsa una tecla para continuar... ");
        Scanner pulsa=new Scanner(System.in);
        pulsa.hasNextLine();
    }
    
    /**
     * Metodo que detiene la ejecución durante un tiempo
     * @param x 
     */
    static void dormir(int x){
        try{
            Thread.sleep(x);
        }catch(InterruptedException e){
            System.out.println("...");
        }
    }
    /**
     * Metodo que limpia la pantalla, imprimiendo 30 lineas en blanco
     */
    static void limpiarPantalla(){
        for(byte i=0;i<30;i++)
                System.out.println("\n");
    }
    static void llenarPantalla(){
        for(byte j=0;j<20; j++){
            for(byte i=0;i<15;i++)
                System.out.println(rojo+"**************************************");
            System.out.println(verde+"**************************************");
        }
    }
    /**
     * Metodo que devuelve un string con el codigo necesario para mostrarlo en rojo
     * @param s
     * @return string
     */
    static String escribirRojo(String s){
        return rojo+s;
    }
    /**
     * Metodo que devuelve un string con el codigo necesario para mostrarlo en verde
     * @param s
     * @return string
     */
    static String escribirVerde(String s){
        return verde+s;
    }
    /**
     * Metodo que devuelve un string con el codigo necesario para mostrarlo en negro
     * @param s
     * @return string
     */
    static String escribirNormal(String s){
        return normal+s;
    }
}

