import java.util.Scanner;
public class PalindromicNumber {
	public static void main(String args[]) {
		int number = 0, d5, d4, d3, d2, d1;
		Scanner reader = new Scanner(System.in);
		number = reader.nextInt();
		reader.close();
		if (number >= 1 && number <= 99999) {
			//��number����ÿһλ����
			d5 = number / 10000;//��
			d4 = number % 10000 / 1000;
			d3 = number % 1000 / 100;
			d2 = number % 100 / 10;
			d1 = number % 10;
			if (d5 != 0) {System.out.println(d5+"��"+d4+"ǧ"+d3+"��"+d2+"ʮ"+d1);
				System.out.println("��5λ��");
				if (d1 == d5 && d2 == d4) {
					System.out.println("�ǻ�����");
				} else {
					System.out.println("���ǻ�����");
				}
			} else if (d4 != 0) {System.out.println(d4+"ǧ"+d3+"��"+d2+"ʮ"+d1);
				System.out.println("��4λ��");
				if (d1 == d4 && d2 == d3)
					System.out.println("�ǻ�����");
				else
					System.out.println("���ǻ�����");
			} else if (d3 != 0) {System.out.println(d3+"��"+d2+"ʮ"+d1);
				System.out.println("��3λ��");
				if (d1 == d3)
					System.out.println("�ǻ�����");
				else
					System.out.println("���ǻ�����");
			} else if (d2 != 0) {System.out.println(d2+"ʮ"+d1);
				System.out.println("��2λ��");
				if (d2 == d1)
					System.out.println("�ǻ�����");
				else
					System.out.println("���ǻ�����");
			} else if (d1 != 0) {System.out.println(d1);
				System.out.println( "��1λ��");
				System.out.println("�ǻ�����");
			}

		} else
			System.out.printf("\n%d����1��99999֮��", number);
	}
}
