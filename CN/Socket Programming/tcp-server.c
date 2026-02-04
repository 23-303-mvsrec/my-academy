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
    int sockfd, newsockfd;
    socklen_t clilen;
    struct sockaddr_in serv_addr, cli_addr;
    char buffer[50];

    // Create socket
    sockfd = socket(AF_INET, SOCK_STREAM, 0);
    if (sockfd < 0) {
        perror("Socket creation failed");
        exit(1);
    }

    // Allow reuse of address
    int opt = 1;
    setsockopt(sockfd, SOL_SOCKET, SO_REUSEADDR, &opt, sizeof(opt));

    // Server address
    serv_addr.sin_family = AF_INET;
    serv_addr.sin_addr.s_addr = htonl(INADDR_ANY);
    serv_addr.sin_port = htons(5001);

    // Bind
    if (bind(sockfd, (struct sockaddr *)&serv_addr, sizeof(serv_addr)) < 0) {
        perror("Bind failed");
        close(sockfd);
        exit(1);
    }

    // Listen
    listen(sockfd, 5);
    printf("TCP Server waiting for client...\n");

    clilen = sizeof(cli_addr);

    while (1)
    {
        // Accept connection
        newsockfd = accept(sockfd, (struct sockaddr *)&cli_addr, &clilen);
        if (newsockfd < 0) {
            perror("Accept failed");
            continue;
        }

        memset(buffer, 0, sizeof(buffer));

        // Read data
        int n = read(newsockfd, buffer, sizeof(buffer) - 1);
        if (n <= 0) {
            perror("Read failed");
            close(newsockfd);
            continue;
        }

        buffer[n] = '\0';
        printf("Server Received: %s\n", buffer);

        // Send back same message
        write(newsockfd, buffer, strlen(buffer));

        // Exit condition
        if (strncmp(buffer, "exit", 4) == 0) {
            printf("Server exiting...\n");
            close(newsockfd);
            break;
        }

        close(newsockfd);
    }

    close(sockfd);
    return 0;
}

