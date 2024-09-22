
#import sys
#sys.setrecursionlimit(1000000)

#input = sys.stdin.readline
n, m = map(int, input().split())

parent = [ i for i in range(n+1) ]

def find(c):
    if parent[c] == c:
        return c
    else:
        parent[c] = find(parent[c]) # 중간 경로 단축
        return parent[c]

def union(a,b):
    
    a = find(a)
    b = find(b)

    if a == b :
        return

    if a < b :
        parent[b] = a
    else:
        parent[a] = b

for i in range(m):
    #input = sys.stdin.readline
    x, a, b = map(int, input().split())
    #print(parent)
    if x == 0 :
        # 집합을 합침
        union(a,b)
    else:
        # 테스트
        if find(a) == find(b):
            print("YES")
        else:
            print("NO")
