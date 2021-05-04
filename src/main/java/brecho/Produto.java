/*
 * Classname
 *
 * Version info
 *
 * Copyright notice
 */
package brecho;

public class Produto {

// Construtor
    public Produto(long codigoProduto, String descricao, double preco, double desconto, Estoque estoque) {
        this.codigoProduto = codigoProduto;
        this.descricao = descricao;
        this.preco = preco;
        this.desconto = desconto;
        this.precoComDesconto = this.preco - this.preco*(this.desconto/100);
        //implementação da relacao de composição entre a classe Produto e Estoque:
        //todo produto pertence à um estoque
        this.estoque = estoque;
        estoque.adicionaProduto(this);
    }
  
// Atributos
    private long codigoProduto;
    private String descricao;
    private double preco;
    private double desconto;
    private final double precoComDesconto;
    private final Estoque estoque;

// Getters and Setters
    public long getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(long codProduto) {
        this.codigoProduto = codProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getPrecoComDesconto() {
        return precoComDesconto;
    }

    public Estoque getEstoque() {
        return estoque;
    }
        
}
