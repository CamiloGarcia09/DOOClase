package co.edu.uco.pch.business.assembler.entity.impl;

import co.edu.uco.pch.business.assembler.entity.AssemblerEntity;
import co.edu.uco.pch.business.domain.DepartamentoDomain;
import co.edu.uco.pch.business.domain.PaisDomain;
import co.edu.uco.pch.entity.DepartamentoEntity;
import co.edu.uco.pch.entity.PaisEntity;

import java.util.List;


public class DepartamentoAssemblerEntity implements AssemblerEntity<DepartamentoDomain, DepartamentoEntity>{

    private static final AssemblerEntity<PaisDomain, PaisEntity> paisAssembler = PaisAssemblerEntity.getInstance();
    private static final AssemblerEntity<DepartamentoDomain, DepartamentoEntity> instance = new DepartamentoAssemblerEntity();

    private DepartamentoAssemblerEntity(){
        super();
    }

    public static final AssemblerEntity<DepartamentoDomain, DepartamentoEntity> getInstance(){
        return instance;
    }

    @Override
    public DepartamentoDomain toDomain(DepartamentoEntity data) {
        return null;
    }

    @Override
    public List<DepartamentoDomain> toDomainCollection(List<DepartamentoEntity> entityCollection) {
        return List.of();
    }

    @Override
    public DepartamentoEntity toEntity(DepartamentoDomain domain) {
        return null;
    }


}
