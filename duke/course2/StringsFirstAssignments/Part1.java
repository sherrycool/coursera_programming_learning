
/**
 * 在这里给出对类 Part1 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Part1 {
    public static String findSimpleGene(String dna){
        String result = "";
        int startIndex = dna.indexOf("ATG");
        if (startIndex==-1) {
            return result;
        }
        int stopIndex = dna.indexOf("TAA", startIndex+3);
        if (stopIndex==-1){
            return result;
        }
        int diff = stopIndex - startIndex;
        if (diff % 3 == 0){
            result = dna.substring(startIndex, stopIndex+3);
        }
        return result;
    }
    
    public static void testSimpleGene(){
        String dna1 = "ATGTAGCTTAAACCTTTAAAGCAAGGCACTGAAAATGCCTA";
        System.out.println("Given gene is "+dna1);
        System.out.println("Gene is "+findSimpleGene(dna1));
        String dna2 = "CTTATGAAAACTCAAAGGTAAACTTGGCGGTGCTTTACATCCCCCTAGAGGAGCCTG";
        System.out.println("Given gene is "+dna2);
        System.out.println("Gene is "+findSimpleGene(dna2));
        String dna3 = "TTATTATGAAATAAATGACTAAAGGAGGATTTAGTAGTAAATTAAGATCAGAGAGCTTA";
        System.out.println("Given gene is "+dna3);
        System.out.println("Gene is "+findSimpleGene(dna3));
        String dna4 = "TTGACCACTATGTTGAACTAAGCCTAGCCCGACCCGACCCAAACAAAACTACCACACACA";
        System.out.println("Given gene is "+dna4);
        System.out.println("Gene is "+findSimpleGene(dna4));
        String dna5 = "CTAGAGATGTAAGCATTATCACAATCCATAGTAGGCCTAGAAGCAGCCACCA";
        System.out.println("Given gene is "+dna5);
        System.out.println("Gene is "+findSimpleGene(dna5));
        String dna6 = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println("Given gene is "+dna6);
        System.out.println("Gene is "+findSimpleGene(dna6));
        
    }
    
    public static void main(String[] argus){
        testSimpleGene();
    }
}
