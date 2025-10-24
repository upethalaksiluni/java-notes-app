# 🗒️ Java File I/O - Notes Manager App

## 🧩 Overview
A **text-based notes management application** built in **Java** that demonstrates **file I/O operations**, **exception handling**, and **persistent data storage**.  
This project is part of a **Java Developer Internship** task focusing on **FileReader** and **FileWriter** usage.

---

## 🎯 Project Objectives
- Learn to persist data using file I/O operations  
- Implement `FileReader` and `FileWriter` for reading and writing operations  
- Handle exceptions properly using **try-with-resources**  
- Understand file handling best practices in Java  

---

## ✨ Features
- **Add Notes** – Create new notes with title, content, and timestamp  
- **View Notes** – Display all stored notes with formatted output  
- **Search Notes** – Find notes by keyword (case-insensitive)  
- **Delete Notes** – Remove notes by title  
- **Data Persistence** – All notes are saved to `notes.txt` file  
- **Exception Handling** – Comprehensive error handling with stack traces  

---

## 📁 File Structure
java-notes-app/
├── NotesApp.java          # Main application file
├── NotesApp.class
├── notes.txt                  # Data file (auto-created)
├── README.md                  # Project documentation

⚙️ System Requirements
Java 8 or higher

VS Code or any Java IDE

Terminal / Command Prompt

Git (for version control)

▶️ How to Run
🧱 Compile
javac NotesApp.java
🚀 Run
bash
Copy code
java -cp src NotesApp
💻 Alternative: Using VS Code
Open the project in VS Code

Install Extension Pack for Java

Click the Run button above the main method

Follow the on-screen menu prompts

🧠 Usage Example
sql
Copy code
╔════════════════════════════════╗
║   JAVA NOTES MANAGER APP       ║
╚════════════════════════════════╝

┌─ MENU ─────────────────────────┐
│ 1. Add a new note              │
│ 2. View all notes              │
│ 3. Search for a note           │
│ 4. Delete a note               │
│ 5. Exit                        │
└────────────────────────────────┘

Enter your choice (1-5): 1
Enter note title: upetha laksiluni
Enter note content: I'm a software engineer
Note added successfully!
🔑 Key Concepts Implemented
📂 File I/O Operations
FileWriter – Writing notes to file (append mode)

FileReader – Reading characters from file

BufferedReader – Efficient line-by-line reading

Try-with-resources – Automatically closes resources

⚠️ Exception Handling
IOException – Handled for all file operations

Stack traces – Printed for debugging

Custom error messages – Clear and user-friendly feedback

💾 Data Persistence
Notes stored in notes.txt with timestamp

Each note includes: timestamp, title, and content

Append mode for adding without overwriting

Overwrite mode for deleting notes

💬 Interview Questions & Answers
1️⃣ Difference between FileReader and BufferedReader?
FileReader reads data character by character from the file (unbuffered and slower).
BufferedReader wraps FileReader and reads in chunks with a buffer, allowing methods like readLine() for faster, line-based reading.

2️⃣ What is try-with-resources?
Introduced in Java 7, it automatically closes any resource implementing AutoCloseable.
Example:
try (FileReader fr = new FileReader("file.txt")) { ... }
It ensures resources are closed even if exceptions occur.

3️⃣ How to handle IOException?
Use try-catch blocks:
try { ... } catch (IOException e) { e.printStackTrace(); }
You can also use try-with-resources or propagate using throws. Always log exception details.

4️⃣ What are checked and unchecked exceptions?
Checked exceptions: Verified at compile-time (e.g., IOException, SQLException)

Unchecked exceptions: Not checked at compile-time (e.g., NullPointerException)

Checked = recoverable errors; Unchecked = programming mistakes.

5️⃣ How does file writing work in Java?
Create FileWriter

Use write()

Call flush()

Close writer

Append mode adds new data; overwrite mode replaces content.

6️⃣ Difference between append and overwrite mode?
Mode	Description
Append (true)	Adds data to end of file
Overwrite (false)	Replaces entire file content

7️⃣ What is exception propagation?
Passing an exception to the calling method using throws.
Example:
void readFile() throws IOException { ... }
8️⃣ How to log exceptions?
e.printStackTrace()

Logging frameworks (Log4j, SLF4J)

Custom logging methods
Always include timestamp, message, and context.

9️⃣ What is a stack trace?
A report showing the chain of method calls that led to an exception.
Printed using e.printStackTrace() – helpful for debugging.

🔟 When to use finally block?
Used to execute code regardless of exception.
Commonly used for closing resources or cleanup tasks.
(Modern Java prefers try-with-resources.)

🛠️ Technologies Used
Component	Details
Language	Java (JDK 8+)
IDE	VS Code
Version Control	Git & GitHub
File Format	Plain text (.txt)

📘 What I Learned
Implemented FileReader and FileWriter

Used try-catch and try-with-resources

Followed file handling best practices

Applied BufferedReader for efficient reading

Practiced data persistence concepts

Debugged using stack traces

🚀 Future Enhancements
Add note categories/tags

Implement regex-based search

Build GUI with Swing or JavaFX

Add database integration

Include encryption for security

Export notes to PDF

📜 License
Open source – for educational purposes.

👨‍💻 Author
Java Developer Intern

