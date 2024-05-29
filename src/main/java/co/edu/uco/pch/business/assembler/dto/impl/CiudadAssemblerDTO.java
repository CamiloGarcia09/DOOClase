package co.edu.uco.pch.business.assembler.dto.impl;

import static co.edu.uco.pch.crosscutting.helpers.ObjectHelper.getObjectHelper;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.pch.business.assembler.dto.AssemblerDTO;
import co.edu.uco.pch.business.domain.CiudadDomain;
import co.edu.uco.pch.business.domain.DepartamentoDomain;
import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import co.edu.uco.pch.dto.CiudadDTO;
import co.edu.uco.pch.dto.DepartamentoDTO;

public class CiudadAssemblerDTO implements AssemblerDTO<CiudadDomain, CiudadDTO> {

    private static final AssemblerDTO<DepartamentoDomain, DepartamentoDTO> departamentoAssembler = DepartamentoAssemblerDTO.getInstance();
    private static final AssemblerDTO<CiudadDomain, CiudadDTO> instance = new CiudadAssemblerDTO();


    private CiudadAssemblerDTO() {
        super();
    }

    public static final AssemblerDTO<CiudadDomain, CiudadDTO> getInstance(){
        return instance;
    }

    @Override
    public final CiudadDomain toDomain(final CiudadDTO data) {
        var ciudadDTOTmp = getObjectHelper().getDefaultValue(data, CiudadDTO.build());
        var departamentoDomain = departamentoAssembler.toDomain(ciudadDTOTmp.getDepartamento());
        return CiudadDomain.build(ciudadDTOTmp.getId(),ciudadDTOTmp.getNombre(),departamentoDomain);
    }

    @Override
    public final CiudadDTO toDTO(final CiudadDomain domain) {
        var ciudadDomainTmp = getObjectHelper().getDefaultValue(domain, CiudadDomain.build());
        var departamentoDTO = departamentoAssembler.toDTO(ciudadDomainTmp.getDepartamento());
        return CiudadDTO.build().setId(ciudadDomainTmp.getId()).setNombre(ciudadDomainTmp.getNombre()).setDepartamento(departamentoDTO);
    }

    @Override
    public final List<CiudadDomain> toDomainCollection(final List<CiudadDTO> dtoCollection) {
        var dtoCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(dtoCollection, new ArrayList<CiudadDTO>());

        var resultadosDomain = new ArrayList<CiudadDomain>();

        for (CiudadDTO ciudadDto : dtoCollectionTmp) {
            var ciudadDomainTmp = toDomain(ciudadDto);
            resultadosDomain.add(ciudadDomainTmp);
        }
        return resultadosDomain;
    }

    @Override
    public final List<CiudadDTO> toDTOCollection(final List<CiudadDomain> domainCollection) {
        var domainCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(domainCollection, new ArrayList<CiudadDomain>());
        return domainCollectionTmp.stream().map(this::toDTO).toList();
    }
}