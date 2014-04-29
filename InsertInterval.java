import shared.Interval;
import java.util.ArrayList;

public class InsertInterval {
  public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
    
    ArrayList<Interval> result = new ArrayList<Interval>();
    if(intervals.size() == 0){
      result.add(newInterval);
      return result;
    }
    
    //merge the new Interval with any possible overlap. while add non-overlap intervals before the merge
    int i =0;
    for(;i<intervals.size();i++){
      //have overlap, merge.
      if(intervals.get(i).end>=newInterval.start){
        if(intervals.get(i).start<newInterval.start){
          newInterval.start = intervals.get(i).start;
        }
        
        while(i<intervals.size() && newInterval.end>=intervals.get(i).start){
          i++;
        }
        
        if(i>0 && newInterval.end < intervals.get(i-1).end)
          newInterval.end = intervals.get(i-1).end;  
        break;
      }else{
        //no overlap, add directly
        result.add(intervals.get(i));
      }
    }
    
    //add the newInterval.
    result.add(newInterval);

    //add the rest of the interval if there are any
    while(i<intervals.size()){
      result.add(intervals.get(i));
      i++;
    }
    
    return result;
  }
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Interval i1 = new Interval(1,5);
    Interval i2 = new Interval(6,8);
    ArrayList<Interval> re = new ArrayList<Interval>();
    re.add(i1);
    InsertInterval so = new InsertInterval();
    System.out.print(so.insert(re, i2));
  }

}
