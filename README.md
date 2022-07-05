# AbsoluteBeginnersFX
Companion project to the "Absolute Beginners Guide to JavaFX" series

# The Absolute Beginners Guide to JavaFX

This is a series of articles intended to teach how to program with JavaFX the "right" way, and without FXML.  It starts from the very beginning, showing how to write a simple "Hello World" screen, then adding user interaction and styling.  After that the series walks, step by step, through building an actual CRUD application that maintains a simulated Customer database.  

Along the way, you'll learn about layout classes, builders, styling, using background threads, handling exceptions, implementing business rules and just about everything you need to know to build a real, robust application.

If you are interested, the course can be found at https:www.progmaticcoding.ca/beginners/intro

# Using this Project 

This is a Gradle based project.  It works very well with Intellij Idea.  Simply download the code and put it in a directory.  Then open the build.gradle file with your Gradle compatible IDE.  It should build automically.

The project is divided up into packages with a single package holding the complete source code for the application at the end of each part, or lesson, in the series.  So you'll find packages like ca.pragmaticcoding.beginners.part1 and ...part2 and so on.  

The best way to run the code is via the Gradle "run" task, in the "application" submenu.  

In each package, the class with the main() method is called "Main".  To run different versions of the application from different packages, you'll need to modify a single line in the build.gradle file:

``` java 
application {
    mainModule = 'ca.pragmaticcoding.beginners'
    mainClass = 'ca.pragmaticcoding.beginners.part1.Main'
}
``` 

Change the package of the mainClass definition from "part1" to whichever version you want to run.
