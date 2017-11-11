package com.miage.crm365.model.service;

import java.util.Locale;

import org.springframework.context.MessageSource;

/**
 * Service de gestion de l'internationalisation de l'application
 *
 * Comment connaitre la localisation dans un service metier ?
 *
 * Dans une application internationalisée, il est important de remonter des messages dans
 * la langue de l'utilisateur. Pour une application Web, la langue est généralement connue
 * à partir d'en tete se trouvant dans la requetes HTTP ( et correspondant donc au reglages
 * du navigateur de l'utilisateur). Ces en tetes HTTP ne sont accessibles que par les
 * couches superieures de l'application. Celles-ci doivent d'une maniere ou une autre
 * rendre la localisation de l'utilisateur accessible aux couches inférieures (métier
 * et parfois persistance). Il ne faut en aucun cas se fonder sur la methode statique
 * Locale.getDefault, qui retourne la localisation du serveur !
 * Une solution élégante consiste à stocker la localisation dans un Bean de portée
 * session HTTP qui pourra etre injecté dans les Beans nécessitant d'interagir avec
 * le contexte utilisateur. (Mecanisme illustree dans Spring par la pratique chap 3).
 *
 * @author tarik DJEBIEN
 */
public interface IMessageI18nService {

	/**
	 * Dans Spring, la notion equivalente de RessourceBundle JAVA
	 * est l'interface MessageSource.
	 * Recupere le Message source afin de recuperer les messages.
	 * @return le MessageSource
	 */
	MessageSource getMessageSource();

	/**
	 * Recupere la valeur d'un message en fonction de sa clé
	 * et de sa locale
	 * @param key la clé
	 * @param params les parametre eventuellement s'il y en a
	 * @param locale la locale
	 * @return la valeur du message
	 */
	String getMessage(String key, Object[] params, Locale locale);

}
