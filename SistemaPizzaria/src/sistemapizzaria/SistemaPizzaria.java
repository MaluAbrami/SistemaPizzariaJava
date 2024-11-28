package sistemapizzaria;

import Dao.ClienteDaoImpl;
import Dao.PizzaDaoImpl;
import Dao.PedidoDaoImpl;
import Dao.DiaTrabalhoDaoImpl;
import SistemaDeMenus.Menus;
import java.util.Scanner;

public class SistemaPizzaria {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //INICIALIZANDO DAO´S
        PizzaDaoImpl pizzaDao = new PizzaDaoImpl();
        PedidoDaoImpl pedidoDao = new PedidoDaoImpl();
        DiaTrabalhoDaoImpl diaTrabalhoDao = new DiaTrabalhoDaoImpl();
        ClienteDaoImpl clienteDao = new ClienteDaoImpl();
        
        Menus menus = new Menus(pizzaDao, pedidoDao, clienteDao, diaTrabalhoDao);
        
        scanner.close();
    }
}
