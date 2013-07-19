/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Kuntal
 */
public class Hash implements Serializable
{

    File clientLog;
    HashMap<String, String> clientMap = new HashMap<>();
    HashMap<String, String> serverMap = new HashMap<>();
    HashMap<String, String> tempMap = new HashMap<>();
    HashMap<String, String> conflict = new HashMap<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        // TODO code application logic here
 /*
         * HashMap map = new HashMap(); map.put("1", new Integer(1));
         * map.put("2", new Integer(1)); map.put("3", new Integer(1)); File file
         * = new File("data.dat"); if (!file.exists()) { FileOutputStream fos =
         * new FileOutputStream(file); ObjectOutputStream oos = new
         * ObjectOutputStream(fos); oos.writeObject(map); oos.flush();
         * oos.close(); System.out.println(map); } else { FileInputStream fis =
         * new FileInputStream(file); ObjectInputStream ois = new
         * ObjectInputStream(fis); Map anotherMap = (Map) ois.readObject();
         * ois.close();
         *
         * FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream
         * oos = new ObjectOutputStream(fos); anotherMap.putAll(map);
         * oos.writeObject(map); oos.flush(); oos.close();
         * System.out.println(anotherMap); } //if (!(file.exists()))
         */
        Hash h1 = new Hash();
        h1.initialize();
    }

    public void initialize() throws IOException, ClassNotFoundException
    {
        clientMap.put("Kuntal.txt", "23434@eee34343pi4i34");
        clientMap.put("abc.doc", "23434@eee34343pi4i34");
        clientMap.put("Kuntal.html", "23434@eee34343pi4i34");
        clientMap.put("Kuntalpk.php", "97777");
        clientMap.put("Kuntalpk.kk", "dddddddddddddddddddddd");



        clientLog = new File(".dblike");
        if (!clientLog.exists())
        {
            writeClientLog();
            System.out.println("" + clientMap);
        }
        else
        {

            readClientLog();

            mergeHashes();
            tempMap.putAll(clientMap);
            System.out.println(tempMap);


            writeClientLog();
        }
    }

    public void writeClientLog() throws IOException
    {
        FileOutputStream fos = new FileOutputStream(clientLog);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        //anotherMap.putAll(map);
        oos.writeObject(clientMap);
        oos.flush();
        oos.close();
    }

    public void readClientLog() throws IOException, ClassNotFoundException
    {
        FileInputStream fis = new FileInputStream(clientLog);
        ObjectInputStream ois = new ObjectInputStream(fis);
        tempMap = (HashMap<String, String>) ois.readObject();
        ois.close();
    }

    public void mergeHashes()
    {
        if (!tempMap.isEmpty())
        {
            for (String filename : clientMap.keySet())
            {
                String compareHash = tempMap.get(filename);
                if (compareHash != clientMap.get(filename))
                {
                    conflict.put(filename, null);
                    //                    clientMap.put(filename, clientMap.get(filename));
                    //                    tempMap.remove(filename);

                }
            }
        }
    }
}
