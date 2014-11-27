
public class SymmetricNumber {
    static String getNext(String a)
    {
        boolean carry = true;
        StringBuilder ret = new StringBuilder("");
        for(int i=a.length()-1; i>=0; i--)
        {
        	if(carry)
        	{
        		if(a.charAt(i)=='9')
        		{
        			ret.append("0");
        		}
        		else
        		{
        			char c = a.charAt(i);
        			ret.append((char)(c+1));
        			carry = false;
        		}
        	}
        	else
        	{
        		while(i>=0)
        		{
        			ret.append(a.charAt(i--));
        		}
        	}
        }
        if(carry) ret.append("1");
        return ret.reverse().toString();
    }
    static boolean bigger(String a, String b)
    {
    	if(a.length()>b.length()) return true;
    	if(a.length()<b.length()) return false;
    	for(int i=0; i<a.length(); i++)
    	{
    		if(a.charAt(i)>b.charAt(i)) return true;
    		if(a.charAt(i)<b.charAt(i)) return false;
    	}
    	return false;
    }
    public static String solve(String a)
    {
    	String half = a.substring(0, a.length()/2);
    	String b = half+(a.length()%2==1?a.charAt(a.length()/2):"")+new StringBuilder(half).reverse().toString();
    	if(bigger(b, a)) return b;
    	half = getNext(half+(a.length()%2==1?a.charAt(a.length()/2):""));
    	b = new StringBuilder(half).reverse().toString();
    	return half+(a.length()%2==1?b.substring(1):b);
    }
    public static void main(String[] args)
    {
    	System.out.println(solve("398"));
    }
}
