
public class Percolation {
	
	  public static int size = 100;
	  public static int length = size * size;
	  public static boolean[] grid = new boolean[length];
	  
//	  public static void print_co(int n)
//	  {
//		  int a, b;
//		  a = n % size;
//		  b = n / size;
//		  System.out.println("( " + b + ", " +a+ " )");
//	  }
	  
	  public static void init()
	  {
		  for(int i = 0 ; i < length; i++)
		  {
			  grid[i] = false;
		  }
	  }

	  public static void print()
	  {
		  for(int i = 0 ; i < size; i++)
		  {
			  for(int j = 0; j < size; j++)
			  {
				  if (grid[i*size + j] == true)
				  {
					  System.out.print("-");
				  }
				  else
				  {
					  System.out.print("*");
				  }
			  }
			  System.out.print("\n");
		  }
	  }
	  
	  public static int random_shadow()
	  {
		  int Ran = (int)(length * Math.random() );
		  //System.out.println(Ran);
		  while(grid[Ran] == true)
		  {
			  Ran = (int)(length * Math.random());
		  }
		  grid[Ran] = true;
		  return Ran;
	  }
	  
//	  public static boolean detect_path(boolean[] seen, int n , boolean up)
//	  {
//		  seen[n] = true;
//		  
//		  int dir = -1;
//		  //Decide the direction;
//		  if (up == false)
//			 dir = +1;
//		  
//		  if ( n < size && dir == -1 )
//		  {
////			  System.out.println("Arrived at the top");
//			  return (true);
//		  }
//		  if ( n > length - size - 1 && dir == 1)
//		  {
////			  System.out.println("Arrived at the bottom");
//			  return (true);
//		  }
//		  
//		  if ( n % size == 0)
//		  {
//			boolean du = false;
//			boolean dr = false;
////			System.out.println("Arrived at the left border") ;
//			if (grid[n + dir * size] == true && seen[n+dir *size] == false)
//			{
//				du =  detect_path(seen, n + dir * size, up);
//			}		
//			if (grid[n + 1] == true && seen[n+1] == false)
//			{
//				dr = detect_path(seen, n + 1, up);
//			}
////			System.out.println("n:"+n);
////			System.out.println("du:"+du);
////			System.out.println("dr:"+dr);
//			return du||dr;
//			
//		  }
//		  
//		  if ( (n+1) % size == 0)
//		  { 
//			boolean du = false;
//			boolean dl = false;
//			if (grid[n + dir * size] == true && seen [n + dir*size] == false)
//			{
//				du = detect_path(seen, n + dir*size, up);
//			}
//			if (grid[n - 1] == true && seen[n-1] == false)
//			{
//				dl =  detect_path(seen, n - 1, up);
//			}
////			System.out.println("n:"+n);
////			System.out.println("du:"+du);
////			System.out.println("dl:"+dl);
//			return du||dl;
//		  }
//		  
//		  
//		  boolean du = false;
//		  boolean dl = false;
//		  boolean dr = false;
//		  if (grid[n + dir *size] == true && seen[n + dir*size] == false)
//		  {
////				System.out.println("Go up(down)");
//				du = detect_path(seen, n + dir*size, up);
//		  }
//
//		  if (grid[n-1] == true && seen[n-1] == false)
//		  {
////				System.out.println("Go left");
//				dl = detect_path(seen, n - 1, up);
//		  }
//		  if (grid[n+1] == true && seen[n+1] == false)
//		  {
////				System.out.println("Go right");
//				dr =  detect_path(seen, n + 1, up);
//		  } 
////		  System.out.println("n:"+n);
////			System.out.println("du:"+du);
////			System.out.println("dr:"+dr);
////			System.out.println("dl:"+dl);
//
//		return (dl || dr)||du;
//		 
//		  
//	  }
//	    
//	  public static boolean is_percolation(int n)
//	  {
//		  boolean[] seen = new boolean[length];
//		  for(int i = 0 ; i< length ; i++)
//		  {
//			  seen[i] = false;
//		  }
//		  // Detection up;
//		  boolean up = true;
//		  
//		  boolean has_path_up = detect_path(seen, n, up);
////		  System.out.println("Has_path_up:"+has_path_up);
//		  //Detection down
//		  up = false;
//		  for(int i = 0 ; i< length ; i++)
//		  {
//			  seen[i] = false;
//		  }
//		  boolean has_path_down = detect_path(seen, n, up);
////		  System.out.println("Has_path_down:"+has_path_down);
//		  return has_path_up && has_path_down;
//	  }
//	  
//	  public static double percolation()
//	  {
//		  init();
//		  //print();
//		  
//		  int n = Percolation.random_shadow();
//		  while(is_percolation(n) == false)
//		  {
//			  n = Percolation.random_shadow();
////			  print();
////			  System.out.println(" ");
//		  }
//		  
//		  int counter = 0 ;
//		  
//		  for(int i = 0; i < length; i++)
//		  {
//			  if (grid[i] == true)
//			  {
//				  counter++;
//				  
//			  }
//		  }
//
//		  double res = (double) counter / length;
//		  
//		  return res;
//		  
//	  }
	  
	  public static boolean is_percolation(int n)
	  {
		  for (int i = 0; i < size; i++)
		  {
			  for (int j = 0; j < size; j++)
			  {
				  if (UnionFind.find(i) == UnionFind.find(size*size - size + j))
					  return true;
			  }
		  }
		  return false;
	  }
	  
