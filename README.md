# Jeff App Home Assignment Implementation

This project contains two gradle sub-projects:
chat-engine and console-application

## Chat Engine

A pluggable Java library for defining and running chat interactions in virtually
any type of JVM application (Console, HTTP server, WebSocket server, Android App,
Swing Application etc.)

In order to use the engine, the application needs to respond to the ChatAction
instructions emitted by it. This repository already contains a client implementation
for a console application.

Main features:
* Zero dependencies, pure Java 11
* 100% code coverage
* Chat builder that allows defining chat inputs and outputs in exactly the same
manner they are presented to the user
* Multiple input types
* Input validation
* Collection of provided values into POJOs
* No hard-coded property names in strings - only refactor-able getter and setter references

## Console Application

A reference implementation of a client of the Chat Engine.

Run [ConsoleApplication](console-application/src/main/java/jeff/app/homework/console/ConsoleApplication.java)
to see it in action. View its source to see an example of how to build your own chat.

### Note about testing

I'm a strong proponent of the quote _"The more your tests resemble the way your software
is used, the more confidence they can give you. © Kent C. Dodds"_, hence you won't find
a separate unit tests for each of the classes present in the project. Instead, I'm using
unit tests that run at integration test abstraction level.

As I understand that it could be a contraversial subject in some companies, I'm totally
open for a discussion here.
