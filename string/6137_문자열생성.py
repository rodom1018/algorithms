n = int(input())
my_list = []

for i in range(n):
    s = input()
    my_list.append(s)
    
start = 0
end = len(my_list) -1

result = ""

def judge(start, end):
    temp = 0
    while True:
        temp+=1
        if start+temp > end-temp : break
        if my_list[start+temp] < my_list[end-temp]:
            return 0
        elif my_list[start+temp]>my_list[end-temp]:
            return 1
    return 0

while True:
    if start>end: break
    
    if my_list[start] < my_list[end]:
        result+=str(my_list[start])
        start+=1
    elif my_list[start] > my_list[end]:
        result+=str(my_list[end])
        end-=1
    else:
        temp = judge(start,end)
        
        if temp == 0 :
            result+=str(my_list[start])
            start+=1
        else:
            result+=str(my_list[end])
            end-=1

total_len = len(result)
q = total_len // 80
r = total_len % 80
temp = 0
for i in range(q):
    print(result[temp:temp+80])
    temp+=80
print(result[temp:temp+r])