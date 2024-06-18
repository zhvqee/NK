package nk;

import java.util.Arrays;

import static nk.NK.print;

public class NK13 {
    //1,2,4,6,5
    //1,2,5,6,4 ==>1,2,5,4,6

    //1,2,3,4,5

    //5,4,3,2,1
    //1,4,3,2,5-> 1,2,3,4,5
    public int[] nextSort(int[] arr) {
        int i = arr.length - 1;
        int key = arr[arr.length - 1];
        while (i >= 0) {
            if (arr[i] < key) {
                break;
            }
            i--;
        }
        if (i < 0) {
            i = 0;
        }
        int tmp = arr[i];
        arr[i] = key;
        arr[arr.length - 1] = tmp;
        Arrays.sort(arr, i + 1, arr.length);
        return arr;
    }


    public static void main(String[] args) {
        NK13 nk13 = new NK13();
        int[] ints = nk13.nextSort(new int[]{5, 4, 3, 2, 1});
        print(ints);
    }
}
