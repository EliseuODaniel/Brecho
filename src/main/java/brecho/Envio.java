
package brecho;

public class Envio {
    
    
//construtor
    //implementação do relacionamento de associação simples entre a classe Envio e a classe pedido
    //recebe informações do pedido sobre a região de envio
    public Envio(Pedido pedido, String formaEnvio) {
        this.regiao = pedido.getCliente().getRegiaoEnvio();
        this.formaEnvio = formaEnvio;
    } 

//atributos    
    private final String regiao;
    private final String formaEnvio;
    private double precoEnvio;
    private int prazoEnvio;


    
//método que calcula o envio conforme a forma de envio Correios/Transportadora e 
//região do pedido (Norte, Sul, etc)
    public void calcularEnvio() {
        
        if ("Correios".equals(this.formaEnvio)) {
            
            if ("Sul".equals(this.regiao) || "Sudeste".equals(regiao)){
                this.precoEnvio = 15.00;
                this.prazoEnvio = 5;
                System.out.println("O preço do frete é de R$ " + this.precoEnvio + ".");
                System.out.println("O prazo de entrega é de " + this.prazoEnvio + " dias úteis.");
            }
            if ("Centro-Oeste".equals(this.regiao)){
                this.precoEnvio = 20.00;
                this.prazoEnvio = 10;
                System.out.println("O preço do frete é de R$ " + this.precoEnvio + ".");
                System.out.println("O prazo de entrega é de " + this.prazoEnvio + " dias úteis.");
            }
            if ("Norte".equals(this.regiao) || "Nordeste".equals(regiao)){
                this.precoEnvio = 25.00;
                this.prazoEnvio = 20;
                System.out.println("O preço do frete é de R$ " + this.precoEnvio + ".");
                System.out.println("O prazo de entrega é de " + this.prazoEnvio + " dias úteis.");
            }
        }
        
        if ("Transportadora".equals(formaEnvio)) {
            
            if ("Sul".equals(this.regiao) || "Sudeste".equals(regiao)){
                this.precoEnvio = 12.00;
                this.prazoEnvio = 10;
                System.out.println("O preço do frete é de R$ " + this.precoEnvio + ".");
                System.out.println("O prazo de entrega é de " + this.prazoEnvio + " dias úteis.");
            }
            if ("Centro-Oeste".equals(this.regiao)){
                this.precoEnvio = 17.00;
                this.prazoEnvio = 18;
                System.out.println("O preço do frete é de R$ " + this.precoEnvio + ".");
                System.out.println("O prazo de entrega é de " + this.prazoEnvio + " dias úteis.");
            }
            if ("Norte".equals(this.regiao) || "Nordeste".equals(regiao)){
                this.precoEnvio = 20.00;
                this.prazoEnvio = 23;
                System.out.println("O preço do frete é de R$ " + this.precoEnvio + ".");
                System.out.println("O prazo de entrega é de " + this.prazoEnvio + " dias úteis.");
            }   
        }
    }



//getters and setters
        public String getRegiao() {
        return regiao;
    }

    public String getFormaEnvio() {
        return formaEnvio;
    }

    public double getPrecoEnvio() {
        return precoEnvio;
    }
    
    public int getPrazoEnvio() {
        return prazoEnvio;
    }    
    
}
