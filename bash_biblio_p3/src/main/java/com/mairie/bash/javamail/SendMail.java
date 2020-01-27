package com.mairie.bash.javamail;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import generated.borrowedBook.BorrowedBook;


public class SendMail {

	/**
	 * Sert a instencier la mise en place de log pour la class
	 */
	private static final Logger log = LoggerFactory.getLogger(SendMail.class.getName());
	
	/**
	 * recupération du fichier application.properties 
	 */
	 InputStream input = SendMail.class.getClassLoader().getResourceAsStream("application.properties");
	
	 Properties propApplicationProperties = new Properties();
	 
	 /**
		 * Envoi un email a l'user qui a une oeuvre non restituée
		 * 
		 * @param borrowedBookNotReturned
		 *            List des oeuvre non restituées
		 * @param i
		 * index de l'oeuvre dans la liste      
		 */
	public void sendMailToUser(List<BorrowedBook> borrowedBookNotReturned, int i){
    	
		
		 try {
			 propApplicationProperties.load(input);
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		 
    	final String username = propApplicationProperties.getProperty("usernameJavaMail");
        final String password = propApplicationProperties.getProperty("passwordJavaMail");
        final String host =propApplicationProperties.getProperty("hostJavaMail");
        final String port=propApplicationProperties.getProperty("portJavaMail");
        final String auth=propApplicationProperties.getProperty("authJavaMail");
        final String starttls=propApplicationProperties.getProperty("starttlsJavaMail");

        Properties prop = new Properties();
		prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", port);
        prop.put("mail.smtp.auth", auth);
        prop.put("mail.smtp.starttls.enable", starttls); 
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
        	
            Message message = new MimeMessage(session);
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(borrowedBookNotReturned.get(i).getUser().getEmail())
            );
            message.setSubject("Retard restitution d'ouvrage");
            message.setText("Bonjour "+borrowedBookNotReturned.get(i).getUser().getUsername()+", \n"
            		+ "Malheureusement vous avez dépassé la date de restitution de l'ouvrage "+borrowedBookNotReturned.get(i).getBook().getTitle()+". \n"
            		+ "Nous savons qu'il sagit d'un simple oubli :), merci de faire le nécessaire pour régulariser la situation. \n"
                    + "L'equipe de la Biblio_p3");
                   
            Transport.send(message);
            log.info("Mail de non restitution envoyé à l'user:"+borrowedBookNotReturned.get(i).getUser().getId()+
            		" pour l'ouvrage: "+borrowedBookNotReturned.get(i).getBook().getId());
        } catch (MessagingException e) {
            e.printStackTrace();
            log.error("erreur  pendant l'envoi du mail: "+e.getMessage());
            
        }
        
        catch (Exception e) {
            e.printStackTrace();
            log.error("erreur pendant l'envoi du mail: "+e.getMessage());
            
        }
	}
}
