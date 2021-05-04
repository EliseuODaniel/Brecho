/*
 * Classname
 *
 * Version info
 *
 * Copyright notice
 */
package brecho;

import java.util.ArrayList;

public class Cliente {
    
// Construtor
    public Cliente(String nome, String cpf, String email, String enderecoEnvio, String regiaoEnvio) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.enderecoEnvio = enderecoEnvio;
        this.regiaoEnvio = regiaoEnvio;
    }
    
    
// Atributos
    private String nome;
    private String cpf;
    private String email;
    private String enderecoEnvio;
    private String regiaoEnvio;
    /*
    implementacao do relacionamento de composição entre a classe cliente e pedido
    um cliente pode ter vários pedidos (atual e os já fechados como um histórico)
    */
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    
    
// Adiciona os pedidos do cliente a uma lista (para ter um histórico de pedidos)
    public void fazPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

//realiza o pedido, calcula o preço, mostra os itens pedidos
    public void pagaPedido(Pedido pedido, Envio envio, Pagamento formaPagamento) {
        
        System.out.println("\nPagamento recebido."); 
        pedido.relatorioPedido();
        System.out.println("");
        envio.calcularEnvio();
        if(formaPagamento.getClass() == Boleto.class){
            formaPagamento.calculaPrecoTotal();
        }
        else if(formaPagamento.getClass() == CartaoCredito.class){
            CartaoCredito pagamentoCredito = (CartaoCredito) formaPagamento;
            formaPagamento.calculaPrecoTotal();
            System.out.println("Com parcela(s) de: R$ " + String.format("%.2f", pagamentoCredito.valorDaParcela(pedido, envio)));
        }
        
        System.out.println("Produtos encaminhados para envio.");

        /*
        for passando por todos os objetos do tipo Produto no carrinho "pedido"
         que receberão a referencia p
        como a arrayList "carrinho" é privada, então usa o método getCarrinho() pra acessá-la
        ou seja, na prática no objeto pedido acessa a array carrinho
         passando por todos os seus objetos do tipo Produto
        */
        for(Produto p:pedido.getCarrinho()){
            /*
            para acessar o estoque, tem que lembrar que todo produto está vinculado a um estoque
            então produto.getEstoque() retorna o estoque daquele produto
            então, usa o método retiraProduto(produto) do estoque
            */
            p.getEstoque().retiraProduto(p);
        }


}


    
    
    
    
// Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEnderecoEnvio() {
        return enderecoEnvio;
    }

    public void setEnderecoEnvio(String enderecoEnvio) {
        this.enderecoEnvio = enderecoEnvio;
    }

    public String getRegiaoEnvio() {
        return regiaoEnvio;
    }

    public void setRegiaoEnvio(String cepEnvio) {
        this.regiaoEnvio = cepEnvio;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
    

 
}
