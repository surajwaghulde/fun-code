package fibonacci;

public class FirstThirdIterative {

    int result;
    
    public int firstThird(int iterations) {
        int first = 0;
        int second = 1;
        int third = 1;
        
        while (iterations > 1) {
            result = first + third;
            first = second;
            second = third;
            third = result;
            System.out.print(result + ",");
            iterations--;
        }
        System.out.println(first + third);
        
        return result;
    }
    
    public static void main(String [] args) {
        FirstThirdIterative firstThird = new FirstThirdIterative();
        firstThird.firstThird(25);
    }
    
    
}
