import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {

    private static int[] mergeArray(int[] arrA, int[] arrB) {
        int[] mergedArray = new int[arrA.length + arrB.length];

        int i = 0, j = 0, k = 0;

        while (i < arrA.length && j < arrB.length) {
            if (arrA[i] < arrB[j]) {
                mergedArray[k] = arrA[i];
                i++;
                k++;
            } else {
                mergedArray[k] = arrB[j];
                j++;
                k++;
            }
        }
        while (i < arrA.length) {
            mergedArray[k] = arrA[i];
            i++;
            k++;
        }
        while (j < arrB.length) {
            mergedArray[k] = arrB[j];
            j++;
            k++;
        }

        Set<Integer> set = new HashSet<Integer>();

        for (int m = 0; m < mergedArray.length; m++) {
            set.add(mergedArray[m]);
        }

        Iterator<Integer> itr = set.iterator();

        int[] mergedArrayNoDups = new int[set.size()];

        int n = 0;

        while (itr.hasNext()) {
            mergedArrayNoDups[n] = itr.next();
            n++;
        }

        Arrays.sort(mergedArrayNoDups);

        return mergedArrayNoDups;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] { 1, 2, 3, 13, 11, 5, 6, 9 };
        int[] arr2 = new int[] { 2, 3, 5, 7, 8, 10, 13 };

        int[] mergedArray = mergeArray(arr1, arr2);

        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));

        System.out.println("Merged Array: " + Arrays.toString(mergedArray));
    }
}
