class Solution:
    
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        
        #one empty array? return the median of filled array.
        if(len(nums1) == 0 or len(nums2)==0):
            print("case1")
            non_empty = nums1 if len(nums2)==0 else nums2
            if(len(non_empty)%2==0):
                mid_1 = len(non_empty)//2
                return (non_empty[mid_1]+non_empty[mid_1-1])/2
            else:
                return non_empty[len(non_empty)//2]
            
        
        #two non-empty arrays
        overall = nums1 + nums2
        overall.sort()
        n = len(overall)
        
        return self.findMedianSortedArrays(overall,[])
        
