package nk;

import java.util.Arrays;

public class NK14 {

    public int absolute(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0;
        int right = 0;
        int cur = Integer.MAX_VALUE;
        int dis = Integer.MAX_VALUE;
        int sum = 0;
        while (right < arr.length) {
            sum += arr[right];
            if (right - left == 2) {
                int d = Math.abs(sum - target);
                if (d < dis) {
                    cur = sum;
                    dis = d;
                }
                sum -= arr[left];
                left++;
            }
            right++;
        }
        return cur;
    }


    public static void main(String[] args) {
        NK14 nk14 = new NK14();
        int v1 = nk14.absolute(new int[]{-1, 2, 1, -4}, 1);
        System.out.println(v1);
        int v2 = nk14.absolute(new int[]{0, 0, 0}, 1);
        System.out.println(v2);

        int v3 = nk14.absolute(new int[]{0, 0, 0,1}, 0);
        System.out.println(v2);
    }
}
