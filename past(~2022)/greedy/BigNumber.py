n,m,k =map(int, input().split())
data = list(map(int, input().split()))

first = -1
index_first = -1

second = -1
index_second = -1

max = -1
max2 = -1
index = 0

result= 0
repeat = 0

#나는 정렬하지 않고 첫번째로 큰 수 , 두번째로 큰 수를 찾았는데
#간단하게 sort 해서 1,2번째 원소 꺼내면 1,2번째 큰 수 꺼낼 수 있다!!
for num in data:
    if max < num :
        max=num

for num in data:

    if num == max:
        if index_first<0:
            index_first = index
        else:
            index_second = index
    index += 1

index=0

if index_second >=0 :
    pass
else:
    for num in data:
        if max2 < num and num != max:
            max2 = num

    for num in data:

        if num == max2:
            index_second= index

        index += 1

for i in range(0,m):
    repeat+=1

    if repeat >k:
        result+=data[index_second]

        repeat=0
    else:
        result+=data[index_first]


print(result)