package ����;
import java.util.Scanner;
import java.util.Random;
public class GuessNumber {
	public static void main(String args[]){
		Scanner reader=new Scanner(System.in);
		Random random=new Random();
		System.out.println("����һ��1��100֮�������,��²������");
		int realNumber=random.nextInt(100)+1;
		int yourGuess=0;
		System.out.println("��������Ĳ²�");
		yourGuess=reader.nextInt();
		while(yourGuess!=realNumber){
			if(yourGuess>realNumber){
				System.out.println("�´���,��������Ĳ²�");
				yourGuess=reader.nextInt();
			}
			else if(yourGuess<realNumber){
				System.out.println("��С��,��������Ĳ²�");
				yourGuess=reader.nextInt();
			}
		}
		reader.close();
		System.out.println("�¶���");
	}
}
