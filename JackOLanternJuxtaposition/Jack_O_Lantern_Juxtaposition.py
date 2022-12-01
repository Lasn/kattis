
designs = input()
output = 1
designs = designs.split(' ')
for n in designs:
    output = output * int(n)

print(output)