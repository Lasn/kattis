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


import sys

# setup: clubsset, names, partys
N = int(sys.stdin.readline())
for test in range(N):
    t = int(sys.stdin.readline())
    size = t * 110 + t + 2
    graph = Flowgraph(size, 0, size - 1)
    clubsset = {}
    partys = {}
    names = {}
    for i in range(t):
        name, party, num, *clubs = sys.stdin.readline().split()
        if party not in partys:
            partys[party] = size - 2 - len(partys)
        graph.addEdge(i + 1, partys[party], 1)
        names[i + 1] = name
        for club in clubs:
            if club not in clubsset:
                clubsset[club] = t + 1 + len(clubsset)
            graph.addEdge(clubsset[club], i + 1, 1)
    for club in clubsset:
        graph.addEdge(0, clubsset[club], 1)
    max_council_sets = len(clubsset) // 2
    if len(clubsset) % 2 == 0:
        max_council_sets -= 1
    for party in partys:
        graph.addEdge(partys[party], size - 1, max_council_sets)

    flow = graph.findMaxFlow()
    if flow < len(clubsset):
        print("Impossible.")
    else:
        for n in clubsset:
            for edge in graph.graph[clubsset[n]]:
                if edge.flow == 1:
                    print(names[edge.b], n)
                    break
