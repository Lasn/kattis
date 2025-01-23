day, month, year = input().split("/")
day = int(day)
month = int(month)
d = False
m = False
if(day <= 12 ): d = True
if(month <= 12): m = True
if(d and not m): print("US")
if(m and not d): print("EU")
if(m and d): print("either")