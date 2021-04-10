
package situacao.lancamentos;


public enum SituacaoLancamentos {
    
    PENDENTE("Pendente"),
    RECEBIDO("Recebido");

    private SituacaoLancamentos(String descricao) {
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
