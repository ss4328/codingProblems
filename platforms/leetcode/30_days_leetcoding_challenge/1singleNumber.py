#Given a non-empty array of integers, every element appears twice except for one Find that single one.

class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        return 2*sum(set(nums))-sum(nums)
        
