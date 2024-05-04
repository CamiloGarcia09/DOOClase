package co.edu.uco.pch.dto;

import co.edu.uco.pch.crosscutting.helpers.TextHelper;
import java.util.UUID;

//DTO = Data Transfer Object
public final class PaisDTO {
    private UUID id;
    private String nombre;

    public PaisDTO() {
        super();
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

    public final PaisDTO setId(final UUID id) {
        this.id = id;
        return this;
    }

    public final String getNombre() {
        return nombre;
    }

    public final PaisDTO setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
        return this;
    }
}
