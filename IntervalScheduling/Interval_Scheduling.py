N = int(input())
intervals = []
for i in range(N):
    s, e = [int(x) for x in input().split()]
    intervals.append((s, e))
intervals.sort(key=lambda k: k[-1])
last_internal = None
count = 0
for i in intervals:
    if last_internal == None or i[0] >= last_internal[1]:
        last_internal = i
        count += 1
print(count)
