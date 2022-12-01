
import bisect
import statistics
import concurrent.futures


def median(list,idx):
    setList = []
    sum = 0
    for a in list:
       bisect.insort(setList,int(a))
       sum += int(statistics.median(setList))
    sums.insert(idx,sum)

sums = []
t = int(input())
for i in range(t):
    n = int(input())
    with concurrent.futures.ThreadPoolExecutor() as executer:
        list = input().split()
        executer.submit(median,list,i)

for i in sums:
    print(i)

       


