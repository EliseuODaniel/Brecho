
package brecho;

import java.util.ArrayList;

public class Estoque {
    
//atributos
    //relação de composição da classe estoque e produto
    //um estoque possui vários produtos - implementado com ArrayList
    private final ArrayList<Produto> estoque = new ArrayList<>();

    
    public ArrayList<Produto> getEstoque() {
        return estoque;
    }
    
    public void adicionaProduto(Produto produto) {
        
        if (this.estoque.contains(produto)) {
            System.out.println("Esse produto já foi adicionado ao estoque!");
        } else {
            this.estoque.add(produto);
            System.out.println("Produto adicionado ao estoque com sucesso!");
            }
    }
    
    public void retiraProduto(Produto produto) {
        
        if (!this.estoque.contains(produto)) {
            System.out.println("Esse produto já foi retirado do estoque!");
        } else {
            this.estoque.remove(produto);
            System.out.println("Produto retirado do estoque com sucesso!");
            }
    }  

    public void relatorioEstoque(){
    
        System.out.println("\n" + "Produtos no estoque:");
    
        // Varre o array estoque do início até o fim, usando e como contador        
        for(Produto e:this.estoque) {
            System.out.println(e.getDescricao());       
        }
    }       
    
}
