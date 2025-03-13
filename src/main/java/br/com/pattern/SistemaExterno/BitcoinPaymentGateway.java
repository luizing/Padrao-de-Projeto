package br.com.pattern.SistemaExterno;

public class BitcoinPaymentGateway implements BitcoinPayment{
        @Override
        public void payInBitcoin(double amount, String walletAddress) {
            System.out.println("Pagamento de " + amount + " BTC para a carteira " + walletAddress);
    }
}
