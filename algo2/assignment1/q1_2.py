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

i = open("jobs.txt", "r")

lines = [map(int, l.splitlines()[0].split(' ')) for l in i][1:]

print( "Q1: " + str(q1(copy(lines))))

print( "Q2: " + str(q2(copy(lines))))

