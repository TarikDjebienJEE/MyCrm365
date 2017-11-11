package com.miage.crm365.model.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Exécution des requêtes
 *
 * Enfin, pour exécuter des requêtes sur notre base (ce qui est le but du DAO après tout), 
 * nous avons plusieurs possibilités:
 *
 * - Faire du pur SQL
 * - Utiliser les requêtes HQL
 * - Utiliser Criteria
 * 
 * Pour ma part, utiliser un ORM pour faire du SQL pur ne me plait pas trop (sauf en cas de besoin extrême), 
 * ce qui élimine la solution 1.
 *
 * HQL est un langage Hibernate de requête sur les objets fortement inspiré du SQL et 
 * qui permet de faire des choses très intéressantes sur les objets.
 *
 * Enfin Criteria permet de créer des requêtes en les composant avec des objets. 
 * Avec Criteria, le SQL est orienté objet. C’est la méthode que j’utilise dans cet exemple.
 *
 * Par exemple, pour récupérer l’ensemble des éléments d’une table, il suffit de faire:
 *
 * List list = sessionFactory.getCurrentSession().createCriteria(Personne.class).list();
 *
 * Et si je veux filtrer le résultat par nom des personnes:
 *
 * List list = sessionFactory.getCurrentSession().createCriteria(Personne.class)
 *             .add(Restrictions.like("name", "%" + name + "%")).list();
 *
 * Je ne rentrerais pas plus dans l’utilisation de Criteria dans cet article
 * mais je demande quand meme a Eric s'il est au courant de cet article ? 
 * C'est celui que t'a donné Antoine. 
 * 
 * @author tarik DJEBIEN
 */

/**
 * Classe abstraite permettant l'accès à HibernateDaoSupport
 * @author RAKOTOBE Sitraka Eric
 */
public abstract class CustomHibernateDaoSupport extends HibernateDaoSupport{
    
     /**
     * Méthode permettant de fournir une fabrique de session pour la creation de 
     * sessions spring
     * (etant donnee la declaration du bean pour la session dans ioc-context.xml
     * , ce setter permettra l'ioc qui se servira dans notre .xml)
     * @param sessionFactory la fabrique de session
     */
    @Autowired
    public void setAbstractSessionFactory(SessionFactory sessionFactory){
        this.setSessionFactory(sessionFactory);
    }
    
}