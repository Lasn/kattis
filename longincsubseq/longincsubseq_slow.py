import sys

def longincsubseq(arr):
    max_seq = 1
    m_idx = 0
    n = len(arr)
    table = [1]*n
    for i in range(1,n):
        for j in range(i):
            if arr[i] > arr[j]:
                table[i] = max(table[i], table[j]+1)
                if table[i] > max_seq:
                    max_seq = table[i]
                    m_idx = i

    #backtracking            
    pre= table[m_idx]
    seq = [m_idx]
    for i in range(m_idx,-2,-1):
        if table[i] == pre-1:
            seq.append(i)
            pre = table[i]

    return max_seq,seq

try:
    while True:
        n = int(sys.stdin.readline())
        arr = list(map(int, sys.stdin.readline().split()))
        max_int, seq = longincsubseq(arr)
        print(max_int)
        s = " ".join(map(str, reversed(seq)))
        print(s)
except:
    pass