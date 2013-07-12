/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servertime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author Kuntal
 */
public class ServerTime
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        String DATEFORMAT = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String utcTime = sdf.format(new Date());
        System.out.println("UTC time is: " + utcTime);

    }
}
