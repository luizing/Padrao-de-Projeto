package br.com.pattern.bsinessFactory;

import br.com.pattern.InterfaceStrategy.PaymentStrategy;
import br.com.pattern.businessStrategy.CreditCardPayment;
import br.com.pattern.businessStrategy.PayPalPayment;

public class PaymentFactory {

    public static PaymentStrategy createPayment(String type, String identifier, String name) {
        switch (type.toLowerCase()) {
            case "creditcard":
                return new CreditCardPayment(identifier, name);
            case "paypal":
                return new PayPalPayment(identifier);
            default:
                throw new IllegalArgumentException("Tipo de pagamento desconhecido: " + type);
        }
    }
}
