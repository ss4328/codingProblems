# Quicksort

Quicksort is one of the most efficient sorting algorithms, and this makes of it one of the most used as well.  

## Algorithm

Quicksort has several implementations but they all mostly differ by just the choice of pivot. 
#### In this implementation, we'll just choose the midpoint element as pivot:

1) Select the midpoint as pivot in the chosen array range.

2) Swap elements around such that all elements less than the pivot come before all the elements bigger than it. This creates a natural division in the array.

3) Repeat above 1) and 2) for the left and right portions recursively.

#### Voila! The array is sorted.


![QS Animation](https://lamfo-unb.github.io/img/Sorting-algorithms/Quicksort.gif)



## Usage

```python
def quickSort(alist):
   quickSortHelper(alist,0,len(alist)-1)

def quickSortHelper(alist,first,last):
   if first<last:

       splitpoint = partition(alist,first,last)

       quickSortHelper(alist,first,splitpoint-1)
       quickSortHelper(alist,splitpoint+1,last)


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
```

## Complexity

- Averagely, we divide array in around equal partitions, then call quicksort on each partitions.

#### Good case (mostly)
- Quick math: In a good case, each element gets quicksort called on it about log N times. And each one of those is one swap.

- So, O(N Log N) time complexity overall.

#### Bad case (rarely ever)
- If we're having a really bad day and just choose worst pivots every time (very first or last element)

- Here we have n squared calls to quicksort and we get demoted to O(N^2) runtime. 

#### General info
- Quicksort operates under O(n log n) so it's theoretically one of the best sorting algorithms.
- Unless we have more information about the content of data (say we know all are 8 bit signed integers) or (say the array is nearly sorted with error of k),  we cannot do better than quicksort.
- Other sorting algorithms which are similarly complex than Quicksort are Mergesort. 



## Credits
[LAMFO-UNB](https://lamfo-unb.github.io/2019/04/21/Sorting-algorithms/#:~:text=%2B1%5D%20%3D%20temp-,Quicksort,greater%20numbers%20on%20the%20right.)

[HackerRank tutorial](https://www.youtube.com/watch?v=SLauY6PpjW4)

## License
[MIT](https://choosealicense.com/licenses/mit/)
