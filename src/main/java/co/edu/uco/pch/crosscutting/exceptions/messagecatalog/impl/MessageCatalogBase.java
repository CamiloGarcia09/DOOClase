package co.edu.uco.pch.crosscutting.exceptions.messagecatalog.impl;

import co.edu.uco.pch.crosscutting.exceptions.custom.CrosscuttingPCHException;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.MessageCatalog;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.Mensaje;
import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;

import java.util.HashMap;
import java.util.Map;

public final class MessageCatalogBase implements MessageCatalog {

    private final Map<String, Mensaje> mensajes = new HashMap<>();

    @Override
    public final void inicializar() {
        mensajes.clear();
        mensajes.put(CodigoMensaje.M00001.getIdentificador(), new Mensaje(CodigoMensaje.M00001,
                "El código del mensaje que quiere obtener del catálogo mensajes llegó nulo..."));
        mensajes.put(CodigoMensaje.M00002.getIdentificador(), new Mensaje(CodigoMensaje.M00002,
                "Se ha presentado un problema tratando de llevar a cabo la operación deseada..."));
        mensajes.put(CodigoMensaje.M00003.getIdentificador(), new Mensaje(CodigoMensaje.M00003,
                "El identificador del mensaje \"${1}\" que se intentó obtener, no está en el catálogo de mensajes base..."));
        mensajes.put(CodigoMensaje.M00004.getIdentificador(), new Mensaje(CodigoMensaje.M00004,
                "El mensaje con identificador \"${1}\" que se intentó obtener, no está configurado para residir en el catálogo de mensajes base..."));
        mensajes.put(CodigoMensaje.M00005.getIdentificador(), new Mensaje(CodigoMensaje.M00005,
                "El mensaje con identificador \"${1}\" que se intentó obtener, no está configurado para residir en el catálogo de mensajes externo..."));
        mensajes.put(CodigoMensaje.M00006.getIdentificador(), new Mensaje(CodigoMensaje.M00006,
                "El identificador del mensaje \"${1}\" que se intentó obtener, no está en el catálogo de mensajes externo..."));

        mensajes.put(CodigoMensaje.M00007.getIdentificador(), new Mensaje(CodigoMensaje.M00007,
                "Se ha presentado un problema tratando de validar si la conexión SQL con la fuente de información deseada estaba cerrada..."));
        mensajes.put(CodigoMensaje.M00008.getIdentificador(), new Mensaje(CodigoMensaje.M00008,
                "Se ha presentado un problema INESPERADO tratando de validar si la conexión SQL con la fuente de información deseada estaba cerrada..."));
        mensajes.put(CodigoMensaje.M00009.getIdentificador(), new Mensaje(CodigoMensaje.M00009,
                "Se ha intentado realizar el cierre de una conexión SQL que ya estaba cerrada..."));
        mensajes.put(CodigoMensaje.M00010.getIdentificador(), new Mensaje(CodigoMensaje.M00010,
                "Se ha presentado un problema tratando de cerrar la conexión SQL con la fuente de información deseada..."));
        mensajes.put(CodigoMensaje.M00011.getIdentificador(), new Mensaje(CodigoMensaje.M00011,
                "Se ha presentado un problema INESPERADO tratando de cerrar la conexión SQL con la fuente de información deseada..."));
        mensajes.put(CodigoMensaje.M00012.getIdentificador(), new Mensaje(CodigoMensaje.M00012,
                "Se ha intentado confirmar una transacción con una conexión SQL cerrada..."));
        mensajes.put(CodigoMensaje.M00013.getIdentificador(), new Mensaje(CodigoMensaje.M00013,
                "Se ha intentado confirmar una transacción cuando el autocommit de la conexión con la base de datos estaba activado..."));
        mensajes.put(CodigoMensaje.M00014.getIdentificador(), new Mensaje(CodigoMensaje.M00014,
                "Se ha presentado un problema tratando de confirmar una transacción SQL con la fuente de información deseada..."));
        mensajes.put(CodigoMensaje.M00015.getIdentificador(), new Mensaje(CodigoMensaje.M00015,
                "Se ha presentado un problema INESPERADO tratando de confirmar una transacción SQL con la fuente de información deseada..."));
        mensajes.put(CodigoMensaje.M00016.getIdentificador(), new Mensaje(CodigoMensaje.M00016,
                "Se ha intentado cancelar una transacción con una conexión SQL cerrada..."));
        mensajes.put(CodigoMensaje.M00017.getIdentificador(), new Mensaje(CodigoMensaje.M00017,
                "Se ha intentado cancelar una transacción cuando el autocommit de la conexión con la base de datos estaba activado..."));
        mensajes.put(CodigoMensaje.M00018.getIdentificador(), new Mensaje(CodigoMensaje.M00018,
                "Se ha presentado un problema tratando de cancelar una transacción SQL con la fuente de información deseada..."));
        mensajes.put(CodigoMensaje.M00019.getIdentificador(), new Mensaje(CodigoMensaje.M00019,
                "Se ha presentado un problema INESPERADO tratando de cancelar una transacción SQL con la fuente de información deseada..."));

        mensajes.put(CodigoMensaje.M00020.getIdentificador(), new Mensaje(CodigoMensaje.M00020,
                "Se ha intentado iniciar una transacción con una conexión SQL cerrada..."));
        mensajes.put(CodigoMensaje.M00021.getIdentificador(), new Mensaje(CodigoMensaje.M00021,
                "Se ha presentado un problema tratando de iniciar una transacción SQL con la fuente de información deseada..."));
        mensajes.put(CodigoMensaje.M00022.getIdentificador(), new Mensaje(CodigoMensaje.M00022,
                "Se ha presentado un problema INESPERADO tratando de iniciar una transacción SQL con la fuente de información deseada..."));

        //Mensajes creados por mi, no estoy seguro como si se implementa aqui o en el External
        mensajes.put(CodigoMensaje.M00023.getIdentificador(), new Mensaje(CodigoMensaje.M00023,
                "No es posible crear el DAO deseado con una conexion cerrada"));
        mensajes.put(CodigoMensaje.M00024.getIdentificador(), new Mensaje(CodigoMensaje.M00024,
                "Se ha presentado un problema tratando de crear la ciudad \"${1}\" por favor intente de nuevo y si el problema persiste contacte al administrador"));
        mensajes.put(CodigoMensaje.M00025.getIdentificador(), new Mensaje(CodigoMensaje.M00025,
                "Se ha presentado una excepcion de tipo SQLException tratando de realizar el insert de la ciudad \"${1}\" en la tabla \"Pais\" " +
                        "de la base de datos Azure SQL. Para mas detalles revise de forma completa la excepcion raiz presentada... "));
        mensajes.put(CodigoMensaje.M00026.getIdentificador(), new Mensaje(CodigoMensaje.M00026,
                "Se ha presentado un problema tratando de crear la ciudad \"${1}\" por favor intente de nuevo y si el problema persiste contacte al administrador"));
        mensajes.put(CodigoMensaje.M00027.getIdentificador(), new Mensaje(CodigoMensaje.M00027,
                "Se ha presentado un problema inesperado con una excepcion de tipo Exception " ));
    }

