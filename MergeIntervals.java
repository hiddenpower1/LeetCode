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
    
    for(int i = 0;i<intervals.size()-1;i++){
      //have overlap
      if(intervals.get(i).end >= intervals.get(i+1).start){
        if(intervals.get(i).end >= intervals.get(i+1).end){
          intervals.set(i+1, new Interval(intervals.get(i).start,intervals.get(i).end));
        }else{
          intervals.set(i+1, new Interval(intervals.get(i).start,intervals.get(i+1).end));
        }
      }else{
        result.add(intervals.get(i));
      }
    }
    
    //add the last interval
    result.add(intervals.get(intervals.size()-1));
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
