
public class Node {
	
	 String head;
	  Node next;

	  Node(String head, Node next) {
		    this.head = head;
		    this.next = next;
		  }
		  
		  static int length(Node l) {
			   if(l == null)
			   {
				   return 0;
			   }
			   int count = 1;
			   for(Node cur = l;cur.next != null;cur =cur.next)
			   {
				   count += 1;
			   }
			   return count;
		  }
		  
		  static int length_rec(Node l) {
			  if(l == null)
			  {
				  return 0;
			  }
			  if(l.next == null)
			  {
				  return 1;
			  }
			  return length_rec(l.next) + 1;
		  }
		  
		  
		  static String printNodes(Node l) {
			  	if(l == null)
			  	{
			  		return null;
			  	}
			    String head = "[";
			    String tail = "]";
			    String connector = ", ";
			    String res = head;
			    for(Node cur = l; cur!= null; cur = cur.next) {
			    	res = res + cur.head;
			    	if(cur.next != null)
			    	res = res + connector;
			    }
			    res = res + tail;
			    return res;
		  }
		  static void addLast(String s, Node l)
		  {
			  
			  Node cur = l;
			  while(cur.next!= null)
			  {
				  cur = cur.next;
			  }
			  cur.next = new Node(s,null);
		  }
		  
		  static void addFirst(String s, Node l)
		  {
			  l =  new Node(s,l);
		  }
		  
		  
		  static Node copy(Node l)
		  {
			  if (l == null)
			  {
				  return null;
			  }
			  if(l.next == null)
			  {
				  return new Node(l.head,null);
			  }
			  return new Node(l.head, copy(l.next));
		  }
		  
		  static Node insert(String s, Node l)
		  {
			  Node l_c = copy(l);
			  Node cur = l_c;
			  if(cur == null)
			  {
				  return new Node(s,null);
			  }
			  
			  if(cur.head.compareTo(s) >= 0)
			  {
//				  System.out.println(s + cur.head);
				  return new Node(s,cur);
			  }
			  
			  
			  while(cur.next!=null && cur.next.head.compareTo(s) <= 0)
			  {
				  cur = cur.next;
//				  System.out.println("1");
			  }
//			  Node temp = copy(cur.next);
			  cur.next = new Node(s,cur.next);
			  return l_c;
		  }
		  
		  static Node insertionSort(Node l)
		  {
			  Node l_c = copy(l);
			  if(l_c == null)
			  {
				  return null; 
			  }
			  Node cur = l_c.next;
			  Node res = new Node(l_c.head,null);
			  while(cur != null)
			  {
//				  System.out.println(cur.head);
				  res = insert(cur.head, res);
				  cur = cur.next;
			  }
			  return res;
		  }
		  
		  
//		  public static void main(String[] args) {
//				// TODO Auto-generated method stub
//			  	Prefix pf_1 = new Prefix(10);
//			  	pf_1.print_pf(10);
//			  	Prefix pf_2 = new Prefix(10);
//			  	pf_2.t[3] = "<fuck!>";
//			  	pf_2.print_pf(10);
//			  	System.out.println(Prefix.eq(pf_1, pf_2));
//			  
//		  }

}
