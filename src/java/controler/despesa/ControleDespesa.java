package controler.despesa;

import despesa.bean.DespesaBean;
import despesa.dao.DespesaDaoImpl;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import tipoLancamento.TipoLancamento;
import util.DaoException;
import util.JSFUtil;

@ManagedBean
@SessionScoped
public class ControleDespesa implements Serializable {
    private Boolean renderizar = false;
    private DespesaBean dpb = new DespesaBean();
    private DespesaDaoImpl dd = new DespesaDaoImpl();
    private List<DespesaBean> listDespesa = new ArrayList<DespesaBean>(); 
    /*permite selecionar objeto da tabela para edição/exclusão*/
    private DespesaBean despesaSelecionada;
    
    public ControleDespesa() {
    }

    private String descricao;
    private String pago;
    private String tipo;
    private BigDecimal valor;
    
    /*função inserir objeto*/
    public void inserirDespesa(){
        this.dpb.setDescricao(descricao);
        this.dpb.setPago(true);
        this.dpb.setTipo(TipoLancamento.RECEITA);
        this.dpb.setValor(valor);
        
        try {
            getDd().inserir(this.dpb);
            this.dpb = new DespesaBean();
            System.out.println("inserido com sucesso !");
        } catch (DaoException ex) {
            System.out.println("Objeto não salvo !");
        }
    }
    
    /*fução escluir */
    public void excluirTipoServicoPrestado(DespesaBean despesa) {
        try {
            getDd().excluir(despesa);
            JSFUtil.adicionarMensagemSucesso("excluido com sucesso!");
        } catch (DaoException ex) {
            Logger.getLogger(ControleDespesa.class.getName()).log(Level.SEVERE, null, ex);
            JSFUtil.adicionarMensagemErro("Objeto Relacionado");
        }

    }
    
    
  public void fecharFormDespesa() {
        this.renderizar = false;
    }

    public DespesaBean getDpb() {
        return dpb;
    }

    public void setDpb(DespesaBean dpb) {
        this.dpb = dpb;
    }

    public DespesaDaoImpl getDd() {
        return dd;
    }

    public void setDd(DespesaDaoImpl dd) {
        this.dd = dd;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Boolean getRenderizar() {
        return renderizar;
    }

    public void setRenderizar(Boolean renderizar) {
        this.renderizar = renderizar;
    }

    public List<DespesaBean> getListDespesa() {
        try {
            return getDd().listar();
        } catch (DaoException ex) {
            Logger.getLogger(ControleDespesa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void setListDespesa(List<DespesaBean> listDespesa) {
        this.listDespesa = listDespesa;
    }

    public DespesaBean getDespesaSelecionada() {
        return despesaSelecionada;
    }

    public void setDespesaSelecionada(DespesaBean despesaSelecionada) {
        this.despesaSelecionada = despesaSelecionada;
    }

}
