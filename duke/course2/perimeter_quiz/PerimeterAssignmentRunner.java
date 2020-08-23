import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int num = 0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()){
            num++;
        }
        return num;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double wholeLength = getPerimeter(s);
        int num = getNumPoints(s);
        return wholeLength / num;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double largestSide = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()){
            double currDist = prevPt.distance(currPt);
            largestSide = Math.max(largestSide, currDist);
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double bigX = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()){
            bigX = Math.max(bigX, currPt.getX());
        }
        return bigX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double bigPerimeter = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f); 
            Shape s = new Shape(fr);
            bigPerimeter = Math.max(bigPerimeter, getPerimeter(s));
        }
        
        return bigPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        double bigPerimeter = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f); 
            Shape s = new Shape(fr);
            double perimeter = getPerimeter(s);
            if(bigPerimeter < perimeter){
                temp = f;
                bigPerimeter = perimeter;
            }
            System.out.println(bigPerimeter+ "  "+perimeter+" "+f);
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int num = getNumPoints(s);
        System.out.println("number of points= " + num);
        double avgLength = getAverageLength(s);
        System.out.println("average length = " + avgLength);
        double largestLength = getLargestSide(s);
        System.out.println("largest length = " + largestLength);
        double bigX = getLargestX(s);
        System.out.println("largest X = " + bigX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double bigPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("largest perimeter of multiple files = "+bigPerimeter);

    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String fileBigPerimeter = getFileWithLargestPerimeter();
        System.out.println("File with the LargestPerimeter = "+fileBigPerimeter);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //pr.testPerimeter();
        //pr.testPerimeterMultipleFiles();
        pr.getFileWithLargestPerimeter();
    }
}
