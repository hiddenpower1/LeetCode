import java.util.ArrayList;


public class RestoreIPAddresses {
  public ArrayList<String> restoreIpAddresses(String s) {
    ArrayList<String> addresses = new ArrayList<String>();
    if(s.length()<4 || s.length()>12){
      return addresses;
    }
    
    String ip = "";
    restore(addresses,s,ip,0);
    
    return addresses;
  }
  
  private void restore(ArrayList<String> addresses, String s,String ip, int count) {
    // TODO Auto-generated method stub
    if(s.length()>(4-count)*3  || s.length() < (4-count) )
      return;
      
    if(count==3 && isValid(s)){
      addresses.add(ip+s);
      return;
    }
    
    //each round can take up to 3 digits
    for(int i = 1;i<=3 && i<s.length();i++){
      String digits = s.substring(0,i);
      if(isValid(digits))
        restore(addresses,s.substring(i),ip+digits+".",count+1);
    }
    
  }

  private boolean isValid(String digits) {
    // TODO Auto-generated method stub
    
    int value = 0;
    
    // single 0 is valid, but 01,010 etc is not.
    if(digits.length()!=1&&digits.charAt(0)=='0'){
        return false;
    }
    
    for (int i = 0;i<digits.length();i++)
        value = value*10+(digits.charAt(i)-'0');
    
    if(value>255)
        return false;
    else
        return true;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
