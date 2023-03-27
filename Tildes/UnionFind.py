class UnionFind:

    def __init__(self, n):
        self.components = n
        self.id = list(range(n))
        self.size = [1]*n

    def find(self, parent):
        baseNum = parent
        while(parent != self.id[parent]):
            parent = self.id[parent]

        self.pathCompress(baseNum, parent)
        return parent

    def pathCompress(self, parent, root):
        while(parent != self.id[parent]):
            nextParent = self.id[parent]
            self.id[parent] = root
            parent = nextParent

    def query(self,s,t):
        return self.find(s) == self.find(t)
    
    def union(self,s,t):
        rootS = self.find(s)
        rootT = self.find(t)

        if(rootS == rootT): 
            return

        self.components -= 1
        if(self.size[rootS] < self.size[rootT]):
            self.id[rootS] = self.id[rootT]
            self.size[rootT] += self.size[rootS]
        else:
            self.id[rootT] = self.id[rootS]
            self.size[rootS] += self.size[rootT]

    def getComponents(self):
        return self.components

    def getSize(self,group):
        return self.size[self.find(group)]


