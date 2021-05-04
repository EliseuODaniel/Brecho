/*
 * Classname
 *
 * Version info
 *
 * Copyright notice
 */
package brecho;

public class CartaoCredito implements Pagamento {

// Construtor
    public CartaoCredito(Pedido pedido, Envio envio, int numParcelas, double taxaJuros) {
        this.pedido = pedido;
        this.envio = envio;
        this.numParcelas = numParcelas;
        this.taxaJuros = taxaJuros/100;
    }

// Atributos
    private final Pedido pedido;
    private final Envio envio;
    private int numParcelas;
    private double taxaJuros;
    private Boolean faturaGerada = false;
   
    
    
// Método sobrescrito por polimorfismo da superclasse Pagamento
//preço total = soma das parcelas no cartão
//método dependente do método valorDaParcela
    @Override
    public double calculaPrecoTotal() {
        // Chama o método que calcula o valor de cada parcela e multiplica pelo número de parcelas
        System.out.println("\n" + "O preço total no crédito é de: R$ " + String.format("%.2f", valorDaParcela(pedido, envio)*numParcelas) + ".");
        return valorDaParcela(pedido, envio)*numParcelas;
    }
    
// Método pra calcular o valor das parcelas à prazo
    public double valorDaParcela(Pedido pedido, Envio envio) {
    
        // Calcula o custo das parcelas usando bisection search
        // Considera o número de parcelas e a taxa de juros do objeto
        double faltaPagar = pedido.getPrecoCarrinho() + envio.getPrecoEnvio();
        double naoPago;
        double bandaInferior = faltaPagar/numParcelas;
        double bandaSuperior = (faltaPagar*(Math.pow(1+taxaJuros, numParcelas)))/numParcelas;
        double pagamentoMinimo = (bandaInferior + bandaSuperior)/2;
        while(true){
            for(int i = 0; i < numParcelas; ++i){
                naoPago = faltaPagar - pagamentoMinimo;
                double valorDeJuros = taxaJuros * naoPago;
                faltaPagar = naoPago + valorDeJuros;            
            } 
            if (faltaPagar < -0.01 || faltaPagar > 0.01){
                pagamentoMinimo = pagamentoMinimo + faltaPagar/numParcelas;
                faltaPagar = pedido.getPrecoCarrinho() + envio.getPrecoEnvio() ;
            }
            else{
                break;
            }
        }
        return pagamentoMinimo;  
    }
    
    
    public boolean geraFatura() {
        this.setFaturaGerada(true);
        System.out.println("Fatura gerada com sucesso!");
        return faturaGerada;
    }





    
// Getters and Setters
    public Pedido getPedido() {
        return pedido;
    }

    public Envio getEnvio() {
        return envio;
    }

    public int getNumParcelas() {
        return numParcelas;
    }

    public void setNumParcelas(int numParcelas) {
        this.numParcelas = numParcelas;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros/100;
    }
    
    public Boolean getFaturaGerada() {
        return faturaGerada;
    }

    public void setFaturaGerada(Boolean faturaGerada) {
        this.faturaGerada = faturaGerada;
    }


    
}