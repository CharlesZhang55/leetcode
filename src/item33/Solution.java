package item33;

public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        int rotation_index = findRotateIndex(nums);
        if (target <= nums[rotation_index] && target >= nums[0]) {
            return biSearch(nums, 0, rotation_index, target);
        } else {
            return biSearch(nums, rotation_index + 1, nums.length - 1, target);
        }
    }

    public int biSearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
            else return mid;
        }
        return -1;
    }

    public int findRotateIndex(int nums[]) {
        int mid = (nums.length - 1) / 2;
        int left = 0, right = nums.length - 1;
        if (nums[left] < nums[right]) return 0;
        while (left <= right) {
            if (nums[mid] > nums[mid + 1]) return mid;
            else if (nums[mid] >= nums[left]) {
                left = mid + 1;
                mid = (left + right) / 2;
            } else {
                right = mid - 1;
                mid = (left + right) / 2;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {8,9,2,3,4};
        System.out.println(s.search(nums, 9));
    }
}
