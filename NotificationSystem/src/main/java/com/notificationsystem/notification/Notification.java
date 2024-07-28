 
package com.notificationsystem.notification;

import com.notificationsystem.serviceprovider.ServiceProvider;

public abstract class Notification {
    protected ServiceProvider serviceProvider;

    protected Notification(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public abstract void send(String message) throws Exception;
}
