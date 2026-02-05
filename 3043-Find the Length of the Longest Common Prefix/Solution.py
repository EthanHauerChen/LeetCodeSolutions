# https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/

class Solution:
    def longestCommonPrefix(self, arr1: List[int], arr2: List[int]) -> int:
        #trie (prefix tree) implementation
        #tree, each node is a digit of a num, if child exists, then prefix exists
        root = {} # initialize empty dict, will store the trie, each pair represents a digit
        for num in arr1: # for each digit in each num, store in the trie
            digits = str(num) # convert to str for easier traversal of the digits
            current = root # current node of the trie
            for digit in digits:
                if digit not in current:
                    current[digit] = {} # add current digit to current node's children
                current = current[digit] # advance the node to the next digit in the trie
        # trie is now constructed

        maxLength = 0
        for num in arr2:
            digits = str(num)
            current = root
            length = 0 # as we traverse the trie, stores the length of the shared prefix
            for digit in digits:
                if digit not in current: #reached end of traversal, exit loop
                    break
                length += 1
                current = current[digit]
            maxLength = max(length, maxLength)

        return maxLength

        #set implementation
        # prefixes = set() # create a set to hold all possible prefixes of arr1
        # for num in arr1: # for each number, store all prefixes in the set
        #     prefix = num
        #     while prefix != 0: # prefix repeatedly divide by 10 until division yields 0
        #         prefixes.add(prefix)
        #         prefix //= 10

        # maxLength = 0
        # for num in arr2: # for each num in arr2, check if its prefixes exist in the prefix set
        #     prefix = num
        #     while prefix != 0:
        #         if prefix in prefixes:
        #             maxLength = max(maxLength, int(math.log10(prefix)) + 1) # log 10 is a way to get num digits for base 10
        #             break
        #         prefix //= 10
        # return maxLength