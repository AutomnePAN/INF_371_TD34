

public class UnionFind {
	public static int []equiv = new int [Percolation.length];	
	public static int []hauteur = new int [Percolation.length]; 
	public static void init()
	{
		for (int i = 0; i < Percolation.length; i++)
		{
			equiv[i] = i;
		}
	}
	
	public static void init_hauteur()
	{
		for (int i = 0; i < Percolation.length; i++)
		{
			hauteur[i] = 1;
		}
	}

	public static void union(int x, int y)
	{
		if(hauteur[x] > hauteur[y])
		{
			equiv[find(x)] = find(y);
			hauteur[x] ++;
		}
		else
		{
			equiv[find(y)] = find(x);
			hauteur[y] ++;
		}
//			
	}
	
	public static int find(int x)
	{
		int y = x;
		while(y != equiv[y])
		{
			equiv[y] = equiv[equiv[y]];
			y = equiv[y];
		}
		return y;
	}
	
	public static void print()
	{
		for(int i = 0 ; i < Percolation.size; i++)
		  {
			  for(int j = 0; j < Percolation.size; j++)
			  {
				 System.out.print(equiv[i * Percolation.size + j] + " ");
			  }
			  System.out.print("\n");
		  }
	}
	
	public static void print_hauteur()
	{
		for(int i = 0 ; i < Percolation.size; i++)
		  {
			  for(int j = 0; j < Percolation.size; j++)
			  {
				 System.out.print(hauteur[i * Percolation.size + j] + " ");
			  }
			  System.out.print("\n");
		  }
	}

}