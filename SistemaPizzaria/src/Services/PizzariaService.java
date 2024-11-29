package Services;

import Dao.PizzariaDaoImpl;

public class PizzariaService {
    private PizzariaDaoImpl pizzariaDao;
    
    public void obterRelatorioDiasTrabalhados(){
        System.out.println(pizzariaDao.obterRelatorioDiasTrabalhados());
    }
}
