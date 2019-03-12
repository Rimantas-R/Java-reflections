package apps;
import java.util.Arrays;

public class SortingQuiz {
	 public static void main(String[] args) {

         Long[] numbers = {-2000000000L, 2000000000L, 0L}; 

         Arrays.sort(numbers, (a, b) -> (int)((b-a)/10000)); 

         System.out.println(Arrays.asList(numbers));//, (a, b) -> (a - b)
         System.out.println(Integer.MIN_VALUE + " " + Integer.parseInt("11aff", 1, 3, 16));

   }


}
