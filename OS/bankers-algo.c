#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h> // Recommended header for boolean types
int m, n, i, j, count = 0, process;
int max[10][10], alloc[10][10], need[10][10], c[10], avail[10];
bool finish[10]; // Use bool for finish array
void readtable(int t[10][10]) {
for(i = 0; i < m; i++)
for(j = 0; j < n; j++)
scanf("%d", &t[i][j]);
}
void printtable(int t[10][10]) {
for(i = 0; i < m; i++) {
for(j = 0; j < n; j++)
printf("\t%d", t[i][j]);
printf("\n");
}
}
void readvector(int v[10]) {
for(j = 0; j < n; j++)
scanf("%d", &v[j]);
}
void printvector(int v[10]) {
for(j = 0; j < n; j++)
printf("\t%d", v[j]);
printf("\n");
}
void init() {
printf("Enter the number of processes: \n");
scanf("%d", &m);
printf("Enter the number of resources: \n");
scanf("%d", &n);
printf("Enter the Max Demand table (%d rows, %d columns):\n", m, n);
readtable(max);
printf("Enter the Allocation table (%d rows, %d columns):\n", m, n);
readtable(alloc);
printf("Enter the Total units of each resource (Vector c, %d elements):\n", n);
readvector(c);
for(i = 0; i < m; i++)
finish[i] = false;
}
void findavail() {
int sum;
for(j = 0; j < n; j++) {
sum = 0;
for(i = 0; i < m; i++) {
sum = sum + alloc[i][j];
}
avail[j] = c[j] - sum;
}
}
void findneed() {
for(i = 0; i < m; i++) {
for(j = 0; j < n; j++) {
need[i][j] = max[i][j] - alloc[i][j];
}
}
}
// Corrected logic for selecting the next safe process
void selectprocess() {
int safe = 0;
for(i = 0; i < m; i++) {
if(!finish[i]) { // Only check unfinished processes
safe = 1; // Assume process is safe
// Check if Need[i] <= Available
for(j = 0; j < n; j++) {
if(need[i][j] > avail[j]) {
safe = 0; // Not enough resources, break early
break;
}
}
// If safe, select this process and break
if(safe) {
process = i;
printf("\n--- Found next process: P%d ---\n", process);
printf("Available before executing P%d: ", process);
printvector(avail);
return;
}
}
}
// If no safe process was found, system is in an unsafe state
printf("\n--- SYSTEM IS IN UNSAFE STATE ---\n");
exit(1);
}
void executeprocess(int p) {
printf("Executing process P%d... (Simulating completion)\n", p);
}
void releaseresource() {
// Release resources back to the Available vector and reset the process allocation
for(j = 0; j < n; j++) {
avail[j] += alloc[process][j]; // Release resources
alloc[process][j] = 0; // Reset allocated resources
need[process][j] = 0; // Reset needed resources
}printf("Resources released by P%d. New Available resources: ", process);
printvector(avail);
}
int main() {
init();
findavail();
findneed();
printf("\n--- Initial State ---\n");
printf("Initial Available: ");
printvector(avail);
printf("Need Table:\n");
printtable(need);
printf("\n--- Safety Sequence Check ---\n");
// Run the safety check until all processes are finished
while(count < m) {
selectprocess(); // Find the next process that can execute
finish[process] = true; // Mark process as finished
count++; // Increment the number of finished processes
executeprocess(process);
releaseresource(); // Release resources from the finished process
}
printf("\n--- SYSTEM IS IN SAFE STATE ---\n");
printf("All %d processes executed correctly in a safe sequence.\n", m);
return 0;
}
