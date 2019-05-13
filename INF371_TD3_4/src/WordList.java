
public class WordList {

	  Node content;

	  public WordList() {
	    content = null;
	  }
	  
	  public WordList(Node  n)
	  {
		  content = n;
	  }
	  public int length()
	  {
		  return Node.length(this.content);
	  }
	  
	  public String print()
	  {
		  return Node.printNodes(this.content);
	  }
	  
	  void addFirst(String w)
	  {
		  this.content = new Node(w, this.content);
	  }
	  
	  void addLast(String w)
	  {
		  if (this.content == null)
		  {
			  this.content = new Node(w,null);
		  }
		  Node.addLast(w, this.content);
	  }
	  
	  String removeFirst()
	  {
		  if(this.content == null)
		  {
			  return null;
		  }
		  this.content = this.content.next;
		  if (this.content == null)
		  {
			  return null;
		  }
		  return Node.printNodes(this.content);
	  }
	  
	  String removeLast()
	  {
		  if(this.content == null)
		  {
			  return null;
		  }
		  Node l = this.content;
		  if(l.next == null)
		  {
			  this.content = null;
			  return Node.printNodes(this.content);
		  }
		  while(l.next.next != null)
		  {
			  l = l.next;
		  }
		  l.next = null;
		  

		  return Node.printNodes(this.content);
		  
	  }
	  
	  void insert(String s)
	  {
		  this.content = Node.insert(s, this.content);
	  }
	  
	  void insertionSort()
	  {
		  this.content = Node.insertionSort(this.content);
	  }
	  
	  WordList(String[] t) {
		  Node n = null;
		  if(t.length == 0)
		  {
			  content = null;
		  }
		  else {
		  for (int i = 0; i < t.length; i++)
		  {
			  n = new Node(t[i], n);
		  }
		   n = Node.insertionSort(n);
		   content = n;
		  }
	  }
	  
	  String[] toArray()
	  {
		  this.insertionSort();
		  int l = this.length();
		  String [] res = new String[l];
		  Node n = this.content;
		  for (int i = 0; i < l; i++)
		  {
			  res[i] = n.head;
			  n = n.next;
		  }
		  return res;
	  }

}
