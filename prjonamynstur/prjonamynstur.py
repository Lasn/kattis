dict = {".": 20, "O": 10, "\\": 25, "/": 25, "A": 35, "^": 5, "v": 22}
row, collum = map(int, input().split())

length = 0
for i in range(row):
    line = list(input())
    for symbol in line:
        length += dict[symbol]
print(length)
