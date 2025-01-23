N, t = [int(x) for x in input().split()]
intervals = []
for i in range(N):
    s, e = [int(x) for x in input().split()]
    intervals.append((s, s + e))
    for j in range((t // s) - 1):
        if len(intervals) == 0:
            intervals.append((s, s + e))
        else:
            last = intervals[-1]
            intervals.append((last[1] + s, last[1] + s + e))
intervals.sort(key=lambda k: k[-1])
last_internal = None
count = 0
for i in intervals:
    if i[0] >= t:
        continue
    if last_internal == None or i[0] > last_internal[1]:
        last_internal = i
        count += 1
print(count)
