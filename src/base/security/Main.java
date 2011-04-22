package base.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.sun.org.apache.xml.internal.security.algorithms.MessageDigestAlgorithm;

public class Main {

	public static void main(String[] args) {
		int a = 0x61c88647;
		System.out.println(a & 4);
		try {
			MessageDigest md = MessageDigest.getInstance(MessageDigestAlgorithm.ALGO_ID_DIGEST_NOT_RECOMMENDED_MD5);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
