def quickSort(alist):
   quickSortHelper(alist,0,len(alist)-1)

def quickSortHelper(alist,first,last):
   if first<last:

       splitpoint = partition(alist, first, last)

       quickSortHelper(alist,first,splitpoint-1)
       quickSortHelper(alist,splitpoint+1,last)

#
# def partition(A,p,r):
#   x = A[r]
#   i = p
#   while (A[i]<=x) and i<r:
#     i = i+1
#   for j in range(i+1,r):
#     if A[j]<=x:
#       A[i], A[j] = A[j], A[i]
#       i=i+1
#   return i-1

def partition(alist,first,last):
   pivotvalue = alist[first]

   leftmark = first+1
   rightmark = last

   done = False
   while not done:
       # move left until you find an element out of order
       while leftmark <= rightmark and alist[leftmark] <= pivotvalue:
           leftmark = leftmark + 1

       # move right until you find an element out of order
       while alist[rightmark] >= pivotvalue and rightmark >= leftmark:
           rightmark = rightmark -1

       # now we actually swap
       if rightmark < leftmark:
           done = True
       else:
           temp = alist[leftmark]
           alist[leftmark] = alist[rightmark]
           alist[rightmark] = temp

   temp = alist[first]
   alist[first] = alist[rightmark]
   alist[rightmark] = temp

   # elements are now sorted here => return right
   return rightmark

if __name__ == "__main__":
   test = [9,2,6,4,3,5,1]
   print(partition(test,0,len(test)-1))
   # quickSort(test)
   print(test)
