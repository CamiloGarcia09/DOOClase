package co.edu.uco.pch.business.assembler.dto.impl;

import co.edu.uco.pch.business.assembler.dto.AssemblerDTO;
import co.edu.uco.pch.business.domain.CiudadDomain;
import co.edu.uco.pch.dto.CiudadDTO;

public class CiudadAssemblerDTO implements AssemblerDTO<CiudadDomain, CiudadDTO> {

    private static final AssemblerDTO<CiudadDomain, CiudadDTO> instance = new CiudadAssemblerDTO();

    private CiudadAssemblerDTO(){
        super();
    }

    public static final AssemblerDTO<CiudadDomain, CiudadDTO> getInstance(){
        return instance;
    }


    @Override
    public CiudadDomain toDomain(CiudadDTO data) {
        return null;
    }

    @Override
    public CiudadDTO toDTO(CiudadDomain domain) {
        return null;
    }
}
