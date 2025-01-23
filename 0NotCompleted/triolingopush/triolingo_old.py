import math, sys, time


# n = int(input())
# n = 2097151  # 2,5 sec
# n = 2097152  # 1 sec
# n = 1000
n = int(input())
N = n
# start = time.time()


def dot3x3(a, b):
    result = [0] * 9
    for i in range(3):
        for j in range(3):
            for k in range(3):
                result[i * 3 + j] += a[i * 3 + k] * b[k * 3 + j]
    return result


# def dot(a, b):
#     return [
#         a[0] * b[0] + a[1] * b[3],
#         a[0] * b[1] + a[1] * b[4],
#         a[0] * b[2] + a[1] * b[5] + a[2] * b[8],
#         a[3] * b[0] + a[4] * b[3],
#         a[3] * b[1] + a[4] * b[4],
#         a[3] * b[2] + a[4] * b[5] + a[5] * b[8],
#         0,
#         0,
#         1,
#     ]


w = [1, 1, 1, 1, 0, 0, 0, 0, 1]

multiply_matrix = []

if n < 4:
    a = 0
    b = 1
    for i in range(n - 1):
        a, b = b, a + b + 1

if n >= 4:
    left = 1
    n2 = int(math.log(n, 2))
    for i in range(n2):
        multiply_matrix.append((left, w))
        left *= 2
        w = dot3x3(w, w)
    n -= left
    b = w[2]
    a = w[5]
    if n != 0:
        a = 0
        for m in multiply_matrix[::-1]:
            while n >= m[0]:
                n -= m[0]
                w = dot3x3(w, m[1])
        b = w[2]
        a = w[5]

print(b)

# sys.stdout.write(str(b))
# end = time.time()
# print(end - start)

# n = N - 1
# a1 = 0
# b1 = 1
# for i in range(n):
#     a1, b1 = b1, a1 + b1 + 1

# if b1 == b:
#     print("ok")
# else:
#     print("no")
