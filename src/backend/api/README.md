This file outlines best practices and design paradigms for how the API will be structured, how data will be queried, and how datagrams will be structured. 
As always, feel free to adjust this how you see fit, add ideas, or take away features. I encourage your input. 
========================
Storing Information About People
1) What kinds of data should we store about people? How do we indentify an individual in code? How should we query these people? What kinds of searches will be performing on people?
  -An individual will be identified with an ID number. An employee's ID Number should start with a 1 while a volunteer's will be stored with a 2.
  -We should associate the following data with a Person:
   A) An Identification number.
   B) A First, middle, and last name, as provided by the person.
   C) Events this person is associated with.
   D) Qualifications or restrictions     
   E) TBD
Storing Information About Events
  Events will have a lot of information tied to them.
  -Events will have an ID number that starts with 3.
  -We should associate the following data with an Event.
    A) An Identification Number
    B) A Start Time
    B) An End Time
    C) Volunteers currently signed up for this event.
    D) How many volunteers this event needs. This will be set by the creator of the event which will always be an employee of the career center.
    E) How many volunteers this event is lacking. "There are 25/30 volunteer slots filled". This should dynamically update.
   
  
