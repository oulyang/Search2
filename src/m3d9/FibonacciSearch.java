package m3d9;

import java.util.Arrays;

public class FibonacciSearch {
	public static int maxSize=20;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,5,6,9,78,99};
		System.out.println(fibSearch(arr,1));
	}

	public static int[] fibArray() {
		int[] f=new int[maxSize];
		f[0]=1;
		f[1]=1;
		for(int i=2;i<maxSize;i++) {
			f[i]=f[i-1]+f[i-2];
		}
		return f;
	}
	
	public static int fibSearch(int[] arr,int value) {
		int low=0;
		int high=arr.length-1;
		int k=0;//斐波那契分割数值的下标
		int mid=0;
		int f[]=fibArray();
		
		//获取斐波那契分割数值的下标
		while(high>f[k]-1) {
			k++;
		}
		
		//f[k]的值可能大于arr的长度，需要一个新的数组指向arr
		int[] temp=Arrays.copyOf(arr, f[k]);//不足的部分会自动填充0
		
		//实际需要用arr最后一个元素填充temp
		for(int i=high+1;i<temp.length;i++) {
			temp[i]=arr[high];
		}
		
		while(low<=high) {
			mid=low+f[k-1]-1;
			if(value<temp[mid]) {//左边
				high=mid-1;
				//1.全部元素=前面元素+后面元素  ，
				//2.f[k]=f[k-1]+f[k-2] 
				//前面有k-1个元素，可以继续拆为f[k-1]=f[k-2]+f[k-3] 
				//即在f[k-1]的前面查找
				
				//下一次循环mid=f[k-1-1]-1;
				k--;
			}else if(value>temp[mid]) {//右边
				low=mid+1;
				//f[k]=f[k-1]+f[k-2]，后面还有k-2个元素，可以继续拆为f[k-2]=f[k-3]+f[k-4]
				//即在f[k-2]的后面查找
				
				//下一次循环mid=f[k-1-2]-1;
				k-=2;
			}else {//找到
				if(mid<=high) {
					return mid;
				}else {
					return  high;
				}
			}
		}
		return -1;
	}
}
