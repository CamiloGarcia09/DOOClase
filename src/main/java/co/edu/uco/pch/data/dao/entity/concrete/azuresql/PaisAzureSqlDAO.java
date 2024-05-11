package co.edu.uco.pch.data.dao.entity.concrete.azuresql;

import co.edu.uco.pch.data.dao.entity.PaisDAO;
import co.edu.uco.pch.data.dao.entity.concrete.SqlConnection;
import co.edu.uco.pch.entity.PaisEntity;

import java.sql.Connection;
import java.util.List;

public class PaisAzureSqlDAO extends SqlConnection implements PaisDAO {

    public PaisAzureSqlDAO(Connection conexion) {
        super(conexion);
    }

    @Override
    public List<PaisEntity> consultar(PaisEntity data) {

        return List.of();
    }
}
