import sys

T = int(sys.stdin.readline())

def ispalindrome(now_str, start, end):
    while start <= end:
        if now_str[start] == now_str[end]:
            start += 1
            end -= 1
        else:
            break
    
    return [start,end]

for i in range(T):
    now_str = sys.stdin.readline().strip()
    now_len = len(now_str)
    
    result1 = ispalindrome(now_str, 0, now_len-1)

    if result1[0] > result1[1]:
        print("0")
        continue
    
    result2 = ispalindrome(now_str, result1[0]+1 , result1[1])
    result3 = ispalindrome(now_str, result1[0], result1[1]-1)

    if result2[0] > result2[1] or result3[0] > result3[1]:
        print("1")
    else:
        print("2")