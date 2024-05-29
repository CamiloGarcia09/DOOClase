package co.edu.uco.pch.business.domain;

import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import co.edu.uco.pch.crosscutting.helpers.TextHelper;
import co.edu.uco.pch.crosscutting.helpers.UUIDHelper;

import java.util.UUID;

public class DepartamentoDomain {
    private UUID id;
    private String nombre;
    private PaisDomain pais;

    private DepartamentoDomain(final UUID id, final String nombre, final PaisDomain pais) {
        setId(id);
        setNombre(nombre);
        setPais(pais);
    }

    public static final DepartamentoDomain build (final UUID id, final String nombre, final PaisDomain pais){
        return new DepartamentoDomain(id, nombre, pais);
    }

    public static final DepartamentoDomain build (final UUID id){
        return new DepartamentoDomain(id, TextHelper.EMPTY, PaisDomain.build());
    }

    public static final DepartamentoDomain build(){
        return new DepartamentoDomain(UUIDHelper.getDefault(), TextHelper.EMPTY, PaisDomain.build());
    }

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public PaisDomain getPais() {
        return pais;
    }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
    }

    private void setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
    }

    private void setPais(final PaisDomain pais) {
        this.pais = ObjectHelper.getObjectHelper().getDefaultValue(pais, PaisDomain.build());
    }
}
