package base.nio;

import java.lang.reflect.Method;

public class ViewByteBuffer {

	public static void foo(String... ss) {
		System.out.println(ss[0]);
	}

	public static void goo(String ss) {
		System.out.println(ss);
	}

	public static void main(String[] args) {
		Class clazz = ViewByteBuffer.class;
		try {
			Method method = clazz.getMethod("foo", String[].class);
			method.invoke(new ViewByteBuffer(), new Object[] { new String[] { "a", "s", "d" } });
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
