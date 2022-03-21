
#include <iostream>
#include <deque>

using namespace std;

struct tree{
    long tired;
    long height;
    int index;
};

long info[1000010];

int main() {
    int n;
    scanf("%d", &n);

    for(int i=1; i<=n; i++){
        int temp;
        scanf("%d", &temp);
        info[i] = temp;
    }

    deque<tree> dq;

    int m;
    scanf("%d", &m);
    for(int i=1 ; i<=m; i++){

        dq.clear();

        int jump;
        scanf("%d", &jump);

        for(int j=1; j<=n; j++) {
            while (true) {
                if (dq.size() == 0) break;
                if (dq.front().index < j - jump) dq.pop_front();
                else break;
            }

            long temp_tired;
            if (dq.size() != 0) {
                if(dq.front().height <= info[j]) temp_tired= dq.front().tired + 1;
                else temp_tired = dq.front().tired;
            } else {
                temp_tired = 0;
            }
            //printf("temp_score: %ld\n",temp_tired);

            if(j==n){
                printf("%ld\n", temp_tired);
                break;
            }

            while (true) {
                if (dq.size() == 0) break;
                if (dq.back().tired > temp_tired) dq.pop_back();
                else if(dq.back().tired == temp_tired && dq.back().height < info[j]) dq.pop_back();
                else break;
            }

            dq.push_back({temp_tired, info[j],j});

        }
   }
}

