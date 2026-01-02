#https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy = sell = len(prices) - 1
        maxprofit = 0
        for i in range(len(prices) - 2, 0, -1):
            if prices[buy] > prices[i]:
                buy = i
                maxprofit = max(maxprofit, prices[sell] - prices[buy])
            if prices[sell] < prices[i] and sell > buy:
                sell = i
                maxprofit = max(maxprofit, prices[sell] - prices[buy])
        return maxprofit