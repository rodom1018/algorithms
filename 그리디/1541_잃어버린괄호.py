import sys

now_str = sys.stdin.readline().strip()
now_list = now_str.split("-")

result = 0 
#print(now_list)
for i in range(len(now_list)):
    now_sub_list = now_list[i].split("+")
    temp = 0

    for j in range(len(now_sub_list)):
        temp += int(now_sub_list[j])

    if i == 0:
        result += temp
    else:
        result -= temp

print(result)