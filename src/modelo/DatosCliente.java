package modelo;

public class DatosCliente {
    private String nombreCliente;
    private String rut;

    public DatosCliente(String nombreCliente, String rut) {
        this.nombreCliente = nombreCliente;
        this.rut = rut;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
}
