#!/usr/bin/env python3

import sys

sys.setrecursionlimit(5000)

filename = "knapsack_big.txt"
#filename = "knapsack1.txt"

firstline = ""
lines = []

count = 0
maxsize = 0

###########

# Named by seq number, (value, size)
items = []
items.append((0,0))

minsize = 0

# indexed by i, x
cache = {}

def findvalue(i, x):
    #print("findvalue:", i, x)
    if x < 0:
        return None
    if i == 0:
        return 0
    if x < minsize:
        return 0
    
    if i in cache:
        if x in cache[i]:
            return cache[i][x]
    value = findvalue_(i,x)

    cache.setdefault(i, {})[x] = value
    return value


def findvalue_(i, x):
    leftvalue = findvalue(i-1, x)

    #print(items[i][1])
    lowervalue = findvalue(i-1, x-items[i][1])

    #print("Finding", i, x)
    #print ("Values left/lower:  ", leftvalue, lowervalue)
    if lowervalue == None:
        return leftvalue

    lowervalue += items[i][0]
    #print ("Values left/lower+v:", leftvalue, lowervalue)
    return max(leftvalue, lowervalue)


###########

with open(filename, "r") as input:
    firstline = input.readline()[:-1]

    (maxsize, count) = firstline.split(' ')
    count = int(count)
    maxsize = int(maxsize)

    minsize = maxsize # init it to the top

    for line in input:
        (value, size) = line[:-1].split(' ')
        size = int(size)
        items.append((int(value), size))
        if size < minsize:
            minsize = size


rightmost = count
topmost = maxsize

print ("Count:", count)
print ("Size:", maxsize)

#print (findvalue(1, 15))
print (findvalue(count, topmost))

