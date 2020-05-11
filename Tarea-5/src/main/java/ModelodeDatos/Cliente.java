/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelodeDatos;

/**
 *
 * @author Inma Viera
 */
public class Cliente {
    private String nombre;
    private String apellidos;
    private int dni;

    static int pasajeros=0;
    /**
     * Constructor por defecto de la clase cliente
     */
    public Cliente(){
        nombre=null;
        apellidos=null;
        dni=0;
    }
    /**
     * Constructor con parámetros
     * @param nombre String con el nombre del cliente
     * @param apellidos String con los apellidos
     * @param dni integer con el numero de dni
     */
    public Cliente(String nombre, String apellidos, int dni){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.dni=dni;
        pasajeros++;
    }
    /**
     * 
     * @return String nombre del cliente
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * Devuelve el apellido
     * @return String
     */
    public String getApellido(){
        return apellidos;
    }
    /**
     * Devuelve el dni, en caso de que exista, si no existe devuelve 0
     * @return dni integer
     */
    public int getDni(){
        return dni;
    }
    /**
     * Asigna un valor a nombre
     * @param nombre 
     */
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    /**
     * Asigna un valor a apellidos
     * @param apellidos String
     */
    public void setApellidos(String apellidos){
        this.apellidos=apellidos;
    }
    /**
     * Asigna un dni al cliente
     * @param dni 
     */ 
    public void setDni(int dni){
        this.dni=dni;
    }
    /**
     * Asigna un valor a la variable que cuenta el total de pasajeros
     * @param pasajeros 
     */
    public void setPasajeros(int pasajeros){
        Cliente.pasajeros=pasajeros;
    }
    /**
     * Devuelve el numero de pasajeros que tenemos
     * @return pasajeros
     */
    public int getPasajeros(){
        return pasajeros;
    }
    /**
     * Metodo que devuelve al informacion correspondiente al pasajero
     * @return String
     */
    @Override
    public String toString(){
        String resultado;
        resultado= "\nNombre: " + nombre+ "\tApellidos: " + apellidos+"\n\tDNI: "+dni+"\n";  
        return resultado;
        
    };
}