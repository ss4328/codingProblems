class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        
        sortedTill = 0
        
        for i in range(0,len(nums)):
            num = nums[i]
            if num !=0:
                nums[sortedTill], nums[i] = nums[i], nums[sortedTill]
                sortedTill+=1
