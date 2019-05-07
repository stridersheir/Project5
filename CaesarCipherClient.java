// A Java program for a CaesarCipherClient 
import java.net.*; 
import java.io.*; 
  
public class CaesarCipherClient 
{ 
    // initialize socket and input output streams 
    private Socket socket            = null; 
    private BufferedReader  input   = null; 
    private DataOutputStream out     = null; 
  
    // constructor to put ip address and port 
    public CaesarCipherClient(String address, int port) 
    { 
        // establish a connection 
        try
        { 
            socket = new Socket(address, port); 
            System.out.println("Connected"); 
  
            // takes input from terminal 
            input  = new BufferedReader(new InputStreamReader(System.in)); 
  
            // sends output to the socket 
            out    = new DataOutputStream(socket.getOutputStream()); 
        } 
        catch(UnknownHostException u) 
        { 
            System.out.println(u); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
  
        // string to read message from input 
        String line = ""; 
  
        // keep reading until "quit" is input 
        while (!line.equals("quit")) 
        { 
            try
            { 
                line = input.readLine(); 
                out.writeUTF(line); 
            } 
            catch(IOException i) 
            { 
                System.out.println(i); 
            } 
        } 
  
        // close the connection 
        try
        { 
            input.close(); 
            out.close(); 
            socket.close(); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
    } 
  
    public static void main(String args[]) 
    { 
        CaesarCipherClient client = new CaesarCipherClient(args[0], Integer.parseInt(args[1])); 
    } 
} 