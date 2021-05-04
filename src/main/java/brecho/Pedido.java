/*
 * Classname
 *
 * Version info
 *
 * Copyright notice
 */
package brecho;

import java.util.ArrayList;

public class Pedido {
    
/*
     Construtor
    relação de composição entre a classe pedido e a classe cliente
    todo pedido pertence a um cliente
    */
public Pedido(long numPedido, Cliente cliente) {
        this.numPedido = numPedido;
        this.cliente = cliente;
    }
    
// Atributos
    private long numPedido;
    private double precoCarrinho;
    private final Cliente cliente;
    //relaçao de agregação entre o pedido e os produtos
    //um pedido possui 0 ou vários produtos
    private final ArrayList<Produto> carrinho = new ArrayList<>();

    
    
    
// Adiciona produtos ao carrinho
    public void addProdutoCarrinho(Produto produto) {
        
        this.carrinho.add(produto);
        this.precoCarrinho += produto.getPrecoComDesconto();
        System.out.println("Produto adicionado ao carrinho com sucesso!");
    }
    
// Remove produtos ao carrinho
    public void delProdutoCarrinho(Produto produto) {
        
        this.carrinho.remove(produto);
        this.precoCarrinho -= produto.getPrecoComDesconto();
        System.out.println("Produto removido do carrinho com sucesso!");  
    } 
    
// Lista os produtos do carrinho
    public void relatorioPedido(){
        
        System.out.println("\n" + "Produtos no pedido:");
  
        // Varre a array carrinho do início até o fim, usando e como contador        
        for(Produto e:this.carrinho){
        System.out.println(e.getDescricao());       
        }
    }    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
// Getters e Setters
    public long getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(long numPedido) {
        this.numPedido = numPedido;
    }

    public ArrayList<Produto> getCarrinho() {
        return carrinho;
    }

    public double getPrecoCarrinho() {
        return precoCarrinho;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
 
    
}
