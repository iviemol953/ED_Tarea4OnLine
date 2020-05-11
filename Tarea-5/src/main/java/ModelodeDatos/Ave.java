package ModelodeDatos;

/**
 * Clase Ave 
 * @author Inma Viera
 */

import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

public class Ave {
    
    private int identificador;
    private String origen;
    private String destino;
    private LocalDateTime fechaSalida;
    private LocalDateTime fechaLlegada;
    private Coche[] misCoches;
    /**
     * Constructor por defecto en el que se pide el numero de coches que tiene el ave
     */
    public Ave(){
        Scanner teclado=new Scanner(System.in);
        byte nCoches=0;
        do{
            System.out.println("Indica el nº de coches del tren: ");
            nCoches=teclado.nextByte();
        }while(nCoches<=0);
        misCoches=new Coche[nCoches];
    };
    /**
     * Constructor de Ave con parámetros. 
     * Por defecto he supuesto que todos los coches son de tipo Turista. HE incluido tambien un
     * parametro con el numero de coches que tiene el tren, para crear el array.
     * @param identificador
     * @param origen
     * @param destino
     * @param fechaSalida
     * @param fechaLlegada
     * @param nCoches 
     */
    public Ave(int identificador, String origen, String destino, LocalDateTime fechaSalida,LocalDateTime fechaLlegada, byte nCoches){
        this.identificador=identificador;
        this.origen=origen;
        this.destino=destino;
        this.fechaSalida=fechaSalida;
        this.fechaLlegada=fechaLlegada;
        misCoches=new Coche[nCoches];
        for(byte i=0;i<nCoches;i++)
        {   
            misCoches[i]=new Coche(i+1,'T');
        }
    };
    /**
     * 
     * @return identificador del tren
     */
    public int getIdentificador(){
        return identificador;
    };
    /**
     * 
     * @return origen
     */
    public String getOrigen(){
        return origen;
    };
    /**
     * 
     * @return destino
     */
    public String getDestino(){
        return destino;
    };
    /**
     * 
     * @return fechaSalida
     */
    public LocalDateTime getFechaSalida(){
        return fechaSalida;
    };
    /**
     * Devuelve fecha
     * @return fechaLlegada
     */
    public LocalDateTime getFechaLlegada(){
        return fechaLlegada;
    };
    /**
     * Devuelve el identificador del ave
     * @param identificador 
     */
    public void setIdentificador(int identificador){
        this.identificador=identificador;
    };
    /**
     * Asigna un origen al tren
     * @param origen 
     */
    public void setOrigen(String origen){
        this.origen=origen;
    };
    /**
     * Asigna un valor al destino de ltren
     * @param destino 
     */
    public void setDestino(String destino){
        this.destino=destino;
    };
    /**
     * Asigna un valor a la fecha de salida
     * @param fechaSalida 
     */
    public void setFechaSalida(LocalDateTime fechaSalida){
        this.fechaSalida=fechaSalida;
    };
    /**
     * Asigna un valor a la fecha de llegada.
     * @param fechaLlegada 
     */
    public void setFechaLlegada(LocalDateTime fechaLlegada){
        this.fechaLlegada=fechaLlegada;
    };
    /**
     * 
     * @param i
     * @return Coche que ocupa la posicion i dentro del array
     */
    public Coche getCoche(byte i){
        return misCoches[i];
    }
    /**
     * 
     * @param c Coche
     * @param i posicion que ocupa dentro del array
     */
    public void setCoche(Coche c,byte i){
        misCoches[i]=c;
    }
    /**
     * Como el numero de coches lo podemos especificar. He creado un método que devuelve el numero de coches. 
     * @return int numero de coches del tren.
     */
    public int getNumeroCoches(){
        return misCoches.length;
    }
    /**
     * 
     * @return String con los datos del tren
     */
    @Override
    public String toString(){
        String resultado;
        DateTimeFormatter isoHoraLocalizedMedium = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        
        resultado="AVE: " + identificador
                +"\n---------------------------------------------------------------------------------- "
                + "\n\tOrigen: "+ origen + " Destino: " + destino
                + "\n\tFecha Salida: " + fechaSalida.format(isoHoraLocalizedMedium) + " Fecha Llegada: " + fechaLlegada.format(isoHoraLocalizedMedium)
                +"\n---------------------------------------------------------------------------------- ";
        return resultado;     
    };   
}
