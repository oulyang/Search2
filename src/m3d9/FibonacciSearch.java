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
		int k=0;//쳲������ָ���ֵ���±�
		int mid=0;
		int f[]=fibArray();
		
		//��ȡ쳲������ָ���ֵ���±�
		while(high>f[k]-1) {
			k++;
		}
		
		//f[k]��ֵ���ܴ���arr�ĳ��ȣ���Ҫһ���µ�����ָ��arr
		int[] temp=Arrays.copyOf(arr, f[k]);//����Ĳ��ֻ��Զ����0
		
		//ʵ����Ҫ��arr���һ��Ԫ�����temp
		for(int i=high+1;i<temp.length;i++) {
			temp[i]=arr[high];
		}
		
		while(low<=high) {
			mid=low+f[k-1]-1;
			if(value<temp[mid]) {//���
				high=mid-1;
				//1.ȫ��Ԫ��=ǰ��Ԫ��+����Ԫ��  ��
				//2.f[k]=f[k-1]+f[k-2] 
				//ǰ����k-1��Ԫ�أ����Լ�����Ϊf[k-1]=f[k-2]+f[k-3] 
				//����f[k-1]��ǰ�����
				
				//��һ��ѭ��mid=f[k-1-1]-1;
				k--;
			}else if(value>temp[mid]) {//�ұ�
				low=mid+1;
				//f[k]=f[k-1]+f[k-2]�����滹��k-2��Ԫ�أ����Լ�����Ϊf[k-2]=f[k-3]+f[k-4]
				//����f[k-2]�ĺ������
				
				//��һ��ѭ��mid=f[k-1-2]-1;
				k-=2;
			}else {//�ҵ�
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
