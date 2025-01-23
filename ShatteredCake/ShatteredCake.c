#include <stdio.h>

int main()
{
    int w, n;
    int size = 0;
    scanf("%d %d", &w, &n);
    for (int i = 0; i < n; i++)
    {
        int a, b;
        scanf("%d %d", &a, &b);
        size += a * b;
    }
    printf("%d", size / w);
    return 0;
}
