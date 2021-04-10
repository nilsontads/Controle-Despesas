
import despesa.bean.DespesaBean;
import despesa.dao.DespesaDaoImpl;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import tipoLancamento.TipoLancamento;
import util.DaoException;


public class testeConexao {
    public static void main(String[] args) {
        DespesaBean ub1 = new DespesaBean();
        
        ub1.setDescricao("teste descricao 2");
        ub1.setValor(BigDecimal.ZERO);
        ub1.setTipo(TipoLancamento.DESESA);
        
        DespesaDaoImpl ud = new DespesaDaoImpl(); 
       
        try {
            ud.inserir(ub1);
        } catch (DaoException ex) {
            Logger.getLogger(testeConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
}
