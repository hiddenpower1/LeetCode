import shared.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {
  public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
    
    ArrayList<Interval> result = new ArrayList<Interval>();
    if (intervals.size()<2)
      return intervals;
    
    //sort intervals based on start
    Collections.sort(intervals,compareStart);
    
    int i = 0;
    while(i<intervals.size()){
        Interval temp = intervals.get(i);
        while(i<intervals.size()-1 && temp.end >= intervals.get(i+1).start){
            //have overlap, keep update cur interval till no overlap or reach the end
            temp.end = Math.max(intervals.get(i+1).end,temp.end);
            i++;
        }
        
        //either i = intervals.size()-1 or no overlap.
        result.add(temp);
        i++;

    }
    
    return result;
    
  }
  
  public static Comparator<Interval> compareStart = new Comparator<Interval>(){

    @Override
    public int compare(Interval o1, Interval o2) {
      // TODO Auto-generated method stub
      return Integer.compare(o1.start, o2.start);
    }
    
  };
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
