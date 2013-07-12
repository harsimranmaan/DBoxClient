/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dboxclient;

/**
 *
 * @author Kuntal
 */
public class Client
{

    private String username;
    private String password;

    /**
     * @return the username
     */
    public Client(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
    }

    /**
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
}
