/**
 * 
 */
package base.constantspool;


/**
 * @author lj04482
 *
 */
public class Main {

	public static void ConstantsPool_String()
	{
		System.out.println("---------------Constants Pool String----------");
		String a = "SleepingBueaty";
		String b = "SleepingBueaty";
		String c = new String("SleepingBueaty");
		System.out.format("a==b?%s%n", a==b);
		System.out.format("a==c?%s%n", a==c);
		System.out.format("a==SleepingBueaty?%s%n", a=="SleepingBueaty");
	}
	
	public static void ConstantsPool_Double(){
		System.out.println("---------------Constants Pool Double----------");
		double value = 1d;
		Double a = value;
		Double b = value;
		Double c = Double.valueOf(value);
		Double d = Double.valueOf(""+value);
		System.out.format("a==b?%s%n", a==b);
		System.out.format("a==c?%s%n", a==c);
		System.out.format("a==d?%s%n", a==d);
		System.out.format("c==d?%s%n", c==d);
	}
	
	public static void ConstantsPool_Long(){
		System.out.println("---------------Constants Pool Long----------");
		long value = 127l;
		Long a = value;
		Long b = value;
		Long c = Long.valueOf(value);
		Long d = Long.valueOf(""+value);
		System.out.format("a==b?%s%n", a==b);
		System.out.format("a==c?%s%n", a==c);
		System.out.format("a==d?%s%n", a==d);
		System.out.format("c==d?%s%n", c==d);
	}
	
	public static void ConstantsPool_Float(){
		System.out.println("---------------Constants Pool Float----------");
		float value = 1l;
		Float a = value;
		Float b = value;
		Float c = Float.valueOf(value);
		Float d = Float.valueOf(""+value);
		System.out.format("a==b?%s%n", a==b);
		System.out.format("a==c?%s%n", a==c);
		System.out.format("a==d?%s%n", a==d);
		System.out.format("c==d?%s%n", c==d);
	}
	
	public static void ConstantsPool_Integer(){
		System.out.println("---------------Constants Pool Integer----------");
		int value = 1;
		Integer a = value;
		Integer b = value;
		Integer c = Integer.valueOf(value);
		Integer d = Integer.valueOf(""+value);
		System.out.format("a==b?%s%n", a==b);
		System.out.format("a==c?%s%n", a==c);
		System.out.format("a==d?%s%n", a==d);
		System.out.format("c==d?%s%n", c==d);
	}
	
	public static void ConstantsPool_Char(){
		System.out.println("---------------Constants Pool Char----------");
		char value = 127;
		Character a = value;
		Character b = value;
		Character c = Character.valueOf(value);
		System.out.format("a==b?%s%n", a==b);
		System.out.format("a==c?%s%n", a==c);
	}
	
	public static void ConstantsPool_Short(){
		System.out.println("---------------Constants Pool Short----------");
		short value = 127;
		Short a = value;
		Short b = value;
		Short c = Short.valueOf(value);
		Short d = Short.valueOf(""+value);
		System.out.format("a==b?%s%n", a==b);
		System.out.format("a==c?%s%n", a==c);
		System.out.format("a==d?%s%n", a == c);
		System.out.format("c==d?%s%n", c==d);
	}
	
	public static void ConstantsPool_Byte(){
		System.out.println("---------------Constants Pool Byte----------");
		byte value = 127;
		Byte a = value;
		Byte b = value;
		Byte c = Byte.valueOf(value);
		Byte d = Byte.valueOf(""+value);
		System.out.format("a==b?%s%n", a==b);
		System.out.format("a==c?%s%n", a==c);
		System.out.format("a==d?%s%n", a == c);
		System.out.format("c==d?%s%n", c==d);
	}
	
	public static void main(String[] args) {
		Main.ConstantsPool_String();
		Main.ConstantsPool_Double();
		Main.ConstantsPool_Long();
		Main.ConstantsPool_Float();
		Main.ConstantsPool_Integer();
		Main.ConstantsPool_Short();
		Main.ConstantsPool_Byte();
		Main.ConstantsPool_Char();
	}
}
