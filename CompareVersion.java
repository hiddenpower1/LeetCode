
public class CompareVersion {
  public int compareVersion(String version1, String version2) {
    //assume both version length not 0
    String[] v1 = version1.split("\\.");
    String[] v2 = version2.split(".");
    
    int i = 0;
    while(i<v1.length && i<v2.length){
        int a = Integer.parseInt(v1[i]);
        int b = Integer.parseInt(v2[i]);
        if(a<b)
            return -1;
        else if(a>b)
            return 1;
        else
            i++;
    }
    
    if(i==v1.length&&i==v2.length)
        return 0;
    else{
        return i==v1.length? -1:1;
    }
}
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    CompareVersion so = new CompareVersion();
    so.compareVersion("123", "123");
  }

}
