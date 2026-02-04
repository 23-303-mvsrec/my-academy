#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>

int main() {
    int sock;
    struct sockaddr_in server_addr;
    char buffer[1024] = {0};

    sock = socket(AF_INET, SOCK_STREAM, 0);

    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(5000);

    // Replace with Python server machine IP
    inet_pton(AF_INET, "172.16.28.67", &server_addr.sin_addr);

    connect(sock, (struct sockaddr *)&server_addr, sizeof(server_addr));

    send(sock, "Hello from C client", 19, 0);

    recv(sock, buffer, sizeof(buffer), 0);
    printf("Server says: %s\n", buffer);

    close(sock);
    return 0;
}

