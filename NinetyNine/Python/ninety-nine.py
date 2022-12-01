import random
import sys
def plays_1(x):
    if x == 99:
        return 'e'
    if x == 98:
        print(x+1, flush=True)
        return 'e'
    if x == 97:
        print(x+2, flush=True)
        return 'e'
    if x == 95:
        print(x+1, flush=True)
        return x
    if x == 94:
        print(x+2, flush=True)
        return x
    else:
        x = x + 2
        print(x, flush=True)
        return x

def plays_2(x):
    if x == 99:
        return 'e'
    if x == 98:
        print(x+1, flush=True)
        return 'e'
    if x == 97:
        print(x+2, flush=True)
        return 'e'
    if x == 95:
        print(x+1, flush=True)
        return x
    if x == 94:
        print(x+2, flush=True)
        return x
    else:
        x = x + 1
        print(x, flush=True)
        return x
    
x = 2
print(x, flush=True)
while True:
    other = input()
    y = int(other) - x
    x = int(other)
    if y == 2:
        x = plays_2(x)
        if x == 'e':
            sys.exit(0)

    elif y == 1:
        x = plays_2(x)
        if x == 'e':
            sys.exit(0)

        





        
        


