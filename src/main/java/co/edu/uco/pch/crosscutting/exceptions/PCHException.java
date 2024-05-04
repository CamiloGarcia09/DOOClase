package co.edu.uco.pch.crosscutting.exceptions;

import co.edu.uco.pch.crosscutting.exceptions.enums.Lugar;
import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import co.edu.uco.pch.crosscutting.helpers.TextHelper;

public class PCHException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    protected String mensajeUsuario;
    protected Lugar lugar;

    public PCHException(final String mensajeTecnico, final String mensajeUsuario, final Lugar lugar, final Throwable excepcionRaiz) {
        super(mensajeTecnico, excepcionRaiz);
        setMensajeUsuario(mensajeUsuario);
        setLugar(lugar);
    }

    public PCHException(final String mensajeTecnico, final String mensajeUsuario, final Lugar lugar) {
        super(mensajeTecnico);
        setMensajeUsuario(mensajeUsuario);
        setLugar(lugar);
    }

    public PCHException(final String mensajeUsuario, final Lugar lugar) {
        super(mensajeUsuario);
        setMensajeUsuario(mensajeUsuario);
        setLugar(lugar);
    }

    private final void setMensajeUsuario(final String mensajeUsuario) {
        this.mensajeUsuario = TextHelper.applyTrim(mensajeUsuario);
    }

    private final void setLugar(final Lugar lugar) {
        this.lugar = ObjectHelper.getObjectHelper().getDefaultValue(lugar, Lugar.DEFAULT);
    }

    public String getMensajeUsuario() {
        return mensajeUsuario;
    }

    public Lugar getLugar() {
        return lugar;
    }
}
