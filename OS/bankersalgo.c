#include <stdio.h>
#include <stdbool.h>

int m, n;
int max[10][10], alloc[10][10], need[10][10];
int total[10], avail[10];
bool finish[10];

void readTable(int t[10][10]) {
    for(int i = 0; i < m; i++)
        for(int j = 0; j < n; j++)
            scanf("%d", &t[i][j]);
}

void readVector(int v[10]) {
    for(int j = 0; j < n; j++)
        scanf("%d", &v[j]);
}

void printVector(int v[10]) {
    for(int j = 0; j < n; j++) printf("%d ", v[j]);
    printf("\n");
}

void printTable(int t[10][10]) {
    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++)
            printf("%d ", t[i][j]);
        printf("\n");
    }
}

void init() {
    printf("Processes: "); scanf("%d", &m);
    printf("Resources: "); scanf("%d", &n);

    printf("Max matrix:\n");        readTable(max);
    printf("Allocation matrix:\n"); readTable(alloc);
    printf("Total resources:\n");   readVector(total);

    for(int i = 0; i < m; i++) finish[i] = false;
}

void calcAvailable() {
    for(int j = 0; j < n; j++) {
        avail[j] = total[j];
        for(int i = 0; i < m; i++)
            avail[j] -= alloc[i][j];
    }
}

void calcNeed() {
    for(int i = 0; i < m; i++)
        for(int j = 0; j < n; j++)
            need[i][j] = max[i][j] - alloc[i][j];
}

int selectProcess() {
    for(int i = 0; i < m; i++) {
        if(!finish[i]) {
            int canRun = 1;
            for(int j = 0; j < n; j++)
                if(need[i][j] > avail[j]) {
                    canRun = 0;
                    break;
                }
            if(canRun) return i;
        }
    }
    return -1;
}

int main() {
    init();
    calcAvailable();
    calcNeed();

    printf("\nNeed Matrix:\n");
    printTable(need);

    printf("\nInitial Available: ");
    printVector(avail);

    int completed = 0;

    while(completed < m) {
        int p = selectProcess();

        if(p == -1) {
            printf("\nSystem is in UNSAFE state.\n");
            return 0;
        }

        printf("\nExecuting P%d, Available before: ", p);
        printVector(avail);

        for(int j = 0; j < n; j++)
            avail[j] += alloc[p][j];

        finish[p] = true;
        completed++;
    }

    printf("\nSystem is in SAFE state.\n");
    return 0;
}

