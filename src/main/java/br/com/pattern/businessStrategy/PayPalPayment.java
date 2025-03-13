package br.com.pattern.businessStrategy;

import br.com.pattern.InterfaceStrategy.PaymentStrategy;
import br.com.pattern.LoggerSingleton.PaymentLogger;

//Implementação do Strategy Pattern
public class PayPalPayment implements PaymentStrategy {
    private String email;
    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Pagamento de R$" + amount + " realizado via PayPal (" + email + ")");
        PaymentLogger.getInstance().logPayment("Paypal -> " + email + ":" + amount);
    }
}
