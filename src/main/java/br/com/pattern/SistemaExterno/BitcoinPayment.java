// Exemplo de sistema externo incompátivel para ser utilizado o Adapter

package br.com.pattern.SistemaExterno;



public interface BitcoinPayment {
    void payInBitcoin(double amount, String walletAddress);
}
