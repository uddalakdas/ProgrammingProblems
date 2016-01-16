package LinkedList.SwappingNodes;
import LinkedList.common.Node;
import LinkedList.common.LinkedList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class SwappingNodes{
	public static void main(String args[])throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-->0){
			int N = Integer.parseInt(br.readLine());
			String line[] = br.readLine().split(" ");
			LinkedList<Integer> ll = new LinkedList<>();
			for(int i=0;i<N;i++)
				ll.addLast(Integer.parseInt(line[i]));
			line = br.readLine().split(" ");
			int x = Integer.parseInt(line[0]);
			int y = Integer.parseInt(line[1]);
			System.out.print("Before");
			ll.display();
			swapNodes(ll,x,y);
			System.out.print("After");
			ll.display();
		}
	}
	public static void swapNodes(LinkedList ll,int x,int y)throws Exception{
		if((Integer)ll.head.data==x || (Integer)ll.head.data==y){
			Node temp = ll.head.next;
			while(temp.next!=null){
				if((Integer)temp.next.data==x || (Integer)temp.next.data==y)
					break;
				temp = temp.next;
			}
			if(temp.next==null)
				throw new Exception("Element not found");
			else{
				swap(ll.head,temp.next);
				Node t = temp.next;
				temp.next = ll.head;
				ll.head = t;
			}
		}
		else{
			Node t1=null,t2=null,temp=ll.head;
			while(temp.next!=null){
				if((Integer)temp.next.data == x || (Integer)temp.next.data == y){
					if(t1==null)
						t1 = temp;
					else{
						t2 = temp;
						break;
					}
				}
				temp = temp.next;
			}
			System.out.println("t1 = "+t1.data+" t2 = "+t2.data);
			if(temp.next == null)
				throw new Exception("Element not found");
			else{
				swap(t1.next,t2.next);
				swap(t1,t2);
			}
		}
	}
	public static void swap(Node a,Node b){
		Node temp = a.next;
		a.next = b.next;
		b.next = temp;
	}
} 