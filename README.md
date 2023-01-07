# Documentation
<p>This is the documentation for this project💖</p>

### How to clone/download

#### Via Web
- Click the **"green code button"** above. Then **"Download Zip"**
- Import to Netbeans

#### Via Netbeans
- Click the **"green code button"** above. Then copy the link.
- In Netbeans, Click **Teams > Git > Clone Repository**
- Paste the link and press enter

### Explanation
Explanation of the role of each directory inside the project

#### Controllers
This is responsible for connecting the database and views directory. You can also place some custom code here that parses or modify data from the database before sending it to the views

#### Database
Contains the data of the system. Data is stored in an ArrayList of User class. It's also responsible for error handling and contain methods that allows the user to **create, find, remove, etc.**

#### Interfaces
This is the blueprint of each class. It defines what methods a class should have. For example, classes that inherits the **IDefaultView** interface are considered as a **view class** and should contain the **render** method

#### Layouts
Contains reusable UI component. Can be used on any view class

#### Main
The root package of the system. Any code that will placed or called here will be executed at the start of the program

#### Models
This contain classes that defines the schema or blueprint of each data stored in the database. The parent class of all the classes is **User**

#### Routes
The routing system of the application. This is responsible for navigating between each view. It's recommended to call this in the **view** or **controller**

#### Views
This contain the pages that will be rendered on each route.

### Roadmap

**admin**
- [x] add doctor (completed)
- [x] list doctors (completed)
- [x] add receptionist (completed)
- [x] list receptionist (completed)
- [x] remove doctor (completed)
- [x] remove receptionist (completed)
- [x] add admin (completed)
- [x] list admin (completed)
- [x] remove admin (completed)

**doctor**
- [ ] release patient
- [ ] list patients 

**patient**
- [ ] view information / status

**receptionist**
- [ ] assign patient to doctor
- [ ] list patients
- [ ] add patient
- [ ] remove patient
