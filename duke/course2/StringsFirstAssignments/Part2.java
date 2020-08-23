
/**
 * 在这里给出对类 Part1 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Part2 {
    public static String findSimpleGene(String dna, String startCodon, String stopCodon){
        String result = "";
        String dna2 = dna.toUpperCase();
        int startIndex = dna2.indexOf(startCodon);
        if (startIndex==-1) {
            return result;
        }
        int stopIndex = dna2.indexOf(stopCodon, startIndex+3);
        if (stopIndex==-1){
            return result;
        }
        int diff = stopIndex - startIndex;
        if (diff % 3 == 0){
            result = dna.substring(startIndex, stopIndex+3);
        }
        return result;
        // input is uppercase, then return upperse. done.
        // input is lowercase, then return lowercase. undone. 
    }
    
    public static void testSimpleGene(){
        String dna1 = "ATGTAGCTTAAACCTTTAAAGCAAGGCACTGAAAATGCCTA";
        System.out.println("Given gene is "+dna1);
        System.out.println("Gene is "+findSimpleGene(dna1,"ATG","TAA"));
        String dna2 = "CTTATGAAAACTCAAAGGTAAACTTGGCGGTGCTTTACATCCCCCTAGAGGAGCCTG";
        System.out.println("Given gene is "+dna2);
        System.out.println("Gene is "+findSimpleGene(dna2,"ATG","TAA"));
        String dna3 = "TTATTATGAAATAAATGACTAAAGGAGGATTTAGTAGTAAATTAAGATCAGAGAGCTTA";
        System.out.println("Given gene is "+dna3);
        System.out.println("Gene is "+findSimpleGene(dna3,"ATG","TAA"));
        String dna4 = "TTGACCACTATGTTGAACTAAGCCTAGCCCGACCCGACCCAAACAAAACTACCACACACA";
        System.out.println("Given gene is "+dna4);
        System.out.println("Gene is "+findSimpleGene(dna4,"ATG","TAA"));
        String dna5 = "gatgctataat";
        System.out.println("Given gene is "+dna5);
        System.out.println("Gene is "+findSimpleGene(dna5,"ATG","TAA"));
        String dna6 = "atgtaa";
        System.out.println("Given gene is "+dna6);
        System.out.println("Gene is "+findSimpleGene(dna6,"ATG","TAA"));
    }
    
    public static void main(String[] argus){
        testSimpleGene();
        char a = 'a';
        int x = (int) a;
        System.out.println(x);
        char A = 'A';
        int y = (int) A;
        System.out.println(y);
        System.out.println(x-y);
    }
}

