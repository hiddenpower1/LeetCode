public class MedianofTwoSortedArrays {
  
  public double medianofTwoSortedArrays(int[] A, int[] B){
    //if A or B is empty
    if (A.length == 0)
      return findSimpleMedian(B);
    
    if (B.length == 0)
      return findSimpleMedian(A); 
    
    //use binary search to find the median
    
    return findMedian(A,B,Math.max(0, (A.length+B.length)/2 - B.length),Math.min(A.length-1, (A.length+B.length)/2));
    
  }

  private double findMedian(int[] a, int[] b, int left, int right) {
    // TODO Auto-generated method stub
    if (left > right) //means the median is not in the first array, now find it from the second array
      return findMedian(b,a,Math.max(0, (a.length+b.length)/2-a.length),Math.min(b.length-1, (a.length+b.length)/2));
    
    int i = (left+right)/2;
    int j = (a.length+b.length)/2 - i - 1;
    
    if( j>=0 && a[i]<b[j]){
      return findMedian(a,b,i+1,right);
    }else{
      if(j<b.length-1 && a[i]>b[j+1])
        return findMedian(a,b,left,i-1);
    }
    
    //median is found
    if((a.length+b.length)%2 == 1)
      return a[i];
    else{ //length of the arrays are even, we find the number larger than (a.length+b.length)/2, but need find the previous number to calc the median
      if (i>0){ // so the median is not the first number of array a.
        int pre = (j>=0)? Math.max(a[i-1], b[j]):a[i-1];
        return (a[i]+pre)/2.0;
      }else{
        return (a[i]+b[j])/2.0;
      }
  
       
    }

  }

  private double findSimpleMedian(int[] a) {
    // TODO Auto-generated method stub
    
    int length = a.length;
    if (length == 0)
        return 0;
    
    if(length % 2 == 0){
      return (a[length/2 -1] + a[length/2])/2.0;
      
    }else{
      return a[length/2];
    }
    
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] numbers1 = { 1 };
    int[] numbers2 = { 1 };
    MedianofTwoSortedArrays so = new MedianofTwoSortedArrays();
    System.out.println(so.medianofTwoSortedArrays(numbers1, numbers2));
}

}
