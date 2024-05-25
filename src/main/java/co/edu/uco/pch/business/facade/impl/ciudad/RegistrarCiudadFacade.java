package co.edu.uco.pch.business.facade.impl.ciudad;

import co.edu.uco.pch.business.assembler.dto.impl.CiudadAssemblerDTO;
import co.edu.uco.pch.business.facade.FacadaWithoutReturn;
import co.edu.uco.pch.business.usecase.impl.ciudad.RegistrarCiudad;
import co.edu.uco.pch.crosscutting.exceptions.PCHException;
import co.edu.uco.pch.crosscutting.exceptions.custom.BusinessPCHException;
import co.edu.uco.pch.data.dao.factory.DAOFactory;
import co.edu.uco.pch.dto.CiudadDTO;

public final class RegistrarCiudadFacade implements FacadaWithoutReturn <CiudadDTO> {

    private DAOFactory daoFactory;

    public RegistrarCiudadFacade (){
        daoFactory = DAOFactory.getFactory();
    }

    @Override
    public void execute(CiudadDTO dto) {
        daoFactory.iniciarTransaccion();
        try{

            var useCase = new RegistrarCiudad(daoFactory);
            var ciudadDomain = CiudadAssemblerDTO.getInstance().toDomain(dto);
            useCase.execute(ciudadDomain);

            daoFactory.confirmarTransaccion();
        }catch (final PCHException exception){
            daoFactory.cancelarTransaccion();
            throw exception;
        }catch (final Exception exception){
            daoFactory.cancelarTransaccion();

            var mensajeUsuario = "Se ha presentado un porblema tratando de registarr la infomacion de la ciudad";
            var mensajeTecnico = "Se ha presentado un porblema inesperado tratando de registrar la informacion de las ciudadees";

            throw new BusinessPCHException(mensajeTecnico, mensajeUsuario, exception);
        }finally {
            daoFactory.cerrarConexion();
        }
    }
}
