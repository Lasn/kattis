N = int(input())

mind = float("inf")
for l in range(N):
    x1,y1,x2,y2 = [int(i) for i in input().split(" ")]
    y = y2-y1
    x = x2-x1
    if x1 <0 > x2 or x1 >0 < x2 or x == 0:
        continue
    s = y/x
    ys = y1-x1*s
    if 0 <ys < mind:
        mind = ys
if mind == float("inf"):
    print(-1.0)
else:
    print(mind)

