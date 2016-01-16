package LinkedList.common;
public class LinkedList<T> {
	public Node head;
	public void addLast(T data){
		Node<T> newNode = new Node<>();
		newNode.data = data;
		newNode.next = null;
		if(head==null)
			head = newNode;
		else{
			Node temp = head;
			while(temp.next!=null){
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}
	public void display(){
		Node temp = head;
		System.out.println();
		while(temp!=null){
			System.out.print(temp.data+"->");
			temp = temp.next;
		}
		System.out.println();
	}
}