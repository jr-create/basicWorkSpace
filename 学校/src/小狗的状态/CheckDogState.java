package С����״̬;


interface DogState {
	public void showState();
}

class SoftlyState implements DogState {
	public void showState() {
		System.out.println("�����˵�����");
	}
}

class MeetEnemyState implements DogState {
	public void showState() {
		System.out.println("��У�������ȥ��ҧ����");
	}
}

class MeetFriendState implements DogState {
	public void showState() {
		System.out.println("�ζ�β�ͣ���ʾ��ӭ");
	}
}

class MeetAnotherDog implements DogState {
	public void showState() {
		System.out.println("��Ϸ");
	}
}

class Dog {
	DogState state;

	public void show() {
		state.showState();
	}

	public void setState(DogState s) {
		state = s;
	}
}
public class CheckDogState {
	public static void main(String args[]) {
		Dog yellowDog = new Dog();
		System.out.println("����������ǰ��");
		yellowDog.setState(new SoftlyState());
		yellowDog.show();
		System.out.println("���������ˣ�");
		yellowDog.setState(new MeetEnemyState());
		yellowDog.show();
		System.out.println("���������ѣ�");
		yellowDog.setState(new MeetFriendState());
		yellowDog.show();
		System.out.println("������ͬ�飺");
		yellowDog.setState(new MeetAnotherDog());
		yellowDog.show();
	}
}
