/*
 * En la clase coche, he dado por sentado que el numero de plazas de cada coche es de 20.
 */
package ModelodeDatos;
import static Test.Utilidades.*;

/**
 *
 * @author Inma Viera
 */
public class Coche {
    private int identificador;
    private char tipo;
    protected Cliente asientos[];
    
    /**
     * Podríamos haber creado una variable para ir indicarndo el tipo de coche y 
     * el numero de asientos de cada uno, para ello simplemente tendriamos que haber indluido el scaner y variables.
     * Por defecto, he supuesto que son 20 asientos
     */
    public Coche(){
        asientos=new Cliente[20];
        for(byte i=0;i<20;i++)
            asientos[i]=new Cliente();
    }
    /**
     * Constructor de coche con parametros
     * @param identificador numero con el que vamos a identificar al coche
     * @param tipo tipo de coche, turista T, preferente P
     */
    public Coche(int identificador, char tipo){
        this.identificador=identificador;
        this.tipo=tipo;
        
        asientos=new Cliente[20];
        for(byte i=0;i<20;i++)
            asientos[i]=new Cliente();
    }
    /**
     * Devuelve el identificador del coche
     * @return identificador detipo entero
     */
    public int getIdentificador(){
        return identificador;
    }
    /**
     * Devuelve tipo de coche
     * @return tipo
     */
    public char getTipo(){
        return tipo;
    }
    /**
     * 
     * @param identificador asigna identificador de coche.
     */
    public void setIdentificador(int identificador){
        this.identificador=identificador;
    }
    /**
     * 
     * @param tipo tipo de coche T: turista, por ejemplo
     */
    public void setTipo(char tipo){
        this.tipo=tipo;
    }
    /**
     * 
     * @param i numero de cliente que vamos a devolver
     * @return cliente posicionado en i
     */
    public Cliente getCliente(byte i){
        return asientos[i];
    }
    /**
     * 
     * @param c cliente que vamos a asignar
     * @param i numero de asiento que vamos a ocupar.
     */
    public void setCliente(Cliente c, byte i){
        asientos[i]=c;
    }
    /**
     * Metodo que devuelve los datos correspondientes al coche.
     * @return 
     */
    @Override
    public String toString(){
        String resultado;
        resultado="\nCoche Nº"+identificador+"\tTipo: "+ tipo+"\n";
        for(byte i=0;i<asientos.length;i++){
            resultado=resultado+asientos[i].toString()+"\n";
        }
        return resultado;
    }
    /**
     * Metodo que devuelve el numero de asientos de un coche
     * @return int numero de asientos de un coche
     */
    public int getNumeroClientes(){
        return asientos.length;
    }
}

