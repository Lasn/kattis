from UnionFind import UnionFind
from sys import stdin, stdout

def Main():
    n, q = stdin.readline().split(" ")
    uf = UnionFind(int(n)+1)
    for i in range(int(q)):
        line = stdin.readline().strip().split(" ")
        if(line[0] == "s"):
            a = int(line[1])-1
            stdout.write(str(uf.getSize(a)) + "\n")
        else:
            a = int(line[1])-1
            b = int(line[2])-1
            uf.union(a, b)

if(__name__ == "__main__"):
    Main()

