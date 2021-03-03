package 日历;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;




public class CalendarMainClass {
	public static void main(String args[]){
		CalendarFrame frame=new CalendarFrame();
		frame.setBounds(100, 100, 360, 300);
		frame.setVisible(true);
		frame.setTitle("src/日历");
		Date date=new Date();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(simpleDateFormat.format(date));
		Calendar cal = Calendar.getInstance();
//		********************************
		int year = cal.get(Calendar.YEAR);//获取年份
		int month=cal.get(Calendar.MONTH)+1;
		System.out.println(year+""+month);
		frame.setYearAndMonth(year,month);
	}
}
