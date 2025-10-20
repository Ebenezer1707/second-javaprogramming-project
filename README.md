# 🌟 Student Grade Calculator

A simple desktop application built with **Java Swing** that allows users to calculate a student's total marks, average percentage, and final letter grade based on the marks obtained in various subjects.

## Screenshot

<img width="1918" height="1018" alt="image" src="https://github.com/user-attachments/assets/eeee4d2a-12e0-43ca-80fc-1691920484fd" />




## 🛠️ Features

* **Dynamic Input Fields:** Enter the number of subjects, and the application will dynamically generate the required text fields for marks.
* **Comprehensive Calculation:** Instantly computes:
    * **Total Marks:** The sum of all marks entered.
    * **Average Percentage:** The overall percentage calculated from the total marks.
    * **Letter Grade:** A final grade (A+, A, B, C, D, F) based on the average percentage.
* **Helpful Feedback:** Provides a short, encouraging feedback message based on the calculated grade.
* **Input Validation:**
    * Ensures the number of subjects is a positive number.
    * Ensures all marks are valid numbers between 0 and 100.
* **Reset Functionality:** A "Reset" button to clear all fields and start a new calculation.

## 📊 Grading System

The grade is calculated based on the following scale:

* **90% and above:** A+
* **80% - 89.99%:** A
* **70% - 79.99%:** B
* **60% - 69.99%:** C
* **50% - 59.99%:** D
* **Below 50%:** F

## 🚀 How to Use

1.  Run the application.
2.  Enter the total number of subjects you want to calculate (e.g., `5`).
3.  Click the **"Generate Fields"** button.
4.  Input the marks (out of 100) for each subject in the text fields that appear.
5.  Click the **"Calculate"** button.
6.  View your **Total Marks**, **Average Percentage**, and **Grade** in the "Result" area.
7.  Click the **"Reset"** button to clear all inputs and perform a new calculation.

## ⚙️ How to Run Locally

### Prerequisites

* **Java Development Kit (JDK)** (e.g., JDK 11 or newer) installed and configured on your system.

### Steps

1.  **Clone the repository** (or download the `.java` file):
    ```sh
    git clone [https://github.com/Ebenezer1707/second-javaprogramming-project.git]
    ```

2.  **Compile the Java file:**
    Open a terminal or command prompt in the project directory and run:
    ```sh
    javac StudentGradeCalculatorGUI.java
    ```

3.  **Run the application:**
    ```sh
    java StudentGradeCalculatorGUI
    ```

The Student Grade Calculator window should now appear.
