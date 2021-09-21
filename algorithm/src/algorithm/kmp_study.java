package algorithm;

public class kmp_study {
	
	static void print(char[] s, int[] table, int jj, int ii) {
		System.out.println();
		System.out.println();
		System.out.println("i = "+ ii +" j = " + jj);
		for(int i=0; i<table.length; i++)
			System.out.print(s[i] + " ");
		System.out.println();
		for(int i=0; i<table.length; i++)
			System.out.print(table[i] + " ");
	}
	
	static int[] getTable(char[] s) {
		int[] arr = new int[s.length];

		int j=0;
		
		for(int i=1; i<s.length; i++) {
			
			while(j>0 && arr[j] != arr[i]) {
				print(s,arr,j,i);
				j = arr[j-1];
			}
			
			if(s[j]==s[i]) {
				arr[i] = ++j;
			}
			print(s,arr,j, i);
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		int[] table = getTable("abcdabcdabcdabcdabcd".toCharArray());
		
		
	}
	

}
