n = int(input())

lst = []
if n % 2 == 1:
    lst.append(3)
    n -= 3
nums = n // 2
lst.extend([2]*nums)
print(len(lst))
print(*lst)