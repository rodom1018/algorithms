from itertools import combinations
import math

n = int(input())

for case in range(n):
    result = -1
    k = int(input())

    items = []

    for i in range(k):
        items.append(i)
    my_list = list(combinations(items, k//2))
    #print(my_list)
    x = []
    y = []

    pointer = 0
    for i in range(k):
        temp1, temp2 = map(int, input().split())
        x.append(temp1)
        y.append(temp2)

    #print(len(my_list)) 252
    for i in range(len(my_list)): #모든 조합의 경우의 수 하나하나.

        add_x = 0
        add_y = 0
        sub_x = 0
        sub_y = 0
        pointer =0

        now = my_list[i]

        for j in range(k):
            if pointer < k//2 and j == now[pointer] :
                add_x += x[j]
                add_y += y[j]
                pointer += 1
            else:
                sub_x += x[j]
                sub_y += y[j]
        """
        print("=====")
        print(pointer)
        print(add_x)
        print(add_y)
        print(sub_x)
        print(sub_y)
        print(math.sqrt((add_x - sub_x) ** 2 + (add_y - sub_y) ** 2))
        print("======")
        """

        if result <0 or result > math.sqrt((add_x - sub_x) ** 2 + (add_y - sub_y) ** 2):
            #print(math.sqrt((add_x - sub_x) ** 2 + (add_y - sub_y) ** 2))
            result = math.sqrt((add_x - sub_x) ** 2 + (add_y - sub_y) ** 2)

    print(result)


