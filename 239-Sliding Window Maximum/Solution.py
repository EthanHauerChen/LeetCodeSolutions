# https://leetcode.com/problems/sliding-window-maximum
class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        # deque
        '''
        deque dQ will store the maxVal of the current window at dQ[0].
        this invariant is maintained by doing the following for each iteration:
            1. checking to see if dQ[0] is still in the current window by checking nums[startIndexOfWindow] == dQ[0]
            and removing it if true, guaranteeing that dQ[0] only contains the max for the current window (and not prior windows)
            2. placing the max of the new window at dQ[0]. this is done by starting from the end of dQ and 
            popping elements of dQ until the endmost elem of dQ is greater than the new elem being inserted
        '''
        dQ = deque([])
        maxVals = [0] * (len(nums) - k + 1)

        for i in range(k): # init first window, which is diff from the other windows as checking to see if dQ[0] is still in the window is unnecessary
            while dQ and dQ[-1] < nums[i]: # starting from the end, remove elems from deque if smaller than nums[i]
                dQ.pop()
            dQ.append(nums[i])
        maxVals[0] = dQ[0]

        for i in range(k, len(nums)): # same as above with extra check to see if dQ[0] still in the current window
            if dQ[0] == nums[i - k]: # remove dQ[0] if no longer in the window
                dQ.popleft()
            while dQ and dQ[-1] < nums[i]:
                dQ.pop()
            dQ.append(nums[i])
            maxVals[i - k + 1] = dQ[0]

        return maxVals

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