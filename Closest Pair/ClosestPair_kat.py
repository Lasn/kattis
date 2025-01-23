import math
import bisect
import sys


def e_dist(p1, p2):
    return math.sqrt(((p1[0] - p2[0]) ** 2 + (p1[1] - p2[1]) ** 2))


def dist_all_pairs(pairs, n):
    min_dist = float("inf")
    min_pair = None
    for i in range(n):
        for j in range(i + 1, n):
            if e_dist(pairs[i], pairs[j]) < min_dist:
                min_dist = e_dist(pairs[i], pairs[j])
                min_pair = (pairs[i], pairs[j])
    return (min_dist, min_pair)


def closest_pair(ps_x):
    n = len(ps_x)
    if n == 2:
        return (e_dist(ps_x[0], ps_x[1]), (ps_x[0], ps_x[1]))
    if n <= 128:
        return dist_all_pairs(ps_x, n)

    mid = len(ps_x) // 2
    p_l = closest_pair(ps_x[:mid])
    p_r = closest_pair(ps_x[mid + 1 :])
    d = min(p_l[0], p_r[0])
    d = p_l if d == p_l[0] else p_r

    ss = bisect.bisect_left(ps_x, ps_x[mid][0] - d[0] / 2, key=lambda x: x[0])
    se = bisect.bisect_right(ps_x, ps_x[mid][0] + d[0] / 2, key=lambda x: x[0]) + 1

    strip = ps_x[ss:se]
    strip.sort(key=lambda c: c[1])

    for i in range(len(strip) - 1):
        for j in range(min(7, len(strip) - 1 - i)):
            new_dist = e_dist(strip[i], strip[i + j + 1])
            new_min = min(d[0], new_dist)
            d = d if d[0] == new_min else (new_dist, (strip[i], strip[i + j + 1]))
    return d


while True:
    N = int(sys.stdin.readline())
    if N == 0:
        break

    pairs = []

    for _ in range(N):
        x, y = map(float, sys.stdin.readline().split())
        pairs.append((x, y))

    pairs.sort(key=lambda c: c[0])

    cp = closest_pair(pairs)
    print(cp[1][0][0], cp[1][0][1], cp[1][1][0], cp[1][1][1])
