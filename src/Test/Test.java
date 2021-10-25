package Test;

import java.util.ArrayList; 
import java.util.Scanner;
public class Test {
	
	static int n;
    static ArrayList<Integer> arr;
    static int exi=0;
  
    
    static void heapify(ArrayList<Integer> arr, int n, int i)
    {
        int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 
  
        
        if (l < n && arr.get(l) > arr.get(largest))
            largest = l;
  
        
        if (r < n && arr.get(r) > arr.get(largest))
            largest = r;
  
        
        if (largest != i) {
            int swap = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, swap);
  
            
            heapify(arr, n, largest);
        }
    }
  
    
    static void buildHeap(ArrayList<Integer> arr, int n)
    {
        
        int startIdx = (n / 2) - 1;
  
        
        for (int i = startIdx; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }
  
    
    static void printHeap(ArrayList<Integer> arr, int n)
    {
        System.out.println("Heap:");
        int line=1;
        int k=1;
        for (int i = 0; i < n; ++i){
            System.out.print(arr.get(i) + " ");
            
            if (line==k){
                System.out.println();
                line=line*2;
                k=0;
            }
            k=k+1;
        }
  
        System.out.println();
    }
    
    static void searchkey(ArrayList<Integer> arr, int n, int key){
        for (int i = 0; i < n; i++){
            if (arr.get(i)==key){
                System.out.println(key+" found at index "+i);
                return;
                
            }
        }
        System.out.println(key+ " NOT found");
    }
  
    
    public static void main(String args[])
    {   
        int ar[];
        int arlen;
        while(true){
            System.out.println("Select from:\n1. Read itemds and build heap\n2. Display heap\n3. Insert a node\n4. Remove the largest node\n5. Search for a key\n0. Exit");
        
            Scanner sc = new Scanner(System.in);
        
            int inp=sc.nextInt();
        
            switch(inp){
                case 1:
                    arr=new ArrayList<Integer>();
                
                    int number=0;
                    
                    System.out.print("Enter integers(negative to stop): ");
                    while (true) {
                        number = sc.nextInt();
                        if (number<0){
                            break;
                        }
                        arr.add(number);
                    }
                
                    n = arr.size();
                    buildHeap(arr, n);
                    break;
                
                case 2:
                    printHeap(arr, n);
                    break;
                
                case 3:
                    System.out.print("Enter a non-negative integer to be inserted: ");
                    int ins=sc.nextInt();
                    System.out.println();
                    arr.add(ins);
                    n=arr.size();
                    buildHeap(arr,n);
                    break;
                
                case 4:
                    arr.remove(0);
                    n=arr.size();
                    buildHeap(arr,n);
                    break;
                    
                case 5:
                    
                    System.out.print("Enter the key to be searched for: ");
                    int key=sc.nextInt();
                    System.out.println();
                    searchkey(arr, n, key);
                    break;
                    
                case 0:
                    exi=1;
                    break;
            }
            System.out.println("\n");
            if(exi==1){
                System.out.println("Thanks for using my program");
                break;
            }
        }   
    }
}