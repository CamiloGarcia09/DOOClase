package co.edu.uco.pch.business.assembler.entity.impl;

import co.edu.uco.pch.business.assembler.entity.AssemblerEntity;
import co.edu.uco.pch.business.domain.DepartamentoDomain;
import co.edu.uco.pch.business.domain.PaisDomain;
import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import co.edu.uco.pch.entity.DepartamentoEntity;
import co.edu.uco.pch.entity.PaisEntity;

import java.util.ArrayList;
import java.util.List;

public class PaisAssemblerEntity implements AssemblerEntity<PaisDomain, PaisEntity>{

    private static final AssemblerEntity<PaisDomain, PaisEntity> instance = new PaisAssemblerEntity();

    private PaisAssemblerEntity() {
        super();
    }

    public static final AssemblerEntity<PaisDomain, PaisEntity> getInstance() {
        return instance;
    }

    @Override
    public final PaisDomain toDomain(final PaisEntity data) {
        var paisEntityTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, PaisEntity.build());
        return PaisDomain.build(paisEntityTmp.getId(), paisEntityTmp.getNombre());
    }

    @Override
    public final PaisEntity toEntity(final PaisDomain domain) {
        var paisDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, PaisDomain.build());
        return PaisEntity.build().setId(paisDomainTmp.getId()).setNombre(paisDomainTmp.getNombre());
    }

    @Override
    public final  List<PaisDomain> toDomainCollection(final List<PaisEntity> entityCollection) {
        var entityCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(entityCollection, new ArrayList<PaisEntity>());

        var resultadosDomain = new ArrayList<PaisDomain>();

        for (PaisEntity paisEntity : entityCollectionTmp) {
            var paisDomainTmp = toDomain(paisEntity);
            resultadosDomain.add(paisDomainTmp);
        }
        return resultadosDomain;
    }

    @Override
    public final List<PaisEntity> toEntityCollection(final List<PaisDomain> domainCollection) {
        var domainCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(domainCollection, new ArrayList<PaisDomain>());
        return domainCollectionTmp.stream().map(this::toEntity).toList();
    }
}
