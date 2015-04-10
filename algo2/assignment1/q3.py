#!/usr/bin/env python3

from copy import copy

def schedule(lines, key):
    w = []
    for l in lines:
        w.append((key(l[0],l[1]), l[0], l[1]))
    w.sort(key=lambda x: (x[0], x[1]), reverse=True)

    def l(acc,x):
        acc[1].append((acc[0]+x[2], x[1]))
        return (acc[0]+x[2], acc[1])
    (s, sumlen) = reduce(l, w, (0, [0]))
    return reduce(lambda acc, x: acc + x[0]*x[1], sumlen[1:], 0)

def q1(lines):
    return schedule(lines=lines, key = lambda x,y: x-y)

def q2(lines):
    return schedule(lines=lines, key = lambda x,y: x*1.0/y)

i = open("edges.txt", "r")

lines = [list(map(int, l.splitlines()[0].split(' '))) for l in i][1:]

vertices = {}
totalcost = 0

def insert(vertices, source, dest, cost):
    vertices.setdefault(source, {})[dest] = cost

for l in lines:
    source = l[0]
    dest = l[1]
    cost = l[2]
    insert(vertices, source, dest, cost)
    insert(vertices, dest, source, cost)

movedvertices = {}
key = next(iter(vertices.keys()))
movedvertices[key] = vertices[key]
del vertices[key]

def movesingle(vertices, movedvertices):
    minedge = None
    mincost = 100000000000000000000000
    for v in movedvertices:
        for e in movedvertices[v]:
            if movedvertices[v][e] < mincost and e in vertices:
                minedge = e
                mincost = movedvertices[v][e]

    movedvertices[minedge] = vertices[minedge]
    del vertices[minedge]

    return mincost

while len(vertices):
    totalcost += movesingle(vertices, movedvertices)


print ("Q3: " + str(totalcost))
#print( "Q1: " + str(q1(copy(lines))))

#print( "Q2: " + str(q2(copy(lines))))

