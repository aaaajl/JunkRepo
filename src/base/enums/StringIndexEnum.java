package base.enums;

import java.util.EnumSet;

public enum StringIndexEnum {
	WHITE("white"), BLACK("black"), RED("red"), YELLOW("yellow"), BLUE("blue");

	 private String value;

	 private StringIndexEnum(String value) {
	   this.value = value;
	 }

	 public String getValue() {
	   return value;
	 }
	 
	 
	 @Override
	public String toString() {
		return value;
	}

	public static StringIndexEnum getByValue(String value){
		 StringIndexEnum rtnValue = null;
		 for(StringIndexEnum e : EnumSet.allOf(StringIndexEnum.class)){
			 if(e.getValue().equals(value))
			 {
				 rtnValue = e;
			 }
		 }
		 return rtnValue;
	 }
}
