package co.edu.uco.pch.entity;

import co.edu.uco.pch.crosscutting.helpers.TextHelper;

import java.util.UUID;

//DTO = Data Transfer Object
public final class PaisEntity {
    private UUID id;
    private String nombre;

    public PaisEntity() {
        super();
    }

    public PaisEntity(final UUID id, final String nombre) {
        setId(id);
        setNombre(nombre);
    }

    //Build significa crear en español
    public static final PaisEntity build(){
        return new PaisEntity();
    }

    public final UUID getId() {
        return id;
    }

    public final PaisEntity setId(final UUID id) {
        this.id = id;
        return this;
    }

    public final String getNombre() {
        return nombre;
    }

    public final PaisEntity setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
        return this;
    }
}
