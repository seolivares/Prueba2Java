package modelo;

import controlador.EmpresaTurismo;

public class Cabagna extends Hospederia {
    protected boolean chimenea;

    public Cabagna(DatosCliente datosClientes, int valorBaseNoche, int cantidadNoches, String tipoTemporada, boolean esFumador, int capacidad, boolean chimenea) {
        super(datosClientes, valorBaseNoche, cantidadNoches, tipoTemporada, esFumador, capacidad);
        this.chimenea = chimenea;
    }

    public boolean isChimenea() {
        return chimenea;
    }

    public void setChimenea(boolean chimenea) {
        this.chimenea = chimenea;
    }

    public int adicional(){
        int adicional = 0;
        EmpresaTurismo empresaTurismo;

        if (this.esFumador == true ) {
            adicional = Math.round((this.valorBaseNoche * this.cantidadNoches)*30/100);
        }

        return adicional;
    }

}