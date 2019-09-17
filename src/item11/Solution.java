package item11;

public class Solution {
    public int maxArea(int[] height) {
        int p = 0, q = height.length - 1;
        int result = 0;
        while (p < q) {
            int h = Math.min(height[p], height[q]);
            result = Math.max(result, h * (q - p));
            if (height[p] < height[q]) {
                p++;
            } else {
                q--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(s.maxArea(height));
    }
}
