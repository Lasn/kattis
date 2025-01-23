from collections import deque


class Edge:
    def __init__(self, a, b, capacity, residual=None):
        self.a = a
        self.b = b
        self.flow = 0
        self.capacity = capacity
        self.residual = residual

    def remainingFlowCapacity(self):
        return self.capacity - self.flow

    def augment(self, bottleneck):
        self.flow += bottleneck
        self.residual.flow -= bottleneck


class Flowgraph:
    def __init__(self, n, s, t):
        self.minCut = []
        self.maxFlow = 0
        self.graph = [[] for _ in range(n)]
        self.s = s
        self.t = t
        self.level = [-1] * n
        self.it = [0] * n

    def addEdge(self, a, b, capacity):
        residual = Edge(b, a, 0)
        edge = Edge(a, b, capacity, residual)
        residual.residual = edge
        self.graph[a].append(edge)
        self.graph[b].append(residual)

    def bfs(self):
        # Build the level graph
        queue = deque([self.s])
        self.level = [-1] * len(self.graph)
        self.level[self.s] = 0

        while queue:
            u = queue.popleft()

            for edge in self.graph[u]:
                v = edge.b
                if self.level[v] == -1 and edge.remainingFlowCapacity() > 0:
                    self.level[v] = self.level[u] + 1
                    queue.append(v)

        return self.level[self.t] != -1  # Returns True if we reached the sink

    def dfs(self, u, flow):
        if u == self.t:
            return flow

        for i in range(self.it[u], len(self.graph[u])):
            self.it[u] = i
            edge = self.graph[u][i]
            v = edge.b

            if self.level[v] == self.level[u] + 1 and edge.remainingFlowCapacity() > 0:
                bottleneck = self.dfs(v, min(flow, edge.remainingFlowCapacity()))

                if bottleneck > 0:
                    edge.augment(bottleneck)
                    return bottleneck

        return 0

    def findMaxFlow(self):
        max_flow = 0

        while self.bfs():
            self.it = [0] * len(self.graph)  # Reset the DFS iterator

            flow = self.dfs(self.s, float("Inf"))
            while flow > 0:
                max_flow += flow
                flow = self.dfs(self.s, float("Inf"))

        self.maxFlow = max_flow
        return max_flow

    def getMinCut(self):
        return [self.level[i] != -1 for i in range(len(self.level))]

    def getGraph(self):
        edges = []
        for u in range(len(self.graph)):
            for edge in self.graph[u]:
                if edge.flow > 0:
                    edges.append((edge.a, edge.b, edge.flow))
        return edges

    def printGraph(self):
        for u in range(len(self.graph)):
            print(f"Node {u}:")
            for edge in self.graph[u]:
                if edge.capacity != 0:
                    print(f"  -> {edge.b} ({edge.flow}/{edge.capacity})")


import sys
import math
import time


n = int(sys.stdin.readline())

rooms = []
for i in range(n):
    rooms.append(int(sys.stdin.readline()))
rooms.sort()

max_capacity = 0
graph = Flowgraph(n, 0, n - 1)
for i in range(len(rooms)):
    for j in range(i + 1, len(rooms)):
        gcd = math.gcd(rooms[i], rooms[j])
        if gcd > 1:
            graph.addEdge(i, j, gcd)
            graph.addEdge(j, i, gcd)

print(graph.findMaxFlow())
