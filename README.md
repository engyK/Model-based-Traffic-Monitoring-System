# Mobile-agent based Traffic Monitoring System
#### _This code assumes distributed monitoring system use mobile agents to get, process and send data between the 3 Tiers in Client-Server (cascade) model_

Developed using java programming language , with java socket | serversocket & Multithreading .


### The file includes

- Step-by-step procedure
- Classes' definitions
- Detailed pdf Report (including diagrams & ALP) 

---
#### 1.Step-by-step procedure

- Download the repo( to get source code and all classes)
- Open a new project using java IDE [ ex: Eclipse IDE for java Developers ]
  1. Run "server" class
  2. Run "client" class (multithreaded-clients) with same number of clients
[To change number of client , change parameter value in line 13 in Server class]

```sh
13 private static ExecutorService pool = Executors.newFixedThreadPool(1);
```
-  3. Type in console whatever you need from the server to provide each client in the format "get me _______"
[ex: get me best route to location X]
    
   4. To end connection between a client and server type "close connection"
___

#### 2.Classes' definitions

| Class | Definition(& it's use) |
| ------ | ------ |
| Server class | Tier1 :Main server for the whole city get data from area computers, process them and send recommendations for requests back - [Implemented using java ServerSocket] |
| Client class | Tier2: clients representing car drivers in real time- [Implemented using java Socket] |
| ClientHandler class | Tier3: representing Area computers to handle requests from several car drivers (clients)-[Implemented using Multithreading , thread for each client] |
| ServerConnection class | intermediate node to initiate additional sockets(one for each client) to leave the Main server port available for new incoming clients --- Allow clients to get information(service) from server without being blocked by keyboard input. [Implemented using Multithreading |
---

#### 3. Link to Detailed report --- filetype <pdf>
https://drive.google.com/file/d/1_PyN6_wgC05ubCqAS-WMwfLtqc_Sa9pG/view?usp=sharing
  
