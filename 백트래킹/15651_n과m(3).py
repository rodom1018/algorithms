import sys

N, M = map(int, sys.stdin.readline().split())

s = []

def dfs():

    # 출력길이에 맞으면 출력하기
    if len(s) == M:
        print(' '.join(map(str, s)))
        return

    for i in range(1,N+1):
        s.append(i)
        dfs()
        s.pop()

dfs()