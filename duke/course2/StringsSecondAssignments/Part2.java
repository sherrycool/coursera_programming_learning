
/**
 * 在这里给出对类 Part2 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Part2 {

    public static int howMany(String stringa, String stringb){
        int x = 0;
        int index = stringb.indexOf(stringa);
        while (index!=-1){
            x++;
            index = stringb.indexOf(stringa, index+stringa.length());
        }
        return x;
    }
    
    public static void testHowMany(){
        System.out.println(howMany("GAA", "ATGAACGAATTGAATC"));
        System.out.println(howMany("AA", "ATAAAA"));
    }
    
    public static void main(String[] argus){
        testHowMany();
    }
}
