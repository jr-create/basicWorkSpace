package ����;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ���� {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Date now=new Date();
		SimpleDateFormat d2=new SimpleDateFormat("yyyy-MM-dd");
		String birth=d2.format(now);
		System.out.println(birth);
		System.out.println(now);
//		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);//��ȡ���
		System.out.println(year);
	}

}

