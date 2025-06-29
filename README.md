# Cloud-VideoClub

This project is an extension of this [project](https://github.com/ManosMorf97/Video-Club-WebApp). \
Instead of just developing the app, there is also the deployment phase using Docker and Kubernetes. \
The app was available on Microsoft Azure for a while.

## Demo

YouTube link: https://www.youtube.com/watch?v=Qn7ZcQvxj3A


## Explanation

This is a task given from Athens University of Economics and Business by proffesor Georgios Stergiopoulos that I had implemented much better than before. &nbsp;
The application allows users to create account and login. &nbsp;
On the main page(Welcome page) the users can search for a movie and see some details about the movies that will appear. &nbsp;
The above movies are fetched from the omdb api via a key. &nbsp;
When the user clicks on like button the movies are stored on a local DB. &nbsp;
When the users clicks on MyBookmarks page they can see more details about the movies they have stored (directors, genres, plot, e.t.c). &nbsp;
More info can be seen [here](https://github.com/ManosMorf97/VideoClub_WebApp/blob/main/Web%20Programming%20-%20Assignment%202%20-%202020.pdf).

## Tools

The technologies were used are: &nbsp;
* HTML
* CSS
* JavaScript
* Java
* Spring Framework
* MySQL
* Docker
* Kubernetes

## microservices
1) The frontend service which runs on HTML, CSS, and JavaScript with node
2) The backend service which run on Java with Spring Boot
3) The database service

## How the app works
### Backend
1) The user can identified or created depends if they have account.
2) When user opens the Welcome page,their bookmarks are loaded from the database ordered by movie_id.
3) When the user clicks like on a movie,only the movie_id and the email are stored on bookmarks.
4) When the user clicks dislike on a movie they liked ,the row with the movie_id and the email is deleted from database.
### Frontend
1) When the user creates account the password becomes hashed.hashed password and username are sent to backend.
2) When the user makes login the password becomes hashed.hashed password and username are sent to backend.&nbsp;
<br> &nbsp; &nbsp; The username is stored on localstorage in order the user can access the WebApp.
3) When the user opens a page from app the data from his bookmarks are fetched from backend and stored on localstorage.
4) When the user search for a movie the frontend fetches movie data(title,year,id) from omdbAPI.
5) When the user clicks like/dislike or like the movie_id stored/removed from local DB.
6) When the user visits his bookmarks, each movie_id from the localstorage is sent on omdbAPI to get more details about this movie (description, genres, plot, etc).
   


