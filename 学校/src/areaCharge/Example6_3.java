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
		System.out.println("��������ʹ��ɲ������");
	}

	public void charge() {
		System.out.println("��������:һԪһ�ţ������㹫����");
	}
}

class Taxi extends MotorVehicles implements MoneyFare, ControlTemperature,Frame {
	void brake() {
		System.out.println("���⳵ʹ����ʽɲ������");
	}

	public void frame(){
		System.out.println("Taxi�����ʱ��ɫ��");
	}
	public void charge() {
		System.out.println("���⳵:2Ԫ/������5Ԫ3����");
	}

	public void ControlAirTemperature() {
		System.out.println("���⳵��װ��hair�յ�");
	}
}

class Cinema implements MoneyFare, ControlTemperature {
	public void charge() {
		System.out.println("��ӰԺ����Ʊ��ʮԪһ��");
	}

	public void ControlAirTemperature() {
		System.out.println("��ӰԺ��װ������յ�");
	}
}

public class Example6_3 {
	public static void main(String args[]) {
		
		Bus bus101 = new Bus(); // Bus ����
		System.out.println(bus101 instanceof MotorVehicles);
		Taxi buleTaxi = new Taxi();// Taxi ����
		Cinema redStarCinema = new Cinema();// Cinema ����
		MoneyFare fare; // �ӿڱ���
		ControlTemperature temperature; // �ӿڱ���
		Frame f;
		fare = bus101; // �ӿڻص�
		bus101.brake();// �̳г��󷽷�
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
