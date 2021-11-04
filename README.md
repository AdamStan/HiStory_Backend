
Firstly, build image of the service

`docker build --tag=quiz-server:latest .`

Secondly, start a container:

`docker-compose up`

Or run locally - start main from HiStoryQuestionsApplication
But you need set up environment variable: QUESTIONS_SERVER_ADDRESS with http address to questions' server

Questions_Server is from project:
https://github.com/AdamStan/HiStory_Backend_PY
