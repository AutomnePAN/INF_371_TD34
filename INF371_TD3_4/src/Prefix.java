
public class Prefix {
	String[] t;

	final static String start = "<START>", end = "<END>", par = "<PAR>";
	
	public Prefix(int n) {
		t = new String[n];
		for(int i = 0; i< n; i++)
		{
			t[i] = start;
		}
	
	}
	public void print_pf(int n)
	{
		for(int i = 0; i < n; i++)
		{
			System.out.println(t[i]);
		}
	}
	
	public static boolean eq(Prefix p1, Prefix p2)
	{
		if (p1.t.length != p2.t.length)
		{
			return false;
		}
		for(int i = 0; i < p1.t.length ; i++)
		{
			if (p1.t[i].equals(p2.t[i]))
			{ 
			}
			else
			{
				return false;
			}
		}
		return true;
	}
	
	Prefix addShift(String w)
	{
		int n = this.t.length;
		Prefix pf_r = new Prefix(n);
		for(int i = 0; i < n-1; i++)
		{
			pf_r.t[i] = this.t[i+1];
		}
		pf_r.t[n-1] = w;
		return pf_r;
	}
	
	public int hashCode()
	{
		int h = 0;
		for(int i = 0; i < this.t.length; i++) h = 37*h + this.t[i].hashCode();
		return h;
	}
	
	int hashCode(int n)
	{
		return this.hashCode() % n;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  	Prefix pf_1 = new Prefix(10);
	  	pf_1.print_pf(10);
	  	Prefix pf_2 = pf_1.addShift("<fuck!>");
	  	pf_2.print_pf(10);
	  	System.out.println(pf_1.hashCode(9));
	  
  }
}
