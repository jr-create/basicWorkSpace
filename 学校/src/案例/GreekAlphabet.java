package ����;

public class GreekAlphabet {
	public static void main(String args[]){
		int startPosition=0,endPosition=0;
		char cStart='��',cEnd='��';
		startPosition=(int)cStart;
		endPosition=(int)cEnd;
		System.out.println("ϣ����ĸ\'��'��unicode���е�˳��λ��:"+startPosition);
		System.out.println("ϣ����ĸ\'��'��unicode���е�˳��λ��:"+endPosition);
		for(int i=startPosition;i<=endPosition;i++){
			char c='\0';
			c=(char)i;
			System.out.print(" "+c);
			if((i-startPosition+1)%10==0)
				System.out.println("");
			
		}
	}
}
