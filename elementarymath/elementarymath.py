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
            for idx, edge in enumerate(self.graph[u]):
                if edge.flow > 0:
                    edges.append((edge.a, edge.b, idx, edge.flow))
        return edges

    def printGraph(self):
        for u in range(len(self.graph)):
            print(f"Node {u}:")
            for edge in self.graph[u]:
                if edge.capacity != 0:
                    print(f"  -> {edge.b} ({edge.flow}/{edge.capacity})")


import sys

n = int(sys.stdin.readline())

pairs = []
results = set([])

for _ in range(n):
    a, b = map(int, sys.stdin.readline().split())
    pairs.append((a, b))
    results.add(a + b)
    results.add(a - b)
    results.add(a * b)

results = list(results)
results_dict = {}
for i in range(len(results)):
    results_dict[results[i]] = i

graph_size = len(pairs) + len(results) + 2

graph = Flowgraph(graph_size, 0, graph_size - 1)

for p in range(len(pairs)):
    graph.addEdge(0, p + 1, 1)
    r = pairs[p][0] + pairs[p][1]
    graph.addEdge(p + 1, results_dict[r] + len(pairs) + 1, 1)
    r = pairs[p][0] - pairs[p][1]
    graph.addEdge(p + 1, results_dict[r] + len(pairs) + 1, 1)
    r = pairs[p][0] * pairs[p][1]
    graph.addEdge(p + 1, results_dict[r] + len(pairs) + 1, 1)

for r in range(len(results)):
    graph.addEdge(len(pairs) + 1 + r, graph_size - 1, 1)


p = []
graph.findMaxFlow()
for edge in graph.getGraph():
    if 0 < edge[0] <= len(pairs):
        p.append(edge)

if len(p) != len(pairs):
    print("impossible")
else:
    for i in range(len(p)):
        if p[i][2] == 1:
            print(f"{pairs[i][0]} + {pairs[i][1]} = {pairs[i][0]+ pairs[i][1]}")
        elif p[i][2] == 2:
            print(f"{pairs[i][0]} - {pairs[i][1]} = {pairs[i][0] - pairs[i][1]}")
        else:
            print(f"{pairs[i][0]} * {pairs[i][1]} = {pairs[i][0] * pairs[i][1]}")
