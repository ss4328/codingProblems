from bst import BST
import math
import random

if __name__=="__main__":

    #master array of different n's as sizes
    n_array = [2, 4, 8, 16, 32, 64, 128,256, 512, 1024]
    exp_res_array = []

    #declaring empty array
    for i in range(0,len(n_array)):
        exp_res_array.append([None]*5)
    print(exp_res_array)

    for j in range(0, len(n_array)):
        for k in range(0,5):
            n = n_array[j]
            total_numbers = pow(5,n)
            arr = [None]*n
            random.seed(random.randint(0,50))

            #populating the array
            for i in range(0,n):
                randint = random.randint(0,total_numbers)
                arr[i] = randint

            #initiating and populating the bst
            tree = BST()
            for i in range(len(arr)):
                tree.insert(arr[i])

            #getting the height of the tree
            print("For n: "+str(n) + ", tree height is " + str(tree.height()))
            exp_res_array[j][k] = tree.height()

    print("Exp results are as follows:")
    print(exp_res_array)





