package co.edu.uco.pch.crosscutting.exceptions.messagecatalog.impl;

import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.MessageCatalog;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.Mensaje;

public final class MessageCatalogExternalService implements MessageCatalog {


    @Override
    public final void inicializar() {

    }

    @Override
    public final String obtenerCondidoMensaje(final CodigoMensaje codigo, final String... parametros) {
        return "";
    }

    @Override
    public final Mensaje obtenerMensaje(final CodigoMensaje codigo, final String... parametros) {
        return null;
    }
}
