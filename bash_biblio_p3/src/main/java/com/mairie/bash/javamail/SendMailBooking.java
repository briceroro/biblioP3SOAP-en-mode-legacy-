package com.mairie.bash.javamail;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
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

import generated.BookingService.Booking;

public class SendMailBooking {

	/**
	 * Sert a instencier la mise en place de log pour la class
	 */
	private static final Logger log = LoggerFactory.getLogger(SendMail.class.getName());
	
	/**
	 * recupération du fichier application.properties 
	 */
	 InputStream input = SendMail.class.getClassLoader().getResourceAsStream("application.properties");
	
	 Properties propApplicationProperties = new Properties();
	 
	 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 
	 public void SendMailBookingToUser(List<Booking> allBooking, int i) {

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
                    InternetAddress.parse(allBooking.get(i).getUser().getEmail())
            );
            message.setSubject("Rservation d'ouvrage");
            message.setText("Bonjour "+allBooking.get(i).getUser().getUsername()+", \n"
            		+ "L'ouvrage "+allBooking.get(i).getBook().getTitle()+" est disponible. \n"
            		+ "Vous avez jusqu'au "+dateFormat.format(allBooking.get(i).getMaxDateBooking().toGregorianCalendar().getTime())+" pour venir le recuperer. \n"
            		+ "Passer ce delai votre réservation sera annuler. \n"
            		+ "L'equipe de la Biblio_p3");
                   
            Transport.send(message);
            log.info("Mail de reservation envoyé a l'user :"+allBooking.get(i).getUser().getId()+
            		" pour l'ouvrage: "+allBooking.get(i).getBook().getId());
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
