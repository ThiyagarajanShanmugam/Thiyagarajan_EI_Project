 
package com.notificationsystem;

import com.notificationsystem.notification.EmailNotification;
import com.notificationsystem.notification.Notification;
import com.notificationsystem.notification.SMSNotification;
import com.notificationsystem.serviceprovider.SendGrid;
import com.notificationsystem.serviceprovider.Twilio;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Notification notification = null;
        
        while (true) {
            try {
                System.out.println("Select Notification Type (1. Email, 2. SMS): ");
                int type = Integer.parseInt(scanner.nextLine().trim());
                
                System.out.println("Select Service Provider (1. Twilio, 2. SendGrid): ");
                int provider = Integer.parseInt(scanner.nextLine().trim());

                switch (type) {
                    case 1:
                        notification = new EmailNotification(provider == 1 ? new Twilio() : new SendGrid());
                        break;
                    case 2:
                        notification = new SMSNotification(provider == 1 ? new Twilio() : new SendGrid());
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid Notification Type");
                }

                System.out.println("Enter your message: ");
                String message = scanner.nextLine().trim();
                notification.send(message);

            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
            
            System.out.println("Do you want to send another notification? (yes/no): ");
            if (!scanner.nextLine().trim().equalsIgnoreCase("yes")) {
                break;
            }
        }

        scanner.close();
    }
}
