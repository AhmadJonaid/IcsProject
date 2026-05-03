import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        EventManegar manager = new EventManegar();

        ArrayList<Department> departments = new ArrayList<>();
        ArrayList<Venue> venues = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== Event Management System =====");
            System.out.println("1. Add Department");
            System.out.println("2. Add Venue");
            System.out.println("3. Add Event");
            System.out.println("4. Show Departments");
            System.out.println("5. Show Venues");
            System.out.println("6. Show Events");
            System.out.println("7. Find Event");
            System.out.println("8. Delete Event");
            System.out.println("0. Exit");

            choice = readIntInRange(input, "Choose: ", 0, 8);

            if (choice == 1) {
                String name = readText(input, "Enter department name: ");
                String person = readText(input, "Enter responsible person: ");

                Department department = new Department(name, person);
                manager.addDepartment(department);
                departments.add(department);

                System.out.println("Department added successfully");
            }

            else if (choice == 2) {
                System.out.println("1. Conference Hall");
                System.out.println("2. Lecture Hall");
                System.out.println("3. Public Space");
                System.out.println("4. Sport Area");

                int type = readIntInRange(input, "Choose venue type: ", 1, 4);

                String place = readText(input, "Enter place: ");
                String location = readText(input, "Enter location: ");
                int capacity = readPositiveInt(input, "Enter capacity: ");

                Venue venue = null;

                if (type == 1) {
                    int sideRooms = readPositiveInt(input, "Enter side rooms: ");
                    boolean audioVisual = readBoolean(input, "Audio visual?");

                    venue = new ConferenceHall(place, location, capacity, sideRooms, audioVisual);
                }

                else if (type == 2) {
                    int hallNumber = readPositiveInt(input, "Enter hall number: ");
                    int seats = readPositiveInt(input, "Enter seats: ");

                    venue = new LectureHall(place, location, capacity, hallNumber, seats);
                }

                else if (type == 3) {
                    boolean covered = readBoolean(input, "Covered?");
                    boolean permission = readBoolean(input, "Permission required?");

                    venue = new PublicSpace(place, location, capacity, covered, permission);
                }

                else if (type == 4) {
                    String sportType = readText(input, "Enter sport type: ");
                    boolean outdoor = readBoolean(input, "Outdoor?");

                    venue = new SportArea(place, location, capacity, sportType, outdoor);
                }

                manager.addvenue(venue);
                venues.add(venue);

                System.out.println("Venue added successfully");
            }

            else if (choice == 3) {
                if (departments.isEmpty() || venues.isEmpty()) {
                    System.out.println("Add at least one department and one venue first");
                }

                else {
                    System.out.println("1. Academic Event");
                    System.out.println("2. Religious Event");
                    System.out.println("3. Social Event");
                    System.out.println("4. Sport Event");

                    int type = readIntInRange(input, "Choose event type: ", 1, 4);

                    String name = readText(input, "Enter event name: ");

                    String startTime;
                    String endTime;

                    while (true) {
                        startTime = readDateTime(input, "Enter start time Example 2026-05-04 14:00: ");
                        endTime = readDateTime(input, "Enter end time Example 2026-05-04 16:00: ");

                        if (isBefore(startTime, endTime)) {
                            break;
                        }

                        System.out.println("Invalid event time. End time must be after start time.");
                        System.out.println("Please enter the start and end time again.");
                    }

                    System.out.println("Choose department:");
                    for (int i = 0; i < departments.size(); i++) {
                        System.out.println((i + 1) + ". " + departments.get(i).getDepartmentName());
                    }

                    int depChoice = readIntInRange(input, "Choose department: ", 1, departments.size());
                    Department department = departments.get(depChoice - 1);

                    System.out.println("Choose venue:");
                    for (int i = 0; i < venues.size(); i++) {
                        System.out.println((i + 1) + ". " + venues.get(i).getPlace());
                    }

                    int venueChoice = readIntInRange(input, "Choose venue: ", 1, venues.size());
                    Venue venue = venues.get(venueChoice - 1);

                    Event event = null;

                    if (type == 1) {
                        String speaker = readText(input, "Enter speaker name: ");
                        String topic = readText(input, "Enter academic topic: ");
                        String format = readText(input, "Enter event format: ");

                        event = new AcademicEvent(name, startTime, endTime, venue, department, speaker, topic, format);
                    }

                    else if (type == 2) {
                        String activity = readText(input, "Enter religious activity: ");
                        boolean gender = readBoolean(input, "Gender restriction?");

                        event = new ReligiousEvent(name, startTime, endTime, venue, department, activity, gender);
                    }

                    else if (type == 3) {
                        String activityType = readText(input, "Enter activity type: ");
                        boolean refresh = readBoolean(input, "Refreshments?");
                        String audience = readText(input, "Enter target audience: ");

                        event = new SocialEvent(name, startTime, endTime, venue, department, activityType, refresh, audience);
                    }

                    else if (type == 4) {
                        String sportType = readText(input, "Enter sport type: ");
                        int teams = readPositiveInt(input, "Enter number of teams: ");
                        int participants = readPositiveInt(input, "Enter number of participants: ");

                        event = new SportEvent(name, startTime, endTime, venue, department, sportType, teams, participants);
                    }

                    manager.addEvent(event);
                }
            }

            else if (choice == 4) {
                manager.showDepartments();
            }

            else if (choice == 5) {
                manager.showVenues();
            }

            else if (choice == 6) {
                manager.showEvents();
            }

            else if (choice == 7) {
                String name = readText(input, "Enter event name: ");
                manager.findEvent(name);
            }

            else if (choice == 8) {
                String name = readText(input, "Enter event name: ");
                manager.deleteEvent(name);
            }

            else if (choice == 0) {
                System.out.println("Goodbye");
            }

        } while (choice != 0);
    }

    public static String readText(Scanner input, String message) {
        while (true) {
            System.out.print(message);
            String text = input.nextLine().trim();

            if (text.isEmpty()) {
                System.out.println("Invalid input. Please enter something.");
            }
            else if (text.matches("\\d+")) {
                System.out.println("Invalid input. Please enter text, not only numbers.");
            }
            else {
                return text;
            }
        }
    }

    public static int readInt(Scanner input, String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(input.nextLine());
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public static int readIntInRange(Scanner input, String message, int min, int max) {
        while (true) {
            int number = readInt(input, message);

            if (number >= min && number <= max) {
                return number;
            }

            System.out.println("Invalid choice. Enter a number from " + min + " to " + max + ".");
        }
    }

    public static int readPositiveInt(Scanner input, String message) {
        while (true) {
            int number = readInt(input, message);

            if (number > 0) {
                return number;
            }

            System.out.println("Invalid input. Number must be greater than 0.");
        }
    }

    public static boolean readBoolean(Scanner input, String message) {
        while (true) {
            System.out.print(message + " true/false: ");
            String answer = input.nextLine();

            if (answer.equalsIgnoreCase("true")) {
                return true;
            }

            if (answer.equalsIgnoreCase("false")) {
                return false;
            }

            System.out.println("Invalid input. Please enter true or false.");
        }
    }

    public static String readDateTime(Scanner input, String message) {
        while (true) {
            System.out.print(message);
            String dateTime = input.nextLine();

            if (isValidDateTimeFormat(dateTime)) {
                return dateTime;
            }

            System.out.println("Invalid date/time format.");
            System.out.println("Please write it like this: 2026-05-04 14:00");
        }
    }

    public static boolean isValidDateTimeFormat(String dateTime) {
        try {
            String[] parts = dateTime.split(" ");

            if (parts.length != 2) {
                return false;
            }

            String[] date = parts[0].split("-");
            String[] time = parts[1].split(":");

            if (date.length != 3 || time.length != 2) {
                return false;
            }

            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);
            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);

            if (year < 1) {
                return false;
            }

            if (month < 1 || month > 12) {
                return false;
            }

            if (day < 1 || day > 31) {
                return false;
            }

            if (hour < 0 || hour > 23) {
                return false;
            }

            if (minute < 0 || minute > 59) {
                return false;
            }

            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public static boolean isBefore(String time1, String time2) {
        int[] first = convertTimeToArray(time1);
        int[] second = convertTimeToArray(time2);

        for (int i = 0; i < first.length; i++) {
            if (first[i] < second[i]) {
                return true;
            }
            else if (first[i] > second[i]) {
                return false;
            }
        }

        return false;
    }

    public static int[] convertTimeToArray(String time) {
        String[] parts = time.split(" ");
        String[] date = parts[0].split("-");
        String[] clock = parts[1].split(":");

        int[] timeArray = new int[5];

        timeArray[0] = Integer.parseInt(date[0]);
        timeArray[1] = Integer.parseInt(date[1]);
        timeArray[2] = Integer.parseInt(date[2]);
        timeArray[3] = Integer.parseInt(clock[0]);
        timeArray[4] = Integer.parseInt(clock[1]);

        return timeArray;
    }
}
