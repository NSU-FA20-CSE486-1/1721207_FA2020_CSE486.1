![![](RackMultipart20210122-4-1pnb2yc_html_a18535a065f24131.png)
](images/image5.png)

**Project Proposal**


**Food Fiesta- Making homemade foods available everywhere**

_Semester: Fall2020_

**Submitted to:**

Shaikh Shawon Arefin Shimon

Lecturer

Dept. of ECE
 North South University

**Submitted by:**

Mohammad Rayed

ID: 1721207042

Section: 01

Course: CSE486

**Submission Date:**

22th January 2021

**Introduction**

Finally there&#39;s a way to avoid talking to rude restaurant hosts! You don&#39;t have to scream or plead to anyone to get your order fast! No more unhealthy office lunches!

Food Fiesta brings homemade foods at your place with a few taps on the screen. It brings you your favourite homemade foods at affordable prices and with plenty of options. You can order food as well as sell food to the community if you like!

Food Fiesta is now loaded with over hundreds of delicious items, filled with delicate items from each cuisine. Download the app now to order a meal.

 ![](images/image9.png) 
 ![](images/image1.png)

**Features**

1. **Single screen registration for Customers and Business owners:** The app provides an easy interface for registering users under a single screen. The app takes only necessary information and registers the users in less than a minute.

![](images/image7.png)
1. **Efficient scrollable menu:** The app displays the food items in a simple manner to provide the users an easy way to browse around items. For each item, the views are recycled so that they do not use much storage.
2. **Firebase Authentication:** The app is connected to Firebase which provides real time authentication for the users. It is backed up by Firebase error cases, which ensures autonomous validation for credentials.
3. **Smart Payment Options:** Options to pay in cash or through cards. The app contains a simple user interface to guide users through setting up cards and payment options. 
![](images/image8.png)

4. **Unique User Profiles:** The app creates a profile for each user and provides an easy way to edit.
![](images/image4.png)

**Data Management**

The data of the app is managed by Local Storage. However, the authentication as well as registration data are managed via Firebase. The full names, address as well as the phone numbers of users are saved in real time at Firebase. The food item details are stored in the local storage for now and in the future it will be integrated with Firebase.

**Design Pattern**

The app is not created following any particular design pattern but the app highly matches with the Observer design pattern of the MVC architecture.

In the application, all the child objects are updated if necessary whenever there is a state change in any particular object. For example, a Progress Bar at the registration and login page which becomes visible after the click of the button Login or Register. The system promptly records its state change and updates the other objects accordingly.

**Roadblocks**

The app contains several bugs and throughout the whole development process, many roadblocks were encountered. Some of them are discussed below,

- Providing permission to Android Studio for using the internet: The application needed an internet connection for authenticating to Firebase which was needed to add separately in the Android Manifest File.
![](images/image3.png)

- Using Firebase instances and Exception getters: The Firebase has its built in exception checker for ensuring successful authentication. It was a bit difficult to integrate the Exception types and then specify them for use in Android Studio. ![](images/image6.png)
- RecyclerView: Despite using an upgraded version of Android Studio, external dependencies were needed to add in the Gradle Module Script. Otherwise it showed errors. ![](images/image12.png)
![](images/image2.png)

- Jenkins Integration: The project couldn&#39;t be successfully integrated with Jenkins. The server was unable to track the repository.
![](images/image10.png)