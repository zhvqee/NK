package nk;

public class NK15 {

    public double getMid(int[] arr1, int[] arr2) {
        int len = arr1.length + arr2.length;
        int mid = 0;

        int i = 0;
        int j = 0;
        if (len % 2 == 0) {
            mid = len / 2 - 1;
        } else {
            mid = len / 2;
        }
        int k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                i++;
            } else {
                j--;
            }
            if (k == mid) {
                break;
            }
            k++;
        }

        if (k != mid) {
            if (i == arr1.length) {
                j += mid - arr1.length;
            } else if (j == arr2.length) {
                i += mid - arr2.length;
            }
        }
        if (i != arr1.length && j != arr2.length) {

        }
        return -1;
    }


    public static void main(String[] args) {

    }
}
