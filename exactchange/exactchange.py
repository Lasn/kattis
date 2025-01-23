import sys


def exactchange(bills, amount):
    n = len(bills)
    max_amount = 10001
    table = [[float("inf")] * (max_amount) for _ in range(n)]

    table[0][0] = 0

    for i in range(1, n):
        for j in range(max_amount):
            if j >= bills[i]:
                table[i][j] = min(table[i - 1][j], table[i - 1][j - bills[i]] + 1)
            else:
                table[i][j] = table[i - 1][j]

    coins = None
    # find change amount
    for j in range(amount, max_amount):
        if table[n - 1][j] != float("inf"):
            print(j, table[n - 1][j])
            break

    # # backtrack
    # c_used = []
    # res = change
    # for i in range(n - 1, 0, -1):
    #     if table[i][res] != table[i - 1][res]:
    #         c_used.append(bills[i])
    #         res -= bills[i]
    # print(change, len(c_used))


N = int(sys.stdin.readline())
for i in range(N):
    amount = int(sys.stdin.readline())
    n_bills = int(sys.stdin.readline())
    bills = [0] + [int(sys.stdin.readline()) for _ in range(n_bills)]
    exactchange(bills, amount)
