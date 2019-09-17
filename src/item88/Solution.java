package item88;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = 0, q = 0;
        while (q < n || p < m) {
            if (p == m) {
                for (int i = q; i < nums2.length; i++) {
                    nums1[p++] = nums2[i];
                    m++;
                }
                return;
            } else if (nums1[p] < nums2[q]) {
                p++;
            } else {
                for (int i = m - 1; i >= p; i--) {
                    nums1[i + 1] = nums1[i];
                }
                q++;
                m++;
                p++;
            }
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = {1};
        int[] nums2 = {};
        s.merge2(nums1, 1, nums2, 0);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i]);
        }
    }
}
