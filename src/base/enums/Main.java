package base.enums;


public class Main {
public static void main(String[] args) {
	System.out.println("----------Print out by BaseEnum----------");
	for(BaseEnum e: BaseEnum.values())
	{
		System.out.println(e.toString());
	}
	System.out.println("----------Print out by IndexEnum----------");
	for(IndexEnum e: IndexEnum.values())
	{
		System.out.println(e.toString()+" "+e.getCode());
	}
	System.out.println("----------Print out by StringIndexEnum----------");
	for(StringIndexEnum e: StringIndexEnum.values())
	{
		System.out.println(e.toString()+" "+e.getValue());
	}
	StringIndexEnum se = StringIndexEnum.getByValue("black");
	System.out.println(se.toString());
	System.out.println("----------Print out by StringIndexEnum----------");
	for(RunnableEnum e: RunnableEnum.values())
	{
		e.run();
	}
}
}
