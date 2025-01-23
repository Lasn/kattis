#include <stdio.h>
#include <string.h>

int main()
{
    char input[100];
    fgets(input, 100, stdin);

    size_t len = strlen(input);
    if (len > 0 && input[len - 1] == '\n')
    {
        input[len - 1] = '\0';
    }

    int a;
    scanf("%d", &a);

    for (int i = 0; i < a; i++)
    {
        printf("%s%s!\n", "Hipp hipp hurra, ", input);
    }

    return 0;
}