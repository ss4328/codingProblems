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
            # return nums1[len(nums1)//2] if (len(nums2) == 0) else nums2[len(nums2)//2]
        
        #sequel sorted arrays
        if(nums2[0]>nums1[-1] or nums1[0]>nums2[-1]):
            print("case2")
            return (nums2[0]+nums1[-1])/2 if nums2[0]>nums1[-1] else (nums1[0]+nums2[-1])/2
        
        #sorted arrays but their ordering is unrelated
        # v1 = nums1[len(nums1)//2]
        # v2 = nums2[len(nums2)//2]
        
        #bruteforce case 3
        overall = nums1 + nums2
        overall.sort()
        print(overall)
        return self.findMedianSortedArrays(overall,[])
        # index = len(overall)//2
        # return overall[index] 
        
        # return (v1+v2)/2
