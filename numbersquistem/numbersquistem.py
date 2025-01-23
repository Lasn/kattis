N = int(input())
exp = input().replace("<]:=","0").replace("/","//")
res = str(int(eval(exp))).replace("0","<]:=")
print(res)