
def getAbsTo(f1):
    smallest = 100
    f1 = list(str (f1))
    for f in pos:
        f = list(str (f))
        dist =  abs(int (f[0]) - int (f1[0])) + abs(int (f[1]) - int (f1[1]))
        if(smallest > dist): smallest = dist
    return smallest


seed = int(input())

pos = set()

while(len(pos) < 4):
    seed = int(seed + (seed/13)) + 15
    s = str (seed)
    pos.add(s[-2:])

count = 0
while(len(pos) != 0):
    guess = input()
    count += 1
    if(guess in pos):
        pos.remove(guess)
        print("You hit a wumpus!")
    if(len(pos) != 0):
        print(getAbsTo(guess))  
print(f"Your score is {count} moves.")

        
        


