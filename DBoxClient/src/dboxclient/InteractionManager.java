/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dboxclient;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Kuntal
 */
public class InteractionManager
{

    private String filePath;
    private Scanner scan;
    private Client client;
    Console console = System.console();
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public InteractionManager() throws IOException
    {
        System.out.println("------------------------------------------------------");
        System.out.println("|             Welcome to dypen Stock Exchange        |");
        System.out.println("------------------------------------------------------");
        System.out.println("");
        scan = new Scanner(System.in);
        System.out.println("User Name:");
        client = new Client((scan.nextLine()));
        System.out.println("Password:");
        String pw = in.readLine();
        client.setPassword(pw);
        // client.setPassword((scan.nextLine()));
    }

    public void Authenticate()
    {

        System.out.println("Enter the path of the dirctory to sync with our cloud service");
        System.out.println("" + client.getUsername() + ">");
    }
}
