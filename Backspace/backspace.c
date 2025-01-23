#include <stdio.h>
#include <string.h>

int main()
{
    char input[1000001];
    fgets(input, 1000001, stdin);
    int len = strlen(input);
    char new_word[1000001];
    int new_word_pointer = 0;

    for (int i = 0; i < len; i++)
    {
        if (input[i] == '<')
        {
            if (new_word_pointer > 0)
            {
                new_word_pointer--;
            }
        }
        else
        {
            new_word[new_word_pointer] = input[i];
            new_word_pointer++;
        }
    }
    new_word[new_word_pointer] = '\0';
    puts(new_word);
    return 0;
}