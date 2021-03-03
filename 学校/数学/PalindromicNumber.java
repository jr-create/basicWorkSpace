import java.util.Scanner;
public class PalindromicNumber {
	public static void main(String args[]) {
		int number = 0, d5, d4, d3, d2, d1;
		Scanner reader = new Scanner(System.in);
		number = reader.nextInt();
		reader.close();
		if (number >= 1 && number <= 99999) {
			//求number数的每一位的数
			d5 = number / 10000;//万
			d4 = number % 10000 / 1000;
			d3 = number % 1000 / 100;
			d2 = number % 100 / 10;
			d1 = number % 10;
			if (d5 != 0) {System.out.println(d5+"万"+d4+"千"+d3+"百"+d2+"十"+d1);
				System.out.println("是5位数");
				if (d1 == d5 && d2 == d4) {
					System.out.println("是回文数");
				} else {
					System.out.println("不是回文数");
				}
			} else if (d4 != 0) {System.out.println(d4+"千"+d3+"百"+d2+"十"+d1);
				System.out.println("是4位数");
				if (d1 == d4 && d2 == d3)
					System.out.println("是回文数");
				else
					System.out.println("不是回文数");
			} else if (d3 != 0) {System.out.println(d3+"百"+d2+"十"+d1);
				System.out.println("是3位数");
				if (d1 == d3)
					System.out.println("是回文数");
				else
					System.out.println("不是回文数");
			} else if (d2 != 0) {System.out.println(d2+"十"+d1);
				System.out.println("是2位数");
				if (d2 == d1)
					System.out.println("是回文数");
				else
					System.out.println("不是回文数");
			} else if (d1 != 0) {System.out.println(d1);
				System.out.println( "是1位数");
				System.out.println("是回文数");
			}

		} else
			System.out.printf("\n%d不在1至99999之间", number);
	}
}
