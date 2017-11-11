import java.util.Scanner;

public class Hotel {
    //La fila 5 del arreglo cuenta como lobby, entonces no se imprime.
   static String [][] hotel = new String [6][6];
   static int habSui=0;
   static int habDob =0;
   static int habSen =0;
   
    public static void main(String[] args) {
        Scanner datos = new Scanner(System.in);
        for (int i =0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                hotel[i][j] = "O";
            }
        }
        
        int opcion;
        int contha1=0;
        int contha2=0;
        int contha3=0;
       
       
        do{
        // linea 0 - Suite
        
        // linea 1 y 2 - Habitaciones dobles
        
        // linea 3 y 4 - Habitaciones sencillas
        
        System.out.println("*****Bienvenido a nuestro hotel*****");
        System.out.println("1. Check - In");
        System.out.println("2. Check - out");
        System.out.println("3. Habitaciones Ocupadas ");
        System.out.println("4. Salir ");
        opcion = datos.nextInt();
        
        switch (opcion){
            case 1:
                String habitacion;
                System.out.println("¿Que tipo de habitacion desea reservar?");
                System.out.println("SUITE");
                System.out.println("DOBLE");
                System.out.println("SENCILLA");
                habitacion = datos.next().toUpperCase();
                
                
                
                switch(habitacion){
                    case "SUITE":
                        contha1 = 0;
        
                        // RESERVAR 
                        for (int i = 0; i < 1; i++) {
                            for (int j = 0; j < 6; j++) {
                                if (!"X".equals(hotel[i][j])) {
                                    hotel[i][j]= "X";
                                    habSui++;
                                    break;
                                }
                                
                            }
                        }   
                            // VEREFICAR SI EXISTEN DISPONIBLES
                            for (int j = 0; j < 1; j++) {
                                for (int k = 0; k < 6; k++) {
                                    if("X".equals(hotel[j][k])){
                                        contha1++;
                                    }
                                }
                            }
                        if(contha1 == 6){
                            System.out.println("YA NO HAY HABITACIONES DISPONIBLES");
                        
                        }else{
                            System.out.println("RESERVO SU HABITACION");
                        }
                            
                        
                        break;
                    case "DOBLE":
                        contha2 = 0;
                        boolean habD = true;
                        // RESERVAR 
                        for (int i = 2; i > 0; i--) {
                            if(habD == false){
                                break;
                            }
                            for (int j = 0; j < 6; j++) {
                                if (!"X".equals(hotel[i][j])) {
                                    hotel[i][j]= "X";
                                    habD = false;
                                    habDob++;
                                    break;
                                }
                               
                            }
                        }   
                            // VEREFICAR SI EXISTEN DISPONIBLES
                            for (int j = 2; j > 0; j--) {
                                for (int k = 0; k < 6; k++) {
                                    if("X".equals(hotel[j][k])){
                                        contha2++;
                                    }
                                }
                            }
                        if(contha2 == 12){
                            System.out.println("YA NO HAY HABITACIONES DISPONIBLES");
                        
                        }else{
                            System.out.println("RESERVO SU HABITACION");
                        }
                        
                        
                        break;
                    case "SENCILLA":
                         contha3 = 0;
                         boolean habD1 = true;
                         // RESERVAR 
                        for (int i = 4; i > 2; i--) {
                            if(habD1 == false){
                                break;
                            }
                            for (int j = 0; j < 6; j++) {
                                if (!"X".equals(hotel[i][j])) {
                                    hotel[i][j]= "X";
                                    habD1 = false;
                                    habSen++;
                                    break;
                                }
                            }
                        }   
                            // VEREFICAR SI EXISTEN DISPONIBLES
                            for (int j = 4; j > 2; j--) {
                                for (int k = 0; k < 6; k++) {
                                    if("X".equals(hotel[j][k])){
                                        contha3++;
                                    }
                                }
                            }
                        if(contha3 == 12){
                            System.out.println("YA NO HAY HABITACIONES DISPONIBLES");
                        
                        }else{
                            System.out.println("RESERVO SU HABITACION");
                        }
                        
                        
                        break;
                    default:
                        System.out.println("Verifique su tipo de habitacion");
                }
                
                
                break;
            case 2:
                int piso;
                int hab;
                System.out.println("Bienvenido al Check - Out");
                System.out.println("Ingrese el piso en que esta");
                piso = datos.nextInt();
                System.out.println("Ingrese # de habitacion: ");
                hab = datos.nextInt();
                
                switch(piso){
                    case 2:
                        piso = 4;
                        break;
                    case 3:
                        piso = 3;
                        break;
                    case 4:
                        piso = 2;
                        break;
                    case 5:
                        piso = 1;
                        break;
                    case 6:
                        piso = 0;
                        break;
                    default:
                        System.out.println("Piso invalido");
                        break;
                 //hotel[piso][hab-1]= "O";       
                }
                if(piso < 5 && hab < 7 && hotel[piso][hab - 1] == "X"){
                    hotel[piso][hab-1] = "O"; 
                    if(piso==0){
                        habSui--;
                        contha1--;
                    }else if (piso == 1 || piso==2){
                        habDob--;
                        contha2--;
                    }else if(piso==3 || piso == 4){
                        habSen--;
                        contha3--;
                    }
                
                }else{
                    System.out.println("Ingreso datos invalidos");
                }
                break;
                
            case 3:
                System.out.println("Habitaciones disponibles");
                System.out.println("");
                
                for (int i = 0; i < 5; i++) {
                    System.out.println("");
                    for (int j = 0; j < 6; j++) {
                        System.out.print("\t"+hotel[i][j]);
                    }
                }
                System.out.println("");
                System.out.println("Total habitaciones ocupadas: "+(contha1+contha2+contha3));
                int total=0;
                total = (habSui*5000)+(habDob*3400)+(habSen*1200);
                System.out.println("Total de dinero en habitaciones ocupadas: "+total+" Lps");
                break;
                
            case 4:
                System.exit(0);
                break;
        }
    }while(opcion !=4);
    }
}