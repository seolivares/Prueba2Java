package modelo;

public abstract class Hospederia extends MedioDeAlojamiento {
    protected boolean esFumador;
    protected int capacidad;

    public Hospederia(DatosCliente datosClientes, int valorBaseNoche, int cantidadNoches, String tipoTemporada, boolean esFumador, int capacidad) {
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

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public abstract int adicional();

}
