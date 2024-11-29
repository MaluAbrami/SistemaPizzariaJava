package sistemapizzaria;

import Dao.ClienteDaoImpl;
import Dao.PizzaDaoImpl;
import Dao.PedidoDaoImpl;
import Dao.DiaTrabalhoDaoImpl;
import Pizzas.Caipira;
import Pizzas.Calabresa;
import Pizzas.QuatroQueijos;
import Services.ClienteService;
import Services.DiaTrabalhoService;
import Services.PedidoService;
import Services.PizzaService;
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
        
        PizzaService pizzaService = new PizzaService(scanner, pizzaDao);
        PedidoService pedidoService = new PedidoService();
        ClienteService clienteService = new ClienteService();
        DiaTrabalhoService diaTrabalhoService = new DiaTrabalhoService();
        
        //ADICIONANDO AS PIZZAS
        pizzaDao.adicionarPizza(calabresa);
        pizzaDao.adicionarPizza(caipira);
        pizzaDao.adicionarPizza(quatroQueijos);
        
        Menus menus = new Menus(pizzaService, pedidoService, clienteService, diaTrabalhoService, scanner);
        menus.menuPrincipal();
        
        scanner.close();
    }
}
