package modelo;

import controlador.EmpresaTurismo;

public class Hotel extends Hospederia {
    private boolean conDesayuno;

    public Hotel(DatosCliente datosClientes, int valorBaseNoche, int cantidadNoches, String tipoTemporada, boolean esFumador, int capacidad, boolean conDesayuno) {
        super(datosClientes, valorBaseNoche, cantidadNoches, tipoTemporada, esFumador, capacidad);
        this.conDesayuno = conDesayuno;
    }

    public boolean isConDesayuno() {
        return conDesayuno;
    }

    public void setConDesayuno(boolean conDesayuno) {
        this.conDesayuno = conDesayuno;
    }

    public int adicional(){
        int adicional = 0;
        //EmpresaTurismo empresaTurismo = null;

        if (this.esFumador == true && this.conDesayuno == true) {
            adicional = Math.round(this.valorBaseNoche * this.cantidadNoches*30/100);
        }

        return adicional;
    }

}