    @Override
    public final String obtenerCondidoMensaje(final CodigoMensaje codigo, final String... parametros) {
        return obtenerMensaje(codigo, parametros). getContenido();
    }
// Se ha registro el pais ... String permite ser dinamico, por ejemplo: Se
// ha registro del el pais colombia {1} de forma exitosa
    @Override
    public final Mensaje obtenerMensaje(final CodigoMensaje codigo, final String... parametros) {

        if (ObjectHelper.getObjectHelper().isNull(codigo)){
            var mensajeUsuario = obtenerCondidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = obtenerCondidoMensaje(CodigoMensaje.M00001, codigo.getIdentificador());
            throw new CrosscuttingPCHException(mensajeTecnico, mensajeUsuario);
        }
        if (!codigo.isBase()){
            var mensajeUsuario = obtenerCondidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = obtenerCondidoMensaje(CodigoMensaje.M00004, codigo.getIdentificador());
            throw new CrosscuttingPCHException(mensajeTecnico, mensajeUsuario);
        }
        if (!mensajes.containsKey(codigo.getIdentificador())){
            var mensajeUsuario = obtenerCondidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = obtenerCondidoMensaje(CodigoMensaje.M00003, codigo.getIdentificador());
            throw new CrosscuttingPCHException(mensajeTecnico, mensajeUsuario);
        }

        //Tarea: asegure que si tiene parametros el contenido del mensaje, se retorne con los parametros reeemplazados
        // {1},{2},{3}

        //Lo hace TextHelper, tiene una libreria String format
        return mensajes.get(codigo.getIdentificador());
    }
}
