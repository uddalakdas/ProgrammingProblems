package LinkedList.MergeSortedLLReverse;
import LinkedList.common.Node;
import LinkedList.common.LinkedList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class MergeSortedLLReverse{
	public static void main(String args[])throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-->0){
			
			String line[] = br.readLine().split(" ");
			int N = Integer.parseInt(line[0]);
			int M = Integer.parseInt(line[1]);
		    line = br.readLine().split(" ");
			LinkedList<Integer> ll1 = new LinkedList<>();
			for(int i=0;i<N;i++)
				ll1.addLast(Integer.parseInt(line[i]));
			line = br.readLine().split(" ");
			LinkedList<Integer> ll2 = new LinkedList<>();
			for(int i=0;i<M;i++)
				ll2.addLast(Integer.parseInt(line[i]));
			ll1.display();
			ll2.display();
			mergeReverse(ll1,ll2);
			ll1.display();

		}
	}
	public static void mergeReverse(LinkedList ll1,LinkedList ll2){
		Node prev = null;
		Node cur1 = ll1.head,cur2 = ll2.head;
		while(cur1!=null && cur2!=null){
			if((Integer)cur1.data < (Integer)cur2.data){
				Node temp = cur1.next;
				cur1.next = prev;
				prev = cur1;
				cur1 = temp;
			}
			else{
				Node temp = cur2.next;
				cur2.next = prev;
				prev = cur2;
				cur2 = temp;
			}
		}
		while(cur1!=null){
			Node temp = cur2.next;
			cur2.next = prev;
			prev = cur2;
			cur2 = temp;
		}
		while(cur2!=null){
			Node temp = cur2.next;
			cur2.next = prev;
			prev = cur2;
			cur2 = temp;
		}
		ll1.head = prev;
	}
}