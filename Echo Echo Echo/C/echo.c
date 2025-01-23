#include <stdio.h>
#include <string.h>

int main()
{
    char input[100];
    fgets(input, 16, stdin);
    printf("%s %s %s", input, input, input);

    return 0;
}