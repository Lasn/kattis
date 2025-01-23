input()
a="<]:="
print(str(int(eval(input().replace(a,"0").replace("/","//")))).replace("0",a))