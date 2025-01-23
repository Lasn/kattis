
L, D, N = map(int, input().split())
birds = []
for _ in range(N):
    birds.append(int(input()))

birds.sort()
additional_birds = 0
if birds:
    start_gap = birds[0] - 6
    if start_gap >= D:
        additional_birds += (start_gap // D)
    for i in range(1, N):
        gap = birds[i] - birds[i - 1]
        if gap >= 2 * D:
            additional_birds += ((gap - D) // D)
    end_gap = L - 6 - birds[-1]
    if end_gap >= D:
        additional_birds += (end_gap // D)
else:
    additional_birds += ((L-12+D) // D)

print(additional_birds)
