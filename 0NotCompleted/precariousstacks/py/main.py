import red_black_bst

N = int(input())

maxHight = 0
bst = red_black_bst.RedBlackBST()

for i in range(N):
    x,s = [int(i) for i in input().split(" ")]
    rangeK = bst.keys_range(x,s+x)
    h = 0
    for i in range(len(rangeK)):
        if(rangeK[i][1] > h): 
            h = rangeK[i][1]+s
            if(rangeK[i][1]+s > maxHight): maxHight = rangeK[i][1]+s
    bst.put(x,(s,h))
    print(maxHight)






   


