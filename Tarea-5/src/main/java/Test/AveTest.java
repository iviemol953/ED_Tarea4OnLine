package Test;

import ModelodeDatos.*;
import static Test.Utilidades.*;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.*;
import java.util.InputMismatchException;

/**
 *
 * @author Inma Viera
 */
public class AveTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        byte opcion=0;
        boolean continuar; 
        
        Scanner teclado=new Scanner(System.in);
        System.out.println("Definición del Tren: ");
        LocalDateTime fechaSalida = LocalDateTime.of(2020, 2, 1, 7, 0);  
        LocalDateTime fechaLlegada = LocalDateTime.of(2020, 2, 1, 9, 30);
        byte nCoches=6;
        Ave a=new Ave(1,"Sevilla","Madrid",fechaSalida,fechaLlegada,nCoches);
        do{
            try{
                do{
                    mostrarMenu();
                    opcion=teclado.nextByte();
                    continuar=true;
                }while(!continuar); 
            
                switch (opcion){
                    case 1:
                        visualizarOcupacion(a);   
                        break;
                    case 2:
                        asignarAsiento(a);
                        break;
                    case 3:
                        liberarAsiento(a);
                        break;
                    case 4:
                     //   imprimirBillete2(a);
                        imprimirBillete(a);
                        break;
                    case 0:
                        System.out.println("Saliendo.");
                        break;
                    default:
                        System.out.println("Opcion incorrecta.");

                }

                pulsarTecla();
                dormir(10);
                limpiarPantalla();
            }catch (InputMismatchException e){
                teclado.nextLine();
                System.err.println("Debe introducir una opción correcta.");

            }
                            
        }while(opcion!=0);
    }
    /**
     * Procedimiento que muestra el menú de nuestra aplicación
     */
    
    static void mostrarMenu(){
        System.out.println("*************************************\n"+
                           "*  1.- Ocupación Tren               *\n"+
                           "*  2.- Asignar Asiento              *\n"+
                           "*  3.- Liberar Asiento              *\n"+
                           "*  4.- Mostrar Billetes             *\n"+
                           "*  0.- Salir                        *\n"+
                           "*************************************\n"+
                           "Elige la opcion a realizar: ");
    }
    /**
     * Muestra la ocupación del tren. asientos libres en color verde |L| y ocupados
     * en rojo |O|
     * A continuación muestra el total de asientos ocupados. Y por ultimo la información de cada unno de los coches
     * @param tren Ave
     */
    static void visualizarOcupacion(Ave tren){
        String resultado;
        
        resultado=tren.toString();
        System.out.println(escribirNormal(resultado)); 
        byte i=0, j=0, total=0;

        Coche c=new Coche();
        total=(byte) tren.getCoche(i).getCliente(i).getPasajeros();
        System.out.println("Total de asientos ocupados: "+total+"\n");
        
        for(i=0;i<tren.getNumeroCoches();i++){
            c=tren.getCoche(i);
            String s=escribirNormal("Coche ")+(i+1)+"\t";
            for(j=0;j<c.getNumeroClientes();j++)
            {
                if (c.getCliente(j).getDni()==0)
                    s=s+escribirVerde("| L |");
                else
                    s=s+escribirRojo("| O |");
            }
            System.out.println(s+"\n");
        }
        System.out.println(escribirNormal("\n"));
    }
    
    /**
     * 
     * @return cliente con los datos que se han pedido.
     * @throws Exception en caso de que no se pueda crear el cliente. 
     * se comprueba que el dni se corresponda con un numero.
     */
    static Cliente crearCliente() throws Exception{
        Scanner teclado=new Scanner(System.in);
        String nombre, apellidos;
        boolean continuar=true;
        int dni=0;
        
        boolean ocupado=true;
        
        System.out.println("Nombre: ");
        nombre=teclado.nextLine();
        System.out.println("Apellidos: ");
        apellidos=teclado.nextLine();
        do{
            try{
                System.out.println("DNI: ");
                dni=teclado.nextInt();
                continuar=false;
            }catch(InputMismatchException e){
                System.err.println("El DNI es un número.");
            }
            teclado.nextLine(); 
        }while(continuar);
        
        try{
            Cliente c=new Cliente(nombre,apellidos,dni);
            return c;
        }catch(Exception e){
            System.out.println("Imposible crear el cliente.");
            teclado.next();
        }
        
       return null;

    }
    /**
     * Busca hueco en el primer asiento libre que hay. En caso de que haya, crea un cliente y lo asigna.
     * @param a Ave
     */
    static void asignarAsiento(Ave a) {
        Cliente u;
        boolean hueco=false;
        Coche c=new Coche();
        try{
            byte i=0,j=0;
            while(!hueco && i<a.getNumeroCoches()){
                c=a.getCoche(i);
                j=0;
                while(j<c.getNumeroClientes() && !hueco){
                    if (c.getCliente(j).getDni()!=0)
                        j++;
                    else
                        hueco=true;
                }
                if (!hueco)
                    i++;
            }
            if (hueco){
                u=crearCliente();
                c.setCliente(u,j);
            }
            else{
                System.out.println("El tren está completo.");
                throw new Exception();
            }
            
        }catch(Exception e){
            System.out.println("El tren está lleno. Imposible asignar asiento.");
        }
        
        
    }
    /**
     * La aplicación pide el identificador del coche y el del asiento. 
     * Como el identificador del coche no tiene por qué ser el mismo que el numero
     * del coche, por eso lo busco asi. De manera general, los asientos si se numeran
     * seguidamente.
     * @param tren Ave
     */
    static void liberarAsiento(Ave tren){
        Scanner teclado=new Scanner(System.in);
        byte posCoche,posAsiento;
        Coche c=new Coche();
        
        do{
            System.out.println("Indique el coche del viajero: ");
            posCoche=teclado.nextByte();
        }while(posCoche>=tren.getNumeroCoches() && posCoche<0);
        do{
            System.out.println("Indique el asiento del viajero: ");
            posAsiento=teclado.nextByte();  
        }while(posAsiento<0 && posAsiento>tren.getCoche(posCoche).getIdentificador());
        
        posAsiento--;
        byte i=0;
        boolean encontrado=false;
        
        while(!encontrado && i<tren.getNumeroCoches())
        {
          c=tren.getCoche(i);  
          if(c.getIdentificador()==posCoche)
              encontrado=true;
          else
              i++;
        }
        /*
        Se supone que el dni no tiene que ser obligatorio pero el nombre y los apellidos si. Por ello compruebo
        que nombre y apellido sean no nulos para liberar el asiento
        */
        if (encontrado){
            if((c.getCliente(posAsiento).getNombre()!=null) && (c.getCliente(posAsiento).getApellido()!=null)  ){
                c.getCliente(posAsiento).setDni(0);
                c.getCliente(posAsiento).setApellidos(null);
                c.getCliente(posAsiento).setNombre(null); 
                c.getCliente(posAsiento).setPasajeros(c.getCliente(posAsiento).getPasajeros()-1);
                System.out.println("El asiento se ha liberado.");
            }
            else
                System.out.println("El asiento estaba libre.");
        }
    }
    
    /**
     * Solicita el identificador del codhe y el numero de asiento e imprime el billete.
     * @param tren Ave
     */
    static void imprimirBillete(Ave tren){
        Scanner teclado=new Scanner(System.in);
        byte posCoche,posAsiento;
        Coche c=new Coche();
        
        System.out.println("Indique el coche del viajero: ");
        posCoche=teclado.nextByte();
        System.out.println("Indique el asiento del viajero: ");
        posAsiento=teclado.nextByte();  
        posCoche--;
        posAsiento--;

        c=tren.getCoche(posCoche);
        if(c.getCliente(posAsiento).getNombre()!=null){
            System.out.println("----------------------------------------------------------------------------------"); 
            System.out.println(tren.toString());
            System.out.println("Coche Nº: "+c.getIdentificador()+" Asiento: "+c.getCliente(posAsiento).getPasajeros());
            System.out.println(c.getCliente(posAsiento).toString());
            System.out.println("\n----------------------------------------------------------------------------------\n"); 
        }
        else
            System.out.println("El asiento está libre.");
    }
    
}
