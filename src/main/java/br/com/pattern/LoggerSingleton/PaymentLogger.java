package br.com.pattern.LoggerSingleton;

public class PaymentLogger {
    private static PaymentLogger instance;
    private StringBuilder log;

    private PaymentLogger() {
        log = new StringBuilder();
    }

    public static PaymentLogger getInstance() {
        if (instance == null) {
            instance = new PaymentLogger();
        }
        return instance;
    }

    public void logPayment(String message) {
        log.append(message).append("\n");
    }

    public String getLog() {
        return log.toString();
    }
}

