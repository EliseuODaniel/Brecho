/*
 * Classname
 *
 * Version info
 *
 * Copyright notice
 */
package controle;

import brecho.*;
import java.util.Scanner;



public class Principal{



    public static void main (String[] args) {



        // Cria o estoque do brechó
        Estoque estoqueBrecho = new Estoque();

        // Cria 5 objetos do tipo produto
        // Código, Descrição do produto, Preço, Desconto em %, Estoque a que pertence
        Produto camiseta = new Produto(000001, "Camiseta azul - tamanho P", 10.90, 10, estoqueBrecho);
        Produto calcajeans = new Produto(000002, "Calça jeans clara - tamanho 46", 29.90, 30, estoqueBrecho);
        Produto vestido = new Produto(000003, "Vestido florido - tamanho M", 35.90, 20, estoqueBrecho);
        Produto camisa = new Produto(000004, "Camisa branca - tamanho G", 19.90, 15, estoqueBrecho);
        Produto saia = new Produto(000005, "Saia midi - tamanho P", 29.90, 10, estoqueBrecho);

        //mostra o relatório de produtos no estoque
        estoqueBrecho.relatorioEstoque();
        System.out.println("");

        // Retira o produto camisa do estoque
        estoqueBrecho.retiraProduto(saia);

        //mostra relatório atualizado de produtos no estoque
        estoqueBrecho.relatorioEstoque();

        // Imprime na tela os produtos e seus preços com desconto
        System.out.println("\nO preço com desconto do produto " + camiseta.getDescricao() + " é de: R$ " + String.format("%.2f", camiseta.getPrecoComDesconto()) + ".");
        System.out.println("O preço com desconto do produto " + calcajeans.getDescricao() + " é de: R$ " + String.format("%.2f", calcajeans.getPrecoComDesconto()) + ".");
        System.out.println("O preço com desconto do produto " + vestido.getDescricao() + " é de: R$ " + String.format("%.2f", vestido.getPrecoComDesconto()) + ".");
        System.out.println("O preço com desconto do produto " + camisa.getDescricao() + " é de: R$ " + String.format("%.2f", camisa.getPrecoComDesconto()) + ".");
        System.out.println("O preço com desconto do produto " + saia.getDescricao() + " é de: R$ " + String.format("%.2f", saia.getPrecoComDesconto()) + "." + "\n");

        // Instancia um objeto cliente
        Cliente joao = new Cliente("João Silva", "4234324", "joao@bol.com.br", "rua dom pedro I, manaus", "Norte");

        // Cria um carrinho pertencente ao objeto cliente joao
        Pedido carrinho1 = new Pedido(1, joao);
        // Adiciona produtos no carrinho
        carrinho1.addProdutoCarrinho(camiseta);
        carrinho1.addProdutoCarrinho(calcajeans);
        carrinho1.addProdutoCarrinho(vestido);

        // Mostra o carrinho com os produtos
        carrinho1.relatorioPedido();
        // Mostra o preço total do carrinho
        System.out.println("Preço total do carrinho: " + carrinho1.getPrecoCarrinho());

        // Remove um produto do carrinho, mostra o carrinho após remover e o preço do carrinho
        System.out.println("\n");
        carrinho1.delProdutoCarrinho(camiseta);
        carrinho1.relatorioPedido();
        System.out.println("Preço total do carrinho: " + carrinho1.getPrecoCarrinho() + "\n");

        // Instancia um envio e calcula o preço e prazo do envio
        Envio manaus = new Envio(carrinho1, "Correios");
        manaus.calcularEnvio();

        // Cria um pagamento por boleto
        Boleto boleto1 = new Boleto(carrinho1, manaus);
        // Calcula o total do carrinho no boleto com o envio já instanciado
        boleto1.calculaPrecoTotal();
        // Gera o boleto
        boleto1.geraBoleto();

        // Cria um pagamento a prazo em 10 parcelas com juros de 3,71%
        CartaoCredito credito1 = new CartaoCredito(carrinho1, manaus, 5, 3.71);
        // Calcula preço total no crédito
        credito1.calculaPrecoTotal();
        System.out.println("O valor foi parcelado em " + credito1.getNumParcelas() + " parcelas de "+ String.format("%.2f", credito1.valorDaParcela(carrinho1, manaus)));
        // Gera a fatura
        credito1.geraFatura();


        //lista o estoque antes de fechar a compra
        System.out.println("\nprodutos no estoque antes de fechar a compra: ");
        estoqueBrecho.relatorioEstoque();

        // Cliente paga pedido e o estoque é atualizado
        joao.pagaPedido(carrinho1, manaus, credito1);

        //lista o estoque novamente
        System.out.println("\nprodutos no estoque após fechar a compra: ");
        estoqueBrecho.relatorioEstoque();

        
        
        
        
    }               
}