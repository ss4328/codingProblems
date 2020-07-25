import random
import math

def kquickSort(alist, k):
    quickSortHelper(alist, 0, len(alist) - 1, k)


def quickSortHelper(alist, first, last, k):
    if abs(first - last) > k:


        pivotvalue = (first+last)//2
        splitpoint = partition(alist, first, pivotvalue, last)

        quickSortHelper(alist, first, splitpoint - 1, k)
        quickSortHelper(alist, splitpoint + 1, last, k)
    else:
        return


def partition(alist, first, pivotvalue, last):

    leftmark = first + 1
    rightmark = last

    done = False
    while not done:
        # move left until you find an element out of order
        while leftmark <= rightmark and alist[leftmark] <= pivotvalue:
            leftmark = leftmark + 1

        # move right until you find an element out of order
        while alist[rightmark] >= pivotvalue and rightmark >= leftmark:
            rightmark = rightmark - 1

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
    # test = [9,2,6,4,3,5,1]
    test = [random.randint(1,100) for _ in range(100)]
    # print(len(test))
    kquickSort(test, 4)
    print(test)
