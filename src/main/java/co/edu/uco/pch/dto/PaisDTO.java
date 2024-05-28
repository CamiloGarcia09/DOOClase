package co.edu.uco.pch.dto;

import co.edu.uco.pch.crosscutting.helpers.TextHelper;
import co.edu.uco.pch.crosscutting.helpers.UUIDHelper;

import java.util.UUID;

//DTO = Data Transfer Object
public final class PaisDTO {

    private UUID id;
    private String nombre;

    public PaisDTO() {
        super();
        setId(UUIDHelper.getDefault());
        setNombre(TextHelper.EMPTY);
    }

    public PaisDTO(final UUID id, final String nombre) {
        setId(id);
        setNombre(nombre);
    }

    //Build significa crear en español
    public static final PaisDTO build(){
        return new PaisDTO();
    }

    public final UUID getId() {
        return id;
    }

    public final String getNombre() {
        return nombre;
    }

    public final PaisDTO setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
        return this;
    }

    public final PaisDTO setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
        return this;
    }
}
