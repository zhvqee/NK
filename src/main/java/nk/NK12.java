package nk;

public class NK12 {

    public int getMiddle(int[] arr1, int[] arr2) {
        if (arr1.length == 1) {
            return Math.min(arr1[0], arr2[0]);
        }

        int i = 0;
        int j = 0;
        int middle = arr1.length - 1;
        while (j < middle && i < middle) {
            if (arr1[i] <= arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return Math.min(arr1[i], arr2[j]);
    }

    public static void main(String[] args) {
        NK12 nk12 = new NK12();
        System.out.println(nk12.getMiddle(new int[]{0, 1, 2}, new int[]{3, 4, 5}));
    }
}
