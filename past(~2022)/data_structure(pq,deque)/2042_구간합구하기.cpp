
#include <iostream>

using namespace std;

struct node{
    long long part_sum;
    long long start;
    long long end;
}nodes[3000100];
long long MY_MAX = 0;
long long info[3000100];

long long init(long long  now, long long left, long long right){
    if(now > MY_MAX) MY_MAX = now;
    nodes[now].start = left;
    nodes[now].end = right;
    // printf("%d / %d , %d.\n ", now, left, right);
    if(left == right){
        nodes[now].part_sum = info[left];
        // printf("%d / %d , %d , %d@@\n ", now, left, right, nodes[now].part_sum);
        return info[left];
    }

    long long mid = (left+right) / 2;

    nodes[now].part_sum = init(now*2+1, left, mid) + init(now*2+2 , mid+1, right);
    // printf("%d / %d , %d , %d?!?\n ", now, left, right, nodes[now].part_sum);
    return nodes[now].part_sum;
}

long long  my_sum(long long  l,long long r, long long now ){
    if(l <= nodes[now].start && r >= nodes[now].end){
        //printf("1. %d %d - %d\n",  nodes[now].start, nodes[now].end, nodes[now].part_sum);
        return nodes[now].part_sum;
    }else if (l > nodes[now].end || r < nodes[now].start) {
        //printf("2.  %d %d - 0\n", nodes[now].start, nodes[now].end);
        return 0;
    }else{
        long long temp = my_sum(l, r, now*2+1 ) + my_sum(l,r,now*2+2);
        //printf("3 . %d %d - %d\n",  nodes[now].start, nodes[now].end, temp);
        return temp;
    }
}

void my_modify(long long cmp , long long add , long long p ){
    //printf("%d %d %d !\n ", cmp, add , p);
    nodes[p].part_sum += add;
    long long mid = (nodes[p].start + nodes[p].end) / 2;
    if(mid < cmp && p*2+2 <= MY_MAX ) my_modify(cmp, add, p*2+2);
    else if(mid >= cmp && p*2+1 <= MY_MAX) my_modify(cmp,add , p*2+1);
    else return;
}

int main() {
    long long  n, m, k;
    scanf("%lld %lld %lld", &n, &m, &k);

    for(long long i=1; i<=n; i++){
        long long temp;
        scanf("%lld", &temp);
        info[i] = temp;
    }

    init(0,1,n);

    for(long long i=1 ; i<= m+k ; i++){
        long long  a,b,c;
        scanf("%lld %lld %lld", &a, &b, &c);

        if(a == 1){
            long long temp = c;
            c = c-info[b];
            info[b] = temp;
            my_modify(b,c, 0 );
        }else{
            long long result = my_sum(b,c, 0 );
            printf("%lld\n", result);
        }


    }
}

