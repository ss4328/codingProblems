def impact(floor):
    return floor*10

case_health = 420
def testFloor(floor):
    if case_health<=impact(floor):
        return True
    return False

def findFloorRecur(low, high):
    print(high)
    mid = (low+high)//2
    # if we break case at a level who's previous floor failed to break, return the floor -> that's the answer
    if(testFloor(mid) and not testFloor(mid-1)):
        return mid
    # if mid and mid-1 both break the case, we're at higher than the answer
    # look left
    elif(testFloor(mid) and  testFloor(mid-1)) :
        return findFloorRecur(low, mid)
    else:
        return findFloorRecur(mid+1, high)

def findFloor(floor_cound):
    return findFloorRecur(0,floor_count)





if __name__=='__main__':
    floor_count = int(input("What's the building size?"))
    case_health = int(input("How much force(Newtons) is needed to break the case?"))
    # floor_height = input("What's the height(m) of each floor of the building?")

    fail = findFloor(floor_count)
    print("The case breaks at: " + str(fail) + " floor")
    # print(testFloor(42))


