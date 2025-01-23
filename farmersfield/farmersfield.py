import re
import bisect

N = int(input())
field = input()
R = int(input())

c_idx = [i.start() for i in re.finditer("C", field)]
w_idx = [i.start() for i in re.finditer("W", field)]


def find_c(i):
    idx = bisect.bisect_left(c_idx, i)
    e_idx = c_idx[idx]
    s_idx = c_idx[idx - 1]

    if e_idx - s_idx - 1 <= R * 2:
        return False
    return True


p = True
for w in w_idx:
    if not find_c(w):
        p = False
        # break


if p:
    print("POSSIBLE")
else:
    print("IMPOSSIBLE")
