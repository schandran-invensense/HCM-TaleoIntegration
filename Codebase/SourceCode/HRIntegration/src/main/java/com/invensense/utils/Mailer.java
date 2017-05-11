
package com.invensense.utils;

import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Mailer {
	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	
    public static void main(String args[]) {
        new Mailer(
        		"email-smtp.us-west-2.amazonaws.com", "schandran@invensense.com", new String[]{"svishnu@invensense.com"}, "subject", "summary", "test");
    }

    public Mailer(String smtp, String from, String to[], String subject, String message, String filename) {
        try {
            sendEmail(smtp, from, to, subject, message, filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Mailer(String smtp, String from, String to[], String subject, String message) {
    	this(smtp, from, to, subject, message, false);
    }
    
    public Mailer(String smtp, String from, String to[], String subject, String message, boolean html) {
        try {
        	if(html){
        		sendHtmlEmail(smtp, from, to, subject, message);
        	}else{
        		sendEmail(smtp, from, to, subject, message);
        	}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Message prepareHeader(String smtp_host, String from, String to[], String subject)
            throws Exception {

        Properties props = new Properties();
        props.put("mail.smtp.host", smtp_host);
        props.put("smtp.host", smtp_host);
        props.put("mail.transport.protocol", "smtp");
       props.put("mail.smtp.auth", "true");
       props.put( "mail.smtp.starttls.enable" , "true" );
       props.put("mail.smtp.auth.plain.disable", "true");
        props.put("mail.debug", "true");
        final String username = "AKIAJIATT7LD6EKSUQCQ ";//change accordingly
        final String password = "AoWlJ8Ra6hJB7EOLbN7I8Ql0+rakC3IDk7/aL3GEKwVc";//change accordingly

    
        System.out.println("\n\t mail.smtp.host: " + smtp_host);
        Session session = Session.getInstance(props, 
        		new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
             });  //Session.getDefaultInstance(props, null);

        Message msg = new MimeMessage(session);

        for (int i = 0; i < to.length; i++) {
            try {
                if (to[i] != null) {
                    InternetAddress addr = new InternetAddress(to[i].trim());
                    msg.addRecipients(Message.RecipientType.TO, new InternetAddress[]{addr});
                }
            } catch (Exception e) {
            }
        }

        InternetAddress from_addr = new InternetAddress(from);
        msg.setFrom(from_addr);

        msg.setSubject(subject);

        return msg;
    }

    public void sendEmail(String smtp_host, String from, String to[], String subject, String message, String filename)
            throws Exception {

        Message msg = prepareHeader(smtp_host, from, to, subject);
System.out.println("In email test");
        // create the body text
        MimeBodyPart mbp1 = new MimeBodyPart();
        mbp1.setText(message);
        System.out.println("In email test");
        // attach the file to the message
   //     MimeBodyPart mbp2 = new MimeBodyPart();
    //    FileDataSource fds = new FileDataSource(filename);
    //    mbp2.setDataHandler(new DataHandler(fds));

        // create the Multipart and add its parts to it
        Multipart mp = new MimeMultipart();
        mp.addBodyPart(mbp1);
       // mp.addBodyPart(mbp2);
        System.out.println("In email test");
        // add the Multipart to the message
        msg.setContent(mp);

        try {
        	System.out.println("Sending email : "+from+": "+ to[0]+" : "+subject);
            Transport.send(msg);
            System.out.println("\n\t mail sent!");
        } catch (MessagingException e) {
            System.out.println("\n\t Error sending mail...: " + e.getMessage());
            e.printStackTrace();
     
        }
    }


    public void sendEmail(String smtp_host, String from, String to[], String subject, String message)
            throws Exception {

        Message msg = prepareHeader(smtp_host, from, to, subject);
        msg.setContent(message, "text/plain");
    	System.out.println("Sending email in sendEmail : "+from+": "+ to[0]+" : "+subject);
        
        try {
            Transport.send(msg);
            System.out.println("\n\t mail sent!");
        } catch (MessagingException e) {
        	System.out.println("\n\t Error sending mail...: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void sendHtmlEmail(String smtp_host, String from, String to[], String subject, String message)
    throws Exception {

		Message msg = prepareHeader(smtp_host, from, to, subject);
		msg.setContent(message, "text/html");
		
		try {
		    Transport.send(msg);
		    System.out.println("\n\t mail sent!");
		} catch (MessagingException e) {
			System.out.println("\n\t Error sending mail...: " + e.getMessage());
		    e.printStackTrace();
		}
	}


}
