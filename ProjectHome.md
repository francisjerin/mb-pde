Detect software design patterns in Java software using static and dynamic code analysis.

| ![http://www.cse.yorku.ca/~mbirkner/website/images/wiki/new.jpg](http://www.cse.yorku.ca/~mbirkner/website/images/wiki/new.jpg) | I just finished packing up the software with examples and a set of scripts that are needed to run the examples. Download this package http://mb-pde.googlecode.com/files/pde.examples.tar.gz |
|:--------------------------------------------------------------------------------------------------------------------------------|:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Run static:                                                                                                                     | java -cp ./conf/log4j.properties:./lib/log4j-1.2.15.jar:pde.jar ca.yorku.cse.designpatterns.PatternDetectionEngine -static                                                                   |
| Run dynamic:                                                                                                                    | java -jar pde-1.0.jar -dynamic                                                                                                                                                               |

  * Introduction - http://code.google.com/p/mb-pde/wiki/Introduction
  * Approach - http://code.google.com/p/mb-pde/wiki/Topic
  * Results - http://code.google.com/p/mb-pde/wiki/Results

| ![http://www.cse.yorku.ca/~mbirkner/website/images/wiki/alert.gif](http://www.cse.yorku.ca/~mbirkner/website/images/wiki/alert.gif) | This project is new and still in development. Right now I am working on documenting the software and the methods to detect software design patterns that were introduced in this work. Please let me know if you have questions. |
|:------------------------------------------------------------------------------------------------------------------------------------|:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|


## Setup Info ##
```
In case you have problems running the examples, please check your environment 
configuration. The following page describes the setup that we are using. 
http://www.cse.yorku.ca/course_archive/2006-07/F/6431/tools.html
```

## Info ##

Design patterns abstract reusable object-oriented software design. Each pattern solves design problems that occur in every day software development. The detection of design patterns during the process of software reverse engineering can provide a better understanding of the software system. The latest tools rely on the abstract syntax tree representation of the source code for fact extraction.
Our approach uses static and dynamic code analysis to detect design pattern in Java applications. We use the roles, responsibilities and collaboration information of each design pattern to define static and dynamic definitions. The static definitions are used to find candidate instances during the static analysis. After the static analysis we validate the found candidate instances using the dynamic behavior of design patterns. For the dynamic analysis we instrument the Java bytecode of the application we are analyzing with additional code fragments and extract method traces from the running application. These method traces represent the dynamic facts of an application. We present several restrictions that are used to define design patterns dynamically. After the dynamic validation we rank the results according on how good they match the dynamic definitions.
This thesis introduces a new approach in detection of object-oriented design patterns in Java applications. We test our approach using the 23 original GoF design patterns and analyze the results. Compared to other tools, our software achieves better results in detecting design patterns. The methods we choose for our approach work great in detecting patterns given the static and dynamic facts as input files.