 
package com.notificationsystem.notification;

import com.notificationsystem.serviceprovider.ServiceProvider;

public class EmailNotification extends Notification {

    public EmailNotification(ServiceProvider serviceProvider) {
        super(serviceProvider);
    }

    @Override
    public void send(String message) throws Exception {
        System.out.println("Sending Email Notification...");
        serviceProvider.sendService(message);
    }
}
