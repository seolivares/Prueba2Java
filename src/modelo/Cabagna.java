package modelo;

public class Cabagna extends Hospederia {
    protected boolean chimenea;

    public Cabagna(DatosCliente datosClientes, int valorBaseNoche, int cantidadNoches, String tipoTemporada, boolean esFumador, boolean capacidad, boolean chimenea) {
        super(datosClientes, valorBaseNoche, cantidadNoches, tipoTemporada, esFumador, capacidad);
        this.chimenea = chimenea;
    }

    public boolean isChimenea() {
        return chimenea;
    }

    public void setChimenea(boolean chimenea) {
        this.chimenea = chimenea;
    }
}