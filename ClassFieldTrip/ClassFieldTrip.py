
mylist = []
for i in range(2):
    for x in list(input()):
        mylist.append(x)       
mylist.sort()
print("".join(mylist))