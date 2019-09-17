package item26;

class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; ++i) {
            if (nums[i - 1] == nums[i]) {
                for (int j = i; j < nums.length; j++) {
                    nums[j - 1] = nums[j];
                }
                len--;
                i--;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int result = s.removeDuplicates(nums);
        System.out.println(result);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
}
