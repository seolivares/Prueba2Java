package modelo;

public class Carpa extends MedioDeAlojamiento{
    private int cantidadPersonas;

    public Carpa(DatosCliente datosClientes, int valorBaseNoche, int cantidadNoches, String tipoTemporada, int cantidadPersonas) {
        super(datosClientes, valorBaseNoche, cantidadNoches, tipoTemporada);
        this.cantidadPersonas = cantidadPersonas;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }


}
