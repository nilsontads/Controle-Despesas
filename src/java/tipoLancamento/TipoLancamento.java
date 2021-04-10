
package tipoLancamento;


public enum TipoLancamento {
    
    RECEITA("Receita"),
    DESESA("Dspesa");

    private TipoLancamento(String descricao) {
        this.descricao = descricao;
    }
    
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