	  public static void propagate_union(int n)
	  {
		  if(n == 0)
		  {
			  if (grid[1] == true)
			  {
				  UnionFind.union(1, 0);
				 // propagate_union(1);
			  }
			  if (grid[size] == true)
			  {
				  UnionFind.union(size, 0);
//				  propagate_union(size);
			  }
			  return;
		  }
		  if(n == size - 1)
		  {
			  if (grid[size - 2] == true)
			  {
				  UnionFind.union(size - 1, 0);
//				  propagate_union(size - 1);
			  }
			  if (grid[2*size - 1] == true)
			  {
				  UnionFind.union(2*size - 1, size - 1);
//				  propagate_union(2*size - 1);
			  }
			  return;
		  }
		  if(n == size*size - size)
		  {
			  if (grid[size * size - 2* size] == true)
			  {
				  UnionFind.union(size * size - 2* size, size * size - size);
//				  propagate_union(size * size - 2 * size);
			  }
			  if (grid[size*size - size + 1] == true)
			  {
				  UnionFind.union(size * size - size + 1, size * size - size);
//				  propagate_union(size * size - size + 1);
			  }
			  return;
		  }
		  if(n == size * size - 1)
		  {
			  if (grid[size * size - size - 1] == true)
			  {
				  UnionFind.union(size * size - size - 1, size * size - 1);
//				  propagate_union(size * size - size - 1);
			  }
			  if (grid[size * size - 2] == true)
			  {
				  UnionFind.union(size * size - 2, size * size - 1);
//				  propagate_union(size * size - 2);
			  }
			  return;
		  }
		  if ( n < size)
		  {
			  //System.out.println("Arrived at the top");
			  if(grid[n-1] == true)
			  {
				  UnionFind.union(n-1 ,n);
//				  propagate_union(n-1);
			  }
			  if(grid[n+1] == true)
			  {
				  UnionFind.union(n+1 ,n);
//				  propagate_union(n + 1);
			  }
			  if(grid[n+size] == true)
			  {
				  UnionFind.union(n+ size ,n);
//				  propagate_union(n + size);
			  }
			  return;
		  }
		  if ( n > length - size - 1 )
		  {
			  //System.out.println("Arrived at the bottom");
			  if(grid[n-1] == true)
			  {
				  UnionFind.union(n-1 ,n);
//				  propagate_union(n-1);
			  }
			  if(grid[n+1] == true)
			  {
				  UnionFind.union(n+1 ,n);
//				  propagate_union(n + 1);
			  }
			  if(grid[n-size] == true)
			  {
				  UnionFind.union(n-size ,n);
//				  propagate_union(n-size);
			  }
			  return;
		  }
		  
		  if ( n % size == 0)
		  {
			  //System.out.println("Arrived at the left bord");
			  if(grid[n-size] == true)
			  {
				  UnionFind.union(n-size ,n);
			  }
			  if(grid[n+1] == true)
			  {
				  UnionFind.union(n+1 ,n);
			  }
			  if(grid[n+size] == true)
			  {
				  UnionFind.union(n+ size ,n);
			  }
			  return;
		  }
		  
		  if ( (n+1) % size == 0)
		  { 
			//System.out.println("Arrived at the right bord");
			  if(grid[n-1] == true)
			  {
				  UnionFind.union(n-1 ,n);
//				  propagate_union(n-1);
			  }
			  if(grid[n - size] == true)
			  {
				  UnionFind.union(n-size ,n);
//				  propagate_union(n-size);
			  }
			  if(grid[n+size] == true)
			  {
				  UnionFind.union(n+ size ,n);
//				  propagate_union(n + size);
			  }
			  return;
		  }
		  if(grid[n-1] == true)
		  {
			  UnionFind.union(n-1 ,n);
//			  propagate_union(n-1);
		  }
		  if(grid[n+1] == true)
		  {
//			  UnionFind.Union(n+1 ,n);
			  propagate_union(n + 1);
		  }
		  if(grid[n+size] == true)
		  {
			  UnionFind.union(n+ size ,n);
//			  propagate_union(n + size);
		  }
		  if(grid[n-size] == true)
		  {
			  UnionFind.union(n-size, n);
//			  propagate_union(n + size);
		  }
		  return;
		  
	  }
	  
	  public static double percolation()
	  {
		  init();
		  UnionFind.init();
		  UnionFind.init_hauteur();
		  
		  int r = random_shadow();
		  while(is_percolation(r) == false)
		  {
			  propagate_union(r);
			  r = random_shadow();
//			  UnionFind.print();
//			  UnionFind.print_hauteur();
//			  print();
		  }
//		  UnionFind.print();
//		  print();
		  int counter = 0;
		  
		  for(int i = 0; i < length; i++)
		  {
			  if (grid[i] == true)
			  {
				  counter++;
			  }
		  }
		  
		  double res = (double) counter / length;
		  
		  return res;
		  
	  }
	  
	  public static double montecarlo(int n)
	  {
		  double Sum = 0.0;
		  for (int i = 0; i < n; i++)
		  {
			  Sum += percolation();
		  }
		  return Sum/n;
	  }

	  
	  public static void main(String[] args) {
		
		  
//		  percolation();
		  String s = args[0];
		  int n = Integer.parseInt(s) ;
		  long t1 = System.currentTimeMillis();
		  double r = montecarlo(n);
		  long t2 = System.currentTimeMillis();
		  System.out.println(r);
		  System.out.println(t2-t1);
		  
	  } 


	
}
