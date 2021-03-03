package areaCharge;

abstract class MotorVehicles {
	abstract void brake();
}

interface MoneyFare {
	void charge();
}

interface ControlTemperature {
	void ControlAirTemperature();
}

interface Frame{
	void frame();
}
class Bus extends MotorVehicles implements MoneyFare {
	void brake() {
		System.out.println("公共汽车使用刹车技术");
	}

	public void charge() {
		System.out.println("公共汽车:一元一张，不计算公里数");
	}
}

class Taxi extends MotorVehicles implements MoneyFare, ControlTemperature,Frame {
	void brake() {
		System.out.println("出租车使用盘式刹车技术");
	}

	public void frame(){
		System.out.println("Taxi的外壳时蓝色的");
	}
	public void charge() {
		System.out.println("出租车:2元/公里，起价5元3公里");
	}

	public void ControlAirTemperature() {
		System.out.println("出租车安装了hair空调");
	}
}

class Cinema implements MoneyFare, ControlTemperature {
	public void charge() {
		System.out.println("电影院：门票，十元一张");
	}

	public void ControlAirTemperature() {
		System.out.println("电影院安装了中央空调");
	}
}

public class Example6_3 {
	public static void main(String args[]) {
		
		Bus bus101 = new Bus(); // Bus 对象
		System.out.println(bus101 instanceof MotorVehicles);
		Taxi buleTaxi = new Taxi();// Taxi 对象
		Cinema redStarCinema = new Cinema();// Cinema 对象
		MoneyFare fare; // 接口变量
		ControlTemperature temperature; // 接口变量
		Frame f;
		fare = bus101; // 接口回调
		bus101.brake();// 继承抽象方法
		fare.charge();
		fare = buleTaxi;
		temperature = buleTaxi;
		f =buleTaxi;
		f.frame();
		buleTaxi.brake();
		fare.charge();
		temperature.ControlAirTemperature();
		fare = redStarCinema;
		temperature = redStarCinema;
		fare.charge();
		temperature.ControlAirTemperature();
	}
}
