class UF:
    def __init__(self, n: int) -> None:

        self._count = n
        self._parent = list(range(n))
        self._size = [1] * n

    def _validate(self, p: int) -> None:
        # validate that p is a valid index
        n = len(self._parent)
        if p < 0 or p >= n:
            raise ValueError("index {} is not between 0 and {}".format(p, n - 1))

    def union(self, p: int, q: int) -> None:

        root_p = self.find(p)
        root_q = self.find(q)
        if root_p == root_q:
            return

        if self._size[root_p] < self._size[root_q]:
            small, large = root_p, root_q
        else:
            small, large = root_q, root_p

        self._parent[small] = large
        self._size[large] += self._size[small]

        self._count -= 1

    def find(self, p: int) -> int:

        self._validate(p)
        while p != self._parent[p]:
            p = self._parent[p]
        return p

    def connected(self, p: int, q: int) -> bool:

        return self.find(p) == self.find(q)

    def count(self) -> int:
        return self._count


row = int(input())
col = int(input())
adds = int(input())

uf = UF(row * col)

smap = []
for _ in range(row):
    smap.append(list(input()))


def tubletoint(t):
    return t[0] * col + t[1]


S = None


def check_around(r, c):
    symbols = ["#", "S"]
    if c + 1 < col and smap[r][c + 1] in symbols:
        uf.union(tubletoint((r, c)), tubletoint((r, c + 1)))
    if c - 1 >= 0 and smap[r][c - 1] in symbols:
        uf.union(tubletoint((r, c)), tubletoint((r, c - 1)))
    if r + 1 < row and smap[r + 1][c] in symbols:
        uf.union(tubletoint((r, c)), tubletoint((r + 1, c)))
    if r - 1 >= 0 and smap[r - 1][c] in symbols:
        uf.union(tubletoint((r, c)), tubletoint((r - 1, c)))


for r in range(row):
    for c in range(col):
        if smap[r][c] == ".":
            continue
        elif smap[r][c] == "#":
            check_around(r, c)
        elif smap[r][c] == "S":
            S = (r, c)
            check_around(r, c)


def count():
    connected_count = 0
    for r in range(row):
        for c in range(col):
            if smap[r][c] == "#" or smap[r][c] == "S":
                if uf.connected(tubletoint(S), tubletoint((r, c))):
                    connected_count += 1
    return connected_count


print(count())

for _ in range(adds):
    r, c = map(int, input().split())
    r, c = r - 1, c - 1
    # smap[r][c] = "#"
    check_around(r, c)
    print(count())
