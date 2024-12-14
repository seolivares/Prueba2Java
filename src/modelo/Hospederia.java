package modelo;

public abstract class Hospederia extends MedioDeAlojamiento {
    protected boolean esFumador;
    protected String capacidad;

    public Hospederia(DatosCliente datosClientes, int valorBaseNoche, int cantidadNoches, String tipoTemporada, boolean esFumador, String capacidad) {
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

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }
}
