#include <stdio.h>
#include <stdlib.h>

long *matrix_power(long *matrix, long n);
long *dot3x3(long *a, long *b);
long fibonacci_matrix_power(long n);

int main()
{
    long n;
    scanf("%ld", &n);
    n += 1;
    long result = fibonacci_matrix_power(n);
    printf("%ld\n", result);
    return 0;
}

long *matrix_power(long *matrix, long n)
{
    if (n <= 1)
    {
        return matrix;
    }

    long *result = (long *)malloc(9 * sizeof(long));
    long *temp = (long *)malloc(9 * sizeof(long));
    for (int i = 0; i < 9; i++)
    {
        result[i] = matrix[i];
        temp[i] = matrix[i];
    }
    n -= 1;

    while (n > 0)
    {
        if (n % 2 == 1)
        {
            result = dot3x3(result, temp);
        }
        temp = dot3x3(temp, temp);
        n /= 2;
    }

    return result;
}

long *dot3x3(long *a, long *b)
{
    long *result = (long *)calloc(9, sizeof(long));
    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            for (int k = 0; k < 3; k++)
            {
                result[i * 3 + j] += a[i * 3 + k] * b[k * 3 + j];
            }
        }
    }
    return result;
}

long fibonacci_matrix_power(long n)
{
    if (n <= 0)
    {
        return 0;
    }

    long transition_matrix[9] = {1, 1, 1, 1, 0, 0, 0, 0, 1};

    long *result_matrix = matrix_power(transition_matrix, n - 1);

    return result_matrix[2];
}
