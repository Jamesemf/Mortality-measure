package dm.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AlphaMergeSort {

    void merge(ArrayList<Integer> AR, int left, int mid, int right) {
        // Find sizes of two subarrays to be merged 
        int n1 = mid - left + 1;
        int n2 = right - mid;


        /* Create temp arrays */
        //int L[] = new int[n1];
        ArrayList<Integer> Left = new ArrayList<>();
        //int R[] = new int[n2];
        ArrayList<Integer> Right = new ArrayList<>();


        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) {
            Left.add(i, AR.get(left + i));
        }
        for (int j = 0; j < n2; ++j) {
            Right.add(j, AR.get(mid + 1 + j));
        }


        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0;

        // Initial index of merged subarry array 
        int k = left;
        while (i < n1 && j < n2) {
            if (Left.get(i) <= Right.get(j)) {
                AR.set(k, Left.get(i));
                i++;
            } else {
                AR.set(k, Right.get(j));
                j++;
            }
            k++;
        }


        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            AR.set(k, Left.get(i));
            i++;
            k++;
        }


        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            AR.set(k, Right.get(j));
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using 
    // merge() 
    void sort(ArrayList<Integer> array, int l, int r) {
        if (l < r) {
            // Find the middle point 
            int m = (l + r) / 2;

            // Sort first and second halves 
            sort(array, l, m);
            sort(array, m + 1, r);

            // Merge the sorted halves 
            merge(array, l, m, r);
        }
    }


    /* A method to print array of size n */
      void printArray(ArrayList<String> array) {
        int n = array.size();
        for (int i = 0; i < n; ++i) {
        }
    }

    public static int convert(String name) {        //Giving each string a numeric value so it can be sorted
        int number = name.charAt(0) * 10000 + name.charAt(1) *100 + name.charAt(name.length() - 1) + name.charAt(name.length()-2)+ name.charAt(name.length()-3)  + name.length();
        return number;
    }

    // Driver method to sort arraytlist into an alphabetical order
    public static ArrayList OrderAlphabeticaly(HashMap<String, String> map) {
        ArrayList<String> words = new ArrayList<>();

        for (Map.Entry m : map.entrySet()) {
            words.add(m.getKey().toString());


        }

        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<OrderAlpha> IDK = new ArrayList<>();

        for (int i = 0; i < words.size(); i++) {
            OrderAlpha One = new OrderAlpha(words.get(i), convert(words.get(i)));
            IDK.add(One);
            numbers.add(convert(words.get(i)));

 
        }

        AlphaMergeSort ob = new AlphaMergeSort();
        ob.sort(numbers, 0, numbers.size() - 1);

        for (int i = 0; i < numbers.size(); i++) {
        }

        for (int i = 0; i < words.size(); i++) {            //Linear sort Assigning the words where there values matches
            for (int j = 0; j < words.size(); j++) {
                if (IDK.get(j).getNumber() == numbers.get(i)) {

                    words.set(i, IDK.get(j).getName());
                }
            }
        }
        
        return words;

    }
}
