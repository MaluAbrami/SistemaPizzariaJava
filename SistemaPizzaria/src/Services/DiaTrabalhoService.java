package Services;

import Dao.PizzariaDao;
import DaoImpl.DiaTrabalhoDaoImpl;
import DaoImpl.PedidoDaoImpl;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import sistemapizzaria.DiaTrabalho;
import sistemapizzaria.Pedido;

public class DiaTrabalhoService {
    private PizzariaDao pizzariaDao;
    private DiaTrabalhoDaoImpl diaTrabalhoDao;
    private PedidoDaoImpl pedidoDao;
    private Scanner scanner;
    
    public DiaTrabalhoService(PizzariaDao pizzariaDao, DiaTrabalhoDaoImpl diaTrabalhoDao, PedidoDaoImpl pedidoDao, Scanner scanner){
        this.pizzariaDao = pizzariaDao;
        this.diaTrabalhoDao = diaTrabalhoDao;
        this.pedidoDao = pedidoDao;
        this.scanner = scanner;
    }
    
    public void adicionarDiaTrabalho(){
        String data;
        int resp;

        System.out.println("\n\tAdicionar novo Dia de Trabalho");

        System.out.print("\nInforme a Data do dia: ");
        scanner.nextLine();
        data = scanner.nextLine();
        DiaTrabalho diaTrabalho = diaTrabalhoDao.procurarDiaTrabalhoPorData(data);

        if (diaTrabalho == null) {
            DiaTrabalho novoDiaTrabalho = new DiaTrabalho(data);
            
            System.out.print("\nDeseja inserir algum pedido ao dia? (1-sim/2-nao)");
            resp = parseInt(scanner.nextLine());
            while (resp == 1) {
                
                System.out.print("\nInforme o ID do Pedido: ");
                Pedido pedido = pedidoDao.procurarPedidoPorId(parseInt(scanner.nextLine()));
                
                if (pedido != null) { 
                    Pedido pedidoJaCadastradoEmUmDia = diaTrabalhoDao.verificarSePedidoJaExisteEmAlgumDia(pedido.getId());
                    
                    if(pedidoJaCadastradoEmUmDia != null){
                        System.out.println("Erro: Esse pedido ja foi registrado em um dia de trabalho");
                        System.out.print("\nContinuar adicionando pedidos? (1-sim/2-nao)");
                        resp = parseInt(scanner.nextLine());
                    } else{
                        novoDiaTrabalho.adicionarPedido(pedido);
                        System.out.print("\nDeseja adicionar mais algum pedido? (1-sim/2-nao)");
                        resp = parseInt(scanner.nextLine());
                    }
                } else {
                    System.out.println("Erro: Pedido do ID informado nao existe");
                    System.out.print("\nContinuar adicionando pedidos? (1-sim/2-nao)");
                    resp = parseInt(scanner.nextLine());
                }
            }

            diaTrabalhoDao.adicionarDiaTrabalho(novoDiaTrabalho);
            pizzariaDao.adicionarDiaTrabalho(novoDiaTrabalho); //Adiciona automaticamente dia trabalho a pizzaria
            System.out.println("Dia de Trabalho adicionado com sucesso!"); 
        } else{
            System.out.println("Erro: ja existe um dia registrado com essa data");
            System.out.print("\nDeseja atualizar o dia refente a data informada? (1-sim/2-nao)");
            resp = parseInt(scanner.nextLine());
            
            if(resp == 1)
                atualizarDiaTrabalho();
        }
    }
    
    public void atualizarDiaTrabalho(){
        int resp;
        List<Pedido> pedidos = new ArrayList();
        
        System.out.println("\n\tAtualizar Dia de Trabalho");
        
        System.out.print("Informe a data do Dia de Trabalho que deseja atualizar: ");
        scanner.nextLine();
        String data = scanner.nextLine();
        DiaTrabalho diaTrabalho = diaTrabalhoDao.procurarDiaTrabalhoPorData(data);
        
        if(diaTrabalho != null){
            System.out.print("\nDeseja atualizar os pedidos do dia? (1-sim/2-nao)");
            resp = parseInt(scanner.nextLine());
            
            while (resp == 1) {
                System.out.print("\nInforme o ID do Pedido: ");
                Pedido pedido = pedidoDao.procurarPedidoPorId(parseInt(scanner.nextLine()));
                
                if (pedido != null) { 
                    Pedido pedidoJaCadastradoEmUmDia = diaTrabalhoDao.verificarSePedidoJaExisteEmAlgumDia(pedido.getId());
                    
                    if(pedidoJaCadastradoEmUmDia != null){
                        System.out.println("Erro: Esse pedido ja foi registrado em um dia de trabalho");
                        System.out.print("\nContinuar adicionando pedidos? (1-sim/2-nao)");
                        resp = parseInt(scanner.nextLine());
                    } else{
                        pedidos.add(pedido);
                        System.out.print("\nDeseja adicionar mais algum pedido? (1-sim/2-nao)");
                        resp = parseInt(scanner.nextLine());
                    }
                } else {
                    System.out.println("Erro: Pedido do ID informado nao existe");
                    System.out.print("\nContinuar adicionando pedidos? (1-sim/2-nao)");
                    resp = parseInt(scanner.nextLine());
                } 
            }
            
            diaTrabalhoDao.atualizarDiaTrabalho(diaTrabalho.getId(), pedidos);
            pizzariaDao.atualizarPizzaria(diaTrabalho); //Atualiza dia trabalho automaticamente a pizzaria
            System.out.println("Dia de trabalho atualizado com sucesso!"); 
        } else{
            System.out.println("Erro: nao foi possivel atualizar o dia de trabalho");
        }
    }
    
    public void deletarDiaTrabalho(){
        System.out.println("\n\tDeletando Dia de Trabalho");
        
        System.out.print("\nInforme o ID do dia de trabalho que deseja deletar: ");
        int id = parseInt(scanner.nextLine());
        boolean resp = diaTrabalhoDao.deleteDiaTrabalho(id);
        
        if(resp){
            System.out.println("Dia de Trabalho deletado com sucesso!");
        } else{
            System.out.println("Erro: nao foi possivel deletar o dia de trabalho");
        }
    }
    
    public void listarDiasTrabalho(){
        System.out.println("\n\tLista de Todos os Dias de Trabalho");
        System.out.println(diaTrabalhoDao.listAllDiasTrabalho());
    }
}
