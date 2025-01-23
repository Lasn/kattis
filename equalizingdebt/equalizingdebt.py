from collections import defaultdict

people = defaultdict(int)
give = defaultdict(int)
for i in range(int(input())):
    u, v, d = input().split()
    d = int(d)
    people[u] -= d
    people[v] += d
peoplelist = sorted(people.items(), key=lambda x: x[1])
while len(peoplelist) > 1:
    owe = peoplelist.pop(0)
    while people[owe[0]] != 0:
        if people[peoplelist[-1][0]] > 0:
            people[peoplelist[-1][0]] -= 1
            people[owe[0]] += 1
            give[peoplelist[-1][0], owe[0]] += 1
        else:
            peoplelist.pop(-1)
for i in give:
    print(i[0], i[1], give[i])
print("settled")
