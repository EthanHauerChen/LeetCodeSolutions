# https://leetcode.com/problems/sliding-window-maximum
class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        # bst (using SortedCollections module which provides complexity nearly the same as bst, but is not bst implementation)
        # bst = SortedList() #internal implementation not actually a bst, but has nearly bst time complexity
        # maxVal = [float('-inf')]
        # for i in range(k):
        #     bst.add(nums[i])
        #     maxVal[0] = max(maxVal[0], nums[i])

        # for i in range(k, len(nums)):
        #     bst.remove(nums[i - k ])
        #     bst.add(nums[i])
        #     maxVal.append(bst[-1])
        
        # return maxVal
            

        # brute force
        # numWindows = len(nums) - k + 1
        # answer = [0] * numWindows

        # for i in range(numWindows):
        #     end = i + k - 1
        #     maxVal = nums[i]
        #     for j in range(i + 1, end + 1):
        #         maxVal = max(nums[j], maxVal)
        #     answer[i] = maxVal
        
        # return answer