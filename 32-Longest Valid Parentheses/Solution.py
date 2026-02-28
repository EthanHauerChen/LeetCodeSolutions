# https://leetcode.com/problems/longest-valid-parentheses
class Solution:
    def longestValidParentheses(self, s: str) -> int:
        maxLength = 0
        stack = []
        localLength = 0
        stillValid = False
        for char in s:
            if char == '(':
                stack.append(char)
                localLength += 1
            elif char == ')':
                if stack:
                    stack.pop()
                    localLength += 1
                else:
                    stillValid = False
                    localLength = 0
            else:
                maxLength = max(maxLength, localLength)
                stillValid = True

        return maxLength
