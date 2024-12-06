package modelo;

public abstract class Hospederia extends MedioDeAlojamiento {
    protected boolean esFumador;
    protected boolean capacidad;

    public Hospederia(DatosCliente datosClientes, int valorBaseNoche, int cantidadNoches, String tipoTemporada, boolean esFumador, boolean capacidad) {
        super(datosClientes, valorBaseNoche, cantidadNoches, tipoTemporada);
        this.esFumador = esFumador;
        this.capacidad = capacidad;
    }

    public boolean isEsFumador() {
        return esFumador;
    }

    public void setEsFumador(boolean esFumador) {
        this.esFumador = esFumador;
    }

    public boolean isCapacidad() {
        return capacidad;
    }

    public void setCapacidad(boolean capacidad) {
        this.capacidad = capacidad;
    }
}
