/**
 * 
 */
package base.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @author fanghui.jl
 *
 */
public class IoTest {

	public static String fileName = "";

	public void readFrombyte() {
		try {
			FileInputStream fis = new FileInputStream(fileName);
			int cnt = 0;
			int b;
			while ((b = fis.read()) != -1) {
				if (b == '\n')
					cnt++;
			}
			fis.close();
			System.out.println(cnt);
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public void readFromInputBuffer() {
		try {
			FileInputStream fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);
			int cnt = 0;
			int b;
			while ((b = bis.read()) != -1) {
				if (b == '\n')
					cnt++;
			}
			bis.close();
			System.out.println(cnt);
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public void readFromDirectBuffer() {
		try {
			FileInputStream fis = new FileInputStream(fileName);
			byte buf[] = new byte[2048];
			int cnt = 0;
			int n;
			while ((n = fis.read(buf)) != -1) {
				for (int i = 0; i < n; i++) {
					if (buf[i] == '\n')
						cnt++;
				}
			}
			fis.close();
			System.out.println(cnt);
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public void disableLineBuffer() {
		FileOutputStream fdout = new FileOutputStream(FileDescriptor.out);
		BufferedOutputStream bos = new BufferedOutputStream(fdout, 1024);
		PrintStream ps = new PrintStream(bos, false);

		System.setOut(ps);

		final int N = 100000;

		for (int i = 1; i <= N; i++)
			System.out.println(i);

		ps.close();
	}

	public void readWriteFile() {
		try {
			FileInputStream fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);
			DataInputStream dis = new DataInputStream(bis);
			int cnt = 0;
			while (dis.readLine() != null)
				cnt++;
			dis.close();
			System.out.println(cnt);
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public void write() {
		try {
			FileOutputStream fos = new FileOutputStream("out2");
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF8");
			PrintWriter pw = new PrintWriter(osw);
			pw.println("\uffff\u4321\u1234");
			pw.close();
		} catch (IOException e) {
			System.err.println(e);
		}
	}


	public static void main(String[] args) {
		IoTest t = new IoTest();
		t.write();
	}
}
