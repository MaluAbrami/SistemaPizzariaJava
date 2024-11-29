package sistemapizzaria;

import DaoImpl.ClienteDaoImpl;
import DaoImpl.PizzaDaoImpl;
import DaoImpl.PedidoDaoImpl;
import DaoImpl.DiaTrabalhoDaoImpl;
import DaoImpl.PizzariaDaoImpl;
import Pizzas.Caipira;
import Pizzas.Calabresa;
import Pizzas.QuatroQueijos;
import Services.ClienteService;
import Services.DiaTrabalhoService;
import Services.PedidoService;
import Services.PizzaService;
import Services.PizzariaService;
import SistemaDeMenus.Menus;
import java.util.Scanner;

public class SistemaPizzaria {

    public static void main(String[] args) {
        Pizza calabresa = new Calabresa();
        Pizza caipira = new Caipira();
        Pizza quatroQueijos = new QuatroQueijos();
        
        Scanner scanner = new Scanner(System.in);
        
        //INICIALIZANDO DAO´S
        PizzaDaoImpl pizzaDao = new PizzaDaoImpl();
        PedidoDaoImpl pedidoDao = new PedidoDaoImpl();
        DiaTrabalhoDaoImpl diaTrabalhoDao = new DiaTrabalhoDaoImpl();
        ClienteDaoImpl clienteDao = new ClienteDaoImpl();
        PizzariaDaoImpl pizzariaDao = new PizzariaDaoImpl();
        
        PizzaService pizzaService = new PizzaService(scanner, pizzaDao);
        PedidoService pedidoService = new PedidoService(pedidoDao, scanner);
        ClienteService clienteService = new ClienteService();
        DiaTrabalhoService diaTrabalhoService = new DiaTrabalhoService();
        PizzariaService pizzariaService = new PizzariaService();
        
        //ADICIONANDO AS PIZZAS
        pizzaDao.adicionarPizza(calabresa);
        pizzaDao.adicionarPizza(caipira);
        pizzaDao.adicionarPizza(quatroQueijos);
        
        Menus menus = new Menus(pizzaService, pedidoService, clienteService, diaTrabalhoService, pizzariaService, scanner);
        menus.menuPrincipal();
        
        scanner.close();
    }
}
