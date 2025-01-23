x = int(input())

if x == 1 or x == 2:
    print(0)
    exit()

overflowtotal = 0

for i in range(3, x + 1):
    overflowtotal += (4 ** (i - 1)) - i**2
print(overflowtotal)
