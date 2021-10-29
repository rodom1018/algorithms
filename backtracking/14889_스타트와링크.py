#input 받기
n = int(input())
my_array = []
min = 9876543

for i in range(n):
    my_array.append(list(map(int, input().split())))

def make_team(team_list, start):
    
    global min
    
    if start >=n : return

    if len(team_list) < n//2:
        for i in range(start, n):
            team_list.append(i)
            make_team(team_list, i+1)
            team_list.remove(i)
    else:
        my_team_score = 0
        opponent_team_score = 0
        for i in range(n):
            for j in range(n):
                if i ==j : continue
                
                if i in team_list and j in team_list:
                    my_team_score +=my_array[i][j]
                
                if (i not in team_list) and (j not in team_list):
                    opponent_team_score +=my_array[i][j]
        
        if min > abs(opponent_team_score - my_team_score):
            min = abs(opponent_team_score - my_team_score)
        
make_team([], 0)
print(min)