import sys

N, M = map(int, sys.stdin.readline().split())

s = []

def dfs():

    # 출력길이에 맞으면 출력하기
    if len(s) == M:
        for i in s:
            print(i, end=" ")
        print()

    for i in range(1,N+1):
        if i not in s:
            s.append(i)
            dfs()
            s.pop()

dfs()
