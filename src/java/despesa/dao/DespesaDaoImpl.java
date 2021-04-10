
package despesa.dao;

import despesa.bean.DespesaBean;
import util.BaseDaoImpl;


public class DespesaDaoImpl extends BaseDaoImpl<DespesaBean> implements DesepesaDao{
  public DespesaDaoImpl() {
        super(DespesaBean.class);
    }  
}
