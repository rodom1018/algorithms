from dataclasses import dataclass
n = int(input())

@dataclass
class Coord:
    x = 98765
    y = 98765
    
coord_list = []

for i in range(n):
    temp = Coord()
    temp_x, temp_y = map(int, input().split())
    temp.x = temp_x
    temp.y = temp_y
    coord_list.append(temp)

coord_list = sorted(coord_list, key = lambda elem : (elem.y, elem.x))
current_time = -1
count = 0
for i in range(len(coord_list)):
    if coord_list[i].x >= current_time:
        current_time = coord_list[i].y
        count+=1
        
print(count)