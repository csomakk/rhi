Welcome to the interview.

We'd like you to work on this task, where we can learn about how you're thinking and collaborate with others. You can ask any questions from your interviewer that you see relevant and necessary to complete this task. You may use the Internet to look up things. We may ask you to explain your thought process. You're not expected to complete all tasks.

Your task:
Two dev teams have developed a service each, that needs communicating to eachother. We'd like you to dockerize the build and running of your selected service. One service is written in Node.js and the other in Java. Once this has been completed, we'll need to move them to a kubernetes cluster, and we'll need to plan for that.


* step 1) 
chose either the Java (a) or the TypeScript+Node.js (b) project to build and run in Docker / k8s.

    * a) Java - 
Build java server `java-http-server-undertow` with Docker. its Java 17, with Maven. Runs on port `8080`.
hit `http://localhost:8080/data` to verify

    * b) Node.js - 
Build the node js app `express` with Docker. its node 16+. Runs on port `3000`
hit `http://localhost:3000/data` to verify

* step 2) 
you'll recieve the solution of the alternative half of step 1)

connect Express to the Java Server - use `JAVA_APP` variable to identify java server address..
`http://localhost:3000/fromjava` to verify

* step 3) 
explain how would you move this into a cloud infrastructure of your choice, with potential redundancy.

* step 4) 
move the 2 services to a minikube cluster (any other setup like rancher, k3s, etc can be used too) if you have a suitable setup ready. Other tools like Helm can be used.
