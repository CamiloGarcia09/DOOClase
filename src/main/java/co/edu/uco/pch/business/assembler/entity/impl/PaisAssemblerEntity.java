package co.edu.uco.pch.business.assembler.entity.impl;

import co.edu.uco.pch.business.assembler.entity.AssemblerEntity;
import co.edu.uco.pch.business.domain.PaisDomain;
import co.edu.uco.pch.entity.PaisEntity;

import java.util.List;

public class PaisAssemblerEntity implements AssemblerEntity<PaisDomain, PaisEntity> {

    private static final AssemblerEntity<PaisDomain, PaisEntity> instance = new PaisAssemblerEntity();

    private PaisAssemblerEntity(){
        super();
    }

    public static final AssemblerEntity<PaisDomain, PaisEntity> getInstance(){
        return instance;
    }

    @Override
    public final PaisDomain toDomain(PaisEntity data) {
        return null;
    }

    @Override
    public List<PaisDomain> toDomainCollection(List<PaisEntity> entityCollection) {
        return List.of();
    }

    @Override
    public final PaisEntity toEntity(PaisDomain domain) {
        return null;
    }

}
