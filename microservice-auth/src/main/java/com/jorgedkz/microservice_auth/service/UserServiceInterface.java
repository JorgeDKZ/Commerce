package com.jorgedkz.microservice_auth.service;

import com.jorgedkz.microservice_auth.entities.User;
import com.jorgedkz.microservice_auth.entities.DTO.UserBuffer;

/**
 * @author JorgeDKZ
 * Interface that defines the methods of the UserService
 */
public interface UserServiceInterface {

    /**
     * Encode the password of a user
     * @param user the user to encode
     * @return the user with the encoded password
     */
    public UserBuffer encodeUserBufferPassword(UserBuffer user);
    /**
     * Save a user in the database
     * @param user the user to save
     * @return true if the user was saved, false if the user already exists
     */
    public boolean saveUser(UserBuffer user);

    /**
     * Find a user by its userName
     * @param userName the userName of the user to find
     * @return the user found or null if the user does not exist
     */
    public User findByUserName(String userName);

    /**
     * Validate if the userName and password are correct
     * @param user the user to validate
     * @return true if the userName and password are correct, false if the user don´t exist or the password is incorrect
     */
    public boolean validateUser(UserBuffer user);

    /**
     * Delete a user by its userName
     * @param userName the userName of the user to delete
     * @return true if the user was deleted, false is the user does not exist
     */
    public boolean deleteUser(String userName);

    /**
     * Delete a user by its userName and password
     * @param userName the userName of the user to delete
     * @param password the password of the user to delete
     * @return true if the user was deleted, false is the user does not exist or the password is incorrect
     */
    public boolean deleteUserByPassword(UserBuffer user);

    /**
     * Get the roles of a user by its userName
     * @param userName the userName of the user
     * @return the roles of the user
     */
    public String[] getRoles(String userName);

    /**
     * Check if a user has a specific role
     * @param userName the userName of the user
     * @param role the role to check
     * @return true if the user has the role, false if the user does not have the role or the user does not exist
     */
    public boolean userHasRole(String userName, String role);
}
