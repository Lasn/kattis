def fib(n):
    memo = {0: 0, 1: 1}

    for i in range(2, n + 1):
        if i <= 2:
            memo[i] = 1
        memo[i] = memo[i - 1] + memo[i - 2] + 1
    return memo[n]


print(fib(int(input())))
