from collections import defaultdict

my_dict = defaultdict(list)
my_dict['a'].append(1)
my_dict['a'].append(2)
print(my_dict)

my_list = [2,4,6,8,10]
print(my_list[1:6])
#문자열을 반대로 출력하기
temp = "abbbbbca"
print(temp)
print(temp[::-1])

cup_list = [(2,4), (0,6), (1,2)]
cup_list.sort(key = lambda x:x[1])
print(cup_list)
cup_list.remove((2,4))
print(cup_list)

cup_list = [2,4,5]
cup_list.sort(key=lambda x:-x)
print(cup_list)

