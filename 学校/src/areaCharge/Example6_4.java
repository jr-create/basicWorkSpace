package areaCharge;

interface CompureAverage {
	public void average();
}

class A implements CompureAverage {
	public void average() {
		double a = 8;
		double b = 9;
		double aver = 0;
		aver = (a + b) / 2;
		System.out.println(aver);
	}
}

class B implements CompureAverage {
	public void average() {
		double a = 8;
		double b = 6;
		double aver = 0;
		aver = Math.sqrt(a * b);
		System.out.println(aver);
	}
}

class Kind {
	public void average(CompureAverage aver) {

		aver.average();
	}
}

public class Example6_4 {
	public static void main(String args[]) {
		Kind kind = new Kind();
		kind.average(new A());
		kind.average(new B());
	}
}
