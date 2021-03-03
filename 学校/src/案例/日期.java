package 案例;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class 日期 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Date now=new Date();
		SimpleDateFormat d2=new SimpleDateFormat("yyyy-MM-dd");
		String birth=d2.format(now);
		System.out.println(birth);
		System.out.println(now);
//		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);//获取年份
		System.out.println(year);
	}

}

