#!/usr/bin/env python3

filename = "clustering_big.txt"

firstline = ""
lines = []

count = 0
bits = 0

def parsebits(line):
    result = 0
    split = line.split(' ')

    for b in range(0, bits):
        result += int(split[b]) << (bits-b-1)

    return result

###########

# Named by leading node
clusters = {}

# Named by members
cluster_memberships = {}

cluster_count = 0

def prepare_uf(values):
    global clusters
    global cluster_memberships
    global cluster_count
    for v in values:
        clusters[v] = [v]
        cluster_memberships[v] = v
    cluster_count = len(values)

def join_uf(value1, value2):
    global cluster_count
    global cluster_memberships
    global clusters
    if value1 not in cluster_memberships:
        return
    if value2 not in cluster_memberships:
        return
    if cluster_memberships[value1] == cluster_memberships[value2]:
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

    (count, bits) = firstline.split(' ')
    count = int(count)
    bits = int(bits)

    for line in input:
        value = parsebits(line[:-1])
        lines.append(value)

lines.sort()
prepare_uf(lines)


# 1-bit diff

for vertex in lines:
    for b in range(0, bits):
        mask = 1<<b
        close_vertex = vertex^mask
        if close_vertex<vertex:
            continue
        join_uf(vertex, close_vertex)

print(cluster_count)

# 2-bit diff

for vertex in lines:
    for b1 in range(1, bits):
        for b2 in range(0, b1-1):
            mask = (1<<b1) + (1<<b2)
            close_vertex = vertex^mask
            if close_vertex<vertex:
                continue
            join_uf(vertex, close_vertex)

print(cluster_count)

