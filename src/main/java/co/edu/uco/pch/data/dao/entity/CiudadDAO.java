package co.edu.uco.pch.data.dao.entity;

import co.edu.uco.pch.entity.CiudadEntity;

import java.util.UUID;

public interface CiudadDAO extends CreateDAO<CiudadEntity>, RetrieveDAO<CiudadEntity>,
        UpdateDAO<CiudadEntity>, DeleteDAO<UUID>{


}