package com.mairie.biblio.db;


import java.util.logging.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import org.hibernate.Session;



/**
 * Servlet servant a mettre a jour les entity et le mapping de l'application
 */
@WebServlet(loadOnStartup=1)
public class InitTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * initialisation de la session
	 */
	private Session session ;
	
	/**
	 * initialisation des log de la class
	 */
	Logger log = Logger.getLogger(InitTable.class.getName());
	
	/**
	 * Methode servant a se connecter a la bdd afin d'initialiser ou de mettre a jour le mapping
	 */
  public void init() {
	
	  		try {
	  			session = HibernateUtil.currentSession();
	  			log.info("connexion InitTable ok au lancement de l'application");
	  			
	  		}finally {

	  			session.close();
	  			
	  		}
	  
	   
		
		
		
		
		
  }  
}
  
  
 


