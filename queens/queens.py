def eval(board, row, col):
    size = len(board[0])
    if(board[row][col]) == False: return False
    board[row] = list([False] * size)
    for i in range(size): board[i][col] = False
    for i in range(size):
        try:
            if(size > row-col+i >= 0):
                board[row-col+i][i] = False
        except:
            False
        try:
            if(0 <= row+col-i < size ):
                board[row+col-i][i] = False
        except:
            False
    return True


n = int(input())
board = [list([True] * n) for l in range(n)]
c = True
for i in range(n):
    row,col = input().split(" ")
    if not eval(board,int(row),int(col)):
        c = False
        break
if(c): print("CORRECT")
else: print("INCORRECT")


       


