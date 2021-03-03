package 案例;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner =new Scanner(System.in);
       int a=scanner.nextInt();
       int arr[]=new int[a];
       for(int i=1;i<=a;i++)
    	   arr[i-1]=i;
        fullSort(arr, 0, arr.length - 1);
    }

    public static void fullSort(int[] arr, int start, int end) {
        // 递归终止条件
        if (start == end) {	
            for (int i : arr) {
                System.out.print(i);
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(arr, i, start);
            fullSort(arr, start + 1, end);
            swap(arr, i, start);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
//public class Main {
//	public static void main(String[] args) {
////		System.out.println("Hello World.");
////		Scanner i=new Scanner(System.in);
////		int a=i.nextInt();
//////		System.out.println((a>=90?"A":(89>a&&a>60)?"B":"C"));
////		System.out.println((a>=90?'A':(89>a&&a>60)?'B':'C'));
////		99乘法表
////		for(int i=1;i<10;i++) {
////			for (int j=1;j<=i;j++) {
////				System.out.printf("%d*%d=%d",i,j,i*j);
////				System.out.print('\t');
////			}
////			System.out.print('\n');
////		}
////		题目1
////		Scanner scanner=new Scanner(System.in);
////		int a=scanner.nextInt();
////		System.out.println(Integer.MIN_VALUE+a-1);
///**
// * 题目二
// *
//// */
////		Scanner scanner=new Scanner(System.in);
////		int num=scanner.nextInt();
////		scanner.nextLine();
////		String[] a = new String [num];
////		for(int i=0;i<num;i++) {
////			 a[i]=scanner.nextLine();
////		}
////		int ch[]=new int[num];
////		int En[]=new int[num];
////		int en[]=new int[num];
////		int nu[]=new int[num];
////		int qt[]=new int[num];
////		
////		for(int i=0;i<num;i++) {
////		
////			for(int j=0;j<a[i].length();j++) {
////				int n = (int)a[i].charAt(j);
////				
////				if(19968<=n&&n<40869) {
////					ch[i]++;
////					
////				}
////				else if(65<=n&&n<91) {
////					En[i]++;
////		
////				}
////				else if(97<=n&&n<123) {
////					en[i]++;
////					
////				}
////				else if(48<=n&&n<=57) {
////					nu[i]++;
////					
////				}else {
////					qt[i]++;
////					
////				}
////			}
////			int su=0;
////			if(ch[i]!=0) {
////				su++;
////			} if(En[i]!=0) {
////				su++;
////			} if(en[i]!=0) {
////				su++;
////			} if(nu[i]!=0) {
////				su++;
////			} if(qt[i]!=0) {
////				su++;
////			}
////			System.out.println(su+" "+ch[i]+" "+En[i]+" "+en[i]+" "+nu[i]+" "+qt[i]);
////		}
//		
//
//		/**
//		 * 题目三
//		 */
////		Scanner scanner=new Scanner(System.in);
////		int end=scanner.nextInt();
////		int sum=0;
////		while(end!=0) {
////			sum+=end;
////			end--;
////		}
////		System.out.println(sum);
//		/**
//		 * 
//		 * 题目四
//		 */
////		Scanner scanner=new Scanner(System.in);
////		int num[]=new int[5];
////		for(int i=0;i<5;i++) {
////			num[i]=scanner.nextInt();
////		}
////		Arrays.sort(num);
////		for(int i=0;i<5;i++)
////			System.out.println(num[i]);
//	/**
//	 * 1002 过河卒
//	 */
//	/**\
//	 * 水桶的最大面积
//	 */
////		Scanner scanner =new Scanner(System.in);
////		int a[]=new int [9];
////		for(int i=0;i<9;i++) {
////			a[i]=scanner.nextInt();
////		}
////		System.out.println(getMaxArea(a));
//		System.out.println(Jump(5)+"");
//		rec(10);
//	}
////	int ghz() {
////		Scanner scanner=new Scanner(System.in);
////		int h_x=scanner.nextInt(),h_y=scanner.nextInt();
////		if(h_x>20||h_x<0&&h_y>20||h_y<0) {
////			return 0;
////		}else {
////			
////		}
////	}
//	public static int getMaxArea(int[] a){
//		int hg = a.length;//数组长度
//		int left = 0;
//		int right = hg-1;
//		//寻找最大面积
//		int x = right - left + 1;//长方形的长度
//		int y = Math.min(a[left], a[right]);
//		int area = x*y;
//		while(left != right){
//			if(a[right] >= a[left]){//左边大于右边 每次要移动高度比较小的那个 才有可能让面积增大
//				left = left + 1;
//			}else{
//				right = right - 1;
//			}
//			x = right - left;
//			y = Math.min(a[left], a[right]);
//			int temp = x*y;
//			if(temp > area){
//				area = temp;
//			}
//		}
//		return area;
//	}
//	static long  Jump(int n)
//	{
//	    if (n == 0) return 0;
//	    if (n == 1) return 1;
//	    if (n == 2) return 2;
//	    System.out.println(n);
//	    return Jump(n - 1) + Jump(n - 2);
//	}
//
//	long  Jump1(int n, long  count[])/*count数组初始值全部设为0*/
//	{
//	    if (n == 0) return 0;
//	    if (n == 1) return 1;
//	    if (n == 2) return 2;
//
//	    if (count[n] == 0)
//	        count[n] = Jump1(n - 1, count) + Jump1(n - 2, count);
//	    else
//	        return count[n];
//
//	    return count[n];
//	}
//}
