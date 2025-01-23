#!/usr/bin/python3
from collections import *
from itertools import permutations #No repeated elements
import sys
sys.setrecursionlimit(10**5)
itr = (line for line in sys.stdin.read().split('\n'))
INP = lambda: next(itr)
def ni(): return int(INP())
def nl(): return [int(_) for _ in INP().split()]
def err(*s): print(*s, file=sys.stderr)

def main():
    n,p = nl()
    n -= p
    x = n % (2*p)
    if x == p:
        x = 0
    print(x)
    return

if __name__ == '__main__':
    main()



