package co.edu.uco.pch.dto;

import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import co.edu.uco.pch.crosscutting.helpers.TextHelper;
import co.edu.uco.pch.crosscutting.helpers.UUIDHelper;
import co.edu.uco.pch.entity.PaisEntity;

import java.util.UUID;

//DTO = Data Transfer Object
public final class DepartamentoDTO {
    private UUID id;
    private String nombre;
    private PaisDTO pais;

    public DepartamentoDTO() {
        super();
        setId(UUIDHelper.getDefault());
        setNombre(TextHelper.EMPTY);
        setPais(PaisDTO.build());

    }

    public DepartamentoDTO(final UUID id, final String nombre, final PaisDTO pais) {
        setId(id);
        setNombre(nombre);
        setPais(pais);
    }

    //Build significa crear en español
    public static final DepartamentoDTO build (){
        return new DepartamentoDTO();
    }

    public final UUID getId() {
        return id;
    }

    public final String getNombre() {
        return nombre;
    }

    public final PaisDTO getPais() {
        return pais;
    }

    public final DepartamentoDTO setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
        return this;
    }

    public final DepartamentoDTO setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
        return this;
    }

    public DepartamentoDTO setPais (final PaisDTO pais) {
        this.pais = ObjectHelper.getObjectHelper().getDefaultValue(pais, new PaisDTO());
        return this;
    }
}
