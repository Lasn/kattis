N = int(input())
opt_weight = 1000

W = []
W.append(0)
for _ in range(N):
    w = int(input())
    W.append(w)

opt_diff = 1000
opt_size = 0

sums = [float("inf")] * (opt_weight * 2 + 1)
sums[0] = 0

for i in range(1, N + 1):
    for j in range(len(sums) - 1, W[i] - 1, -1):
        sum = min(sums[j], sums[j - W[i]] + W[i])
        sums[j] = sum

for s in sums:
    diff = abs(s - opt_weight)
    if s != float("inf") and diff <= opt_diff and s > opt_size:
        opt_diff = diff
        opt_size = s
print(opt_size)
