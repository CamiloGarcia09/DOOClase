package co.edu.uco.pch.business.assembler.dto.impl;

import co.edu.uco.pch.business.assembler.dto.AssemblerDTO;
import co.edu.uco.pch.business.domain.CiudadDomain;
import co.edu.uco.pch.business.domain.PaisDomain;
import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import co.edu.uco.pch.dto.CiudadDTO;
import co.edu.uco.pch.dto.PaisDTO;

import java.util.ArrayList;
import java.util.List;

import static co.edu.uco.pch.crosscutting.helpers.ObjectHelper.getObjectHelper;

public class PaisAssemblerDTO implements AssemblerDTO<PaisDomain, PaisDTO> {

    private static final AssemblerDTO<PaisDomain, PaisDTO> instance = new PaisAssemblerDTO();

    private PaisAssemblerDTO(){
        super();
    }

    public static final AssemblerDTO<PaisDomain, PaisDTO> getInstance(){
        return instance;
    }

    @Override
    public final PaisDomain toDomain(final PaisDTO data) {
        var paisDtoTmp = getObjectHelper().getDefaultValue(data, PaisDTO.build());
        return PaisDomain.build(paisDtoTmp.getId(), paisDtoTmp.getNombre());
    }

    @Override
    public final PaisDTO toDTO(final PaisDomain domain) {
        var paisDomainTmp = getObjectHelper().getDefaultValue(domain, PaisDomain.build());
        return PaisDTO.build().setId(paisDomainTmp.getId()).setNombre(paisDomainTmp.getNombre());
    }

    @Override
    public final List<PaisDomain> toDomainCollection(final List<PaisDTO> entityCollection) {
        return List.of();
    }

    @Override
    public final List<PaisDTO> toDTOCollection(final List<PaisDomain> domainCollection) {
        var domainCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(domainCollection, new ArrayList<PaisDomain>());
        return domainCollectionTmp.stream().map(this::toDTO).toList();
    }
}
