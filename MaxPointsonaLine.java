import java.util.HashMap;

import shared.Point;


public class MaxPointsonaLine {
  public int maxPoints(Point[] points) {
    if (points.length<3)
      return points.length;
    
    //at least two points can form a line
    int max = 1;
    
    for(int i=0;i<points.length-1;i++){
      HashMap<Double,Integer> hm = new HashMap<Double,Integer>();
      int samerow= 1;
      int curmax = 1;
      int dup = 0;
      for(int j=i+1;j<points.length;j++){
        //y not the same
        if(points[i].y != points[j].y){
          //0.0+ to avoid -0.0 when all x are the same, but y have negative
          double slop = 0.0+(double)(points[i].x -points[j].x)/(points[i].y -points[j].y);
          if(hm.containsKey(slop)){
            hm.put(slop, hm.get(slop)+1);
            //check if need update max.
            if(hm.get(slop)>curmax)
              curmax = hm.get(slop);
          }else{
            hm.put(slop, 2);
            if(hm.get(slop)>curmax)
              curmax = hm.get(slop);
          }
        }else{
          //x and y are the same, add 1 to the duplicate count.
          if(points[i].x == points[j].x){
            dup++;
          }else{
            //y is the same , to avoid the divide 0 error. use samerow to calculate this case.
            samerow++;
            if(samerow>curmax)
              curmax = samerow;
          }
        }
      }
      
      if(curmax+dup>max)
        max = curmax+dup;
    }
    
    return max;
    
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Point a = new Point(1,1);
    Point b = new Point(1,1);
    Point c = new Point(0,0);
    Point[] points = {a,b,c};
    MaxPointsonaLine so = new MaxPointsonaLine();
    System.out.print(so.maxPoints(points));
  }

}
