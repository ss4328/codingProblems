class Solution(object):
    def findPeakRecur(self, nums, low, high):
        #mid
        i = low + ((high - low) / 2)
        print(i)
        if(i is len(nums)-1):
            if nums[i]> nums[i-1]:
                return i
        elif(i is 0):
            if nums[i]> nums[i+1]:
                return i
        
        if(nums[i]>nums[i+1] and nums[i]>nums[i-1]):
            return i
        elif(nums[i]>nums[i+1]):
            #go left
            return self.findPeakRecur(nums, low, i)
        else:
            #go right
            return self.findPeakRecur(nums, i+1, high)
    
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        if len(nums)<=1:
            return 1 if len(nums)==2 else 0
        low = 0
        high = len(nums)-1
        return self.findPeakRecur(nums, low, high)
        
