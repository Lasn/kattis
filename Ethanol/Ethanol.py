l1 = "  "
l2 = "  "
l3 = "H-"
l4 = "  "
l5 = "  "

ml1 = "H "
ml2 = "| "
ml3 = "C-"
el1 = "  "
el2 = "OH"

repeat = int(input())

for i in range(repeat):
    l1 += ml1
    l2 += ml2
    l3 += ml3
    l4 += ml2
    l5 += ml1

l1 += el1
l2 += el1
l3 += el2
l4 += el1
l5 += el1

print(l1)
print(l2)
print(l3)
print(l4)
print(l5)
