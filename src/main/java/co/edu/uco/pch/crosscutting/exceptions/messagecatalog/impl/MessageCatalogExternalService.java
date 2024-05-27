package co.edu.uco.pch.crosscutting.exceptions.messagecatalog.impl;

import co.edu.uco.pch.crosscutting.exceptions.custom.CrosscuttingPCHException;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.MessageCatalog;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.Mensaje;
import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;

import java.util.HashMap;
import java.util.Map;

public final class MessageCatalogExternalService implements MessageCatalog {

    private final Map<String, Mensaje> mensajes = new HashMap<>();

    @Override
    public final void inicializar() {

    }

    @Override
    public final String obtenerCondidoMensaje(final CodigoMensaje codigo, final String... parametros) {
        return obtenerMensaje(codigo, parametros).getContenido();
    }

    @Override
    public final Mensaje obtenerMensaje(final CodigoMensaje codigo, final String... parametros) {

        if (ObjectHelper.getObjectHelper().isNull(codigo)) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00001);
            throw new CrosscuttingPCHException(mensajeTecnico, mensajeUsuario);
        }

        if (codigo.isBase()) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00005, codigo.getIdentificador());
            throw new CrosscuttingPCHException(mensajeTecnico, mensajeUsuario);
        }

        if (!mensajes.containsKey(codigo.getIdentificador())) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00006, codigo.getIdentificador());
            throw new CrosscuttingPCHException(mensajeTecnico, mensajeUsuario);
        }

        return mensajes.get(codigo.getIdentificador());
    }

}

