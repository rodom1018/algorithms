#include <cstdio>
#include <cstring>
#include <iostream>
#include <algorithm>

int info[10010][2];
int dp[10010][3];

using namespace std;

int t, n ,w;

void solve( int start){
    for(int i=start; i<=n ; i++){

        if(info[i-1][0] + info[i][0] <= w) dp[i][0] = min(dp[i-1][1]+1, dp[i-1][2]+1);
        else dp[i][0] = min(dp[i-1][1]+2, dp[i-1][2]+1);

        if(info[i-1][1] + info[i][1] <= w) dp[i][1] = min(dp[i-1][0]+1, dp[i-1][2]+1);
        else dp[i][1] = min(dp[i-1][0]+2, dp[i-1][2]+1);

        int temp_min_a = min(dp[i][0], dp[i][1])+1;

        int temp_min_b;
        if(info[i][0] + info[i][1] <= w) temp_min_b = dp[i-1][2] +1;
        else temp_min_b = dp[i-1][2] +2 ;

        int temp_min_c;
        if(info[i][0] + info[i-1][0] <= w
        && info[i][1] + info[i-1][1] <= w){
            temp_min_c = dp[i-2][2] +2;
        }else if(info[i][0] + info[i-1][0] <= w)temp_min_c = dp[i-2][2] +3;
        else if(info[i][1] + info[i-1][1] <= w) temp_min_c = dp[i-2][2]+3;
        else temp_min_c = dp[i-2][2]+4;

        dp[i][2] = min(min(temp_min_a, temp_min_b),temp_min_c);

       //printf("%d %d %d \n", dp[i][0], dp[i][1], dp[i][2]);
    }
   //printf("\n");
}
int main(void) {
    scanf("%d", &t);

    for(int test = 1 ; test<=t ; test++){
        int result = 98765432;
        memset(info, 0 ,sizeof(info));
        memset(dp, 0 ,sizeof(dp));

        scanf("%d %d", &n, &w);

        for(int i=1 ; i<= n*2 ; i++){
            int temp ;
            scanf("%d", &temp);
            int a,b;
            b = (i-1)/n;
            a = ((i-1)%n)+1;
            info[a][b] = temp;
        }

        int temp_result;

        // 안겹친 경우
        dp[1][0] =1; dp[1][1] = 1;
        if(info[1][0] + info[1][1] <= w) dp[1][2] = 1;
        else dp[1][2] =2;
        solve(2);
        int temp_min = min(dp[n][1], dp[n][0]);
        temp_result = min(dp[n][2], temp_min+1);
        //printf("1 . %d\n", temp_result);
        if(result > temp_result ) result = temp_result;

        if(n==1){
            // 한줄 이면 , 사이클 개념이 없다 . 종료
            printf("%d\n", result);
            continue;
        }

        int temp0 = info[1][0];
        int temp1 = info[1][1];

        // 안쪽 [0] 이 겹친 경우
        if(info[1][0] + info[n][0] <= w) {
            memset(dp, 0, sizeof(dp));
            dp[1][0] = 1; dp[1][1] = 1; dp[1][2] = 2;
            info[1][0] = 98765432;
            solve(2);
            info[1][0] = temp0;
            temp_result = dp[n][1];
            //printf("2 . %d\n", temp_result);
            if (result > temp_result) result = temp_result;
        }

        //바깥쪽 [1] 이 겹친 경우
        if(info[1][1] + info[n][1] <= w) {
            memset(dp, 0, sizeof(dp));
            dp[1][0] = 1;dp[1][1] = 1;dp[1][2] = 2;
            info[1][1] = 98765432;
            solve(2);
            info[1][1] = temp1;
            temp_result = dp[n][0];
            //printf("3 . %d\n", temp_result);
            if (result > temp_result) result = temp_result;
        }

        // 둘 다 겹친 경우
        if(info[1][0] + info[n][0] <= w && info[1][1] + info[n][1] <= w) {
            memset(dp, 0, sizeof(dp));
            dp[1][0] = 1; dp[1][1] = 1; dp[1][2] = 2;
            info[1][0] = 98765432; info[1][1] = 98765432;
            solve(2);
            info[1][0] = temp0; info[1][1] = temp1;
            temp_result = min(min(dp[n - 1][2], dp[n - 1][0] + 1), dp[n - 1][1] + 1);
            //printf("4 . %d\n", temp_result);
            if (result > temp_result) result = temp_result;
        }

        printf("%d\n", result);
    }


}

