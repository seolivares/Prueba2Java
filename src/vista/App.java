package vista;

import controlador.EmpresaTurismo;
import modelo.Cabagna;
import modelo.Carpa;
import modelo.DatosCliente;
import modelo.MedioDeAlojamiento;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        int opcion;
        String rutCliente;

        EmpresaTurismo empresaTurismo = new EmpresaTurismo(new ArrayList<>());

        do{
            opcion = menu();

            switch (opcion){
                case 1:
                    System.out.println("Ingresar medio");
                    rutCliente = pideCodigo();

                    if(empresaTurismo.buscarMedio(rutCliente)==-1){
                        System.out.println("No existe y se debe crear");
                        System.out.println();
                        System.out.println("Nombre del cliente: "); String nombre = Leer.dato();
                        System.out.println("Rut del cliente: "); String rut = Leer.dato();
                        System.out.println("Valor base de la noche: "); int valor = Leer.datoInt();
                        System.out.println("Cantidad de noches: "); int cantidadNoches = Leer.datoInt();

                        String tipoTemporada;
                        do{
                            System.out.println("¿Tipo de temporada ((Alta, Media o Baja)? ");
                            tipoTemporada = Leer.dato();
                        }while(tipoTemporada.compareToIgnoreCase("Alta") !=0 &&
                                tipoTemporada.compareToIgnoreCase("Media") !=0 &&
                                tipoTemporada.compareToIgnoreCase("Baja") !=0);

                        int respuesta;
                        do{
                            System.out.println("Favor indicar medio de alojamiento: 1)Carpa    2)Cabaña    3)Hotel");
                            System.out.println("Favor ingrese una opción para continuar (1,2 o 3)");
                            respuesta = Leer.datoInt();
                        }while(respuesta < 1 || respuesta >3);

                        if(respuesta==1){
                            System.out.println("Cantidad de personas: "); int cantidadPersonas = Leer.datoInt();

                            DatosCliente datosCliente = new DatosCliente(nombre,rut);
                            Carpa carpa = new Carpa(datosCliente,valor,cantidadNoches,tipoTemporada,cantidadPersonas);

                            empresaTurismo.ingresarCarpa(carpa);
                            System.out.println("Se registra la carpa correctamente...");
                        }
                    }else{
                        System.out.println("El rut " + rutCliente + " del cliente ya existe!!!");
                    }
                    break;
                case 2:
                    System.out.println("Datos de medio");
                    System.out.println();
                    System.out.println(empresaTurismo.medioCarpa());
                    break;
                case 3:
                    System.out.println("en construcción");
                    break;
                case 4:
                    System.out.println("en construcción");
                    break;
                case 5:
                    System.out.println("en construcción");
                    break;
                case 6:
                    System.out.println("en construcción");
                    break;
                case 7:
                    System.out.println("en construcción");
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
