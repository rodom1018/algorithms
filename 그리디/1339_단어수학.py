import sys

N = int(sys.stdin.readline())
str_list = []
str_dict = dict()
for i in range(N):
    str_list.append(sys.stdin.readline().strip())

for now_str in str_list:

    now_len = len(now_str)

    for i in range(now_len):
        if now_str[i] not in str_dict:
            #딕셔너리에 해당 문자가 처음 들어갈 경우
            str_dict[now_str[i]] = 10 ** (now_len - i - 1)
        else:
            #딕셔너리에 해당 문자가 있는 경우
            str_dict[now_str[i]] += 10 ** (now_len - i - 1)

str_dict = sorted(str_dict.values(), reverse=True)
result = 0

for i in range(len(str_dict)):
    result += str_dict[i] * (9-i)

print(result)