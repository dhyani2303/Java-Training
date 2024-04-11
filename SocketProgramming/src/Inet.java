package SocketProgramming.src;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Inet
{
    public static void main(String[] args)
    {
        InetAddress inetAddress = null;
        try
        {
            inetAddress = InetAddress.getByName("10.20.40.128");
            inetAddress = InetAddress.getLocalHost();
            System.out.println(inetAddress);
            System.out.println(inetAddress.getCanonicalHostName());
            System.out.println(inetAddress.getHostAddress());

        } catch(UnknownHostException e)
        {
            throw new RuntimeException(e);
        }

        System.out.println(inetAddress);
    }
}
