# https://leetcode.com/problems/sliding-window-maximum
class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        # 

        # bst (using SortedCollections module which provides complexity nearly the same as bst, but is not bst implementation)
        # sortedWindow = SortedList() # init a data structure that keeps track of all windows in sorted order (a balanced bst is common)
        # maxVals = []

        # # first window
        # for i in range(k): # init first window
        #     sortedWindow.add(nums[i])
        # maxVals.append(sortedWindow[-1])

        # for i in range(k, len(nums)): # for all subsequent windows
        #     # update the window, remove the leftmost value, add the next value
        #     sortedWindow.remove(nums[i - k])
        #     sortedWindow.add(nums[i])
        #     maxVals.append(sortedWindow[-1]) # then add the maxVal of the current window
        
        # return maxVals
            
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