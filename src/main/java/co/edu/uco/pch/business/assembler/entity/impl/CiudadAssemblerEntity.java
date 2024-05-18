package co.edu.uco.pch.business.assembler.entity.impl;

import co.edu.uco.pch.business.assembler.entity.AssemblerEntity;
import co.edu.uco.pch.business.domain.CiudadDomain;
import co.edu.uco.pch.entity.CiudadEntity;

public class CiudadAssemblerEntity implements AssemblerEntity<CiudadDomain, CiudadEntity> {

    private static final AssemblerEntity<CiudadDomain, CiudadEntity> instance = new CiudadAssemblerEntity();

    private CiudadAssemblerEntity(){
        super();
    }

    public static final AssemblerEntity<CiudadDomain, CiudadEntity> getInstance(){
        return instance;
    }

    @Override
    public CiudadDomain toDomain(CiudadEntity data) {
        return null;
    }

    @Override
    public CiudadEntity toEntity(CiudadDomain domain) {
        return null;
    }

}
