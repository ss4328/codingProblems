from bisect import bisect_left
class Solution(object):
    
    def findSmallestIndex(self, nums):
        if nums[-1]>nums[0]:
            return 0
        
        left,right = 0, len(nums)-1
        while(left<right):
            mid = left+(right-left)//2
            if(nums[mid]>nums[right]):
                left = mid+1
            else:
                right = mid
            
        return left
        
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if len(nums)==0:
            return -1
        if len(nums)==1:
            return 0 if nums[0]==target else -1
        
        # find smallest point index by binary search
        min_index = self.findSmallestIndex(nums)
        print(min_index)
                
        # run b_search on valid half
        index = -1
        if(target>nums[-1]):
            index = bisect_left(nums,target, 0, min_index)
        else:
            index = bisect_left(nums,target, min_index, len(nums))
        print(index,'index')
        return index if nums[index]==target else -1
        
