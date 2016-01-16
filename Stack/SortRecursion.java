import java.util.Stack;
class SortRecursion{
	public static void main(String args[]){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(5);
		stack.push(4);
		stack.push(2);
		stack.push(1);
		stack.push(6);
		stack.push(3);
		stack.push(8);
		System.out.println(stack);
		sort(stack,stack.size());
		System.out.println(stack);
	}
	public static void sort(Stack stack,int size){
		if(size==0)
			return;
		inner(stack,(int)stack.pop());
		sort(stack,size-1);
	}
	public static void inner(Stack stack,Integer value){
		if(!stack.empty()){
			int topValue = (int)stack.pop();
			if(topValue<value){
				inner(stack,topValue);
				topValue=value;
			}
			else{
				inner(stack,value);
			}
			stack.push(topValue);
		}
		else
			stack.push(value);
	}
}