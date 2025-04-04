package com.maroc_air.Utils.email;


import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.time.LocalTime;
import java.util.Properties;

public class SimpleEmail {

    // Sender's email ID needs to be mentioned
    private static String from = "oussamaelbechari@gmail.com";
    private static String password = "tggkumyqrnoilgmc";

    // Assuming you are sending email from localhost
//    private static String host = "localhost";




    public static LocalTime sendSimpleEmail (String to, String subject, String msg) {
        // Getting system properties
        Properties properties = System.getProperties();
//        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        // creating session object to get properties
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        EmailHelper.sendEmail(session, to, from , subject, msg);
        return LocalTime.now();
    }


}
