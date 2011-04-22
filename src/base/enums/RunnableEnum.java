package base.enums;

public enum RunnableEnum implements Runnable {
	WHITE, BLACK, RED, YELLOW, BLUE;

	public void run() {
		System.out.println("name()=" + name() +", toString()=" + toString());
	}

}
