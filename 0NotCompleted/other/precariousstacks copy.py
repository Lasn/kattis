N = int(input())

maxHight = 0
hights = []
xc = []

for i in range(N):
    x,s = [int(i) for i in input().split(" ")]
    xc.append((x,s))
xc.sort()


    # start = x
    # if(len(hights) < start+s+1): [hights.append(0) for i in range(x+s+1-len(hights))]
    # newH = s+hights[start]
    # for h in range(s):
    #     if(hights[start+h]+s > newH): newH = hights[h+start]+s
    # x = newH
    # if(x > maxHight): maxHight = x
    # for j in range(s):
    #     hights[start+j] = x
    # print(maxHight)

