m = set([input().lower()])

Akureyri = set(["akureyri", "mulathing", "fjardabyggd"])

if Akureyri.intersection(m):
    print("Akureyri")
else:
    print("Reykjavik")
