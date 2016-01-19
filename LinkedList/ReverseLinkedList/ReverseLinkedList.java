package LinkedList.ReverseLinkedList;
import LinkedList.common.Node;
import LinkedList.common.LinkedList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class ReverseLinkedList{
	public static void main(String args[])throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-->0){
			int N = Integer.parseInt(br.readLine());
			String line[] = br.readLine().split(" ");
			LinkedList<Integer> ll = new LinkedList<>();
			for(int i=0;i<N;i++)
				ll.addLast(Integer.parseInt(line[i]));
			System.out.print("Before Iterative");
			ll.display();
			reverseLinkedListIteratively(ll);
			System.out.print("After Iterative");
			ll.display();

			System.out.print("Before Recursive");
			ll.display();
			reverseLinkedListRecursively(ll);
			System.out.print("After Recursive");
			ll.display();
		}
	}
	public static void reverseLinkedListIteratively(LinkedList ll){
		if(ll.head==null || ll.head.next==null)
			return;
		Node prev = null,cur = ll.head, next = cur.next;
		do{
			cur.next = prev;
			Node temp = next.next;
			next.next = cur;

			prev = cur;
			cur = next; 
			next = temp;
		}
		while(next!=null);
		ll.head = cur;
	}
	public static void reverseLinkedListRecursively(LinkedList ll){
		if(ll.head==null || ll.head.next==null)
			return;
		
		Node temp = reverseRecursive(ll.head);
		ll.head.next = null;
		ll.head = temp;
	}
	public static Node reverseRecursive(Node node){
		Node temp=null;
		if(node.next.next!=null)
			temp = reverseRecursive(node.next);
		else
			temp = node.next;
		node.next.next = node;
		return temp;
	}

}