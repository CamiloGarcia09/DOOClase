package co.edu.uco.pch.business.assembler.dto.impl;

import co.edu.uco.pch.business.assembler.dto.AssemblerDTO;
import co.edu.uco.pch.business.domain.CiudadDomain;
import co.edu.uco.pch.business.domain.DepartamentoDomain;
import co.edu.uco.pch.business.domain.PaisDomain;
import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import co.edu.uco.pch.dto.CiudadDTO;
import co.edu.uco.pch.dto.DepartamentoDTO;
import co.edu.uco.pch.dto.PaisDTO;

import java.util.ArrayList;
import java.util.List;

import static co.edu.uco.pch.crosscutting.helpers.ObjectHelper.getObjectHelper;

public class DepartamentoAssemblerDTO implements AssemblerDTO<DepartamentoDomain, DepartamentoDTO> {

    private static final AssemblerDTO<PaisDomain, PaisDTO> paisAssembler = PaisAssemblerDTO.getInstance();
    private static final AssemblerDTO<DepartamentoDomain, DepartamentoDTO> instance = new DepartamentoAssemblerDTO();

    private DepartamentoAssemblerDTO(){
        super();
    }

    public static final AssemblerDTO<DepartamentoDomain, DepartamentoDTO> getInstance(){
        return instance;
    }

    @Override
    public final DepartamentoDomain toDomain(final DepartamentoDTO data) {
        var departamentoDtoTmp = getObjectHelper().getDefaultValue(data, DepartamentoDTO.build());
        var paisDomain = paisAssembler.toDomain(departamentoDtoTmp.getPais());
        return DepartamentoDomain.build(departamentoDtoTmp.getId(), departamentoDtoTmp.getNombre(), paisDomain );
    }

    @Override
    public final DepartamentoDTO toDTO(final DepartamentoDomain domain) {
        var departamentoDomainTmp = getObjectHelper().getDefaultValue(domain, DepartamentoDomain.build());
        var paisDTO = paisAssembler.toDTO(departamentoDomainTmp.getPais());
        return DepartamentoDTO.build().setId(departamentoDomainTmp.getId()).setNombre(departamentoDomainTmp.
                getNombre()).setPais(paisDTO);
    }

    @Override
    public final List<DepartamentoDomain> toDomainCollection(final List<DepartamentoDTO> entityCollection) {
        return List.of();
    }

    @Override
    public final List<DepartamentoDTO> toDTOCollection(final List<DepartamentoDomain> domainCollection) {
        var domainCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(domainCollection, new ArrayList<DepartamentoDomain>());
        return domainCollectionTmp.stream().map(this::toDTO).toList();
    }
}
