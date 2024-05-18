package co.edu.uco.pch.business.assembler.dto.impl;

import co.edu.uco.pch.business.assembler.dto.AssemblerDTO;
import co.edu.uco.pch.business.domain.DepartamentoDomain;
import co.edu.uco.pch.business.domain.PaisDomain;
import co.edu.uco.pch.dto.DepartamentoDTO;
import co.edu.uco.pch.dto.PaisDTO;

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
    public DepartamentoDomain toDomain(DepartamentoDTO data) {
        var departamentoDtoTmp = getObjectHelper().getDefaultValue(data, DepartamentoDTO.build());
        var paisDomain = paisAssembler.toDomain(departamentoDtoTmp.getPais());
        return DepartamentoDomain.build(departamentoDtoTmp.getId(), departamentoDtoTmp.getNombre(), paisDomain );
    }

    @Override
    public DepartamentoDTO toDTO(DepartamentoDomain domain) {
        var departamentoDomainTmp = getObjectHelper().getDefaultValue(domain, DepartamentoDomain.build());
        var paisDTO = paisAssembler.toDTO(departamentoDomainTmp.getPais());
        return DepartamentoDTO.build().setId(departamentoDomainTmp.getId()).setNombre(departamentoDomainTmp.getNombre());
    }


}
