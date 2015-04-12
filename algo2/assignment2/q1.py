#!/usr/bin/env python3

import sys

filename = "clustering1.txt"

firstline = ""
lines = []

count = 0
bits = 0

###########

# Named by cost, constains array
edges = {}

# Named by leading node
clusters = {}

# Named by members
cluster_memberships = {}

cluster_count = 0

def prepare_uf(values):
    global clusters
    global cluster_memberships
    global cluster_count

    for (start,end,cost) in values:
        edges.setdefault(cost, []).append((start, end))
        if start == end:
            continue
        clusters[start] = [start]
        clusters[end] = [end]
        cluster_memberships[start] = start
        cluster_memberships[end] = end

    cluster_count = len(clusters)

def in_same_cluster(value1, value2):
    if cluster_memberships[value1] == cluster_memberships[value2]:
        return True
    return False

def join_uf(value1, value2):
    global cluster_count
    global cluster_memberships
    global clusters
    if value1 not in cluster_memberships:
        return
    if value2 not in cluster_memberships:
        return
    if in_same_cluster(value1, value2):
        return

    if len(clusters[cluster_memberships[value1]]) > len(clusters[cluster_memberships[value2]]):
        bigger = value1
        smaller = value2
    else:
        bigger = value2
        smaller = value1

    smallercluster_id = cluster_memberships[smaller]
    biggercluster_id = cluster_memberships[bigger]

    smallercluster = clusters[smallercluster_id]
    biggercluster = clusters[biggercluster_id]

    for vertex in smallercluster:
        cluster_memberships[vertex] = biggercluster_id
        biggercluster.append(vertex)
    del clusters[smallercluster_id]
    cluster_count = cluster_count - 1


###########

with open(filename, "r") as input:
    firstline = input.readline()[:-1]
    count = int(firstline)
    lines = [list(map(int, l.splitlines()[0].split(' '))) for l in input]

prepare_uf(lines)


while cluster_count >= 4:
    minedge = min(edges)
    (start, end) = edges[minedge].pop()
    if not len(edges[minedge]):
        del edges[minedge]

    if cluster_count == 4:
        if not in_same_cluster(start, end):
            break
    else:
        join_uf(start, end)

print(min(edges))

