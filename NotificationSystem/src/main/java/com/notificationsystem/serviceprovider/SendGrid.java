 
package com.notificationsystem.serviceprovider;

import java.io.IOException;

public class SendGrid implements ServiceProvider {

    @Override
    public void sendService(String message) throws Exception {
        validateMessage(message);
        System.out.println("Using SendGrid to send: " + message);
        simulateTransientError();
    }

    private void validateMessage(String message) throws IllegalArgumentException {
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }
    }

    private void simulateTransientError() throws IOException {
        // Simulating a transient error
        if (Math.random() > 0.8) {
            throw new IOException("Transient error occurred while sending message");
        }
    }
}
