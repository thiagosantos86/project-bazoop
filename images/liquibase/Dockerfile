FROM webdevops/liquibase:postgres
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.5.1/wait /wait
RUN chmod +x /wait

ENTRYPOINT ["/bin/bash", "-c", "/wait && /entrypoint update"]