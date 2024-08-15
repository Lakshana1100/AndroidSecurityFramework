## Getting started

A security framework to help secure your Android application development.

Install/upgrade the latest Java available on your system - Preferably jdk version 21 +

To add the JAR file to your application in development

1. Place Your JAR File: First, ensure that your SecurityFramework.jar is accessible to your new project. You can place it within your project's directory structure in a folder like lib or libs. For example, create a lib folder in your project root and place the JAR there.

2. Configure Build Path in IDE: Example : Visual Studio
Open your project in Visual Studio.
Select Properties from the menu options.
Go to Java Build Path on the left/availble panel.
Click on the Libraries tab.
Click Add JARs or Add External JARs (depending on where you placed your JAR file).
Navigate to where you saved your SecurityFramework.jar, select it, and click OK to add it to your project.
Click Apply and Close to save the changes.

3. Use the Library in Your Application :

Import Classes - In any Java file where you want to use functionalities from your library, import the necessary classes. 
Example:

import LaksSecurity.EncryptionModule;
import LaksSecurity.AuthorizationModule;

Call Library Methods - Now you can instantiate objects or call static methods provided by your library. 
Example:

// Encryption code exists here
SecretKey key = EncryptionModule.generateKey();
byte[] encryptedData = EncryptionModule.encryptData("Hello, World!", key);

Commands to execute this project : 
To compile - javac -d bin src/*.java
To run - java App

