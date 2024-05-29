package co.edu.uco.pch.business.usecase.impl.ciudad;

import co.edu.uco.pch.business.assembler.entity.impl.DepartamentoAssemblerEntity;
import co.edu.uco.pch.business.domain.CiudadDomain;
import co.edu.uco.pch.business.usecase.UseCaseWithoutReturn;
import co.edu.uco.pch.crosscutting.exceptions.custom.BusinessPCHException;
import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import co.edu.uco.pch.crosscutting.helpers.UUIDHelper;
import co.edu.uco.pch.data.dao.factory.DAOFactory;
import co.edu.uco.pch.entity.CiudadEntity;

import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

public final class RegistrarCiudad implements UseCaseWithoutReturn<CiudadDomain> {

    private final DAOFactory factory;
    private static final Pattern NOMBRE_PATTERN = Pattern.compile("^[a-zA-Z\\s]+$");

    public RegistrarCiudad(final DAOFactory factory) {
        if (ObjectHelper.getObjectHelper().isNull(factory)) {
            var mensajeUsuario = "Se ha presentado un problema tratando de llevar a cabo el registro de una ciudad";
            var mensajeTecnico = "El DAOFactory para crear la ciudad llegó nulo.";
            throw new BusinessPCHException(mensajeTecnico, mensajeUsuario);
        }
        this.factory = factory;
    }

    @Override
    public void execute(final CiudadDomain data) {
        validarDatosCiudad(data);
        validarCiudadMismoNombre(data.getNombre());
        UUID ciudadId = generarIdentificadorCiudad();

        var ciudadEntity = CiudadEntity.build()
                .setId(ciudadId)
                .setNombre(data.getNombre())
                .setDepartamento(DepartamentoAssemblerEntity.getInstance().toEntity(data.getDepartamento()));

        factory.getCiudadDAO().crear(ciudadEntity);
    }

    private UUID generarIdentificadorCiudad() {
        UUID id;
        boolean existeId;

        do {
            id = UUIDHelper.generate();
            var ciudadEntity = CiudadEntity.build().setId(id);
            List<CiudadEntity> resultados = factory.getCiudadDAO().consultar(ciudadEntity);
            existeId = !resultados.isEmpty();
        } while (existeId);

        return id;
    }

    private void validarCiudadMismoNombre(final String nombreCiudad) {
        var ciudadEntity = CiudadEntity.build().setNombre(nombreCiudad);
        List<CiudadEntity> resultados = factory.getCiudadDAO().consultar(ciudadEntity);

        if (!resultados.isEmpty()) {
            var mensajeUsuario = String.format("Ya existe una ciudad con el nombre \"%s\".", nombreCiudad);
            var mensajeTecnico = String.format("Se intentó registrar una ciudad con el nombre \"%s\", pero ya existe una ciudad con el mismo nombre.", nombreCiudad);
            throw new BusinessPCHException(mensajeTecnico, mensajeUsuario);
        }
    }

    private void validarDatosCiudad(CiudadDomain data) {

        if (ObjectHelper.getObjectHelper().isNull(data.getNombre()) || data.getNombre().trim().isEmpty()) {
            throw new BusinessPCHException("El nombre de la ciudad está vacío.", "Debe proporcionar un nombre válido para la ciudad.");
        }
        if (!NOMBRE_PATTERN.matcher(data.getNombre()).matches()) {
            throw new BusinessPCHException("El nombre de la ciudad contiene caracteres inválidos.", "El nombre de la ciudad solo puede contener letras y espacios.");
        }
        if (ObjectHelper.getObjectHelper().isNull(data.getDepartamento()) || ObjectHelper.getObjectHelper().isNull(data.getDepartamento().getId())) {
            throw new BusinessPCHException("El departamento de la ciudad es nulo.", "Debe proporcionar un departamento válido para la ciudad.");
        }
    }
}