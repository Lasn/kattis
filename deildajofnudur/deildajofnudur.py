from collections import Counter

n = int(input())
s = input()

substrings = []

for i in range(n):
    for j in range(i + 1, n + 1):
        substrings.append(s[i:j])

longest = 0
for i in substrings:
    c = Counter(i)
    equal = set(c.values())

    if len(equal) == 1:
        longest = max(longest, len(c) * equal.pop())
print(longest)
