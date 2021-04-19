import java.util.*;

public class FourSum {
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            int length = nums.length;
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            if (length < 4) {
                return res;
            };
            Arrays.sort(nums);
            //System.out.println(Arrays.toString(nums));
            int m = length - 1;
            for (int i = 0; i < length; i++) {
                int iEle = nums[i];
                for (int j = i + 1; j < length; j++) {
                    int jEle = nums[j];
                    for (int k = j + 1; k < length; k++) {
                        int kEle = nums[k], mEle = nums[m];
                        int mTarget = target - iEle - jEle - kEle;
                        while (mEle >= mTarget && m > k) {
                            if (iEle + jEle + kEle + mEle == target) {
                                //System.out.println("yes");
                                List<Integer> newList = new ArrayList<Integer>();
                                newList.add(iEle);
                                newList.add(jEle);
                                newList.add(kEle);
                                newList.add(mEle);
                                res.add(newList);
                                break;
                            }
                            m -= 1;
                            while(nums[m] == mEle) {
                                m -= 1;
                            }
                            mEle = nums[m];
                        }
                        while (k < length && nums[k] == kEle) {
                            k += 1;
                        }
                        k -= 1;
                    }
                    m = length - 1;
                    while (j < length && nums[j] == jEle) {
                            j += 1;
                        }
                    j -= 1;
                }
                while (i < length && nums[i] == iEle) {
                    i += 1;
                }
                i -= 1;
            }
            return res;
        }
    }
}
