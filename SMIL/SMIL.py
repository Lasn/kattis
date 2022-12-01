word = input()
smile = ''
output = []

for idx, letter in enumerate(word):
    if ':' in letter or ';' in letter:
        smile += letter 
        index = idx
    elif ':' in smile or ';' in smile:
        if letter == '-':
            smile += letter
        elif letter == ')':
            smile += letter 
            smile=''
            output.append(index)
        else:
            smile = '' 
    else: 
        smile = ''
        continue

for i in output:
    print(i)
