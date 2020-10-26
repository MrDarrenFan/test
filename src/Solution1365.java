/*
1365. 有多少小于当前数字的数字

给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
以数组形式返回答案。

示例 1：
    输入：nums = [8,1,2,2,3]
    输出：[4,0,1,1,3]
    解释：
    对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
    对于 nums[1]=1 不存在比它小的数字。
    对于 nums[2]=2 存在一个比它小的数字：（1）。
    对于 nums[3]=2 存在一个比它小的数字：（1）。
    对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。

示例 2：
    输入：nums = [6,5,4,8]
    输出：[2,1,0,3]

示例 3：
    输入：nums = [7,7,7,7]
    输出：[0,0,0,0]

提示：
    2 <= nums.length <= 500
    0 <= nums[i] <= 100
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1365 {

    public static void main(String[] args) {
        Solution1365 solution1365 = new Solution1365();
        System.out.println(Arrays.toString(solution1365.smallerNumbersThanCurrent(new int[]{5,0,10,0,10,6})));
    }

    // 排序后根据数字所在位置记录答案
    // O(nlogn), O(k)   k为值域大小
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int length = nums.length;
        int[] countSmaller = Arrays.copyOf(nums, length);
        Arrays.sort(nums);
        // 利用map记录排序后某数所在的位置
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = length - 1; i >= 0; i--) {
            indexMap.put(nums[i], i);
        }
        // 写入答案数组
        for (int i = 0; i < length; i++) {
            countSmaller[i] = indexMap.get(countSmaller[i]);
        }
        return countSmaller;
    }

}
