package co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data;
//El static deja traer las funciones para que sea propias de esta clase
import static co.edu.uco.pch.crosscutting.helpers.TextHelper.concatenate;
import static co.edu.uco.pch.crosscutting.helpers.TextHelper.UNDERLINE;

public enum CodigoMensaje {

    M00001(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00001", true),
    M00002(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00002", true),
    M00003(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00003", true),
    M00004(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00004", true);


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

    public static void main(String[] args) {
        System.out.println(M00001.getIdentificador());
    }
}
