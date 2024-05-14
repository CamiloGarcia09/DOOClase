package co.edu.uco.pch.data.dao.entity.concrete.azuresql;

import co.edu.uco.pch.crosscutting.exceptions.custom.DataPCHException;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.pch.data.dao.entity.CiudadDAO;
import co.edu.uco.pch.data.dao.entity.concrete.SqlConnection;
import co.edu.uco.pch.entity.CiudadEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class CiudadAzureSqlDAO extends SqlConnection implements CiudadDAO {

    public CiudadAzureSqlDAO(final Connection conexion) {
        super(conexion);
    }

    @Override
    public final void crear(final CiudadEntity data) {
        final StringBuilder sentenciaSql = new StringBuilder();

        sentenciaSql.append("INSERT INTO Ciudad (id, nombre, departamento) ");
        sentenciaSql.append("SELECT ?,?,?");

        try(final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {

            sentenciaSqlPreparada.setObject(1, data.getId());
            sentenciaSqlPreparada.setString(2, data.getNombre());
            sentenciaSqlPreparada.setObject(3, data.getId());

            sentenciaSqlPreparada.executeUpdate();

        //Tarea no quemar los mensajes, agregarlos al catalogo de mensajes, para usar el sistema
            // de mensajeria que ya creamos en clases pasadas
        }catch (final SQLException exception){
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00024);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00025);
            throw new DataPCHException(mensajeTecnico, mensajeUsuario, exception);

        }catch (final Exception exception){
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00026);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00027);
            throw new DataPCHException(mensajeTecnico, mensajeUsuario, exception);
        }
    }

    @Override
    public void eliminar(UUID id) {

    }

    @Override
    public List<CiudadEntity> consultar(CiudadEntity data) {
        return List.of();
    }

    @Override
    public void modificar(CiudadEntity data) {

    }
}
