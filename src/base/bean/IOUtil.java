/**
 * 
 */
package base.bean;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author aaaajl
 *
 */
public class IOUtil{
    public static void pump(InputStream in, OutputStream out, boolean closeIn, boolean closeOut) throws IOException{
        byte[] bytes = new byte[1024];
        int read;
        try{
            while((read=in.read(bytes))!= -1)
                out.write(bytes, 0, read);
        }finally{
            if(closeIn)
                in.close();
            if(closeOut)
                out.close();
        }
    }
}