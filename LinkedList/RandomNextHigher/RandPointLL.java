package LinkedList.RandomNextHigher;

class RandPointLL<T> {
	public RandPointNode head;
	public void addLast(T data){
		RandPointNode<T> newNode = new RandPointNode<>();
		newNode.data = data;
		newNode.next = null;
		if(head==null)
			head = newNode;
		else{
			RandPointNode temp = head;
			while(temp.next!=null){
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}
	public void display(){
		RandPointNode temp = head;
		System.out.println();
		while(temp!=null){
			System.out.print("("+temp.data+","+(temp.rand!=null?temp.rand.data:null)+")->");
			temp = temp.next;
		}
		System.out.println();
	}
}