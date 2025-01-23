import math


def sb(a, b):
    if b < 2:
        return 0

    sieve_limit = int(b**0.5) + 1
    is_prime_small = [True] * (sieve_limit + 1)
    is_prime_small[0] = is_prime_small[1] = False

    for p in range(2, sieve_limit + 1):
        if is_prime_small[p]:
            for multiple in range(p * p, sieve_limit + 1, p):
                is_prime_small[multiple] = False

    range_size = b - a + 1
    is_prime = [True] * range_size

    if a == 1:
        is_prime[0] = False

    for p in range(2, sieve_limit + 1):
        if is_prime_small[p]:
            start = max(p * p, (a + p - 1) // p * p)

            for multiple in range(start, b + 1, p):
                is_prime[multiple - a] = False

    if a == 0:
        is_prime[0] = False
        if b >= 1:
            is_prime[1 - a] = False

    count = sum(is_prime)

    return count


a, b = map(int, input().split())

count = 0


count = sb(a, b)
print(count)

# 0 1000000 78498
# sieve_of_pritchard with segmented sieve
