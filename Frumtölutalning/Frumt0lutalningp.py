def sp(a, b):
    if b < 2:
        return 0

    is_prime = [True] * (b + 1)
    is_prime[0] = is_prime[1] = False

    for p in range(2, int(b**0.5) + 1):
        if is_prime[p]:

            for multiple in range(p * p, b + 1, p):
                is_prime[multiple] = False

    count = 0
    for p in range(a, b + 1):
        if is_prime[p]:
            count += 1

    return count


a, b = map(int, input().split())

count = 0


count = sp(a, b)
print(count)

# 0 1000000 78498
#sieve_of_pritchard
