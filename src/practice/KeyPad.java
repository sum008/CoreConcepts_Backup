package practice;

public class KeyPad {
	static void solve(String curr, int index, String[] arr) {
		if (index==arr.length) {
			return;
		}
		int i=0;
		while (i<arr[index].length()) {
			solve(curr+arr[index].charAt(i), index+1, arr);
			if (index==arr.length-1) {
				System.out.print(curr+arr[index].charAt(i)+" ");	
			}
			i+=1;
		}
	}
	
	public static void main(String... s) {
		String[] arr = {".;abc","defg"};
		int index=0;
		solve("",index,arr);
	}
}
