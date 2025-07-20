import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            showMenu();
            int option = readOption();

            switch (option) {
                case 1:
                    addTask();
                    break;
                case 2:
                    listTasks();
                    waitForEnter();
                    break;
                case 3:
                    removeTask();
                    waitForEnter();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    waitForEnter();
            }
        }
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n--- To-Do List ---");
        System.out.println("1. Add task");
        System.out.println("2. List tasks");
        System.out.println("3. Remove task");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    private static int readOption() {
        int option = -1;
        try {
            option = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            // if input is not a number, return -1 to trigger invalid option message
        }
        return option;
    }

    private static void addTask() {
        System.out.print("Enter the task to add: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added!");
        waitForEnter();
    }

    private static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private static void removeTask() {
        listTasks();
        if (!tasks.isEmpty()) {
            System.out.print("Enter the number of the task you want to remove: ");
            int index = -1;
            try {
                index = Integer.parseInt(scanner.nextLine());
                if (index > 0 && index <= tasks.size()) {
                    String removed = tasks.remove(index - 1);
                    System.out.println("Task '" + removed + "' removed.");
                } else {
                    System.out.println("Invalid number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            }
        }
    }

    private static void waitForEnter() {
        System.out.println("\nPress Enter to return to the main menu...");
        scanner.nextLine();
    }
}
