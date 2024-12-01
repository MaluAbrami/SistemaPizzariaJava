package Services;

import DaoImpl.PizzariaDaoImpl;

public class PizzariaService {
    private PizzariaDaoImpl pizzariaDao;
    
    public PizzariaService(PizzariaDaoImpl pizzariaDao){
        this.pizzariaDao = pizzariaDao;
    }
    
    public void obterRelatorioDiasTrabalhados(){
        System.out.println(pizzariaDao.obterRelatorioDiasTrabalhados());
    }
}
