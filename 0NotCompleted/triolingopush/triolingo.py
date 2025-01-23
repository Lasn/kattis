def matrix_power(matrix, n):
    if n <= 1:
        return matrix

    result = matrix.copy()
    temp = matrix.copy()
    n -= 1

    while n > 0:
        if n % 2 == 1:
            result = dot3x3(result, temp)
        temp = dot3x3(temp, temp)
        n //= 2

    return result


def dot3x3(a, b):
    result = [0] * 9
    for i in range(3):
        for j in range(3):
            for k in range(3):
                result[i * 3 + j] += a[i * 3 + k] * b[k * 3 + j]
    return result


def fibonacci_matrix_power(n):
    if n <= 0:
        return 0

    transition_matrix = [1, 1, 1, 1, 0, 0, 0, 0, 1]

    result_matrix = matrix_power(transition_matrix, n - 1)

    return result_matrix[2]


n = int(input()) + 1
result = fibonacci_matrix_power(n)
print(result)
