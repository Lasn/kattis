from collections import deque


class P:
    def __init__(self, n: str, p_l: deque):
        self.n = n
        self.pt = []
        self.p_l = p_l


class R:
    def __init__(self, n: str, p_l: dict):
        self.n = n
        self.pt = ""
        self.p_l = p_l


n, m, k = [int(i) for i in input().split()]
fP = deque()
P_m = dict()
R_m = dict()

for i, l in enumerate(range(n + k)):
    line = input().split()
    if i < n:
        nm = line[0]
        q = deque(line[1:])
        p = P(nm, q)
        P_m[nm] = p
        fP.append(nm)
    else:
        nm = line[0]
        d = {x: idx for idx, x in enumerate(line[1:])}
        R_m[nm] = R(nm, d)

fP = fP * m

fl = False
while len(fP) != 0:
    p = P_m[fP.popleft()]
    if len(p.p_l) == 0:
        fl = True
        break
    r = R_m[p.p_l.popleft()]
    if r.pt == "":
        r.pt = p.n
        p.pt.append(r.n)
    elif r.p_l[p.n] < r.p_l[r.pt]:
        p_p = P_m[r.pt]
        p_p.pt.remove(r.n)
        fP.append(p_p.n)
        r.pt = p.n
        p.pt.append(r.n)
    else:
        fP.append(p.n)

if fl:
    print("-")
else:
    for p in P_m:
        p = P_m[p]
        print(f"{p.n} {' '.join(p.pt)}")
