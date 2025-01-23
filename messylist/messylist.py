from copy import deepcopy

n = input()
list = [int(n) for n in input().split()]

o_list = list.copy()
list.sort()

fcount = 0
for i in range(len(list)):
    if list[i] != o_list[i]:
        fcount += 1

print(fcount)
