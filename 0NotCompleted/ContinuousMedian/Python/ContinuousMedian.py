
import bisect
import statistics


def median(list):
    setList = []
    sum = 0
    for a in list:
       bisect.insort(setList,int(a))
       sum += int(statistics.median(setList))
    print(sum)

sums = []
t = int(input())
for i in range(t):
    n = int(input())
    median(input().split())


