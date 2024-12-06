package controlador;

import modelo.Cabagna;
import modelo.Carpa;
import modelo.Hotel;
import modelo.MedioDeAlojamiento;

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
            //definir una estructura de control
            if(empresaTurismo.get(i) instanceof Carpa){
                carpa = (Carpa) empresaTurismo.get(i);
                mensaje = mensaje + "\nRut cliente: "+ carpa.getDatosClientes().getRut() + "\nNombre cliente: "+ carpa.getDatosClientes().getNombreCliente()
                        + "\nValor: " + carpa.getValorBaseNoche() + "\nNoches: " + carpa.getCantidadNoches()
                        + "\nPersonas: " + carpa.getCantidadPersonas() + "\nTemporada: " + carpa.getTipoTemporada();
            }
        }
        if(mensaje.equalsIgnoreCase("")){
            mensaje = "No hay carpas registradas!!!";
        }
        return mensaje;      //mostrar info
    }
}
