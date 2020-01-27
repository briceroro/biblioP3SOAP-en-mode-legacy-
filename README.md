# p6_expert_jee

Depot du projet  6 "Améliorez le système d’information de la bibliothèque" de la formation Expert JEE [formation Expert JEE](https://openclassrooms.com/fr/paths/99-expert-java-ee) OpenClassroom.

## Index
* [Technologies utilisés](#technoUtil)
  * [WebService](#technoUtilWebService)
  * [WebApp](#technoUtilWebApp)
  * [Bash](#technoUtilBash)
  
* [Configuration des Applications via IDE](#configApp)
  * [WebService](#configAppWebService)
  * [WebApp](#configAppWebApp)
  * [Bash](#configAppBash)
  
* [Déploiement des Applications via IDE](#deployApp)
  * [WebService](#deployAppWebService)
  * [WebApp](#deployAppWebApp)
  * [Bash](#deployAppBash)

* [Configuration et déploiement VIa fichier config](#viaFichierConfig)
  * [WebService](#viaFichierConfigConfiguration)
  * [WebApp](#viaconfigFichierConfigDeploy)


## Technologies utilisés:<a name="technoUtil"></a>

### WebService <a name="technoUtilWebService"></a>
* OpenJDk 1.8.0_222
* Maven 3.6.0
* Glassfish 5.0
* MySQL 5.7
* Hybernate 5.4.3
* JPA 2.2.1
* jaxws 2.3.1

### WebApp<a name="technoUtilWebApp"></a>
* OpenJDk 1.8.0_222
* Maven 3.6.0
* Spring Boot 2.1.6
  * Security
  * Thymleaf
  * Web
* Tomcat 9.0

### Bash<a name="technoUtilBash"></a>
* OpenJDk 1.8.0_222
* Maven 3.6.0
* Spring Boot 2.1.6
* javax.mail 1.6.2

## Configuration des Applications via IDE<a name="configApp"></a>

### WebService<a name="configAppWebService"></a>

#### Connexion a la BDD:

Dans le fichier : /WebService_biblio_p3/src/main/resources/hibernate.cfg.xml:
* connection-url:
L'adresse de votre BDD.*(rajouter si probleme de timezone aprés votre BDD: useSSL=false&amp;serverTimezone=UTC)*  
* connection.username:
Votre user.
* connection.password:
Le password de votre user

```java
        <property name="connection.url">votre BDD</property>
        <property name="connection.username">votre username</property>
        <property name="connection.password">votre password</property>
```
### WebApp<a name="configAppWebApp"></a>

#### Pour la gestion de tomcat:

Dans le fichier /WebApp_biblio_p3/src/main/resources/application.properties
* server.port:
Definir un port différent d'un port deja utilisé( ex: Glassfish)
```java
# tomcat
server.port= le port choisi pour votre App
```
#### Pour la gestion des WebServices<a name="WebService"></a>

Utilisé la commande directment dans la webApp  (en modifiant l'adress wsdl et le nom du service):
wsimport -Xnocompile -d ./src/main/java -p generated.NOMDUSERVICE https://ADRESSEWSDLDUSERVICE

### Bash<a name="configAppBash"></a>

#### Pour la gestion des WebServices

idem que pour la webApp

#### Pour modifier le delai d'envoi d'envoi du bash

Dans le fichier /bash_biblio_p3/src/main/resources/application.properties:

Configurer suivant votre besoin la propriété cronExpression
```java
# pour gerer delai lancement du bash
cronExpression=0 0 10 * * *
```

Doc officielle [Spring.io](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/scheduling/support/CronSequenceGenerator.html)

Example patterns:

* "0 0 * * * *" = the top of every hour of every day.
* "*/10 * * * * *" = every ten seconds.
* "0 0 8-10 * * *" = 8, 9 and 10 o'clock of every day.
* "0 0 6,19 * * *" = 6:00 AM and 7:00 PM every day.
* "0 0/30 8-10 * * *" = 8:00, 8:30, 9:00, 9:30, 10:00 and 10:30 every day.
* "0 0 9-17 * * MON-FRI" = on the hour nine-to-five weekdays
* "0 0 0 25 12 ?" = every Christmas Day at midnight


#### Pour parameter la connexion au compte mail

Dans le fichier /bash_biblio_p3/src/main/resources/application.properties

Exemple via gmail:

```java
#javaMail
usernameJavaMail=votre user
passwordJavaMail=password de votre user
hostJavaMail=smtp.gmail.com
portJavaMail=587
authJavaMail=true
starttlsJavaMail=true 
```
Pour d'autres configurations se référer a la documentation officielle de javamail https://javaee.github.io/javamail/

## Déployement des Applications via IDE<a name="deployApp"></a>

### Webservice<a name="deployAppWebService"></a>

Une fois le webService configuré:
* faire un mvn install avec Maven
* deployer dans Glassfish le War généré
### WebApp<a name="deployAppWebApp"></a>

Une fois la WebApp configuré:
* faire un mvn clean install avec Maven
* soit faire:
  * lancer directement l'application avec mvn spring-boot:run
  * deployer dans tomcat le war généré

### Bash<a name="deployAppBash"></a>

Une fois le Bash configuré:
* faire un mvn clean install avec Maven
* soit faire:
  * utilisé le fichier launchBash.sh dans le dossier biblio_p3_Bash/launcher
  * soit lancer directement l'application avec mvn spring-boot:run
  
 ## Configuration et déploiement via fichier config<a name="viaFichierConfig"></a>
 
 ### configuration<a name="viaFichierConfigConfiguration"></a>
 * aller dans le dossier livrables_biblio_p3/fichiers_config
 * paramétrer les fichiers de configuration
 * copier dans les war/jar les fichiers de configuration dans main/ressources de chaque jar/war
 
 Pour plus d'infos ce reporter au fichier readme fourni avec chaque fichier de configuration.
 
 ### deploiement<a name="viaconfigFichierConfigDeploy"></a>
 
  * WebService: deployer de war dans Glassfish
  * WebApp : deployer le war dans Tomcat
  * Bash : utiliser le fichier launcherBash.sh 
  
  
