package br.com.pattern.Decorators;

import br.com.pattern.InterfaceStrategy.PaymentStrategy;

public abstract class PaymentDecorator implements PaymentStrategy {
    protected PaymentStrategy decoratedPayment;

    public PaymentDecorator(PaymentStrategy decoratedPayment) {
        this.decoratedPayment = decoratedPayment;
    }

    @Override
    public void pay(double amount) {
        decoratedPayment.pay(amount);
    }
}