/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socketclient;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Kuntal
 */
public class SocketClient
{

    Socket socket = null;
    Socket socket1 = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
    }
    // create send method

    public void sendFile() throws IOException
    {

        String host = "127.0.0.1";
        String host1 = "127.0.0.2";

        socket = new Socket(host, 4444);
        socket1 = new Socket(host1, 444);

        File file = new File("/home/reza/Desktop/link help");
        File file1 = new File("/home/reza/Desktop/hi");
        long length = file.length();
        long length1 = file1.length();
        byte[] bytes = new byte[(int) length];
        byte[] bytes1 = new byte[(int) length1];

        FileInputStream fis = new FileInputStream(file);
        FileInputStream fis1 = new FileInputStream(file1);

        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
        BufferedInputStream bis1 = new BufferedInputStream(fis1);
        BufferedOutputStream out1 = new BufferedOutputStream(socket1.getOutputStream());

        int count;
        int count1;


        while ((count = bis.read(bytes)) > 0)
        {
            out.write(bytes, 0, count);

        }
        while ((count1 = bis1.read(bytes1)) > 0)
        {
            out1.write(bytes1, 0, count1);

        }


        Thread t = new Thread(new Runnable()
        {
            public void run()
            {
                while (socket.isConnected())
                {

                    Wait2();


                    try
                    {
                        sendFile();
                    }
                    catch (IOException e)
                    {

                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t1 = new Thread(new Runnable()
        {
            public void run()
            {
                while (socket1.isConnected())
                {

                    Wait2();


                    try
                    {
                        sendFile();
                    }
                    catch (IOException e)
                    {

                        e.printStackTrace();
                    }
                }

            }
        });
        t.start();
        t1.start();

        fis.close();
        fis1.close();

        out.close();
        bis.close();
        out1.close();
        bis1.close();
        socket.close();
        socket1.close();
    }

    public void Wait2()
    {


        try
        {

            Thread.currentThread().sleep(3000);

        }
        catch (InterruptedException x)
        {

            System.out.println("Interrupted!");

        }

    }
}
