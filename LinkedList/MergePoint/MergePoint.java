package LinkedList.MergePoint;
import LinkedList.common.Node;
import LinkedList.common.LinkedList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class MergePoint{
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

			int mPoint = FindMergeNode(ll1.head,ll2.head);
			System.out.println(mPoint);
			
		}
	}
	public static int FindMergeNode(Node headA, Node headB) {
		Node smallerListHead = headA,largerListHead = headB;
		int count = 0;
		boolean swap = false;
		while((headA!=null || headB!=null)){
			
			if(headA!=null && headB!=null){
				headA = headA.next;
				headB = headB.next;
			}
			else if(headA==null){
				count++;
				headB = headB.next;
			}
			else{
				count++;
				headB = headB.next;
				swap = true;	
			}
		}
		if(swap){
			Node temp = smallerListHead;
			smallerListHead = largerListHead;
			largerListHead = temp;
		}
		while(count-->0){
			largerListHead = largerListHead.next;
		}
		while(largerListHead.data != smallerListHead.data){
			largerListHead = largerListHead.next;
			smallerListHead = smallerListHead.next;
		}
		return (Integer)largerListHead.data;
	}
}