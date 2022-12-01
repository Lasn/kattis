import sys
l = []
for line in sys.stdin:
    line = line.rstrip()
    l.append(line)
del l[0]
birthdays = {}
for line in l:
    lineSplit = line.split(' ')
    name = lineSplit[0]
    like = int(lineSplit[1])
    bday = lineSplit[2]
    if bday not  in birthdays:
        birthdays[bday] = (name,like)
    elif bday in birthdays and like > birthdays[bday][1]:
        birthdays[bday] = (name,like)
print(len(birthdays))
for bday in sorted(birthdays, key=birthdays.get):
    print(birthdays[bday][0])






    
