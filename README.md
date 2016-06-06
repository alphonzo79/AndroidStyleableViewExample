# AndroidStyleableViewExample
This project is a simple example of how to create a styleable view in Android to accompany a presentation on the subject. The app itself does very little -- virtually nothing. The important part is in the custom views, the `attr.xml` file and the main activity layout file. The repo also contains the slides for the presentation. The slides can also be found [here] (www.slidedeck.com/alphonzo79/AndroidStyleableViewExample)

## Setup and Dependencies
This project is built with AndroidStudio 2.1.1, Gradle plugin 2.1 and Gradle Wrapper 2.10. As long as you have a sufficient version of AS installed and use the Gradle wrapper everything should work just fine. If you keep a local install of Gradle and use it for command-line work then you will either need to have a sufficient version of Gradle installed or tweak this setup to match your needs.

| Name                 | Provider    | Summary |
|:--------------------:|:-----------:|:-------:|
| J-Unit               |             | Support for java unit testing |
| Android Appcompat v7 | Google      | Backwards compatibility library |
| ButterKnife | Jake Wharton      | View Injection library |

## Background and Information
Sometimes during development you find the need to wrap common or repeatedly-used UI elements into their own custom views so they can be easily reused and encapsulate their own logic. To make these views more flexible you might want to make them styleable so you can configure and customize the view in the layout file independent of your other Java code.

This simple sample demonstrates
* Creating a custom view, `ComplexEditText`, which encompasses an `EditText`, a label or error `TextView` and a highlight or status bar. 
* Declaring that view Styleable, along with its unique attributes in the `attrs.xml` file beyond those already provided by Android.
* Consuming those attributes in an `init` method inside `ComplexEditText`
* Including several instances of `ComplexEditText` inside the `activity_main.xml` layout and giving each instance different styling.
