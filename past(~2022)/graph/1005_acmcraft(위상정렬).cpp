#include <cstdio>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

int result[1010];
int graph[1001][1001];
int locking[1001];
int times[1010];


int main(void) {

    int t;
    scanf("%d", &t);

    for(int cases=0 ; cases<t; cases++){

        queue<int> q;
        memset(result, 0, sizeof(result));
        memset(graph, 0 ,sizeof(graph));
        memset(times, 0 , sizeof(times));
        memset(locking , 0, sizeof(locking));

        int n, k ;
        scanf("%d %d", &n, &k);

        for(int i=1 ; i<=n; i++){
            int temp_value;
            scanf("%d", &temp_value);
            times[i] = temp_value;
        }

        for(int i=1; i<=k; i++){
            int start , end;
            scanf("%d %d", &start, &end);
            graph[start][end] = 1;
            locking[end] ++;
        }

        int s;
        scanf("%d", &s);

        for(int i=1; i<=n ; i++){
            if(locking[i] == 0) q.push(i);
        }

        while(q.size() !=0) {
            int now = q.front();
            q.pop();

            result[now] = result[now] + times[now];

            for (int i = 1; i <= n; i++) {
                if (graph[now][i] == 1) {
                    locking[i]--;
                    if(result[i] < result[now]) result[i] = result[now];
                    if (locking[i] == 0) q.push(i);
                }
            }
        }

        printf("%d\n", result[s]);
    }

}


