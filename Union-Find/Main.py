from UnionFind import UnionFind
from sys import stdin, stdout

def main():
    n,q = stdin.readline().split(" ")

    n = int(n)
    q = int(q)

    uf = UnionFind(n)

    for i in range(q):
        o,s,t = stdin.readline().split(" ")
        s =int(s)
        t = int(t)
        if(o == "?"):
            if(uf.query(s,t)): 
                stdout.write("yes\n")
            else: 
                stdout.write("no\n")
        else:
            uf.union(s,t)

if(__name__ == "__main__"):
    main()

    


