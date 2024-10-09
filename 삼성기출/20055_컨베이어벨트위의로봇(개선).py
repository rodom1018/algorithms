import sys

N, K = map(int, sys.stdin.readline().split(" "))
belt_array = list(map(int, sys.stdin.readline().split(" ")))
robot_list = []
result = 1
now_count = 0

def move(now_array):
    new_array = now_array[-1:] + now_array[:-1]
    return new_array

def robot_change(index, count):
    belt_array[index] -= 1

    if belt_array[index] == 0:
        count += 1

    return count

def robot_narim(index):
    if robot_list[index] == N-1:
        robot_list.pop(i)

while True:
    # 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
    # 로봇 한칸씩 이동
    for i in range(len(robot_list)):
        robot_list[i] += 1
        robot_narim(i)
        
    # 벨트 한칸씩 이동
    belt_array = move(belt_array)


    # 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
    # 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
    for i in range(len(robot_list)-1, -1, -1):
        if i == len(robot_list)-1:
            #제일 먼저 놓인 로봇
            if belt_array[robot_list[i] + 1] > 0:
                now_count = robot_change(robot_list[i]+1, now_count)
                robot_list[i] += 1

            robot_narim(i)

        else:
            #제일 먼저 놓인 로봇이 아닌 경우
            if robot_list[i+1] != robot_list[i] + 1 and belt_array[robot_list[i] + 1] > 0 :
                now_count = robot_change(robot_list[i]+1, now_count)
                robot_list[i] += 1


    # 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
    if belt_array[0] > 0 :
        robot_list.insert(0,0)
        now_count = robot_change(0, now_count)

    # 4. 내구도가 0인 칸의 개수가 K개 이상이면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
    if now_count >= K:
        break

    result += 1 

print(result)






