import sys
data = {}
for line in sys.stdin:
    line = line.rstrip()
    line = int(line)
    line = line % 42
    data[line] = line

print(len(data))