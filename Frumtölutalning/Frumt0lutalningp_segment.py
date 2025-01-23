import math


def sieve_small_primes(limit):
    is_prime_small = [True] * (limit + 1)
    is_prime_small[0] = is_prime_small[1] = False

    for p in range(2, limit + 1):
        if is_prime_small[p]:
            for multiple in range(p * p, limit + 1, p):
                is_prime_small[multiple] = False

    return [p for p, is_prime in enumerate(is_prime_small) if is_prime]


def segmented_sieve(a, b):
    if b < 2:
        return 0

    sieve_limit = int(math.isqrt(b))
    small_primes = sieve_small_primes(sieve_limit)

    prime_count = 0

    chunk_size = sieve_limit
    for start in range(a, b + 1, chunk_size):
        end = min(start + chunk_size - 1, b)

        range_size = end - start + 1
        is_prime = [True] * range_size

        if start == 0:
            is_prime[0] = False
            if end >= 1:
                is_prime[1] = False
        elif start == 1:
            is_prime[0] = False

        for p in small_primes:

            first_multiple = max(p * p, (start + p - 1) // p * p)

            for multiple in range(first_multiple, end + 1, p):
                is_prime[multiple - start] = False

        prime_count += sum(is_prime)

    return prime_count


a, b = map(int, input().split())

prime_count = segmented_sieve(a, b)
print(prime_count)
