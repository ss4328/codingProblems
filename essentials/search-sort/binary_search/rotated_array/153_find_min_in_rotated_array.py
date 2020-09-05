class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums)==1:
            return nums[0]
        
        if nums[0]<nums[-1]:
            return nums[0]
        
        left,right = 0, len(nums)-1
        while(left<right):
            mid = left+(right-left)//2
            
            #if mid is greater than the right value, shift mid rightwards
            if(nums[mid]>nums[right]):
                left = mid+1
            #mid is smaller or equal? make right as mid
            else:
                right = mid
            
        return nums[left]
        
