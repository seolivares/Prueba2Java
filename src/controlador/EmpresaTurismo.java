package controlador;

import modelo.*;

import java.util.ArrayList;

public class EmpresaTurismo {
    private ArrayList<MedioDeAlojamiento> empresaTurismo;

    public EmpresaTurismo(ArrayList<MedioDeAlojamiento> empresaTurismo) {
        this.empresaTurismo = empresaTurismo;
    }

    public ArrayList<MedioDeAlojamiento> getEmpresaTurismo() {
        return empresaTurismo;
    }

    public void setEmpresaTurismo(ArrayList<MedioDeAlojamiento> empresaTurismo) {
        this.empresaTurismo = empresaTurismo;
    }

    public int buscarMedio(String rutCliente) {
        for (int i = 0; i < empresaTurismo.size(); i++) {
            //lista.elemento.caracteristica cumple criterio
            if (empresaTurismo.get(i).getDatosClientes().getRut().compareToIgnoreCase(rutCliente) == 0) {
                return i;
            }
        }
        return -1;
    }

    public void ingresarHotel(Hotel hotel) {
        if (this.buscarMedio(hotel.getDatosClientes().getRut()) == -1) {
            empresaTurismo.add(hotel);
        }
    }

    public void ingresarCabagna(Cabagna cabagna) {
        if (this.buscarMedio(cabagna.getDatosClientes().getRut()) == -1) {
            empresaTurismo.add(cabagna);
        }
    }

    public void ingresarCarpa(Carpa carpa) {
        if (this.buscarMedio(carpa.getDatosClientes().getRut()) == -1) {
            empresaTurismo.add(carpa);
        }
    }

    public String medioCarpa(){
        //recorrer la lista
        String mensaje = "";
        Carpa carpa = null;

        for(int i=0;i<empresaTurismo.size();i++){

            if(empresaTurismo.get(i) instanceof Carpa){
                mensaje = mensaje + "\nNombre Cliente: " + empresaTurismo.get(i).getDatosClientes().getNombreCliente()
                        + "\nRut cliente: " + empresaTurismo.get(i).getDatosClientes().getRut();
                mensaje = mensaje + datosCarpa(i);
            }
        }

        if(mensaje.equalsIgnoreCase("")){
            mensaje = "No hay carpas registradas!!!\n";
        }
        return mensaje;
    }

    public String medioCabagna(){
        //recorrer la lista
        String mensaje = "";
        Cabagna cabagna = null;

        for(int i=0;i<empresaTurismo.size();i++){

            if(empresaTurismo.get(i) instanceof Cabagna){
                cabagna = (Cabagna) empresaTurismo.get(i);
                mensaje = mensaje + "\nMedio de Alojamiento: Cabaña "
                                  + "\nTemporada: " + cabagna.getTipoTemporada()
                                  + "\nValor por Noche: " + cabagna.getValorBaseNoche()
                                  + "\nCantidad de Noches: " + cabagna.getCantidadNoches()
                                  + "\nTiene Capacidad: " + cabagna.getCapacidad()
                                  + "\nTiene Chimenea: ";

                if(cabagna.isChimenea()){
                    mensaje = mensaje + "Si";
                }else{
                    mensaje = mensaje + "No";
                }

                mensaje = mensaje + "\nNombre Cliente: " + cabagna.getDatosClientes().getNombreCliente()
                        + "\nRut cliente: "+ cabagna.getDatosClientes().getRut()
                        + "\nFumador: ";

                if(cabagna.isEsFumador()){
                    mensaje = mensaje + "Si\n";
                }else{
                    mensaje = mensaje + "No\n";
                }
            }
        }
        if(mensaje.equalsIgnoreCase("")){
            mensaje = "No hay Cabañas registradas!!!\n";
        }
        return mensaje;
    }

    public String medioHotel(){
        String mensaje = "";
        Hotel hotel = null;

        for(int i=0;i<empresaTurismo.size();i++){
            //definir una estructura de control
            if(empresaTurismo.get(i) instanceof Hotel){
                hotel = (Hotel) empresaTurismo.get(i);
                mensaje = mensaje + "\nMedio de Alojamiento: Hotel "
                                  + "\nTemporada: " + hotel.getTipoTemporada()
                                  + "\nValor por Noche: " + hotel.getValorBaseNoche()
                                  + "\nCantidad de Noches: " + hotel.getCantidadNoches()
                                  + "\nTiene Capacidad: " + hotel.getCapacidad()
                                  + "\nTiene Desayuno: ";

                if(hotel.isConDesayuno()){
                    mensaje = mensaje + "Si";
                }else{
                    mensaje = mensaje + "No";
                }

                mensaje = mensaje + "\nNombre Cliente: " + hotel.getDatosClientes().getNombreCliente()
                        + "\nRut cliente: "+ hotel.getDatosClientes().getRut()
                        + "\nFumador: ";

                if(hotel.isEsFumador()){
                    mensaje = mensaje + "Si\n";
                }else{
                    mensaje = mensaje + "No\n";
                }
            }
        }
        if(mensaje.equalsIgnoreCase("")){
            mensaje = "No hay Hoteles registrados!!!\n";
        }
        return mensaje;
    }

    public String datosCliente(String rutCliente){
        //recorrer la lista
        String mensaje = "";
        Carpa carpa = null;
        Cabagna cabagna = null;
        Hotel hotel = null;
        int i=0;
        boolean encontrado = false;

        do{
            if(empresaTurismo.get(i).getDatosClientes().getRut().compareToIgnoreCase(rutCliente) == 0) {
                encontrado = true;

                if (empresaTurismo.get(i) instanceof Carpa) {
                    mensaje = mensaje + "\nNombre Cliente: " + empresaTurismo.get(i).getDatosClientes().getNombreCliente()
                            + "\nRut cliente: " + empresaTurismo.get(i).getDatosClientes().getRut();
                    mensaje = mensaje + datosCarpa(i);
                } else if (empresaTurismo.get(i) instanceof Cabagna) {
                    cabagna = (Cabagna) empresaTurismo.get(i);
                } else if (empresaTurismo.get(i) instanceof Hotel) {
                    hotel = (Hotel) empresaTurismo.get(i);
                }
            }
            i=i+1;
        }while(encontrado == false);

        return mensaje;
    }

    public String datosCarpa(int i){
        String mensaje = "";
        Carpa carpa;

        carpa = (Carpa) empresaTurismo.get(i);
        mensaje = mensaje + "\nMedio de Alojamiento: Carpa "
                          + "\nTemporada: " + carpa.getTipoTemporada()
                          + "\nValor por Noche: " + carpa.getValorBaseNoche()
                          + "\nCantidad de Noches: " + carpa.getCantidadNoches()
                          + "\nCantidad de Personas: " + carpa.getCantidadPersonas() + "\n";

        return mensaje;
    }

}

