/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dboxclient;

/**
 *
 * @author Kuntal
 */
public class DBoxClient
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        try
        {
            InteractionManager interact = new InteractionManager();
            interact.Authenticate();
        }
        catch (Exception ex)
        {
            System.out.println("Exception:" + ex.getMessage());
        }
    }
}
