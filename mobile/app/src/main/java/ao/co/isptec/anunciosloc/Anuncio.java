package ao.co.isptec.anunciosloc;

public class Anuncio {
    public String titulo;
    public String local;
    public String status;
    public int corStatus;
    public String acao;
    public int iconeAcao;

    public Anuncio(String titulo, String local, String status, int corStatus, String acao, int iconeAcao) {
        this.titulo = titulo;
        this.local = local;
        this.status = status;
        this.corStatus = corStatus;
        this.acao = acao;
        this.iconeAcao = iconeAcao;
    }
}
