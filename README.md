# trackwebserver

Trackwebserver application logs the user record whoever request for the viewing image in the text file. Image resource and file logs are stored and acessed from the project directory.

/ping - returns response code 200 and string OK when file /tmp/ok is present, if file is not present returns 503 service unavailable


/img - returns a 1x1 gif image, and log the request.





The below screenshot is the example for ping endpoint which checks whether the file "ok.txt" is available or not.


<img width="846" alt="image" src="https://user-images.githubusercontent.com/42512377/182453133-0fea0e97-bcc1-4d52-b2a2-bd14dd3ba919.png">


Here the logs are saved as a text file in the project folder under static/files/tmp/ok.txt. Log file gets generated once you hit the /img endpoint
The path variable sends the username(eg udhay)



<img width="1193" alt="image" src="https://user-images.githubusercontent.com/42512377/182453607-5d833aa6-4289-4180-b96b-df071833a984.png">



The below shows log file ok.txt under static/files/tmp in the project folder. This file saves the username and timestamp into it


<img width="689" alt="image" src="https://user-images.githubusercontent.com/42512377/182453699-236e368f-93a3-4ddc-ae8e-264b612c4d9e.png">



Ping endpoint after log file gets generated responds ok



<img width="674" alt="image" src="https://user-images.githubusercontent.com/42512377/182454111-dd8a08d1-c0d9-4764-90eb-b459fb1482e4.png">

Note: This can be extended by saving the logs in persistent storage like SQL or NOSQL database based on the requirement so that we can keep track of who is accessing the resources. Also the resources can be stored in the object store or file store which can be fetched easily.

for large and concurrent users, we need to scale the system. So we need to spin the application in a multinode clusters with loadbalancers to redirect concurrent requests to different nodes evenly. Depending upon the count of the requests that users make concurrently, we can also use queue system to save the requests and serve them. One more recommendation is like we can go with Nosql storage for logs files which supports horizontal scaling and provides high availablity. We can also host the NOSQL database for the logs  and image source file system(object storage) in a multinode cluster which can serve many requests concurrently.
