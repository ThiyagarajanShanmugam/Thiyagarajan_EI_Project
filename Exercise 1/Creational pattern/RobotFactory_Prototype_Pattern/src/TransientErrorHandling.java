package com.factory;

public class TransientErrorHandling {

    public static void retry(Runnable runnable, int retries, long delay) {
        for (int i = 0; i < retries; i++) {
            try {
                runnable.run();
                return;
            } catch (Exception e) {
                Logger.log("Transient error occurred: " + e.getMessage());
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        throw new RuntimeException("Failed after " + retries + " attempts");
    }
}
