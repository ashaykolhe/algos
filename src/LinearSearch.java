import java.util.Arrays;
import java.util.List;

public class LinearSearch {
    public static void main(String[] args) {
        //sorted or unsorted
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
        Integer num = 3;
//        System.out.println(linearSearch(nums, num));
        System.out.println(improvedLS(nums, num));

        List<String> chars = Arrays.asList("A","B","C","D","E");
        String cha = "D";
//        System.out.println(linearSearch(chars, cha));
        System.out.println(improvedLS(chars, cha));

        nums = Arrays.asList(1,8,2,9,3,4,5,6);
        num = 4;
//        System.out.println(linearSearch(nums, num));
        System.out.println(improvedLS(nums, num));

        num = 40;
//        System.out.println(linearSearch(nums, num));
        System.out.println(improvedLS(nums, num));
    }

    public static <T> Integer linearSearch(List<T> list, T searchObject) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("i "+(i+1));
            if(searchObject.equals(list.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static <T> Integer improvedLS(List<T> list, T searchTerm) {

        int length = list.size();
        int finalLength = (length/2)+(length%2);
        System.out.println("finalLength "+finalLength);
        int left = 0;
        int right = length-1;

        for (int i = 0; i < finalLength; i++) {
            System.out.println("i "+(i+1));
            if(searchTerm.equals(list.get(left))) {
                return left;
            }
            if(searchTerm.equals(list.get(right))) {
                return right;
            }
            left++;
            right--;
        }


        return -1;
    }
}
