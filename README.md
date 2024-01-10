<h1> Task Management Backend API</h1>
<h2> A REST API that manipulates entity of Type "Task" POJP</h2>
<h1>Technologies and programming langs used </h1>
<h2>Java 17, mysql 8</h2>
<h2>Spring boot, Spring data Jpa, Spring Validate, Spring Security</h2>
<h2>Maven Build tool</h2>
<h1>Programming Principles used </h1>
<h2> Object Oriented Design</h2>
<h2>Exception Handling</h2>
<h2>Authentication and Validation</h2>
<h1>API EndPoints</h1>
<h2>runs on port : 8080</h2>
<h2>/getTask method : get retrieves all Tasks</h2>
<h2>/getTask/{id} method : get Retrieves one task based on id</h2>
<h2>/addTask method : post addd task </h2>
<h2>/deleteTask/{id} method : delete deletes task of id {id}</h2>
<h2>/updateTask/{id} method : put update isDone field, request param isDone : boolean(true) (http://localhost:8080/updateTask/1?isDone=true)</h2>
<h2>/updateTask/{id}/taskDescription method : put updates taskDescription FIeld, req param : taskDescription </h2>
<h2>/updateTask/{id}/taskDate method : put updates taskDate Field, req param : completionDate (updateTask/1/taskDate?completionDate:yyyy-mm-dd)</h2>
<h2>kindly look up the controller class in controllers package under any confusion regarding api endpoints.</h2>
<h1>How to set up and run</h1>
<h2>1.Download jar file from release section of the project </h2>
<h2>2.Run the Jar file on terminal </h2>
<h2>3.Run mysql server and create and use "mock" db </h2>
<h2>4,Fire the URLs from postman API</h2>
<h2>Use username : "somesh" && password : "somesh@123" for authentication header (verify by looking up Application.properties file</h2>
<h2> Another way of running the project is to clone the project and run in IDE(I used IntelliJ) with mysql server running</h2>
<h2>Any suggestion and improvements are Welcome</h2>
<j2>JSON Payload</j2>
<j3>{"taskDescription" "String ",
      "taskDate":yy-mm-dd
                            }</j3>
                            
<h3> taskId is auto incremented and isCompleted boolean value will accept default false on adding a payload it will cange when you use "/updateTask/{id} put method </h3>
