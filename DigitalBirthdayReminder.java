
import java.time.LocalDate;
import java.time.Period;
import java.time.DayOfWeek;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BirthdayReminder {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter =
                     DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println("=== Digital Birthday Reminder System ===");
        System.out.println("Current Date: " + today.format(formatter));

        System.out.print("Enter person's name: ");
        String name = sc.nextLine();

        System.out.print("Enter date of birth (yyyy-MM-dd): ");
        LocalDate dob = LocalDate.parse(sc.nextLine());

        int age = Period.between(dob, today).getYears();

        String formattedDob = dob.format(formatter);

        DayOfWeek birthDay = dob.getDayOfWeek();

        LocalDate nextBirthday = dob.withYear(today.getYear());

        if (nextBirthday.isBefore(today)) {
            nextBirthday = nextBirthday.plusYears(1);
        }

        long daysRemaining =
                ChronoUnit.DAYS.between(today, nextBirthday);

        System.out.println("\n--- Birthday Details ---");
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + formattedDob);
        System.out.println("Day of Birth: " + birthDay);
        System.out.println("Age: " + age + " years");

        if (daysRemaining == 0) {
            System.out.println("Happy Birthday, " + name + "!");
            System.out.println("Wishing you a wonderful birthday!");
        } else {
            System.out.println("Next Birthday: "
                    + nextBirthday.format(formatter));
            System.out.println("Days remaining until next birthday: "
                    + daysRemaining);
        }

        sc.close();
    }
}
