import itertools

a,b,c = list(map(int, input().split(" ")))

perm = itertools.product(["+","-","*","/"],repeat=2)

smallest = 1000000

num = a
l = [b,c]

for op in perm:
    for i in range(2):
        if op[i] == '+':
            num = num + l[i]
        elif op[i] == '-':
            num = num - l[i]
        elif op[i] == '*':
            num = num * l[i]
        elif op[i] == '/':
            if num % l[i] != 0:
                num = 1000000
                break
            else: num = num // l[i]
    if 0 <= num < smallest: smallest = num
    num = a
            
print(smallest)

