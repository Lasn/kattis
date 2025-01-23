n, m = [int(i) for i in input().split(" ")]
f = [int(i) for i in input().split(" ")]
s = set([int(i) for i in input().split(" ")])
o = []
for i in f:
    if i in s:
        o.append(i)
print(*o)