import java.io.*;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NotesApp {
    private static final String NOTES_FILE = "notes.txt";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("╔════════════════════════════════╗");
        System.out.println("║   JAVA NOTES MANAGER APP       ║");
        System.out.println("╚════════════════════════════════╝");

        while (running) {
            displayMenu();
            System.out.print("\nEnter your choice (1-5): ");
            String choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1":
                        addNote(scanner);
                        break;
                    case "2":
                        viewNotes();
                        break;
                    case "3":
                        searchNote(scanner);
                        break;
                    case "4":
                        deleteNote(scanner);
                        break;
                    case "5":
                        running = false;
                        System.out.println("Thank you for using Notes Manager. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter 1-5.");
                }
            } catch (IOException e) {
                handleException("Operation failed", e);
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n┌─ MENU ─────────────────────────┐");
        System.out.println("│ 1. Add a new note              │");
        System.out.println("│ 2. View all notes              │");
        System.out.println("│ 3. Search for a note           │");
        System.out.println("│ 4. Delete a note               │");
        System.out.println("│ 5. Exit                        │");
        System.out.println("└────────────────────────────────┘");
    }

    private static void addNote(Scanner scanner) throws IOException {
        System.out.print("\nEnter note title: ");
        String title = scanner.nextLine().trim();

        if (title.isEmpty()) {
            System.out.println("Title cannot be empty.");
            return;
        }

        System.out.print("Enter note content: ");
        String content = scanner.nextLine().trim();

        if (content.isEmpty()) {
            System.out.println("Content cannot be empty.");
            return;
        }

        String timestamp = LocalDateTime.now().format(formatter);
        String noteEntry = String.format("[%s]\nTitle: %s\nContent: %s\n---\n", timestamp, title, content);

        try (FileWriter writer = new FileWriter(NOTES_FILE, true)) {
            writer.write(noteEntry);
            System.out.println("Note added successfully!");
        } catch (IOException e) {
            handleException("Failed to add note", e);
            throw e;
        }
    }

    private static void viewNotes() throws IOException {
        File file = new File(NOTES_FILE);

        if (!file.exists()) {
            System.out.println("No notes found. Create one to get started!");
            return;
        }

        System.out.println("\n╔════════════════════════════════╗");
        System.out.println("║        ALL NOTES               ║");
        System.out.println("╚════════════════════════════════╝\n");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int noteCount = 0;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                if (line.contains("---")) {
                    noteCount++;
                }
            }
            System.out.println("\nTotal notes: " + noteCount);
        } catch (IOException e) {
            handleException("Failed to read notes", e);
            throw e;
        }
    }

    private static void searchNote(Scanner scanner) throws IOException {
        System.out.print("\nEnter search keyword: ");
        String keyword = scanner.nextLine().trim().toLowerCase();

        if (keyword.isEmpty()) {
            System.out.println("Keyword cannot be empty.");
            return;
        }

        File file = new File(NOTES_FILE);

        if (!file.exists()) {
            System.out.println("No notes found.");
            return;
        }

        System.out.println("\nSearch results for: '" + keyword + "'\n");
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuilder currentNote = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                currentNote.append(line).append("\n");
                if (line.contains("---")) {
                    if (currentNote.toString().toLowerCase().contains(keyword)) {
                        System.out.println(currentNote.toString());
                        found = true;
                    }
                    currentNote = new StringBuilder();
                }
            }
            if (!found) {
                System.out.println("No notes matching '" + keyword + "' found.");
            }
        } catch (IOException e) {
            handleException("Failed to search notes", e);
            throw e;
        }
    }

    private static void deleteNote(Scanner scanner) throws IOException {
        System.out.print("\nEnter note title to delete: ");
        String titleToDelete = scanner.nextLine().trim();

        if (titleToDelete.isEmpty()) {
            System.out.println("Title cannot be empty.");
            return;
        }

        File file = new File(NOTES_FILE);

        if (!file.exists()) {
            System.out.println("No notes found.");
            return;
        }

        StringBuilder allNotes = new StringBuilder();
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuilder currentNote = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                currentNote.append(line).append("\n");
                if (line.contains("---")) {
                    if (!currentNote.toString().contains("Title: " + titleToDelete)) {
                        allNotes.append(currentNote.toString());
                    } else {
                        found = true;
                    }
                    currentNote = new StringBuilder();
                }
            }
        } catch (IOException e) {
            handleException("Failed to read notes", e);
            throw e;
        }

        if (found) {
            try (FileWriter writer = new FileWriter(NOTES_FILE)) {
                writer.write(allNotes.toString());
                System.out.println("Note deleted successfully!");
            } catch (IOException e) {
                handleException("Failed to delete note", e);
                throw e;
            }
        } else {
            System.out.println("Note with title '" + titleToDelete + "' not found.");
        }
    }

    private static void handleException(String message, IOException e) {
        System.out.println(message);
        System.out.println("Error: " + e.getMessage());
        System.out.println("Stack Trace:");
        e.printStackTrace();
    }
}
