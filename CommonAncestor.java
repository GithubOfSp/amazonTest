
public class CommonAncestor {
	static int getLevel(int a)
	{
		int ret = 0;
		int coef = 1;
		while(a>=0)
		{
			a -= coef;
			coef *= 3;
			ret++;
		}
		return ret;
	}
	static int getParent(int a)
	{
		int coef = 1;
		while(a>=0)
		{
			a -= coef;
			coef *= 3;
		}
		coef /= 3*3*3;
		a = -a-1;
		a /= 3;
		while(coef!=0)
		{
			a += coef;
			coef /= 3;
		}
		return a;
	}
	public static int solve(int a, int b)
	{
		if(a<b)
		{
			int temp = a;
			a = b;
			b = temp;
		}
		int levelDiff = getLevel(a)-getLevel(b);
		for(int i=0; i<levelDiff; i++)
		{
			a = getParent(a);
		}
		while(a!=b)
		{
			a = getParent(a);
			b = getParent(b);
		}
		return a;
	}
	
	public static void main(String[] args)
	{
		System.out.println(solve(10, 16));
	}
}
