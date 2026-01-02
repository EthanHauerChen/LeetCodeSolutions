#https://leetcode.com/problems/merge-two-sorted-lists/
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def copyNode(self, node: Optional[ListNode]):
        if node:
            return ListNode(node.val, node.next)
        return None

    def advanceNode(self, node: Optional[ListNode]):
        if node:
            node = node.next
        return node

    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        # new, cool solution
        head = ListNode()
        current = head
        while list1 and list2:
            if list1.val < list2.val:
                current.next = list1
                list1 = list1.next
            else:
                current.next = list2
                list2 = list2.next
            current = current.next
        # add last element for either list1 or list2
        if list1:
            current.next = list1
        elif list2:
            current.next = list2
        return head.next

        # old, inelegant solution
        # l1 = list1
        # l2 = list2
        # if not l1:
        #     head = self.copyNode(l2)
        #     l2 = self.advanceNode(l2)
        # elif not l2:
        #     head = self.copyNode(l1)
        #     l1 = self.advanceNode(l1)
        # else:
        #     if l1.val < l2.val:
        #         head = self.copyNode(l1)
        #         l1 = self.advanceNode(l1)
        #     else:
        #         head = self.copyNode(l2)
        #         l2 = self.advanceNode(l2)
        # if not head:
        #     return head
        # current = head
        
        # while True:
        #     if not l1:
        #         current.next = self.copyNode(l2)
        #         l2 = self.advanceNode(l2)
        #     elif not l2:
        #         current.next = self.copyNode(l1)
        #         l1 = self.advanceNode(l1)
        #     else:
        #         if l1.val < l2.val:
        #             current.next = self.copyNode(l1)
        #             l1 = self.advanceNode(l1)
        #         else:
        #             current.next = self.copyNode(l2)
        #             l2 = self.advanceNode(l2)
        #     if not current or not current.next:
        #         return head
        #     current = current.next
        # return head


