import sys
list = []
for line in sys.stdin:
    line = line.rstrip()
    list.append(line)
del list[0]
list.reverse()
for i in list:
    print(i)