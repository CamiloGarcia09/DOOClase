package co.edu.uco.pch.controller.response;

import co.edu.uco.pch.dto.CiudadDTO;

import java.util.ArrayList;

public class CiudadResponse extends Response <CiudadDTO> {
    public CiudadResponse(){
        setMensajes(new ArrayList<>());
        setDatos(new ArrayList<>());
    }

}
