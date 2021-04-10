
import despesa.bean.DespesaBean;
import despesa.dao.DespesaDaoImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DaoException;


public class testeConexao {
    public static void main(String[] args) {
        DespesaBean ub1 = new DespesaBean();
        
        ub1.setDescricao("teste descricao ");
        ub1.setValor(150.0);
        ub1.setDataVencimento("10/04/2021");
        ub1.setStatus("Pendente");
        DespesaDaoImpl ud = new DespesaDaoImpl(); 
       
        try {
            ud.inserir(ub1);
        } catch (DaoException ex) {
            Logger.getLogger(testeConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
}
