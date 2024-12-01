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
        Pizzaria pizzaria = new Pizzaria();
        
        Pizza calabresa = new Calabresa();
        Pizza caipira = new Caipira();
        Pizza quatroQueijos = new QuatroQueijos();
        
        Cliente malu = new Cliente("123.456.789-01", "Maria Luiza Abrami", "(12)34567-8905");
        Pedido pedidoMalu = new Pedido();
        pedidoMalu.adicionarCliente(malu);
        pedidoMalu.adicionarPizza(caipira);
        pedidoMalu.adicionarPizza(quatroQueijos);
        DiaTrabalho primeiroDia = new DiaTrabalho("25/11/2024");
        
        Scanner scanner = new Scanner(System.in);
        
        //INICIALIZANDO DAO´S
        PizzaDaoImpl pizzaDao = new PizzaDaoImpl();
        PedidoDaoImpl pedidoDao = new PedidoDaoImpl();
        DiaTrabalhoDaoImpl diaTrabalhoDao = new DiaTrabalhoDaoImpl();
        ClienteDaoImpl clienteDao = new ClienteDaoImpl();
        PizzariaDaoImpl pizzariaDao = new PizzariaDaoImpl();
        
        PizzaService pizzaService = new PizzaService(scanner, pizzaDao);
        PedidoService pedidoService = new PedidoService(pedidoDao, clienteDao, pizzaDao, scanner);
        ClienteService clienteService = new ClienteService(clienteDao, scanner);
        DiaTrabalhoService diaTrabalhoService = new DiaTrabalhoService(pizzariaDao, diaTrabalhoDao, pedidoDao, scanner);
        PizzariaService pizzariaService = new PizzariaService(pizzariaDao);
        
        //ADICIONANDO AS PIZZAS
        pizzaDao.adicionarPizza(calabresa);
        pizzaDao.adicionarPizza(caipira);
        pizzaDao.adicionarPizza(quatroQueijos);
        
        clienteDao.adicionarCliente(malu);
        pedidoDao.adicionarPedido(pedidoMalu);
        diaTrabalhoDao.adicionarDiaTrabalho(primeiroDia);
        pizzariaDao.adicionarDiaTrabalho(primeiroDia);
        
        Menus menus = new Menus(pizzaService, pedidoService, clienteService, diaTrabalhoService, pizzariaService, scanner);
        menus.menuPrincipal();
        
        scanner.close();
    }
}
