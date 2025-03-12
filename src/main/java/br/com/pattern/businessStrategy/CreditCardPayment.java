package br.com.pattern.businessStrategy;

import br.com.pattern.InterfaceStrategy.PaymentStrategy;
//Implementação do Strategy Pattern
public class CreditCardPayment implements PaymentStrategy {

    private String cardNumber;
    private String name;
    public CreditCardPayment(String cardNumber, String name) {
        this.cardNumber = cardNumber;
        this.name = name;
    }
    @Override
    public void pay(double amount) {
        System.out.println("Pagamento de R$" + amount + " realizado com cartão de crédito (" + cardNumber + ") em nome de " + name);
    }
}
