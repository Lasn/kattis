#include <stdio.h>
#include <stdlib.h>

void longincsubseq(int arr[], int n, int *max_seq, int **seq, int *seq_len)
{
    int *table = (int *)malloc(n * sizeof(int));
    int max_idx = 0;
    *max_seq = 1;

    for (int i = 0; i < n; ++i)
    {
        table[i] = 1;
    }

    for (int i = 1; i < n; i++)
    {
        for (int j = 0; j < i; j++)
        {
            if (arr[i] > arr[j] && table[i] < table[j] + 1)
            {
                table[i] = table[j] + 1;
            }
        }
        if (table[i] > *max_seq)
        {
            *max_seq = table[i];
            max_idx = i;
        }
    }

    // Backtracking to find the subsequence
    *seq_len = *max_seq;
    *seq = (int *)malloc(*seq_len * sizeof(int));
    int pre = *max_seq;
    (*seq)[(*seq_len) - 1] = max_idx;

    int index = *seq_len - 2;
    for (int i = max_idx - 1; i >= 0; i--)
    {
        if (table[i] == pre - 1)
        {
            (*seq)[index--] = i;
            pre = table[i];
        }
    }

    free(table);
}

int main()
{
    int n;
    while (scanf("%d", &n) == 1)
    {
        int *arr = (int *)malloc(n * sizeof(int));
        for (int i = 0; i < n; i++)
        {
            scanf("%d", &arr[i]);
        }

        int max_seq;
        int *seq;
        int seq_len;

        longincsubseq(arr, n, &max_seq, &seq, &seq_len);

        printf("%d\n", max_seq);

        for (int i = 0; i < seq_len; i++)
        {
            printf("%d ", seq[i]);
        }
        printf("\n");

        free(arr);
        free(seq);
    }

    return 0;
}
