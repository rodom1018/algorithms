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

