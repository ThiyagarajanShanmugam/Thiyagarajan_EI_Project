 
package com.notificationsystem.notification;

import com.notificationsystem.serviceprovider.ServiceProvider;

public class SMSNotification extends Notification {

    public SMSNotification(ServiceProvider serviceProvider) {
        super(serviceProvider);
    }

    @Override
    public void send(String message) throws Exception {
        System.out.println("Sending SMS Notification...");
        serviceProvider.sendService(message);
    }
}
