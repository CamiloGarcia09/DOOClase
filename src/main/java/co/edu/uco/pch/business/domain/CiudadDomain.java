package co.edu.uco.pch.business.domain;

import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import co.edu.uco.pch.crosscutting.helpers.TextHelper;
import co.edu.uco.pch.crosscutting.helpers.UUIDHelper;

import java.util.UUID;

public class CiudadDomain {
    private UUID id;
    private String nombre;
    private DepartamentoDomain departamento;


    private CiudadDomain(final UUID id, final String nombre, final DepartamentoDomain departamento) {
        setId(id);
        setNombre(nombre);
        setDepartamento(departamento);
    }

    public static final CiudadDomain build(final UUID id, final String nombre, final DepartamentoDomain departamento){
        return new CiudadDomain(id, nombre, departamento);
    }

    private static final CiudadDomain build(final UUID id){
        return new CiudadDomain(id, TextHelper.EMPTY, DepartamentoDomain.build());
    }

    public static final CiudadDomain build(){
        return new CiudadDomain(UUIDHelper.getDefault(), TextHelper.EMPTY, DepartamentoDomain.build());
    }

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public DepartamentoDomain getDepartamento() {
        return departamento;
    }

    private void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
    }

    private void setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
    }

    private void setDepartamento(final DepartamentoDomain departamento) {
        this.departamento = ObjectHelper.getObjectHelper().getDefaultValue(departamento, DepartamentoDomain.build());
    }
}
