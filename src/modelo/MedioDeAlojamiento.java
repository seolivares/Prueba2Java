package modelo;

public abstract class MedioDeAlojamiento {
    protected DatosCliente datosClientes;
    protected int valorBaseNoche;
    protected int cantidadNoches;
    protected String tipoTemporada;

    public MedioDeAlojamiento(DatosCliente datosClientes, int valorBaseNoche, int cantidadNoches, String tipoTemporada) {
        this.datosClientes = datosClientes;
        this.valorBaseNoche = valorBaseNoche;
        this.cantidadNoches = cantidadNoches;
        this.tipoTemporada = tipoTemporada;
    }

    public DatosCliente getDatosClientes() {
        return datosClientes;
    }

    public void setDatosClientes(DatosCliente datosClientes) {
        this.datosClientes = datosClientes;
    }

    public int getValorBaseNoche() {
        return valorBaseNoche;
    }

    public void setValorBaseNoche(int valorBaseNoche) {
        this.valorBaseNoche = valorBaseNoche;
    }

    public int getCantidadNoches() {
        return cantidadNoches;
    }

    public void setCantidadNoches(int cantidadNoches) {
        this.cantidadNoches = cantidadNoches;
    }

    public String getTipoTemporada() {
        return tipoTemporada;
    }

    public void setTipoTemporada(String tipoTemporada) {
        this.tipoTemporada = tipoTemporada;
    }

}
