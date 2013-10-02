#!/usr/bin/env python

from copy import copy

def q1(lines):
    w = []
    for l in lines:
        w.append((l[0]-l[1], l[0], l[1]))
    w.sort(key=lambda x: (x[0], x[1]), reverse=True)

    print w
    sumlen=[]
    s = 0
    for x in w:
        s += x[2]
        sumlen.append((s, x[1]))

    return reduce(lambda acc, x: acc + x[0]*x[1], sumlen, 0)

def q2(lines):
    w = []
    for l in lines:
        w.append((l[0]*1.0/l[1], l[0], l[1]))
    w.sort(key=lambda x: x[0], reverse=True)

#    print w
    sumlen=[]
    s = 0
    for x in w:
        s += x[2]
        sumlen.append((s, x[1]))

    return reduce(lambda acc, x: acc + x[0]*x[1], sumlen, 0)


i = open("jobs.txt", "r")

lines = [map(int, l.splitlines()[0].split(' ')) for l in i][1:]

#lines = [(10,2),(4,5),(1,2),(2,3)]
#lines = [(5,3), (2,1)]

print "Q1: " + str(q1(copy(lines)))

print "Q2: " + str(q2(copy(lines)))

