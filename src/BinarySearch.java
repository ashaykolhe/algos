import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//https://www.geeksforgeeks.org/complexity-analysis-of-binary-search/
public class BinarySearch {
    public static void main(String[] args) {
        Comparator<Integer> integerComparator = (o1, o2) -> {
            return o1.compareTo(o2);
        };

        Comparator<String> stringComparator  = (o1, o2) -> {
            return o1.compareTo(o2);
        };
//        System.out.println(comparator.compare(1,2));
//        System.out.println(comparator.compare(3,2));
//        System.out.println(comparator.compare(2,2));

        List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
        Integer num = 2;
        System.out.println(binarySearch(nums, num, integerComparator));
//        System.out.println(binarySearchIterative(nums, num, integerComparator));

        List<String> chars = Arrays.asList("A","B","C","D","E");
        String cha = "D";
        System.out.println(binarySearch(chars, cha, stringComparator));
//        System.out.println(binarySearchIterative(chars, cha, stringComparator));

//        nums = Arrays.asList(1,8,2,9,3,4,5,6);
//        num = 4;
//        System.out.println(binarySearch(nums, num, integerComparator));

        num = 40;
        System.out.println(binarySearch(nums, num, integerComparator));
//        System.out.println(binarySearchIterative(nums, num, integerComparator));
    }

    public static <T> Integer binarySearch(List<T> list, T searchTerm, Comparator<T> comparator) {
        if(list.isEmpty() || list.size() == 1) return -1;
        int length = list.size();
        int finalLength = (length/2)+(length%2);
        Integer result = comparator.compare(searchTerm, list.get(finalLength));;

        if(result == 0){
            return finalLength;
        } else if(result == 1) {
            return binarySearch(list.subList(finalLength, length), searchTerm, comparator);
        } else if(result == -1) {
            return binarySearch(list.subList(0, finalLength), searchTerm, comparator);
        }

        return -1;


    }

    public static <T> Integer binarySearchIterative(List<T> list, T searchTerm, Comparator<T> comparator) {
        if(list.isEmpty()) return -1;

        int length = list.size();
        int left = 0;
        int middle = (length/2)+(length%2);
        int right = length-1;

        for (; left != middle;) {
            int index = comparator.compare(searchTerm, list.get(middle));
            if(index == 0) {
                return middle;
            } else if (index == 1) {
                left = middle;
            } else {
                right = middle;
            }
            middle = ((right - left)/2)+((right - left)%2);
        }

        return -1;
    }
}
