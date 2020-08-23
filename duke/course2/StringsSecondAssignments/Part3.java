
/**
 * 在这里给出对类 Part1 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Part3 {
    public static int findStopCodon(String dna, int startIndex, String stopCodon){
        int currIndex = dna.indexOf(stopCodon, startIndex+3);
        //System.out.println(currIndex);
        if (currIndex==-1){
            return dna.length();
        }
        while (currIndex != -1){
            //System.out.println(currIndex);
            if ((currIndex-startIndex)%3==0){
                return currIndex;
            }
            currIndex = dna.indexOf(stopCodon, currIndex+1);
        }
        //System.out.println(dna.substring(startIndex, currIndex+3));
        return dna.length();
    }
    
    public static String findGene(String dna){
        int startIndex = dna.indexOf("ATG");
        String dnaOne = "";
        if (startIndex == -1){
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int atgIndex = findStopCodon(dna, startIndex, "ATG");
        int minEndIndex = Math.min(taaIndex, Math.min(tagIndex, atgIndex));
        //System.out.println(taaIndex+" "+tagIndex+" "+atgIndex+" "+minEndIndex);
        if (minEndIndex <= startIndex || minEndIndex == dna.length()){
            return "";
        }
        dnaOne = dna.substring(startIndex, minEndIndex+3);
        return dnaOne;
    }
    
    public static void printAllGenes(String dna){
        //System.out.println("DNA0:"+dna);
        int startIndex = dna.indexOf("ATG");
        String dnaOne="";
        int count = 0;
        int indexNew = 0;
        //System.out.println("DNA1:"+dna);
        while(true){
            if(startIndex==-1){
                break;
            }
            dnaOne = findGene(dna);
            System.out.println("dnaOne: "+dnaOne);
            //System.out.println("DNA2:"+dna);
            count++;
            indexNew = dna.indexOf(dnaOne, startIndex)+dnaOne.length();
            dna = dna.substring(indexNew);
            //System.out.println("DNA3:"+dna);
            dnaOne = findGene(dna);
            startIndex = dna.indexOf("ATG");
            
            
            if (dnaOne==""){
                break;
            }
        }
        System.out.println("Gene count: "+count);
    }

    public static void testPrintAllGenes(){
        /*System.out.println("dna:ATGXXATAAXATGXXBTAA");
        printAllGenes("ATGXXATAAXATGXXBTAA");
        System.out.println("dna:XXXAXTAAXATGTAG");
        printAllGenes("XXXAXTAAXATGTAG");
        */
       //XTAATGXXXTAAXXXXTGAXXTGAXTGATGXXXXXXXXXXXTAAXTGAXXTAGATGXXXATGZTAA
        System.out.println("dna:AATGCTAACTAGCTGACTAAT");
        printAllGenes("AATGCTAACTAGCTGACTAAT");
        /*System.out.println("dna:XXA");
        printAllGenes("XXA");
        System.out.println("dna:XXATGXX");
        printAllGenes("XXATGXX");
        System.out.println("dna:XXATGXXTAG");
        printAllGenes("XXATGXXTAG");
        System.out.println("dna:TAATAA");
        printAllGenes("TAATAA");*/
        
    }
    
    public static void testFindGene(){
        System.out.println("ATGXXXTAAXATG");
        System.out.println(findGene("ATGXXXTAAXATG"));
        System.out.println("XXXAXTAAXATGTAG");
        System.out.println(findGene("XXXAXTAAXATGTAG"));
        System.out.println("XTAATGXXXTAAXXXXTGAXXTGAXTGA");
        System.out.println(findGene("XTAATGXXXTAAXXXXTGAXXTGAXTGA"));
        System.out.println("XXA");
        System.out.println(findGene("XXA"));
        System.out.println("XXATGXX");
        System.out.println(findGene("XXATGXX"));
        System.out.println("XXATGXXTAG");
        System.out.println(findGene("XXATGXXTAG"));
        System.out.println("TAATAA");
        System.out.println(findGene("TAATAA"));
        
    }
    
    public static void testFindStopCodon(){
        System.out.println(findStopCodon("ATGXXXTAA",0,"TAA"));
        System.out.println(findStopCodon("XXXAXTAAXATGTAG",0,"TAA"));
        System.out.println(findStopCodon("XTAATGXXXTAAXXXXTGAXXTGAXTGA",0,"TAA"));
    }
    
    public static void main(String[] argus){
        testPrintAllGenes();
    }
}
