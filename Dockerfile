FROM ubuntu:latest
LABEL authors="claudio"

ENTRYPOINT ["top", "-b"]