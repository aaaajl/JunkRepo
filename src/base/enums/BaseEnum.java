package base.enums;

public enum BaseEnum {
	WHITE, BLACK, RED{
		public String toString(){return "AAAA RED";}
	}, YELLOW, BLUE;
	@Override public String toString(){
		String s = super.toString();
		return "Override "+s;
	}
}
