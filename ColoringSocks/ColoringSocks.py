import sys
list = []
for line in sys.stdin:
    line = line.rstrip()
    line = line.split(' ')
    list.append(line)
S = int(list[0][0])
C = int(list[0][1])
K = int(list[0][2])
socks = []
for str in list[1]:
    socks.append(int(str))
socks = sorted(socks)
machine_list = []
umachine_list = []
count = C
for num in socks:
    num = int(num)
    if umachine_list == []:
        umachine_list = [num]
        count -= 1
        continue
    if count == 0:
        machine_list.append(umachine_list)
        umachine_list = [num]
        count = C -1
        continue
    if num - umachine_list[0] <= K:
        umachine_list.append(num)
        count -= 1
        continue
    if num - umachine_list[0] > K:
        machine_list.append(umachine_list)
        umachine_list = [num]
        count = C -1
        continue
machine_list.append(umachine_list)    
machines = len(machine_list)

print(machines)