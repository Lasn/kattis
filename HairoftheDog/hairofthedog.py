previous = ""
count = 0
for i in range(int(input())):
    state = input()
    if state == "sober" and previous == "drunk":
        count += 1
    previous = state
print(count)
