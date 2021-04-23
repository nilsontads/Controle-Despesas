package controler.despesa;

import despesa.bean.DespesaBean;
import despesa.dao.DespesaDaoImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import util.DaoException;
import util.JSFUtil;

@ManagedBean
@SessionScoped
public class ControleDespesa implements Serializable {

    private Boolean renderizar = false;
    private DespesaBean dpb = new DespesaBean();
    private DespesaDaoImpl dd = new DespesaDaoImpl();
    private List<DespesaBean> listDespesa = new ArrayList<DespesaBean>();

    public ControleDespesa() {
    }

    private String descricao;
    private String status;
    private Double valor;
    private String dataVencimento;

    /*função inserir objeto*/
    public void inserirDespesa() {
        this.dpb.setDataVencimento(dataVencimento);
        this.dpb.setDescricao(descricao);
        this.dpb.setStatus(status);
        this.dpb.setValor(valor);

        try {
            getDd().inserir(this.dpb);
            this.dpb = new DespesaBean();
            JSFUtil.adicionarMensagemSucesso("salvo com sucesso!");
        } catch (DaoException ex) {
            Logger.getLogger(ControleDespesa.class.getName()).log(Level.SEVERE, null, ex);
            JSFUtil.adicionarMensagemErro(ex.getMessage());
        }
    }

    /*fução escluir */
    public void excluirLancamentos(DespesaBean despesa) {
        try {
            getDd().excluir(despesa);
            messageSucesso("Usuário Excluído com Sucesso!", "formMenu:mgsGeral");
        } catch (DaoException ex) {
            Logger.getLogger(ControleDespesa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /*retorno de mensagens*/
    public void messageSucesso(String a, String update) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(a));
        RequestContext.getCurrentInstance().update(Arrays.asList(update));
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

}
