1)	Setup docker desktop and ensure to login into docker hub
2)	Package the application - mvn clean install
3)	create docker image
docker build -t melantiast/bookslibrary:0.0.1 .
4)	docker-compose up

4)In some cases the app will exit as mysql did not start, in such cases start the app manually in docker desktop

# booklibrary
Library to manage books
