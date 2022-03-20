
#include <iostream>
#include <deque>

using namespace std;

struct num{
    long long score;
    int index;
}nums[100010];

int main() {
    int n, d;
    long long result = -20000001000;
    scanf("%d %d", &n, &d);

    for(int i=1; i<=n ; i++){
        long long temp;
        scanf("%lld", &temp);
        nums[i].score = temp;
        nums[i].index = i;
    }

    deque<num> dq;

    for(int i=1 ; i<=n; i++){

       while(true){
           if(dq.size() ==0 ) break;
           if(dq.front().index <i-d) dq.pop_front();
           else break;
       }

       long long temp_score;
       if(dq.size()!=0) {
           temp_score = max(dq.front().score + nums[i].score, nums[i].score);
       }else{
           temp_score = nums[i].score;
       }
       //printf("temp_score: %ld\n",temp_score);

       if(result< temp_score) result = temp_score;

       while(true){
           if(dq.size() == 0) break;
           if (dq.back().score < temp_score) { dq.pop_back(); }
           else break;
       }

       dq.push_back({temp_score, i});
   }

    printf("%lld", result);
}

