import java.util.Scanner;

/******************************************************************
Driver.java
Driver program que funciona con cualquier tipo de radio que 
implemente la interfaz Radio.java

@since	17/1/2022
******************************************************************/
public class Driver {
    
    private static MiRadio r;
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        r = new MiRadio();
        desplegarMenu();
    }

    /**
     * Se despliega el menú con todas las opciones que se pueden hacer en el radio
     */
    private static void desplegarMenu() {
        int opcion = 0;
		while (opcion != 7){
		
			System.out.println("\n\n Escoja una opcion del menú");
			System.out.println("1. Prende el radio");
			System.out.println("2. Cambia de AM a FM/ de FM a AM");
			System.out.println("3. Mover en el dial de las emisoras. Al llegar al final del dial inicia nuevamente.");
			System.out.println("4. Guardar una emisora en uno de los 12 botones            ");
			System.out.println("5. Selecciona una de las emisoras guardadas");
			System.out.println("6. Apagar el radio");
            System.out.println("7. Cierra el menú");


			scan = new Scanner(System.in);
			try{opcion = scan.nextInt();}
			catch(Exception e){System.out.println("INVALIDO");}
			//catch(Exception e){System.out.println("INVALIDO");}


			if (opcion == 1){prender();}
            else if(opcion ==2){cambiarAM_FM();}
            else if(opcion ==3){avanzarDial();}
			else if(opcion ==4){guardarEmisora();}
			else if(opcion ==5){seleccionarEmisora();}
			else if(opcion ==6){apagar();}
			else{ System.out.println("Agregue una entrada valida del menu");}
            
            }
		}
    

    /**
     * Prende la radio si se encuentra apagada, o despliega que se
     * encuentra encendida si ya lo está.
     */
    private static void prender() {
        boolean on = r.isOn();
        boolean isAM = r.getFrequency();
        double station=  r.getStation();
        if(on) {
            System.out.println("La radio ya se encuentra encendida");
        }else {
            r.turnOnOff();
            System.out.println("Se ha encendido la radio");
            if(isAM){
                System.out.println("Usted se encuentra en la emisora "+station+" AM");
            }else{
                System.out.println("Usted se encuentra en la emisora "+station+" FM");
            }
            
        }
    }

    /**
     * Apaga la radio si se encuentra encendida, o despliega que se
     * encuentra apagada si ya lo está.
     */
    private static void apagar() {
        boolean on = r.isOn();
        if(!on) {
            System.out.println("La radio ya se encuentra apagada");
        }else {
            r.turnOnOff();
            System.err.println("Se ha apagado la radio");
        }
    }

    /**
     * Solicita la posicion en la que se guardara la emisora.
     * Solo acepta numeros del 1-12
     */
    private static void guardarEmisora() {
        
        if (r.isOn()) {
            double station = r.getStation();
        System.out.println("Elija el botón (1-12) para guardar la emisora "+station);
        int position = 0;
        while (!(0<position && position <13)){
			scan = new Scanner(System.in);
			try{position = scan.nextInt();}
			catch(Exception e){System.out.println("Escoja un entero");}

            if (!(0<position && position <13)) {
               System.out.println("Elija un entero del 1-12"); 
            }
		}
        r.saveStation(position, station);
                
        System.out.println("Se ha guardado la emisora "+station+" en el boton "+position);
        } else {
            System.out.println("La radio se encuentra apagada");
        }
    }

        
    /**
     * Solicita el botón donde se encuentra la emisora guardada y la reproduce
     * solo acepta de 1-12
     */
    private static void seleccionarEmisora() {

        if (r.isOn()) {
            double station = r.getStation();
            if(r.getFrequency()){
                System.out.println("Usted está en frecuencia AM");
            }else{
                System.out.println("Usted está en frecuencia FM");
            }
        System.out.println("Elija el botón (1-12) donde está la emisora que desea escuchar");
        int position = 0;
        while (!(0<position && position <13)){
			scan = new Scanner(System.in);
			try{position = scan.nextInt();}
			catch(Exception e){System.out.println("Escoja un entero");}

            if (!(0<position && position <13)) {
               System.out.println("Elija un entero del 1-12"); 
            }
		}

        station=r.getSavedStation(position);
        System.out.println("La emisora "+station+" está en el boton "+position+" y ahora esta sonando");

        } else {
            System.out.println("La radio se encuentra apagada");
        }
    }

    /**
     * Mueve Dial adelante y para atrás dependiendo de la frecuencia 
     * si llega al máximo o al mínmio regresa a la primera o a la última
     */
    private static void avanzarDial() {
        
        if(r.isOn()){


            System.out.println("Usted desea mover la emisora:\n1.Adelante\n2.Atrás");
            scan = new Scanner(System.in);
            int dial=scan.nextInt();
            if(dial==1){

                r.nextStation(r.getFrequency());// ??????????
                double station=  r.getStation();
                boolean isAM = r.getFrequency();
                if (isAM) {
                    System.out.print("Se ha avanzado a la emisora "+station+" AM");
                    
                } else {
                    System.out.println("Se ha avanzado a la emisora "+station+" FM");
                    
                }
            }else if(dial==2){
            retrocederDial();
            }else{
                System.out.println("Opcion invalida");
            }



        }else{
            System.out .println("La radio se encuetra apagada");
        }
        

        

        
    }
    
    /**
     * retrocede el Dial dependiendo de la frecuencia
     * si llega al mínimo se envía a la estación más alta
     */
    private static void retrocederDial() {
        r.prevStation(r.getFrequency());// ??????????
        double station=  r.getStation();
        boolean isAM = r.getFrequency();
        if (isAM) {
            System.out.print("Se ha avanzado a la emisora "+station+" AM");
        } else {
            System.out.print("Se ha avanzado a la emisora "+station+" FM");
        }
        
    }

    /**Se cambia de frecuencia */
    private static void cambiarAM_FM() {
        
        if(r.isOn()){

            r.switchAMFM();
            boolean isAM = r.getFrequency();
            if (isAM) {
                System.out.println("Se ha cambiado a la frecuencia AM");
                double station=r.getStation();
                System.out.println("La estación que escuchas es "+station);
            } else {
                System.out.println("Se ha cambiado a la frecuencia FM");
                double station=r.getStation();
                System.out.println("La estación que escuchas es "+station);
            }

        }else{
            System.out.println("La radio se encuetra apagada");
        }
        
        
        
    }

    
    
}
