import random
import os

output = "1000\n"
for _ in range(1000):
    output += str(random.randint(2, int(2 * 1e9))) + "\n"

print(output)
# save to 1.in
os.system('echo "' + output + '" > 1.in')
