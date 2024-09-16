n = int(input())
my_list = list(map(int, input().split()))

my_list.sort()

print(my_list[0] * my_list[n-1])