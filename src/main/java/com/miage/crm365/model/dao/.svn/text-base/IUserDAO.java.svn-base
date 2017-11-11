package com.miage.crm365.model.dao;

import java.util.List;

import com.miage.crm365.model.entity.User;


/**
 * Interface IUserDAO permettant les transactions (insertion,suppression...d'un user)
 * @author RAKOTOBE Sitraka Eric
 */
public interface IUserDAO{

    /**
     * Méthode permettant l'insertion d'un utilisateur dans la table User
     * @param unUser
     */
    void save(User unUser);

    /**
     * Méthode permettant d'avoir la liste de tous les utilisateurs de la BDD
     * @return la liste de tous les utilisateurs
     */
    List<User> getAllUsers();

    /**
     * Méthode permettant de supprimer un utilisateur
     * @param unUser l'utilisateur a supprimer
     */
    void delete(User unUser);

    /**
     * Méthode permettant d'obtenir un utilisateur en fonction d'un username
     * @param userName le userName de l'utilisateur
     * @return l'utilisateur ayant comme userName celui en parametre
     */
    User getOneUserByUserName(String userName);

}