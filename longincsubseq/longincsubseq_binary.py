from bisect import bisect_left
import sys


def longincsubseq(arr):
    if not arr:
        return []

    pre = [-1] * len(arr)
    seq_end = [-1] * len(arr)
    values = []

    l = 0

    for i, num in enumerate(arr):
        pos = bisect_left(values, num)

        if pos == l:
            if l > 0:
                pre[i] = seq_end[l - 1]
            seq_end[l] = i
            values.append(num)
            l += 1
        else:
            if pos > 0:
                pre[i] = seq_end[pos - 1]
            seq_end[pos] = i
            values[pos] = num

    arr_sequence = []
    k = seq_end[l - 1]
    while k >= 0:
        arr_sequence.append(k)
        k = pre[k]

    return arr_sequence[::-1]


try:
    while True:
        n = int(sys.stdin.readline())
        arr = list(map(int, sys.stdin.readline().split()))
        seq = longincsubseq(arr)
        sys.stdout.write(str(len(seq)) + "\n")
        sys.stdout.write(" ".join(map(str, seq)) + "\n")
except:
    pass
