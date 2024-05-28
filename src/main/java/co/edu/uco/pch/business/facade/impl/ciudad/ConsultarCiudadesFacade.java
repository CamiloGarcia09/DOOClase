package co.edu.uco.pch.business.facade.impl.ciudad;

import co.edu.uco.pch.business.assembler.dto.impl.CiudadAssemblerDTO;
import co.edu.uco.pch.business.facade.FacadaWithReturn;
import co.edu.uco.pch.business.usecase.impl.ciudad.ConsultarCiudades;
import co.edu.uco.pch.crosscutting.exceptions.PCHException;
import co.edu.uco.pch.crosscutting.exceptions.custom.BusinessPCHException;
import co.edu.uco.pch.data.dao.factory.DAOFactory;
import co.edu.uco.pch.dto.CiudadDTO;

import java.util.List;
public final class ConsultarCiudadesFacade implements FacadaWithReturn<CiudadDTO, List<CiudadDTO>> {

    private DAOFactory daoFactory;

    public ConsultarCiudadesFacade() {
        daoFactory = DAOFactory.getFactory();
    }

    @Override
    public List<CiudadDTO> execute(final CiudadDTO dto) {

        try {
            var usecase = new ConsultarCiudades(daoFactory);
            var ciudadDomain = CiudadAssemblerDTO.getInstance().toDomain(dto);
            var resultadosDomain = usecase.execute(ciudadDomain);
            return CiudadAssemblerDTO.getInstance().toDTOCollection(resultadosDomain);

        } catch (final PCHException exception) {
            throw exception;
        } catch (final Exception exception) {

            var mensajeUsuario = "Se ha presentado un problema consultar la informacion de las ciudad";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de consultar la ciudad";

            throw new BusinessPCHException(mensajeTecnico, mensajeUsuario, exception);

        } finally {
            daoFactory.cerrarConexion();
        }
    }

}
