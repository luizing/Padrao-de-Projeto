package br.com.pattern.Decorators;

import br.com.pattern.InterfaceStrategy.PaymentStrategy;

public class ProcessingFeeDecorator extends PaymentDecorator {
    private double feePercentage;

    public ProcessingFeeDecorator(PaymentStrategy decoratedPayment, double feePercentage) {
        super(decoratedPayment);
        this.feePercentage = feePercentage;
    }

    @Override
    public void pay(double amount) {
        double totalAmount = amount + (amount * feePercentage / 100);
        System.out.println("Adicionando taxa de processamento de " + feePercentage + "%");
        decoratedPayment.pay(totalAmount);
    }
}
