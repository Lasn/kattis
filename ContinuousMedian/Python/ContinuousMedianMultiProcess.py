
import bisect
import multiprocessing
import statistics




def median(list,idx):
    setList = []
    sum = 0
    for a in list:
       bisect.insort(setList,int(a))
       sum += int(statistics.median(setList))
    sums.insert(idx,sum)

    

sums = []
mp = []
t = int(input())
for i in range(t):
    n = int(input())
    list = input().split()
    multiprocessing.Process(target=median(list,i))

for i in sums:
    print(i)

       


