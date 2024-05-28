package co.edu.uco.pch.business.assembler.entity.impl;

import co.edu.uco.pch.business.assembler.entity.AssemblerEntity;
import co.edu.uco.pch.business.domain.DepartamentoDomain;
import co.edu.uco.pch.business.domain.PaisDomain;
import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import co.edu.uco.pch.entity.DepartamentoEntity;
import co.edu.uco.pch.entity.PaisEntity;

import java.util.List;


public class DepartamentoAssemblerEntity implements AssemblerEntity<DepartamentoDomain, DepartamentoEntity> {

    private static final AssemblerEntity<PaisDomain, PaisEntity> paisAssembler = PaisAssemblerEntity.getInstance();
    private static final AssemblerEntity<DepartamentoDomain, DepartamentoEntity> instance = new DepartamentoAssemblerEntity();

    private DepartamentoAssemblerEntity() {
        super();
    }

    public static final AssemblerEntity<DepartamentoDomain, DepartamentoEntity> getInstance() {
        return instance;
    }

    @Override
    public final DepartamentoDomain toDomain(final DepartamentoEntity data) {
        var departamentoEntityTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, DepartamentoEntity.build());
        var paisDomain = paisAssembler.toDomain(departamentoEntityTmp.getPais());
        return DepartamentoDomain.build(departamentoEntityTmp.getId(), departamentoEntityTmp.getNombre(), paisDomain);
    }

    @Override
    public final DepartamentoEntity toEntity(final DepartamentoDomain domain) {
        var departamentoDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, DepartamentoDomain.build());
        var paisEntity = paisAssembler.toEntity(departamentoDomainTmp.getPais());
        return DepartamentoEntity.build().setId(departamentoDomainTmp.getId())
                .setNombre(departamentoDomainTmp.getNombre()).setPais(paisEntity);
    }

    @Override
    public List<DepartamentoDomain> toDomainCollection(List<DepartamentoEntity> entityCollection) {
        return null;
    }
}
