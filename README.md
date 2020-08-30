# Inspector System
## Description
This is a Java application that connects to an oracle database on the backend. I created this application to improve administration and management efficiency for my company. 
Every user can be one of two roles:
- Inspector: when creating a new user as an inspector, the user has to specify their administrator. Inspectors will receive tasks from the administrators who manage them. 
After receiving new tasks, inspectors can log into their user account to view the tasks and the detailed descriptions. After completing a certain task, the inspector can report the 
task result, which consists of total time and cost of that specific task. 
- Administrator: an administrator manages a group of inspectors. After logging into their accounts, administrators can assign tasks to the inspectors under their management.
If the inspector reports a task, that task will be marked as complete under the "Finished Tasks" table, and administrator would be able to view the total time and cost invested into
that task.

## Application Preview
#### *Role selection page:*  
![snap1](https://github.com/linknacro/Inspector-System/blob/master/previews/snap1.png)
#### *Login page:*    
![snap2](https://github.com/linknacro/Inspector-System/blob/master/previews/snap2.png)
#### *Assigning a new task to an inspector:*  
![snap3](https://github.com/linknacro/Inspector-System/blob/master/previews/snap3.png)
#### *Assigning a new task to an inspector:*  
![snap4](https://github.com/linknacro/Inspector-System/blob/master/previews/snap4.png)
#### *Viewing the full description of a task:*  
![snap5](https://github.com/linknacro/Inspector-System/blob/master/previews/snap5.png)
#### *Reporting a completed task as an inspector:*  
![snap6](https://github.com/linknacro/Inspector-System/blob/master/previews/snap6.png)
#### *Viewing the task tables as an inspector:*  
![snap7](https://github.com/linknacro/Inspector-System/blob/master/previews/snap7.png)
#### *Viewing the task tables as an administrator:* 
![snap8](https://github.com/linknacro/Inspector-System/blob/master/previews/snap8.png)

## Current Stage of Development
The application is not ready for the release yet. Currently, the application connects to my database using my IPv4 address, which means that another laptop can only connect to my databse if we connect to same local network. Eventually, this application will be hosted on my company's server, and the users will be able to access the database through the 
internet instead local area network.
