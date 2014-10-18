package monitor.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.*;
import java.io.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.io.*;
import java.net.*;


/**
 * 
 *
 */

public class SendMail {

	/**
	 * send Email  
	 *  
	 */
    public void sendMail(CallerVO target){
    	//smtp server 
    	String host = "lacalhost";
    	//smtp server port
    	int      port = 25; 
    	String subject = "Service Monitoring Notification";
        String content = null;
        //sender
        String from = "error@email.com";
        //receiver 
        String to = target.getEmail();                                 

        content = "Caller : ";
        content += target.getCaller();
        content += "\n";
        content += "Host : ";
        content += target.getHost();
        content += "\n";
        content += "Server Port : ";
        content += target.getPort();
        content += "\n";
        content += "Status : ";
        content += target.getCrntStatus();
        content += "\n";
        
        try{
            // properties value instance and session
            Properties props = new Properties();
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", String.valueOf(port));
           
            Session session = Session.getDefaultInstance(props, null);

            Message msg = new MimeMessage(session);
            //sender
            msg.setFrom(new InternetAddress(from));
            //receiver
            InternetAddress[] address = {new InternetAddress(to)}; 
            msg.setRecipients(Message.RecipientType.TO, address);

            //subject setting
            msg.setSubject(subject);                                           
            //send date
            msg.setSentDate(new java.util.Date());                             
            //set content
            msg.setContent(content);  

            //send email
            Transport.send(msg);       
           
            System.out.println("completed");
        } catch (MessagingException ex) {
            System.out.println("mail send error : " + ex.getMessage());
        }catch(Exception e){
            System.out.println("error : " + e.getMessage());
        }
    }

}
