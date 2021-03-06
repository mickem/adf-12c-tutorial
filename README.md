ADF 12c Tutorial
================

This is a simple ADF 12c tutorial with goes through an entire application.
It is designed to be a bit less point-n-click and more "think for your self". Thus the format is minimalistic. There is a word document with screen shots and so on for "a" solution.
The tutorial is open ended so your solution might differ from mine but the idea is to have fun and learn a bit about ADF along the process.
The tutorial assumes basic ADF and google skills as there is not much in explinations.


The assignments are divided up in three basic areas:

1. [Creating the Model](tutorial/01_model.md)
2. [Creating the UI](tutorial/02_ui.md)
3. [Assignments](tutorial/03_assignments.md)

To get started you need Oracle JDeveloper 12c as well as Oracle XE 11g with HR schema.
You can probably get by with 11g as well if you prefer as the differences are not that great (on this level).

The solutions can be found in the solutions brach where there are tags for each section/step.
Many of the assignments require you to checkout various tags in git and fixing issues (as per instructions).

FIY: This is a work in progress and will be finnished in the next few weeks.
The first section is in progress and will be finnished soon.

Setting up the virtual machine
------------------------------

The enviornment can be found as a vagrant image here: https://github.com/mickem/adf-12c-enviornment


Setting up the code repo
------------------------

You can oen the git repo from jdeveloper by checking it out as a new application.


Starting an assignmnt
---------------------

Before you start an assignment it is a good idea to always start from a given tag.
The best way to do tis is to:

```
it checkout model.1.0-done -B mywork
```

If your current branch is not clean you can fix this by reseting it before:
```
git reset --hard HEAD
```  

The avalible tags can be found by checking releases here on github.
