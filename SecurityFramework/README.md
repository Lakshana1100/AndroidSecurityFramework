## Getting started

A security framework to help secure your Android application development.

Install/upgrade the latest Java available on your system - Preferably jdk version 21 +

To add the JAR file to your application in development

1. Place Your JAR File: First, ensure that your SecurityFramework.jar is accessible to your new project. You can place it within your project's directory structure in a folder like lib or libs. <br>
2. Example - create a lib folder in your project root and place the JAR there.

3. Configure Build Path in IDE: Example : Visual Studio <br>
Open your project in Visual Studio. <br>
Select Properties from the menu options. <br>
Go to Java Build Path on the left/availble panel. <br>
Click on the Libraries tab. <br>
Click Add JARs or Add External JARs (depending on where you placed your JAR file). <br>
Navigate to where you saved your SecurityFramework.jar, select it, and click OK to add it to your project. <br>
Click Apply and Close to save the changes.

4. Use the Library in Your Application :

Import Classes - In any Java file where you want to use functionalities from your library, import the necessary classes. <br>
Example: 

import LaksSecurity.EncryptionModule; <br>
import LaksSecurity.AuthorizationModule;

Call Library Methods - Now you can instantiate objects or call static methods provided by your library. <br>
Example: 

// Encryption code exists here <br>
SecretKey key = EncryptionModule.generateKey(); <br>
byte[] encryptedData = EncryptionModule.encryptData("Hello, World!", key); <br>

Commands to execute this project : <br>
To compile - javac -d bin src/*.java <br>
To run - java App

