import java.util.Arrays;
import java.util.Scanner;


public class PokerHandRanking {
	static int checkT(int[] a)
	{
		if(a[0]==a[1] && a[1]==a[2] && a[2]==a[3]) return 0;
		Arrays.sort(a);
		if(a[0]==1 && a[1]==11 && a[2]==12 && a[3]==13) return 1;
		if(a[0]+1==a[1] && a[1]+1==a[2] && a[2]+1==a[3]) return 2;
		if(a[0]==a[1] && a[1]==a[2] || a[1]==a[2] && a[2]==a[3]) return 3;
		if(a[0]==a[1] && a[2]==a[3]) return 4;
		if(a[0]==a[1] || a[1]==a[2] || a[2]==a[3]) return 5;
		return 6;
	}
	static int findDouble(int[] a)
	{
		for(int i=0; i<3; i++)
		{
			if(a[i]==a[i+1])
			{
				int temp = a[i];
				a[i]=0;
				a[i+1]=0;
				Arrays.sort(a);
				return temp;
			}
		}
		return 0;
	}
	public static int solve(int[] a, int[] b)
	{
		//check legal
		int[] cardsCount = new int[13];
		for(int i=0; i<4; i++)
		{
			cardsCount[a[i]-1]++;
			cardsCount[b[i]-1]++;
		}
		for(int i:cardsCount)
		{
			if(i>4) return -2;
		}
		int aT = checkT(a);
		int bT = checkT(b);
		if(aT<bT) return 1;
		if(aT>bT) return -1;
		if(aT==5)
		{
			int aD = findDouble(a);
			int bD = findDouble(b);
			if(aD>bD) return 1;
			if(aD<bD) return -1;
		}
		if(aT==6)
		{
			if(a[0]==1 && b[0]!=1) return 1;
			if(a[0]!=1 && b[0]==1) return -1;
		}
		for(int i=3; i>=0; i--)
		{
			if(a[i]==1 && b[i]!=1 || a[i]>b[i]) return 1;
			if(a[i]!=1 && b[i]==1 || a[i]<b[i]) return -1;
		}
		return 0;
	}
	public static void main(String[] args)
	{
//		Scanner in = new Scanner(System.in);
//		String line1 = in.nextLine();
//		String line2 = in.nextLine();
//		line1 = line1.replace("A", "1");
//		line1 = line1.replace("J", "11");
//		line1 = line1.replace("Q", "12");
//		line1 = line1.replace("K", "13");
//		line2 = line2.replace("A", "1");
//		line2 = line2.replace("J", "11");
//		line2 = line2.replace("Q", "12");
//		line2 = line2.replace("K", "13");
//		String[] split1 = line1.split(",");
//		String[] split2 = line2.split(",");
//		int[] a = new int[4];
//		int[] b = new int[4];
//		for(int i=0; i<4; i++)
//		{
//			a[i] = Integer.parseInt(split1[i]);
//			b[i] = Integer.parseInt(split2[i]);
//		}
		System.out.println(checkT(new int[]{3,3,8,1}));
	}
}
