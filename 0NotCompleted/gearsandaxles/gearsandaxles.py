from collections import defaultdict
import math

N = int(input())

dict = defaultdict(list)

for i in range(N):
    s, c = [int(i) for i in input().split(" ")]
    dict[s].append(c)

speed = 1

for s in dict.keys():
    s = sorted(dict[s])
    for t in range(len(s) // 2):
        a = s[t]
        b = s[-1 - t]
        m = b / a
        speed *= m


print(math.log(speed))
