#include <stdio.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <stdlib.h>
#include <arpa/inet.h>
#include <unistd.h>
#include <string.h>

int main()
{
    int sockfd;
    struct sockaddr_in serv_addr;
    char buffer[50], reply[50];

    sockfd = socket(AF_INET, SOCK_STREAM, 0);
    if (sockfd < 0)
    {
        printf("Socket creation failed\n");
        exit(0);
    }

    serv_addr.sin_family = AF_INET;
    serv_addr.sin_addr.s_addr = inet_addr("127.0.0.1");
    serv_addr.sin_port = htons(4568);

    if (connect(sockfd, (struct sockaddr *)&serv_addr, sizeof(serv_addr)) < 0)
    {
        printf("Connection failed\n");
        exit(0);
    }

    printf("Enter message: ");
    scanf("%s", buffer);

    write(sockfd, buffer, sizeof(buffer));
    read(sockfd, reply, sizeof(reply));

    printf("Client Received: %s\n", reply);

    close(sockfd);
    return 0;
}

