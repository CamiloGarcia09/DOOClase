package co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data;
//El static deja traer las funciones para que sea propias de esta clase
import static co.edu.uco.pch.crosscutting.helpers.TextHelper.concatenate;
import static co.edu.uco.pch.crosscutting.helpers.TextHelper.UNDERLINE;

public enum CodigoMensaje {

    M00001(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00001", true),
    M00002(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00002", true),
    M00003(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00003", true),
    M00004(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00004", true),
    M00005(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00005", true),
    M00006(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00006", true),
    M00007(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00007", true),
    M00008(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00008", true),
    M00009(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00009", true),
    M00010(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00010", true),
    M00011(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00011", true),
    M00012(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00012", true),
    M00013(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00013", true),
    M00014(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00014", true),
    M00015(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00015", true),
    M00016(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00016", true),
    M00017(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00017", true),
    M00018(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00018", true),
    M00019(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00019", true),
    M00020(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00020", true),
    M00021(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00021", true),
    M00022(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00022", true),

    //Mensajes creados por mi
    M00023(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00023", true),
    M00024(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00023", true),
    M00025(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00023", true),
    M00026(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00023", true),
    M00027(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00023", true);


    private TipoMensaje tipo;
    private CategoriaMensaje categoria;
    private String codigo;
    private boolean base;


    private CodigoMensaje(final TipoMensaje tipo, final CategoriaMensaje categoria,
                          final String codigo, final boolean base) {
        setTipo(tipo);
        setCategoria(categoria);
        setCodigo(codigo);
        setEsBase(base);
    }

    public final boolean isBase() {
        return base;
    }

    private final void setEsBase(final boolean base) {
        this.base = base;
    }

    public TipoMensaje getTipo() {
        return tipo;
    }

    public CategoriaMensaje getCategoria() {
        return categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    private void setTipo(final TipoMensaje tipo) {
        this.tipo = tipo;
    }

    private void setCategoria(final CategoriaMensaje categoria) {
        this.categoria = categoria;
    }

    private void setCodigo(final String codigo) {
        this.codigo = codigo;
    }

    public String getIdentificador(){
        return concatenate(getTipo().name(), UNDERLINE, getCategoria().name(), UNDERLINE, getCodigo());
    }

}
