package com.didi.payment.base.logger;

public class PayLogger {
    private PayLogger() {
        throw new RuntimeException(getClass().getSimpleName() + " should not be instantiated");
    }

    private static class InnerPayLogger {
        public static PayDidiLogger instance = new PayDidiLogger();

        private InnerPayLogger() {
        }
    }

    public static IPayLogger getLogger() {
        return InnerPayLogger.instance;
    }
}
