package m3d9;

import java.util.Arrays;

public class InsertValueSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[100];
		for(int i=0;i<arr.length;i++) {
			arr[i]=i+1;
		}
		
		//System.out.println(Arrays.toString(arr));
		
		int index=insertValueSearch(arr,0,arr.length-1,88);
		System.out.println(index);
	}

	public static int insertValueSearch(int[] arr,int left,int right,int value) {
		if(left>right||value<arr[0]||value>arr[arr.length-1]) {
			return -1;
		}
		
		int mid=left+(right-left)*(value-arr[left])/(arr[right]-arr[left]);
		int midValue=arr[mid];
		
		if(value>midValue) {
			return insertValueSearch(arr,mid+1,right,value);
		}else if(value<midValue) {
			return insertValueSearch(arr,left,mid-1,value);
		}else {
			return mid;
		}
	}
}
