package co.edu.uco.pch.business.assembler.entity;

import co.edu.uco.pch.business.assembler.Assembler;

import java.util.List;

public interface AssemblerEntity<D, K> extends Assembler<D, K> {

   K toEntity(D domain);

   List<K> toEntityCollection(List<D> domainCollection);

}
