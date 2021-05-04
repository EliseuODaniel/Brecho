/*
 * Classname
 *
 * Version info
 *
 * Copyright notice
 */
package brecho;

//superclasse das classes Boleto e CartaoCredito
public interface Pagamento {

// Método abstrato a ser implementado nas classes filhas
    public abstract double calculaPrecoTotal();
    
}