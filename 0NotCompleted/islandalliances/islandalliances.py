class WeightedQuickUnionUF:
    """
    This is an implementation of the union-find data structure - see module documentation for
    more info.

    This implementation uses weighted quick union by size (without path compression).
    Initializing a data structure with n sites takes linear time. Afterwards, the union, find,
    and connected operations take logarithmic time (in the worst case) and the count operation
    takes constant time. For alternate implementations of the same API, see UF, QuickFindUF,
    and QuickUnionUF.

    For additional documentation, see Section 1.5 of Algorithms, 4th Edition by Robert Sedgewick and Kevin Wayne.
    """

    def __init__(self, n: int) -> None:
        """Initializes an empty union-find data structure with n sites, 0
        through n-1. Each site is initially in its own component.

        :param n: the number of sites

        """
        self._count = n
        self._parent = list(range(n))
        self._size = [1] * n

    def _validate(self, p: int) -> None:
        # validate that p is a valid index
        n = len(self._parent)
        if p < 0 or p >= n:
            raise ValueError("index {} is not between 0 and {}".format(p, n - 1))

    def union(self, p: int, q: int) -> None:
        """Merges the component containing site p with the component containing
        site q.

        :param p: the integer representing one site
        :param q: the integer representing the other site

        """
        root_p = self.find(p)
        root_q = self.find(q)
        if root_p == root_q:
            return

        # make root of smaller rank point to root of larger rank
        if self._size[root_p] < self._size[root_q]:
            small, large = root_p, root_q
        else:
            small, large = root_q, root_p

        self._parent[small] = large
        self._size[large] += self._size[small]

        self._count -= 1

    def find(self, p: int) -> int:
        """Returns the component identifier for the component containing site
        p.

        :param p: the integer representing one site
        :return: the component identifier for the component containing site p

        """
        self._validate(p)
        while p != self._parent[p]:
            p = self._parent[p]
        return p

    def connected(self, p: int, q: int) -> bool:
        """Returns true if the two sites are in the same component.

        :param p: the integer representing one site
        :param q: the integer representing the other site
        :return: true if the two sites p and q are in the same component; false otherwise

        """
        return self.find(p) == self.find(q)

    def count(self) -> int:
        return self._count


n, m, q = [int(x) for x in input().split()]

distrust = {}

for i in range(m):
    v, w = [int(x) for x in input().split()]
    distrust[v - 1] = w - 1
    distrust[w - 1] = v - 1

UF = WeightedQuickUnionUF(n)
for i in range(q):
    v, w = [int(x) for x in input().split()]
    v -= 1
    w -= 1
    if v in distrust:
        d1 = distrust[v]
        if UF.find(d1) == UF.find(w):
            print("REFUSE")
            continue
    elif w in distrust:
        d2 = distrust[w]
        if UF.find(d2) == UF.find(v):
            print("REFUSE")
            continue
    UF.union(v, w)
    print("APPROVE")
