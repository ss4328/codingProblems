Solutions:
#Try #1
#Question 1
# two pointer approach, didn't think code is needed
def alternativeSorting(arr):
    arr.sort()
    ptr1 = 0
    ptr2 = len(arr)-1

    while(ptr1<ptr2):
        print(arr[ptr2])
        ptr2-=1
        print(arr[ptr1])
        ptr1+=1

# Complexity:	time->One pass therefore O(n)
# 		space->O(1)


#Question 2
# Input : arr[] = {6, 5, 3, 2, 8, 10, 9} k = 3          # any element can be at max k places out of place
# Output : arr[] = {2, 3, 5, 6, 8, 9, 10}
def kSorted(Arr, size):
    i, key, j = 0, 0, 0

    for i in range(size):
        key = Arr[i]
        j = i - 1

        while j >= 0 and Arr[j] > key:
            Arr[j + 1] = Arr[j]
            j = j - 1
        Arr[j + 1] = key

# Complexity:	time-> O(n^2)
# 		space->O(1)

# Too much time complexity therefore gotta redo this



#Question 3
def generateAbsoluteDiffSortedArray(k,arr):
    print("k absolute sorted numbers:")
    res = numberArray
    res.sort()
    # for j in range(0,len(res)):
    #     print(res[j])
    result=[]
    ptr1 = getptr1Index(k,res)
    ptr2 = ptr1+1
    print("PTR1 is: " + str(ptr1))

    while(ptr1!=-1 and ptr2!=len(res)):
        res1 = abs(k-res[ptr1])
        res2 = abs(k-res[ptr2])
        if(res1>res2):
            result.append(res[ptr2])
            ptr2+=1
        else:
            result.append(res[ptr1])
            ptr1-=1

#handle remaining numbers
    while(ptr1!=-1):
        result.append(res[ptr1])
        ptr1-=1

    while(ptr2!=len(res)):
        result.append(res[ptr2])
        ptr2+=1

    return result

def getptr1Index(k,arr):
    if(k in arr):
        return arr.index(k)
    else:
        return getptr1Index(k-1,arr)


# Complexity:	time->getPtr1Index is O(n) since it’s a linear search (unsorted arr). Hence O(n^2)
# 		space->O(n)		because of memory requisition by using res

#Question 4
#just thought of this question as edited version of #1. 
# Sort, then do #1 --> Thought a lot but couldn't think of a better approach.   ->nlogn then one pass as in #1




#Question 5
#get n in m and then sort



#Question 6
# Input : arr[] = {10, 7, 9, 2, 8, 3, 5, 4, 6, 1};
# Output : 1 2 3 4 5 6 7 8 9 10

#How is this any different than the regular sorts? -> because we know n, and we only have to sort 1 to n
#leveraging that, I see we should use the upper limit somehow
#n->n-1 index
def sortOneToN(arr, n):
    for i in range(n):
        arr[i] = i+1
    return arr


# Complexity:	time-> O(n)
# 		space->O(1)



#question 8
# Input :  arr[] = [0, 1, 0, 1, 0, 0, 1, 1, 1, 0]
# Output : arr[] = [0, 0, 0, 0, 0, 1, 1, 1, 1, 1]
#20 mins
# try 1


def segregateBinaryNumbers(arr):
    res = [None] * len(arr)
    ptr1 = 0
    ptr2 = len(res)-1
    size = len(arr)

    for i in range(0, size):
        if(arr[i]==0):
            print("Zero")
            res[ptr1]=arr[i]
            ptr1+=1
        else:
            print("One")
            res[ptr2]=arr[i]
            ptr2-=1

    return res


# Complexity:	time-> O(n)
# 		space->O(n)		since we do mem requisition for res


#question 9 -> Hashmap somehow. Dunno how
#question 10-> dunno how.




# Try #2
#question 4

# Maybe just sort of like alternative swapping with conditions?
#just ensure even numbered elements are bigger than odd positioned elements
def waveSort(arr):
    for i in range(0,len(arr),2):
        #previous element check -> 0 is edge case
        if(i>0 and arr[i]<arr[i-1]):
            swap(arr, i, i-1)
        #next element check -> last element edge case
        if(i<len(arr)-1 and arr[i]< arr[i+1]):
            swap(arr,i,i+1)


# Complexity:	time-> O(n)
# 		space->O(1)



#5
#Copy n into m+N array, after m's elements, then finally we sort (merge sort)
def mergeTwoSortedArrays(m,n):
    #copy n into m+n's array
    for i  in range (len(m)-len(n), len(m)-1):
        m[i]=n[i-(len(m)-len(n))]

    #merge() the list now with partitions (0->len(m-n) (len(m-n) - > len(m))
    merge(m, 0, (len(m)-len(n)), len(m))

def merge(arr,l,m,r):
    n1 = m-l+1
    n2 = r-m

    #create temp array left
    L = [None]* n1
    for i in range(0,n1):
        L[i] = arr[l+i]

    #create temp array right
    R = [None] * n2
    for i in range(0,n2):
        R[i] = arr[m+1+i]

    i,j=0
    k=1

    while(i<n1 and j<n2):
        if L[i] <= R[j]:
            arr[k] = L[i]
            i += 1
        else:
            arr[k] = R[j]
            j += 1
        k += 1

    # Copy the remaining elements of L[], if there
    # are any
    while i < n1:
        arr[k] = L[i]
        i += 1
        k += 1

    # Copy the remaining elements of R[], if there
    # are any
    while j < n2:
        arr[k] = R[j]
        j += 1
        k += 1
        
# Complexity:	time->?? Debugging nightmare
# 		space->O(??)

#8
def segregateBinaryNumbers(arr):
    ptr1 = 0
    ptr2 = len(arr)-1
    size = len(arr)

    i=0
    while(ptr1<ptr2):
            if(arr[i]==0):
                #swap 0 to first available position
                # while(arr[ptr1]==0):
                #     ptr1+=1
                swap(arr,ptr1, i)
                ptr1+=1
            else:
                #swap 1 to last available position
                # while (arr[ptr2] == 1):
                #     ptr2 -= 1
                swap(arr, ptr2, i)
                ptr2-=1
            i+=1
    return arr

#should I pass everything onto this helper? Could make it work like the merge function

def swap(arr, ptrPos, currentPos):
    temp = arr[ptrPos]
    arr[ptrPos] = arr[currentPos]
    arr[currentPos] = temp


# Doesn’t matter. Buggy solution: doesn’t handle cases in which the last element is 1 or the first element is 0. It’ll blindly swap to give an incorrect solution
# space->O(1)

