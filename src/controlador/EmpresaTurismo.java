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
        String mensaje = "";

        for(int i=0;i<empresaTurismo.size();i++){
            if(empresaTurismo.get(i) instanceof Carpa){
                mensaje = mensaje + datosCarpa(i);
            }
        }

        return mensaje;
    }

    public String medioCabagna(){
        String mensaje = "";

        for(int i=0;i<empresaTurismo.size();i++){
            if(empresaTurismo.get(i) instanceof Cabagna){
                mensaje = mensaje + datosCabagna(i);
            }
        }

        return mensaje;
    }

    public String medioHotel(){
        String mensaje = "";

        for(int i=0;i<empresaTurismo.size();i++){
            if(empresaTurismo.get(i) instanceof Hotel){
                mensaje = mensaje + datosHotel(i);
            }
        }

        return mensaje;
    }

    public String datosCliente(String rutCliente){
        String mensaje = "";
        int i=0;
        boolean encontrado = false;

        do{
            if(empresaTurismo.get(i).getDatosClientes().getRut().compareToIgnoreCase(rutCliente) == 0) {
                encontrado = true;

                if (empresaTurismo.get(i) instanceof Carpa) {
                    mensaje = mensaje + datosCarpa(i);
                } else if (empresaTurismo.get(i) instanceof Cabagna) {
                    mensaje = mensaje + datosCabagna(i);
                } else if (empresaTurismo.get(i) instanceof Hotel) {
                    mensaje = mensaje + datosHotel(i);
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

        mensaje = mensaje + "\nNombre Cliente: " + empresaTurismo.get(i).getDatosClientes().getNombreCliente()
                + "\nRut cliente: " + empresaTurismo.get(i).getDatosClientes().getRut()
                + "\nMedio: Carpa "
                + "\nTemporada: " + carpa.getTipoTemporada()
                + "\nValor por Noche: " + carpa.getValorBaseNoche()
                + "\nCantidad de Noches: " + carpa.getCantidadNoches()
                + "\nCantidad de Personas: " + carpa.getCantidadPersonas() + "\n";

        return mensaje;
    }

    public String datosCabagna(int i){
        String mensaje = "";
        Cabagna cabagna;
        cabagna = (Cabagna) empresaTurismo.get(i);

        mensaje = mensaje + "\nNombre Cliente: " + empresaTurismo.get(i).getDatosClientes().getNombreCliente()
                + "\nRut cliente: " + empresaTurismo.get(i).getDatosClientes().getRut()
                + "\nMedio: Cabaña "
                + "\nTemporada: " + cabagna.getTipoTemporada()
                + "\nValor por Noche: " + cabagna.getValorBaseNoche()
                + "\nCantidad de Noches: " + cabagna.getCantidadNoches()
                + "\nCapaciad: " + cabagna.getCapacidad()
                + "\nTiene Chimenea: ";

        if(cabagna.isChimenea()){
            mensaje = mensaje + "Si";
        }else{
            mensaje = mensaje + "No";
        }

        mensaje = mensaje + "\nFumador: ";

        if(cabagna.isEsFumador()){
            mensaje = mensaje + "Si\n";
        }else{
            mensaje = mensaje + "No\n";
        }

        return mensaje;
    }

    public String datosHotel(int i){
        String mensaje = "";
        Hotel hotel;
        hotel = (Hotel) empresaTurismo.get(i);

        mensaje = mensaje + "\nNombre Cliente: " + empresaTurismo.get(i).getDatosClientes().getNombreCliente()
                + "\nRut cliente: " + empresaTurismo.get(i).getDatosClientes().getRut()
                + "\nMedio: Hotel"
                + "\nTemporada: " + hotel.getTipoTemporada()
                + "\nValor por Noche: " + hotel.getValorBaseNoche()
                + "\nCantidad de Noches: " + hotel.getCantidadNoches()
                + "\nCapacidad: " + hotel.getCapacidad()
                + "\nDesayuno: ";

        if(hotel.isConDesayuno()){
            mensaje = mensaje + "Si";
        }else{
            mensaje = mensaje + "No";
        }

        mensaje = mensaje + "\nFumador: ";

        if(hotel.isEsFumador()){
            mensaje = mensaje + "Si\n";
        }else{
            mensaje = mensaje + "No\n";
        }

        return mensaje;
    }

    public int subtotal(){
        int subtotal = 0;
        Hotel hotel;
        Cabagna cabagna;
        Carpa carpa;

        for(int i=0;i<empresaTurismo.size();i++){

            if(empresaTurismo.get(i) instanceof Carpa){
                carpa = (Carpa) empresaTurismo.get(i);
                subtotal = carpa.getValorBaseNoche() * carpa.getCantidadNoches();
            }else if(empresaTurismo.get(i) instanceof Cabagna){
                cabagna = (Cabagna) empresaTurismo.get(i);
                subtotal = cabagna.getValorBaseNoche() * cabagna.getCantidadNoches();
            } else if(empresaTurismo.get(i) instanceof Hotel){
                hotel = (Hotel) empresaTurismo.get(i);
                subtotal = hotel.getValorBaseNoche() * hotel.getCantidadNoches();
            }
        }

        return subtotal;
    }

    public String valoraCancelar(String rutCliente){
        int i=0;
        boolean encontrado = false;
        String mensaje= "";
        Hotel hotel;
        Cabagna cabagna;
        Carpa carpa;

        do{
            if(empresaTurismo.get(i).getDatosClientes().getRut().compareToIgnoreCase(rutCliente) == 0) {
                encontrado = true;

                if (empresaTurismo.get(i) instanceof Carpa) {
                    carpa = (Carpa) empresaTurismo.get(i);
                    mensaje = "\nEl cliente tiene un valor a cancelar de: " + (subtotal() - bonoDescuento(i)) + "\n";
                } else if (empresaTurismo.get(i) instanceof Cabagna) {
                    cabagna = (Cabagna) empresaTurismo.get(i);
                    mensaje = "\nEl cliente tiene un valor a cancelar de: " + (subtotal() - bonoDescuento(i) + cabagna.adicional()) + "\n";
                } else if (empresaTurismo.get(i) instanceof Hotel) {
                    hotel = (Hotel) empresaTurismo.get(i);
                    mensaje = "\nEl cliente tiene un valor a cancelar de: " + (subtotal() - bonoDescuento(i) + hotel.adicional()) + "\n";
                }
            }

            i=i+1;

        }while(encontrado == false);

        return mensaje;
    }

    public int bonoDescuento(int i){
        int descuento = 0;
        Hotel hotel;
        Cabagna cabagna;
        Carpa carpa;

            if(empresaTurismo.get(i) instanceof Carpa){
                carpa = (Carpa) empresaTurismo.get(i);
                if(carpa.getTipoTemporada().equalsIgnoreCase("b")){
                    descuento = Math.round(subtotal() / 4);
                }else{
                    if(carpa.getTipoTemporada().equalsIgnoreCase("m")){
                        descuento = Math.round(subtotal() / 8);
                    }
                }
            }else if(empresaTurismo.get(i) instanceof Cabagna){
                cabagna = (Cabagna) empresaTurismo.get(i);
                if(cabagna.getTipoTemporada().equalsIgnoreCase("b")){
                    descuento = Math.round(subtotal() / 4);
                }else{
                    if(cabagna.getTipoTemporada().equalsIgnoreCase("m")){
                        descuento = Math.round(subtotal() / 8);
                    }
                }
            } else if(empresaTurismo.get(i) instanceof Hotel){
                hotel = (Hotel) empresaTurismo.get(i);
                if(hotel.getTipoTemporada().equalsIgnoreCase("b")){
                    descuento = Math.round(subtotal() / 4);
                }else{
                    if(hotel.getTipoTemporada().equalsIgnoreCase("m")){
                        descuento = Math.round(subtotal() / 8);
                    }
                }
            }

        return descuento;
    }

    public String totalAdicional(String rutCliente){
        int i=0;
        boolean encontrado = false;
        String mensaje= "";
        Hotel hotel;
        Cabagna cabagna;

        do{
            if(empresaTurismo.get(i).getDatosClientes().getRut().compareToIgnoreCase(rutCliente) == 0) {
                encontrado = true;

                if(empresaTurismo.get(i) instanceof Carpa){
                    mensaje = "El cliente no paga adicional\n";
                }else if (empresaTurismo.get(i) instanceof Cabagna) {
                    cabagna = (Cabagna) empresaTurismo.get(i);
                    mensaje = "El cliente paga un total adicional de: " + cabagna.adicional() + "\n";
                } else if (empresaTurismo.get(i) instanceof Hotel) {
                    hotel = (Hotel) empresaTurismo.get(i);
                    mensaje = "El cliente paga un total adicional de: " + hotel.adicional() + "\n";
                }
            }
            i=i+1;

        }while(encontrado == false);

        return mensaje;
    }

    public String totalBono(String rutCliente){
        int i=0;
        boolean encontrado = false;
        String mensaje= "";

        do{
            if(empresaTurismo.get(i).getDatosClientes().getRut().compareToIgnoreCase(rutCliente) == 0) {
                encontrado = true;
                if(!empresaTurismo.get(i).getTipoTemporada().equalsIgnoreCase("a")){
                    mensaje = "El cliente tiene un total por bono descuento de: " + bonoDescuento(i) + "\n";
                }else {
                    mensaje = "El cliente no tiene descuento\n";
                }
            }
            i=i+1;
        }while(encontrado == false);

        return mensaje;
    }

    public String cantidadMedios(){
        String mensaje= "";
        int total = 0, contCarpa = 0, contCabagna = 0, contHotel = 0;
        Hotel hotel;
        Cabagna cabagna;
        Carpa carpa;

        for(int i=0;i<empresaTurismo.size();i++){

            if(empresaTurismo.get(i) instanceof Carpa){
                contCarpa+=1;
            }else if(empresaTurismo.get(i) instanceof Cabagna){
                contCabagna+=1;
            } else if(empresaTurismo.get(i) instanceof Hotel){
                contHotel+=1;
            }
        }

        mensaje = "\nLa cantidad de Carpas es: " + contCarpa
                + "\nLa cantidad de Cabañas es: " + contCabagna
                + "\nLa cantidad de Hoteles es: " + contHotel + "\n";

        return mensaje;
    }

    public String incrementarValorbase(){
        String mensaje = "";
        Cabagna cabagna;
        int cont = 0;

        for(int i=0;i<empresaTurismo.size();i++){
            if(empresaTurismo.get(i) instanceof Cabagna){
                cabagna = (Cabagna) empresaTurismo.get(i);
                if(cabagna.getCapacidad() > 5){
                    cabagna.setValorBaseNoche(Math.round(cabagna.getValorBaseNoche() * 18/100 + cabagna.getValorBaseNoche()));
                    cont+=1;
                }
            }
        }

        if(cont>0){
            mensaje = "Se incremento el valor base a " + cont + " Cabañas\n";
        }else{
            mensaje = "No se realizó ningún incremento\n";
        }

        return mensaje;
    }
}

