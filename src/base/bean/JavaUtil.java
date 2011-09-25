/**
 * 
 */
package base.bean;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * @author aaaajl
 *
 */
public class JavaUtil{
    public static String getPID() throws IOException{
        String pid = System.getProperty("pid"); //NOI18N
        if(pid==null){
            String cmd[];
            File tempFile = null;
            if(System.getProperty("os.name").toLowerCase().indexOf("windows")==-1)
                cmd = new String[]{ "/bin/sh", "-c", "echo $$ $PPID" }; //NOI18N
            else{
                // getpids.exe is taken from http://www.scheibli.com/projects/getpids/index.html (GPL)
                tempFile = File.createTempFile("getpids", "exe"); //NOI18N
                // extract the embedded getpids.exe file from the jar and save it to above file
                IOUtil.pump(JavaUtil.class.getResourceAsStream("getpids.exe"), new FileOutputStream(tempFile), true, true); //NOI18N
                cmd = new String[]{ tempFile.getAbsolutePath() };
            }
            if(cmd!=null){
                Process p = Runtime.getRuntime().exec(cmd);
                ByteArrayOutputStream bout = new ByteArrayOutputStream();
                IOUtil.pump(p.getInputStream(), bout, false, true);
                if(tempFile!=null)
                    tempFile.delete();

                StringTokenizer stok = new StringTokenizer(bout.toString());
                stok.nextToken(); // this is pid of the process we spanned
                pid = stok.nextToken();
                if(pid!=null)
                    System.setProperty("pid", pid); //NOI18N
            }
        }
        return pid;
    }

    public static void main(String[] args) throws IOException{
        System.out.println(getPID());
    }
}
