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


class Flowgraph:
    def __init__(self, n, s, t):
        self.minCut = []
        self.maxFlow = 0
        self.graph = [[] for _ in range(n)]
        self.s = s
        self.t = t
        self.parent = [-1] * n

    def addEdge(self, a, b, capacity):
        residual = Edge(b, a, 0)
        edge = Edge(a, b, capacity, residual)
        residual.residual = edge
        self.graph[a].append(edge)
        self.graph[b].append(residual)

    def bfs(self, delta):
        queue = deque([self.s])
        visited = [False] * len(self.graph)
        visited[self.s] = True

        while queue:
            u = queue.popleft()

            for edge in self.graph[u]:
                v = edge.b

                if not visited[v] and edge.remainingFlowCapacity() >= delta:
                    self.parent[v] = edge
                    visited[v] = True
                    queue.append(v)

                    if v == self.t:
                        return True

        self.minCut = visited
        return False

    def findMaxFlow(self):
        delta = 1
        max_capacity = max(
            edge.capacity for edges in self.graph for edge in edges if edge.capacity > 0
        )

        while delta <= max_capacity:
            delta <<= 1
        delta >>= 1

        while delta > 0:
            while self.bfs(delta):
                path_flow = float("Inf")
                v = self.t

                while v != self.s:
                    edge = self.parent[v]
                    path_flow = min(path_flow, edge.remainingFlowCapacity())
                    v = edge.a

                v = self.t
                while v != self.s:
                    edge = self.parent[v]
                    edge.augment(path_flow)
                    edge.residual.augment(-path_flow)
                    v = edge.a

                self.maxFlow += path_flow

            delta //= 2

        return self.maxFlow

    def getMinCut(self):
        return self.minCut

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

n, m, s, t = map(int, sys.stdin.readline().split())

flowgraph = Flowgraph(n, s, t)

for e in range(m):
    a, b, c = map(int, sys.stdin.readline().split())
    flowgraph.addEdge(a, b, c)


maxflow = flowgraph.findMaxFlow()
edges_used = flowgraph.getGraph()
print(n, maxflow, len(edges_used))
for edge in edges_used:
    print(edge[0], edge[1], edge[2])
