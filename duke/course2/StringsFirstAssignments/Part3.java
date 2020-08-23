
/**
 * 在这里给出对类 Part3 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Part3 {
    public static boolean twoOccurrences(String stringa,String stringb){
        String x = stringb;
        int index1 = x.indexOf(stringa);
        if (index1 == -1){
            return false;
        }
        int index2 = x.indexOf(stringa,index1+1);
        if (index2 == -1){
            return false;
        }
        return true;
    }
    
    public static String lastPart(String stringa,String stringb){
        int index1 = stringb.indexOf(stringa);
        if (index1==-1){
            return stringb;
        }
        else{
            return stringb.substring(index1+stringa.length());   
        }
    }
   
        
    public static void testing(){
        System.out.println(twoOccurrences("by", "A story by Abby Long"));
        System.out.println(twoOccurrences("a","banana"));
        System.out.println(twoOccurrences("atg","ctgtatgta"));
        System.out.println(lastPart("an", "banana") );
        System.out.println(lastPart("zoo", "forest") );
        System.out.println(lastPart("pos", "position") );
    }
    
       
    public static void main(String[] argus){
        testing();
    }
}
