package Services;

import DaoImpl.DiaTrabalhoDaoImpl;
import DaoImpl.PedidoDaoImpl;
import static java.lang.Integer.parseInt;
import java.util.Scanner;
import sistemapizzaria.DiaTrabalho;
import sistemapizzaria.Pedido;

public class DiaTrabalhoService {
    private DiaTrabalhoDaoImpl diaTrabalhoDao;
    private PedidoDaoImpl pedidoDao;
    private Scanner scanner;
    
    public DiaTrabalhoService(DiaTrabalhoDaoImpl diaTrabalhoDao, PedidoDaoImpl pedidoDao, Scanner scanner){
        this.diaTrabalhoDao = diaTrabalhoDao;
        this.pedidoDao = pedidoDao;
        this.scanner = scanner;
    }
    
    public void adicionarDiaTrabalho(){
        String data;
        int resp;
        
        System.out.println("\n\tAdicionar novo Dia de Trabalho");
        
        System.out.print("\nInforme a Data do dia: ");
        data = scanner.nextLine();
        
        DiaTrabalho novoDiaTrabalho = new DiaTrabalho(data);
        
        System.out.print("\nDeseja inserir algum pedido ao dia? (1-sim/2-nao)");
        resp = parseInt(scanner.nextLine());
        while(resp == 1){
            System.out.print("\nInforme o ID do Pedido: ");
            Pedido pedido = pedidoDao.procurarPedidoPorId(parseInt(scanner.nextLine()));
            if(pedido != null){
                novoDiaTrabalho.adicionarPedido(pedido);
                System.out.print("\nDeseja adicionar mais algum pedido? (1-sim/2-nao)");
                resp = parseInt(scanner.nextLine());
            } else{
                System.out.println("Erro: Pedido do ID informado nao existe");
                System.out.print("\nContinuar adicionando pedidos? (1-sim/2-nao)");
                resp = parseInt(scanner.nextLine());
            }
        }
        
        System.out.println("Dia de Trabalho adicionado com sucesso!");
    }
}
