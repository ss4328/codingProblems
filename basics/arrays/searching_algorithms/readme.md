# Floor break determiner

Made to determine the answer to an exam problem. This program uses custom binary sort to find a floor where the case breaks if thrown from. Uses python 3. 

## Problem statement

You work at a company that makes specialized security briefcases. You need to test a new model to
see how many floors up it can be dropped from and not smash. Assume the test is boolean (Yes/No).
Either the case breaks enough someone can get the contents or they cannot access the contents.

Given a building with N floors, come up with an Algorithm to find the lowest floor the briefcase smashes from. Your goal is to optimize the number of tests. Come up with an algorithm that throws as few briefcases as possible. A briefcase can only be thrown once, even if it does not break.

Give a pseudocode function findFloor(numFloors). Assume you have a function testFloor(f) that
return True if the briefcase breaks when thrown from floor f and False otherwise.

```bash
python briefcaseBreaker.py
```

## Usage

```python
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
```

## Further Improvements Envisioned
1. Ask user for the height of each floor in metres.
2. Use the classical mechanics equations to find out the acceleration near the ground.
3. Use the F= MA equation to find out how much force will be applied by the case, and therefore by Newton's third law, will be applied on the case. 
4. If Impact > case_health, case opens up


## Interesting reads
[Falling objects](https://courses.lumenlearning.com/physics/chapter/2-7-falling-objects/)