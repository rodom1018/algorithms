from itertools import combinations
import math


#my_list = list(combinations(items, 2)) 2개 선택 조합.

n, k =map(int, input().split())
info = list(map(int, input().split()))
list1 = info[:n//2]
list2 = info[n//2:]

sum1 = []
sum2 = []

for i in range(0,n//2+1):
    temp_comb = list(combinations(list1 , i))

    for j in range(len(temp_comb)):
        now = temp_comb[j]
        sum1.append(sum(now))

for i in range(0, (n - n//2) + 1):
    temp_comb = list(combinations(list2, i))
    for j in range(len(temp_comb)):
        now = temp_comb[j]
        sum2.append(sum(now))

sum1.sort()
sum2.sort()

p1 = 0
p2 = len(sum2)-1
sum1_len = len(sum1)

result = 0
while p2 >= 0 and p1 < sum1_len :

    temp_sum = sum1[p1] + sum2[p2]
    if k == temp_sum :
        now_p1 = p1
        now_p2 = p2

        multiply_1 =1
        multiply_2 =1

        p1 += 1
        p2 -= 1

        while p1 < sum1_len and sum1[p1] == sum1[now_p1]:
            p1+=1
            multiply_1 +=1

        while p2 >=0 and sum2[p2] == sum2[now_p2]:
            p2-=1
            multiply_2 +=1

        result += multiply_1 * multiply_2
    elif k < temp_sum:
        p2 -= 1
    else:
        p1 += 1


if k != 0 : print(result)
else : print(result - 1)


