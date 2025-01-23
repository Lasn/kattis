#!/usr/bin/python3
from collections import *
from itertools import permutations #No repeated elements
import sys
sys.setrecursionlimit(10**5)
# itr = (line for line in sys.stdin.read().split('\n'))
itr = sys.stdin
INP = lambda: next(itr)
def ni(): return int(INP())
def nl(): return [int(_) for _ in INP().split()]
def err(*s): print(*s, file=sys.stderr)

def main():
    sx,sy = nl()
    ex,ey = nl()
    px,py = nl()
    s_dir = [None,None]
    e_dir = [None,None]
    if sx < px:
        s_dir[0] = -1
    else:
        s_dir[0] = 1
    if sy < py:
        s_dir[1] = -1
    else:
        s_dir[1] = 1
    if ex < px:
        e_dir[0] = -1
    else:
        e_dir[0] = 1
    if ey < py:
        e_dir[1] = -1
    else:
        e_dir[1] = 1
    MAX = 10**9
    p1 = tuple(MAX*d for d in s_dir)
    p3 = tuple(MAX*d for d in e_dir)
    p2 = (p1[0],p3[1])
    print(3)
    print(*p1)
    print(*p2)
    print(*p3)

    return

if __name__ == '__main__':
    main()



