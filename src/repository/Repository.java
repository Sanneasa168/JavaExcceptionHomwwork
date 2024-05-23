package repository;

import model.Course;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Repository {
    static List<Course> courseList = new ArrayList<>();
    public static void  getAllCourse(){
        Scanner scanner = new Scanner(System.in);
        int random  = new Random().nextInt(100)+999;
        String id = String.valueOf(random);
        System.out.println("[+]: Inter Course Title ");
        String title = scanner.nextLine().trim();
        System.out.println("[+]: Inter Course Requirement ");
        String[] requirement = scanner.nextLine().split(",");
        System.out.println("[+]: Inter Course Instructors");
        String[] instructor = scanner.nextLine().split(",");
        LocalDateTime localDateTime = LocalDateTime.now();
        Course course = new Course(id,title,requirement,instructor,localDateTime.toLocalDate());
       courseList.add(course);
    }
    public static List<Course> getCourses(){
        return  courseList;
    }
}
