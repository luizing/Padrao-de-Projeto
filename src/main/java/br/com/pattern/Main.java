package br.com.pattern;

import br.com.pattern.ContextStrategy.PaymentContext;
import br.com.pattern.Decorators.ProcessingFeeDecorator;
import br.com.pattern.InterfaceStrategy.PaymentStrategy;
import br.com.pattern.LoggerSingleton.PaymentLogger;
import br.com.pattern.SistemaExterno.BitcoinPayment;
import br.com.pattern.SistemaExterno.BitcoinPaymentGateway;
import br.com.pattern.bsinessFactory.PaymentFactory;
import br.com.pattern.bussinesAdapter.BitcoinPaymentAdapter;

public class Main {
    public static void main(String[] args) {

        System.out.println("Iniciando contexto de pagamento");

        // Usando o Factory Pattern para criar estratégias de pagamento
        PaymentStrategy creditCardPayment = PaymentFactory.createPayment("creditcard", "1234-5678-9012-3456", "João Silva");
        PaymentStrategy payPalPayment = PaymentFactory.createPayment("paypal", "joao.silva@example.com", null);

        // Usando o Strategy Pattern para processar pagamentos
        PaymentContext context1 = new PaymentContext(creditCardPayment);
        context1.executePayment(100.50);

        PaymentContext context2 = new PaymentContext(payPalPayment);
        context2.executePayment(200.75);

        // Usando Decorator para modificar os pagamentos
        PaymentStrategy debitCardPayment = PaymentFactory.createPayment("debitcard", "1234-5678-9012-3456", "João Silva");
        PaymentStrategy paymentWithFee = new ProcessingFeeDecorator(debitCardPayment, -2.5); // 2.5% de taxa

        PaymentContext context3 = new PaymentContext(paymentWithFee);
        context3.executePayment(100.50); // Pagamento com taxa

        // Usando Adapter para um exemplo de sistema externo usando Bitcoin
        BitcoinPayment bitcoinPayment = new BitcoinPaymentGateway();
        PaymentStrategy bitcoinAdapter = new BitcoinPaymentAdapter(bitcoinPayment, "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa");

        PaymentContext context4 = new PaymentContext(bitcoinAdapter);
        context4.executePayment(0.005); // Pagamento de 0.005 BTC

        // Usando o Logger criado com singleton
        System.out.println("Log de pagamentos:");
        System.out.println(PaymentLogger.getInstance().getLog());
    }
}