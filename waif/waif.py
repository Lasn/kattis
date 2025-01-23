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

    def bfs(self):
        queue = deque([self.s])
        visited = [False] * len(self.graph)
        visited[self.s] = True

        while queue:
            u = queue.popleft()

            for edge in self.graph[u]:
                v = edge.b

                if not visited[v] and edge.remainingFlowCapacity() > 0:
                    self.parent[v] = edge
                    visited[v] = True
                    queue.append(v)

                    if v == self.t:
                        return True

        self.minCut = visited
        return False

    def findMaxFlow(self):
        while self.bfs():
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

n, m, p = map(int, sys.stdin.readline().split())
graph_size = n + m + p + 2
graph = Flowgraph(graph_size, 0, graph_size - 1)


children_preferences = []

for c in range(n):
    graph.addEdge(0, c + 1, 1)
    toys = list(map(int, sys.stdin.readline().split()))[1:]
    for toy in toys:
        graph.addEdge(c + 1, toy + n, 1)

toys_used = set([])
for ca in range(p):
    category_info = list(map(int, sys.stdin.readline().split()))
    toy_count = category_info[0]
    toys_in_category = category_info[1:-1]
    for toy in toys_in_category:
        graph.addEdge(toy + n, n + m + ca + 1, 1)
        toys_used.add(toy)
    graph.addEdge(n + m + ca + 1, graph_size - 1, category_info[-1])

for t in range(1, m + 1):
    if t not in toys_used:
        graph.addEdge(t + n, graph_size - 1, 1)


print(graph.findMaxFlow())
