from collections import deque


class Proposer:
    def __init__(self, name: str, priority_list: deque):
        self.name = name
        self.partner = []
        self.priority_list = priority_list


class Rejecter:
    def __init__(self, name: str, priority_list: dict):
        self.name = name
        self.partner = ""
        self.priority_list = priority_list


n, m, k= [int(i) for i in input().split()]
len_priority_list = 0
freeP = deque()
P = dict()
R = dict()

for idx, l in enumerate(range(n+k)):
    line = input().split()
    if idx < n:
        name = line[0]
        q = deque(line[1:])
        p = Proposer(name, q)
        P[name] = p
        freeP.append(name)
    else:
        name = line[0]
        d = dict()
        d = {i: idx for idx, i in enumerate(line[1:])}
        R[name] = Rejecter(name, d)

freeP = freeP*m

fail = False
while len(freeP) != 0:
    p = P[freeP.popleft()]
    if len(p.priority_list) == 0:
        fail = True
        break
    r = R[p.priority_list.popleft()]
    if r.partner == "":
        r.partner = p.name
        p.partner.append(r.name)
    elif r.priority_list[p.name] < r.priority_list[r.partner]:
        pre_partner = P[r.partner]
        idx = pre_partner.partner.remove(r.name)
        freeP.append(pre_partner.name)
        r.partner = p.name
        p.partner.append(r.name)
    else:
        freeP.append(p.name)


if fail:
    print("-")
else:
    for p in P:
        p = P[p]
        print(f"{p.name} {' '.join(p.partner)}")
