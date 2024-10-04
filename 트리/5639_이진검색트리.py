import sys
sys.setrecursionlimit(10**6)
my_list = []

while True:
    try:
        my_list.append(int(sys.stdin.readline()))
    except:
        break
    
def traverse(now_list):
    if len(now_list) == 1:
        left = []
        right = []
        mid = now_list[0]
    else:
        #mid, left, right 로 나눈다.
        index = 1
        while True:
            if index >= len(now_list) or now_list[index] > now_list[0]:
                break
            index += 1
               
        left = now_list[1:index]
        right = now_list[index:]
        mid = now_list[0]
    
    # 후위 순회 - 왼쪽, 오른쪽, 루트 노드
    if len(left) != 0:
        traverse(left)
    if len(right) != 0:
        traverse(right)
    print(mid)

traverse(my_list)