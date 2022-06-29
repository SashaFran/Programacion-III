package ejercicio_2_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeSortMain {

    public static void main(String[] args) {
    	try {
        BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));
        System.out.println("Ingrese 10 elementos");
        int n = Integer.parseInt(entrada.readLine());
        int []arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(entrada.readLine());
        
        mergeSort(arr);
        System.out.println("the array after merge sort"+Arrays.toString(arr));
    	}catch(Exception e) {
    		System.out.println(e);
    	}
   }
   
   public static void mergeSort(int []arr){
       int n = arr.length;
       if(n<2){
           return;
       }
       int mid = n/2;
       int []left = new int[mid];
       int []right = new int[n-mid];
       for(int i=0;i<mid;i++){
           left[i] = arr[i];
       }
       for(int i=mid;i<n;i++){
           right[i-mid] = arr[i];
       }
       
       mergeSort(left);
       mergeSort(right);
       merge(arr,left,right);
   }
   
   public static void merge(int[]arr,int[]left,int[]right){
       int l = 0;
       int r = 0;
       int k = 0;
       while(l<left.length && r<right.length){
           if(left[l]>right[r]){
               arr[k++] = left[l++];
           }else{
               arr[k++] = right[r++]; 
           }
       }while(l<left.length){
           arr[k++] = left[l++];         
       }while(r<right.length){
           arr[k++] = right[r++];
       }
       
   }
}
