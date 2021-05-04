/*
 * Classname
 *
 * Version info
 *
 * Copyright notice
 */

package brecho;

public class Boleto implements Pagamento {

/*
     Construtor
    implementação da associacao simples com a classe pedido e Envio
    recebe as informacoes das classes pedido e envio pra poder calcular o valor total
    */
public Boleto(Pedido pedido, Envio envio) {
        this.pedido = pedido;
        this.envio = envio;
        this.numPedido = pedido.getNumPedido();
        this.nome = pedido.getCliente().getNome();
        this.cpf = pedido.getCliente().getCpf();
    }
    
// Atributos
    private final Pedido pedido;
    private final Envio envio;
    private final long numPedido;
    private final String nome;
    private final String cpf;
    private double precoTotal;
    private Boolean boletoGerado = false;
      
    
    
    
// Método sobrescrito por polimorfismo da superclasse Pagamento
    @Override
    public double calculaPrecoTotal() {
        this.precoTotal = this.pedido.getPrecoCarrinho() + envio.getPrecoEnvio();
        System.out.println("\n" + "O preço total do boleto é de: R$ " + String.format("%.2f", this.precoTotal) + ".");
        return precoTotal;
    }

    public boolean geraBoleto() {
        this.setBoletoGerado(true);
        System.out.println("Boleto gerado com sucesso!");
        return boletoGerado;
    }    
    
    
    
    
    
    
// Getters e Setters
    public long getNumPedido() {
        return numPedido;
    }
    
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }
    
    public Boolean getBoletoGerado() {
        return boletoGerado;
    }

    public void setBoletoGerado(Boolean boletoGerado) {
        this.boletoGerado = boletoGerado;
    }
    


}