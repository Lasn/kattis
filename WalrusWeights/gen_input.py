import random
import sys


N = int(sys.argv[1])
output = ""
for i in range(N):
    output += f"{random.randint(1,1000)}\n"
print(N)
print(output)
