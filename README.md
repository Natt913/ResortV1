# Resort Project
You are the owners of an up-and-coming resort. Business is booming, and you need a system that will automate your booking process. It will have a user-friendly interface for prospective guests, where they can enter dates, type of room, etc. for their stay as well as payment information. Your system shall produce summry report views for a manager and handle special cases such as cancellation or being sold out.

Upon further discussion with Dr. Koufakou, the project is shifted more onto a system management instead of booking . Guest reservations will come from an outside service (such as Kayak, Booking.com, etc.)

The programming language used is **Java**.
The project is subdivided in multiple versions. Each version will display its changes, under its own **Changelog**. There is also a section that displays possible future features that can be added to the program, under the section **Future Features**.

## Project Description
Our goal is to implement a software for hotel’s guests and staff.
If a guest wants to have extra towels or shampoos, they  can go to the housekeeping page and request it. They will be able to request room service, as well as placing maintenance requests if they encounter issues in their room. There would be concierge services, where guest can find the best activities to enjoy in the city, such as restaurants, local venues, etc.
Hotel management will be able to track guest activities in real time, and as soon as they are completed, mark them as such.
There will be multiple classes of users, which can be seen in the **UserTypes** file. (TO ADD)

## ResortV1
Screens from Group1 and ResortProject repositories combined and modiefied to be more cohesive. 

### Major Update V1
- Linked every screen to each other, now each screen is loaded onto one Anchorpane! 
- Improved performance. 
- Fixed minor and major bugs. 
- Fixed paths in files (now all relative!). 
- Fixed naming issues.

## Login Test
You can try to log in as each category of users. Simply use ~~these strings as a username~~ a userName and userPIN from the table below:
-~~guest~~<br>
-~~manager~~<br>
-~~housekeeping~~<br>
-~~maintenance~~<br>
-~~valet~~<br>
userID|userPIN|userName|isEmployee|userStatus|userCreated|guestRoomNumber|empType
------|-------|--------|----------|----------|-----------|---------------|-------
1003|1234|nathaliec|1|active|2018-11-10T15:39:15.371-05:00||1
1004|1234|tylerm|1|active|2018-11-10T16:43:11.425-05:00|0|1
1006|1111|asmith|0|active|2018-11-10T16:48:14.191-05:00|13|0
1007|9876|swallace|0|active|2018-11-10T16:52:05.069-05:00|10|0
1008|1248|phil|1|active|2018-11-10T19:07:16.089-05:00|0|2
1009|1684|wyattb|1|active|2018-11-10T19:09:45.875-05:00|0|1
1010|1917|alsus|1|active|2018-11-10T19:40:17.782-05:00|0|1
1011|1215|lucam|1|active|2018-11-10T19:40:17.950-05:00|0|3

##TODO:
- [ ] Randomize background picture for screens
- [*] Database Integration
- [*] Exception throwing/catching to handle user authentication
- [ ] Add fields for guest user data(credit card number, email address, etc.) either to Users table or set up a join
- [ ] Integrate model code with view/controller code
- [ ] Checking existing database records to prevent duplicate record insertion
- [ ] Plenty more...


## Built With

* [IntelliJ IDEA](https://www.jetbrains.com/idea/) - IDE of choice
* [SceneBuilder](https://gluonhq.com/products/scene-builder) - Great software to create GUI screens with ease

## Plugins Used
* [FindBugs](http://findbugs.sourceforge.net/)
* [CheckStyle](http://checkstyle.sourceforge.net/config_naming.html#PackageName) - Google Checks used

## Authors

* **Luca Missaglia** - *Backend Developer, GitHub Manager* - [Lollators](https://github.com/Lollators)
* **Nathalie Crespo** - *Frontend Developer* - [Natt913](https://github.com/Natt913)
* **Alsu Saifetdinova** - *Frontend Developer, Project Manager* - [Alsu102](https://github.com/Alsu102)
* **Wyatt Byroade** - *Backend Developer, Database Manager* - [wabyroade](https://github.com/wabyroade)
* **Tyler Martin** - *Documentation Manager* - [tamartin9013](https://github.com/tamartin9013)

## License

Coming soon!
