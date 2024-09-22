import sys

intput = sys.stdin.readline
N = int(input())

intput = sys.stdin.readline
M = int(input())

cost_list = []
for i in range(M):
    input = sys.stdin.readline
    a,b,c = map(int, input().split())
    cost_list.append((c,a,b))

cost_list.sort()
len_list = len(cost_list)
parent_list = [ i for i in range(N+1)]

def find(x):
    if x == parent_list[x]:
        return x
    else:
        parent_list[x] = find(parent_list[x])
        return parent_list[x]

def union(a,b):
    a = find(a)
    b = find(b)

    if a < b :
        parent_list[b] = a
    else:
        parent_list[a] = b


result = 0

for i in range(len_list):
    now_a = cost_list[i][1]
    now_b = cost_list[i][2]
    now_cost = cost_list[i][0]
    if find(now_a) != find(now_b):
        union(now_a, now_b)
        result += now_cost

print(result)
