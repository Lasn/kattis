import math


def min_sprinkler(n, l, w):
    intervals = []
    for i in range(n):
        x, r = [int(x) for x in input().split()]
        if r >= w / 2:
            lenght = math.sqrt(math.pow(r, 2) - math.pow(w / 2, 2))
            s = max(x - lenght, 0)
            e = min(x + lenght, l)
            intervals.append((s, e))
    intervals.sort(key=lambda k: k[0])

    if intervals[0][0] > 0:
        print(-1)
        return

    selected_intervals = []
    current_point = 0
    i = 0
    n_intervals = len(intervals)

    while current_point < l:
        max_end = current_point
        while i < n_intervals and intervals[i][0] <= current_point:
            max_end = max(max_end, intervals[i][1])
            i += 1
        if max_end == current_point:
            print(-1)
            return

        current_point = max_end
        selected_intervals.append(max_end)

    if current_point >= l:
        print(len(selected_intervals))
    else:
        print(-1)


try:
    while True:
        n, l, w = [int(x) for x in input().split()]
        min_sprinkler(n, l, w)
except EOFError:
    pass
