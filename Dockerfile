# base image
FROM python:3.8.1-slim

# set environment variables
ENV PYTHONDONTWRITEBYTECODE 1
ENV PYTHONUNBUFFERED 1

# install netcat
RUN apt-get update \
  && apt-get -y install netcat \
  && apt-get clean

RUN pip install pipenv

# set working directory
WORKDIR /usr/src/app

# add and install requirements
COPY ./Pipfile /usr/src/app/Pipfile

RUN pipenv install

# add entrypoint.sh
COPY ./entrypoint.sh /usr/src/app/entrypoint.sh
RUN chmod +x /usr/src/app/entrypoint.sh

# add app
COPY . /usr/src/app

# run server
CMD ["/usr/src/app/entrypoint.sh"]
