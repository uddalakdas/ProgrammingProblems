/*
	Given an array, 1 2 0 5 4 88 0 0 0 6
	make it, 1 2 5 4 88 6 0 0 0 0
*/
import java.io.*;
class Segmentation {
	public static void main(String args[])throws IOException{
		int ar[],l;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		l = Integer.parseInt(br.readLine()); //Size of the array
		ar = new int[l];
		String values[] = br.readLine().split(" ");
		for(int i=0;i<l;i++)
			ar[i] = Integer.parseInt(values[i]);
		segment(ar,l);
		for(int i=0;i<l;i++)
			System.out.print(ar[i]+" ");
		System.out.println();
		
	}
	public static void segment(int ar[],int l){
		int i,j;
		for(i=0;i<l;i++)
			if(ar[i]==0)
				break;
		for(j=i+1;j<l;j++){
			if(ar[j]!=0){
				int temp = ar[i];
				ar[i] = ar[j];
				ar[j] = temp;
				i++;
			}
		}
	}
}