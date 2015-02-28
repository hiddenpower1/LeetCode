public class MedianofTwoSortedArrays {

  // convert to find kth element in two sorted array.
  public double medianofTwoSortedArrays(int[] A, int[] B) {
    // if A or B is empty

    int m = A.length;
    int n = B.length;
    int k = (m + n) / 2;

    // // odd
    // if ((m + n) % 2 == 1)
    // return findKth(A, 0, m - 1, B, 0, n - 1, k);
    // else
    // return (findKth(A, 0, m - 1, B, 0, n - 1, k - 1) + findKth(A, 0, m - 1, B, 0, n - 1, k)) /
    // 2.0;
    //

    if ((m + n) % 2 != 0) // odd
      return (double) findKth(A, B, k + 1, 0, m - 1, 0, n - 1);
    else { // even
      return (findKth(A, B, k, 0, m - 1, 0, n - 1) + findKth(A, B, k + 1, 0, m - 1, 0, n - 1)) * 0.5;
    }

  }



  public static int findKth(int A[], int B[], int k, int aStart, int aEnd, int bStart, int bEnd) {

    int aLen = aEnd - aStart + 1;
    int bLen = bEnd - bStart + 1;

    if (aLen == 0)
      return B[bStart + k - 1];
    if (bLen == 0)
      return A[aStart + k - 1];
    if (k == 1)
      return Math.min(A[aStart], B[bStart]);

    //aMid+bMid = k-1, means there are total K+1 numbers aStart->aMid + bStart->bMid
    int aMid = aLen * (k - 1) / (aLen + bLen);
    int bMid = (k - 1) - aMid - 1;

    aMid = aStart + aMid;
    bMid = bStart + bMid;
    if (A[aMid] < B[bMid]) {
      k = k - (aMid - aStart + 1);
      aStart = aMid + 1;
      bEnd = bMid;
    } else {
      k = k - (bMid - bStart + 1);
      bStart = bMid + 1;
      aEnd = aMid;
    }

    return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
  }



  // use binary search
  public double medianofTwoSortedArrays2(int[] A, int[] B) {
    // if A or B is empty
    if (A.length == 0)
      return findSimpleMedian(B);

    if (B.length == 0)
      return findSimpleMedian(A);

    // use binary search to find the median

    return findMedian(A, B, Math.max(0, (A.length + B.length) / 2 - B.length),
        Math.min(A.length - 1, (A.length + B.length) / 2));

  }

  private double findMedian(int[] a, int[] b, int left, int right) {
    // TODO Auto-generated method stub
    if (left > right) // means the median is not in the first array, now find it from the second
                      // array
      return findMedian(b, a, Math.max(0, (a.length + b.length) / 2 - a.length),
          Math.min(b.length - 1, (a.length + b.length) / 2));

    // A[i] is larger than i number in A, if it's median then it's larger than (A.length+B.length)/2 - i number in B
    int i = (left + right) / 2;
    int j = (a.length + b.length) / 2 - i - 1;

    //found the median, A[i] between B[j],B[j+1]£¬means it larger than exactly (A.length+B.length)/2 numbers, which is the median
    if (j >= 0 && a[i] < b[j]) {
      return findMedian(a, b, i + 1, right);
    } else {
      if (j < b.length - 1 && a[i] > b[j + 1])
        return findMedian(a, b, left, i - 1);
    }

    // median is found
    if ((a.length + b.length) % 2 == 1)//odd
      return a[i];
    else { // length of the arrays are even, we find the number larger than (a.length+b.length)/2,
           // but need find the previous number to calc the median
      if (i > 0) { // so the median is not the first number of array a.
        int pre = (j >= 0) ? Math.max(a[i - 1], b[j]) : a[i - 1];
        return (a[i] + pre) / 2.0;
      } else {
        return (a[i] + b[j]) / 2.0;
      }


    }

  }



  private double findSimpleMedian(int[] a) {
    // TODO Auto-generated method stub

    int length = a.length;
    if (length == 0)
      return 0;

    if (length % 2 == 0) {
      return (a[length / 2 - 1] + a[length / 2]) / 2.0;

    } else {
      return a[length / 2];
    }

  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] numbers1 = {1};
    int[] numbers2 = {1};
    MedianofTwoSortedArrays so = new MedianofTwoSortedArrays();
    System.out.println(so.medianofTwoSortedArrays2(numbers1, numbers2));
  }

}
