def printTak(n):
    print(f"Tak for din stemme paa {n}.")

N,Q = input().split(" ")

songs = []
people = {}

for _ in range(int(N)):
    songs.append(input())

for i in range(int(Q)):
    pn = input()
    s = input().lower().split(" ")
    if len(s)!= 2 or not s[1].isnumeric():
        print("Ugyldig stemme!")
        continue
    q = int(s[1])-1
    if s[0] != "sang" or int(q)>len(songs)-1 or s[1].startswith("0"): 
        print("Ugyldig stemme!")
        continue
    if pn not in people:
        people[pn] = set()
        people[pn].add(int(q))
        printTak(songs[q])
    else: 
        if q in people[pn]: print(f"Du har allerede stemt paa {songs[q]}!")
        else:
            people[pn].add(int(q))
            printTak(songs[q])
