#!/usr/bin/python3
from collections import *
from itertools import permutations #No repeated elements
import sys
from math import log2
sys.setrecursionlimit(10**5)
itr = (line for line in sys.stdin.read().split('\n'))
INP = lambda: next(itr)
def ni(): return int(INP())
def nl(): return [int(_) for _ in INP().split()]
def err(*s): print(*s, file=sys.stderr)

def main():
    s = int(INP(),2)
    d = int(INP(),2)
    m = int(INP(),2)
    day = 0
    m_original = 0
    seen = set()
    prev_d = float('inf')
    while m > 0:
        day += 1
        m >>= 1
        if (m,day%d) in seen:
            print('Infinite money!')
            quit()
        seen.add((m,day%d))
        if day % d == 0:
            m += s
        
        prev_d = m
    print(bin(day)[2:])

    return

if __name__ == '__main__':
    main()



