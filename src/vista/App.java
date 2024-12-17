package vista;

import controlador.EmpresaTurismo;
import modelo.*;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        int opcion;
        String rutCliente;
        boolean fumador;
        int capacidad;
        EmpresaTurismo empresaTurismo = new EmpresaTurismo(new ArrayList<>());

        do{
            opcion = menu();

            switch (opcion){
                case 1:
                    System.out.println("Ingresar medio");
                    System.out.println();

                    rutCliente = pideCodigo();

                    if(empresaTurismo.buscarMedio(rutCliente)==-1){
                        System.out.println("No existe y se debe crear");
                        System.out.println();
                        System.out.println("Nombre del cliente: "); String nombre = Leer.dato();
                        System.out.println("Valor base de la noche: "); int valor = Leer.datoInt();
                        System.out.println("Cantidad de noches: "); int cantidadNoches = Leer.datoInt();

                        String tipoTemporada;
                        do{
                            System.out.println("Tipo de temporada: Alta, Media o Baja");
                            tipoTemporada = Leer.dato();
                        }while(tipoTemporada.compareToIgnoreCase("A") !=0 &&
                                tipoTemporada.compareToIgnoreCase("M") !=0 &&
                                tipoTemporada.compareToIgnoreCase("B") !=0);

                        int respuesta;
                        do{
                            System.out.println("Favor indicar medio de alojamiento: 1)Carpa    2)Cabaña    3)Hotel");
                            System.out.println("Favor ingrese una opción para continuar (1,2 o 3)");
                            respuesta = Leer.datoInt();
                        }while(respuesta < 1 || respuesta >3);

                        if(respuesta==1){
                            System.out.println("Cantidad de personas: "); int cantidadPersonas = Leer.datoInt();

                            DatosCliente datosCliente = new DatosCliente(nombre,rutCliente);
                            Carpa carpa = new Carpa(datosCliente,valor,cantidadNoches,tipoTemporada,cantidadPersonas);
                            empresaTurismo.ingresarCarpa(carpa);
                            System.out.println("Se registra la carpa correctamente...\n");
                        }else{
                            if(respuesta==2){
                                System.out.println("Capacidad: ");
                                capacidad = Leer.datoInt();

                                String opcionChi;
                                do{
                                    System.out.println("¿Tiene Chimenea (Si o No)? ");
                                    opcionChi = Leer.dato();
                                }while(opcionChi.compareToIgnoreCase("S") !=0 &&
                                        opcionChi.compareToIgnoreCase("N") !=0);

                                Boolean chimenea;
                                if(opcionChi.equalsIgnoreCase("S")){
                                    chimenea = true;
                                }else {
                                    chimenea = false;
                                }

                                fumador = esFumador();

                                DatosCliente datosCliente = new DatosCliente(nombre,rutCliente);
                                Cabagna cabagna = new Cabagna(datosCliente,valor,cantidadNoches,tipoTemporada,fumador,capacidad,chimenea);
                                empresaTurismo.ingresarCabagna(cabagna);
                                System.out.println("Se registra la cabaña correctamente...\n");
                            }else{
                                if(respuesta==3){
                                    System.out.println("Capacidad: ");
                                    capacidad = Leer.datoInt();

                                    String opcionDesa;
                                    do{
                                        System.out.println("¿Tiene Desayuno (Si o No)? ");
                                        opcionDesa = Leer.dato();
                                    }while(opcionDesa.compareToIgnoreCase("S") !=0 &&
                                            opcionDesa.compareToIgnoreCase("N") !=0);

                                    Boolean desayuno;
                                    if(opcionDesa.equalsIgnoreCase("S")){
                                        desayuno = true;
                                    }else {
                                        desayuno = false;
                                    }

                                    fumador = esFumador();

                                    DatosCliente datosCliente = new DatosCliente(nombre,rutCliente);
                                    Hotel hotel = new Hotel(datosCliente,valor,cantidadNoches,tipoTemporada,fumador,capacidad,desayuno);
                                    empresaTurismo.ingresarHotel(hotel);
                                    System.out.println("Se registra el hotel correctamente...\n");
                                }
                            }
                        }

                    }else{
                        System.out.println("El rut del cliente ya existe!!!\n");
                    }
                    break;
                case 2:
                    System.out.println("Medios de Alojamiento\n");


                    System.out.println(empresaTurismo.medioCarpa());
                    System.out.println(empresaTurismo.medioCabagna());
                    System.out.println(empresaTurismo.medioHotel());

                    if(empresaTurismo.medioCarpa().isEmpty()){
                        System.out.println("No hay Carpa Registrada!!!\n");
                    }

                    if(empresaTurismo.medioCabagna().isEmpty()){
                        System.out.println("No hay Cabaña Registrada!!!\n");
                    }

                    if(empresaTurismo.medioHotel().isEmpty()){
                        System.out.println("No hay Hotel Registrado!!!\n");
                    }

                    break;
                case 3:
                    rutCliente = pideCodigo();

                    if(empresaTurismo.buscarMedio(rutCliente)!=-1){
                        System.out.println(empresaTurismo.datosCliente(rutCliente));
                    }else{
                    System.out.println("\nEl Cliente no se encuentra registrado!!!\n");
                    }

                    break;
                case 4:
                    rutCliente = pideCodigo();

                    if(empresaTurismo.buscarMedio(rutCliente)!=-1){
                        System.out.println(empresaTurismo.totalAdicional(rutCliente));
                    }else{
                        System.out.println("\nEl Cliente no se encuentra registrado!!!\n");
                    }

                    break;
                case 5:
                    rutCliente = pideCodigo();

                    if(empresaTurismo.buscarMedio(rutCliente)!=-1){
                        System.out.println(empresaTurismo.totalBono(rutCliente));
                    }else{
                        System.out.println("\nEl Cliente no se encuentra registrado!!!\n");
                    }

                    break;
                case 6:
                    System.out.println(empresaTurismo.cantidadMedios());
                    break;
                case 7:
                    rutCliente = pideCodigo();

                    if(empresaTurismo.buscarMedio(rutCliente)!=-1){
                        System.out.println(empresaTurismo.valoraCancelar(rutCliente));
                    }else{
                        System.out.println("\nEl Cliente no se encuentra registrado!!!\n");
                    }

                    break;
                case 8:
                    System.out.println("en construcción");
                    break;
            }
        }while(opcion!=9);
    }

    public static String pideCodigo(){
        System.out.println("Favor ingrese rut del cliente...");
        return Leer.dato();
    }

    public static boolean esFumador(){
        String opcionFuma;
        do{
            System.out.println("¿Es Fumador (Si o No)? ");
            opcionFuma = Leer.dato();
        }while(opcionFuma.compareToIgnoreCase("S") !=0 &&
                opcionFuma.compareToIgnoreCase("N") !=0);

        Boolean fumador;
        if(opcionFuma.equalsIgnoreCase("S")){
            fumador = true;
        }else {
            fumador = false;
        }

        return fumador;
    }

    public static int menu(){
        System.out.println("---- Sistema Empresa de Turismo ----");
        System.out.println("------------------------------------");
        System.out.println("1.\tIngresar medio de alojamiento");
        System.out.println("2.\tMostrar medios de alojamiento");
        System.out.println("3.\tDatos de un cliente X");
        System.out.println("4.\tTotal adicional");
        System.out.println("5.\tTotal bono descuento");
        System.out.println("6.\tCantidad medios de alojamiento X");
        System.out.println("7.\tValor a cancelar por un cliente X");
        System.out.println("8.\tAplicar incremento del valor base");
        System.out.println("9.\tSalir.");
        System.out.println("------------------------------------");
        System.out.println("Favor ingrese una opción para continuar...");
        return Leer.datoInt();
    }
}
