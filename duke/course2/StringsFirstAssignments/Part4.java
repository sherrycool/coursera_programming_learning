
/**
 * 在这里给出对类 Part4 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
import java.io.File;

public class Part4 {
    
    public static void findYoutubeAddress(String s){
        String s2 = s.toLowerCase();       
        int index = s2.indexOf("youtube.com");
        if(index!=-1){
            //System.out.println(s);  
            //<li> <a href="http://www.youtube.com/watch?v=XlOySsg7oxY">
            int startIndex = s2.indexOf("a href=\"");
            int endIndex = s2.indexOf("\"", startIndex+8);
            
            if (startIndex!=-1 && endIndex!=-1){
                //System.out.println(startIndex+" "+endIndex);
                System.out.println(s.substring(startIndex+8, endIndex));
            }
        }
    }

    
    public static void main(String[] argus){
        FileResource fr = new FileResource("youtubeaddress.txt");
        //String x = fr.asString();
        int count = 0;
        for (String line : fr.lines()) {
            /*System.out.println(line);
            System.out.println(count);
            count++;*/
            findYoutubeAddress(line);
        }
        //;
    }
}
