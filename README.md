
# Air Line Management System ✈️

**Semester Project (Java and MySQL)**

A comprehensive Desktop Application designed for airline staff to manage daily operations efficiently. This system handles everything from flight scheduling to passenger booking and boarding.

## 📋 Features

*   **Staff Access Only:** Secure login system for authorized personnel.
*   **Customer Management:** Add new customers and view customer details.
*   **Flight Operations:** Check flight availability and details.
*   **Booking System:** Book flights for customers.
*   **Ticket Management:**
    *   Reschedule Flights.
    *   Cancel Tickets.
*   **Boarding:** Generate boarding passes.
*   **Reporting:** View Flight and Customer information.

## 🛠️ Tech Stack

*   **Language:** Java (Swing/AWT)
*   **Database:** MySQL
*   **IDE:** NetBeans (Recommended) or VS Code

## ⚙️ Prerequisites

Before you begin, ensure you have the following installed on your machine:

1.  **Java JDK** (Development Kit)
2.  **NetBeans IDE** (Preferred) or VS Code
3.  **MySQL Workbench** (For database management)

## 🚀 How to Run

Follow these steps to set up and run the project locally.

### Step 1: Download the Project
Download this repository or copy the project folder to your local drive.

### Step 2: Configure the Database (MySQL Workbench)
1.  Open **MySQL Workbench**.
2.  Click on **File** -> **New Query Tab**. A new blank tab will open.
3.  In the new tab, look for the **Folder Icon** (Open Script) on the top left toolbar.
4.  Browse to the project folder and select the `AirLine_Management_System.sql` file.
5.  Once the SQL script is loaded, press **Ctrl + A** to select all text.
6.  Click the **Lightning Bolt icon** ⚡ on the top toolbar to execute the script.
    *   *This will create the necessary database and tables.*

### Step 3: Open Project in NetBeans
1.  Open **NetBeans IDE**.
2.  Go to **File** -> **Open Project**.
3.  Browse to the location where you saved the folder and select it.

### Step 4: Add External Libraries (Important)
*If the libraries are not linked correctly, the project will not run.*

1.  In the NetBeans "Projects" view (left sidebar), expand your project folder.
2.  Locate the **Libraries** folder.
3.  Right-click on **"Libraries"** and select **Add JAR/Folder**.
4.  Browse to your project folder and add the following three files (repeat the process for each if necessary):
    *   `jcalendar-tz-1.3.3-4.jar` (For Date Pickers)
    *   `mysql-connector-java-8.0.28.jar` (For Database Connection)
    *   `rs2xml.jar` (For displaying data in Tables)

### Step 5: Run the Application
1.  In the project explorer, look for the **Main** class or **Home** class.
2.  Right-click the file and select **Run File** (or press Shift+F6).
3.  The login screen should appear.
