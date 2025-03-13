package br.com.pattern.bussinesAdapter;
import br.com.pattern.InterfaceStrategy.PaymentStrategy;
import br.com.pattern.LoggerSingleton.PaymentLogger;
import br.com.pattern.SistemaExterno.BitcoinPayment;

public class BitcoinPaymentAdapter implements PaymentStrategy {
    private BitcoinPayment bitcoinPayment;
    private String walletAddress;

    public BitcoinPaymentAdapter(BitcoinPayment bitcoinPayment, String walletAddress) {
        this.bitcoinPayment = bitcoinPayment;
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(double amount) {
        bitcoinPayment.payInBitcoin(amount, walletAddress);
        PaymentLogger.getInstance().logPayment("Bitcoin -> " + walletAddress + ":" + amount);
    }
}
