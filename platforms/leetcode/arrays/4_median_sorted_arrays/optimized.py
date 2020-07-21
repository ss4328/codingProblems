class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """ 
        
        x = len(nums1)
        y = len(nums2)
        total_n = y + x 
        
        if(y<x):
            return self.findMedianSortedArrays(nums2,nums1)  #ensuring y is greater than x as we'll iterate on x
        
        start, end = 0, x
        
        #here, we'll iterate on n1; positioning on n2 (i.e.y) is dependent on positioning on n1
        while(start<=end):
            px = (start+end) // 2            #partition of x
            py = ((total_n+1) // 2) - px     #partition of y
            
            max_left_x = float('-inf') if px==0 else nums1[px-1]
            min_right_x = float('inf') if px==x else nums1[px]
            max_left_y = float('-inf') if py==0 else nums2[py-1]
            min_right_y = float('inf') if py==y else nums2[py]
            
            #using the inherent property of sorted array, we try to find the optimum location for placing our partitions via b_search
            if(max_left_x <= min_right_y) and (max_left_y <= min_right_x):
                if((total_n)%2 != 0):
                    return max(max_left_x, max_left_y) 
                else:
                    return (max(max_left_x, max_left_y) + min(min_right_x, min_right_y)) / 2.0
            elif(max_left_x>min_right_y):
                end-=1
            else:
                start+=1
        
        raise Exception('garbage array')
        
