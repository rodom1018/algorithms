
#include <iostream>

using namespace std;

struct node{
    long long part_max;
    long long part_min;
}nodes[300001];

long long info[300001];

struct node init(long long  now, long long left, long long right){
    if(left == right){
        nodes[now].part_max = info[left];
        nodes[now].part_min = info[left];
        struct node temp_info = { nodes[now].part_max, nodes[now].part_min };
        return temp_info;
    }

    long long mid = (left + right) / 2;
    struct node temp_left = init(now*2 , left, mid);
    struct node temp_right = init(now*2+1 , mid+1 , right);

    long long temp_max = max(temp_left.part_max, temp_right.part_max);
    long long temp_min = min(temp_left.part_min, temp_right.part_min);

    nodes[now].part_max = temp_max;
    nodes[now].part_min = temp_min;

    struct node temp_info = {temp_max, temp_min};
    return temp_info;
}

struct node  my_calc(long long  start,long long end, long long left, long long right , long long now){
    if(start <= left && end >= right) return nodes[now];
    else if(start > right || end < left ) return {0,0};

    long long mid = (left+right) / 2;
    struct node temp_left = my_calc(start, end, left, mid, now*2);
    struct node temp_right  = my_calc(start, end, mid+1 ,right, now*2+1);

    long long temp_min;
    long long temp_max;

    if(temp_left.part_min != 0 && temp_right.part_min != 0){
        temp_min = min(temp_left.part_min, temp_right.part_min);
    }else if(temp_left.part_min != 0){
        temp_min = temp_left.part_min;
    }else if(temp_right.part_min != 0){
        temp_min = temp_right.part_min;
    }else{
        temp_min = 0;
    }

    if(temp_left.part_max != 0 && temp_right.part_max != 0){
        temp_max = max(temp_left.part_max, temp_right.part_max);
    }else if(temp_left.part_max != 0){
        temp_max = temp_left.part_max;
    }else if(temp_right.part_max != 0){
        temp_max = temp_right.part_max;
    }else{
        temp_max = 0;
    }

    //printf("%d %d %d %d %d %d %d !!\n", start, end, left, right, now, temp_max, temp_min);
    return {temp_max, temp_min};
}
int main() {

    long long n, k ;
    scanf("%lld %lld", &n, &k);

    for(long long i=1; i<=n ; i++){
        long long temp;
        scanf("%d", &temp);
        info[i] = temp;
    }

    init(1,1, n);

    /*for(int i=1; i<30; i++){
        printf("%d %d /", nodes[i].part_max, nodes[i].part_min);
    }*/

    for(long long i=1; i<=k;i++){
        long long l, r;
        scanf("%lld %lld", &l, &r);
        struct node temp_info = my_calc(l, r, 1, n,1 );
        printf("%d %d\n", temp_info.part_min, temp_info.part_max);
    }
}

