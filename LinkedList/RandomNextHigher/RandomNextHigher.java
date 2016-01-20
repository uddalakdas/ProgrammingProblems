package LinkedList.RandomNextHigher;

import LinkedList.common.Node;
import LinkedList.common.LinkedList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
class RandomNextHigher{
	public static void main(String args[])throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-->0){
			int N = Integer.parseInt(br.readLine());
			String line[] = br.readLine().split(" ");
			RandPointLL<Integer> ll = new RandPointLL<>();
			for(int i=0;i<N;i++)
				ll.addLast(Integer.parseInt(line[i]));
			System.out.println("Before");
			ll.display();
			populateRandomPointers(ll);
			System.out.print("After");
			ll.display();
		}
	}
	public static void populateRandomPointers(RandPointLL ll){
		if(ll==null || ll.head==null ||ll.head.next==null)
			return;
		Stack<RandPointNode> stk = new Stack<>();
		stk.push(ll.head);
		RandPointNode temp = ll.head.next;
		while(temp!=null){
			RandPointNode prev = stk.peek();
			while(prev !=null && (Integer)temp.data>(Integer)prev.data){
				stk.pop();
				prev.rand = temp;
				prev = stk.empty()?null:stk.peek();
				
			}
			stk.push(temp);
			temp = temp.next;
		}
	}
}