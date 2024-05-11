package co.edu.uco.pch.data.dao.entity.concrete.azuresql;

import co.edu.uco.pch.data.dao.entity.DepartamentoDAO;
import co.edu.uco.pch.data.dao.entity.concrete.SqlConnection;
import co.edu.uco.pch.entity.DepartamentoEntity;

import java.sql.Connection;
import java.util.List;

public class DepartamentoAzureSqlDAO extends SqlConnection implements DepartamentoDAO {

    public DepartamentoAzureSqlDAO(Connection conexion) {
        super(conexion);
    }

    @Override
    public List<DepartamentoEntity> consultar(DepartamentoEntity data) {
        return List.of();
    }
}
