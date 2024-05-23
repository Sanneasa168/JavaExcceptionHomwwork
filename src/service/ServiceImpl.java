package service;

import model.Course;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.Table;
import repository.Repository;
import exception.UserNotFoundException;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;

import static repository.Repository.getCourses;

public  class ServiceImpl implements Service{
    @Override
    public void addNewCourse() {
        Repository.getAllCourse();
    }
    @Override
    public void listCourse() {
        Table tb = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER);
        for(int i=0;i<5;i++){
            tb.setColumnWidth(i,25,25);
        }
        tb.addCell("ID",new CellStyle(CellStyle.HorizontalAlign.CENTER));
        tb.addCell("TITLE",new CellStyle(CellStyle.HorizontalAlign.CENTER));
        tb.addCell("INSTRUCTIONS",new CellStyle(CellStyle.HorizontalAlign.CENTER));
        tb.addCell("REQUIREMENTS",new CellStyle(CellStyle.HorizontalAlign.CENTER));
        tb.addCell("START DATA ",new CellStyle(CellStyle.HorizontalAlign.CENTER));
        for(Course course : getCourses()){
            tb.addCell(course.getId(),new CellStyle(CellStyle.HorizontalAlign.CENTER));
            tb.addCell(course.getTitle().toString(),new CellStyle(CellStyle.HorizontalAlign.CENTER));
            tb.addCell(Arrays.toString(course.getInstructor()),new CellStyle(CellStyle.HorizontalAlign.CENTER));
            tb.addCell(Arrays.toString(course.getRequirement()),new CellStyle(CellStyle.HorizontalAlign.CENTER));
            tb.addCell(String.valueOf(course.getDate()),new CellStyle(CellStyle.HorizontalAlign.CENTER));
        }
        System.out.println(tb.render());
    }

    @Override
    public Course findCourseById( Integer id ) throws UserNotFoundException {

            Optional<Course> course = Repository.getCourses()
                    .stream().
                    filter(e->e.getId().equals(id))
                    .findFirst();
            if(course.isEmpty()){
                throw new UserNotFoundException(" Course not found with id  :"+id);
            }

        return course.get();
    }

//    @Override
    public void findID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Course Search App!");
        try{
                try{
                    System.out.println("Enter The ID of the course you want to find");
                    Integer courseId = scanner.nextInt();
                    Course foundCourse = findCourseById(courseId);
                    System.out.println("found Course :"+foundCourse.getTitle());

                }catch (UserNotFoundException e){
                    System.out.println(e.getMessage());
                }
        }finally {
            scanner.close();
        }
    }

    @Override
    public Course findCourseByTitle(String title) throws UserNotFoundException{
        Optional<Course> course = Repository.getCourses().stream()
                .filter(e->e.getTitle().equalsIgnoreCase(title))
                .findFirst();
        if(course.isEmpty()){
            throw new UserNotFoundException(" Course not found with title :"+title);
        }
        return course.get();
    }

    @Override
    public void findByTitle() throws NoSuchElementException {
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("Enter The Title of the Course you want to find");

            if(scanner.hasNextLine()){
                String courseName = scanner.nextLine();
                try{
                    Course foundCourse =  findCourseByTitle(courseName);
                    System.out.println(" Found Course :"+foundCourse.getTitle());
                }catch (UserNotFoundException e){
                    System.out.println(e.getMessage());
                }

            }else{
                System.out.println("Invalid input. Please enter a valid course name.");
            }

        }catch (NoSuchElementException e ){
             e.printStackTrace();
        }finally {
            scanner.close();
        }
    }

    @Override
    public Course removeCourseById(Integer id) throws NoSuchElementException {
        Optional<Course> course = Repository.getCourses()
                .stream().
                filter(e->e.getId().equals(id))
                .findFirst();
        if(course.isEmpty()){
            throw new exception.NoSuchElementException(" Course not found with id  :"+id);
        }
        Course  courseRemove =  course.get();
        Repository.getCourses().remove(courseRemove);
        return courseRemove;

    }
    @Override
    public void removeById() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Welcome to the Course Removal App!");
            System.out.println("Enter the ID of the course you want to remove:");

            if (scanner.hasNextInt()) {
                Integer courseId = scanner.nextInt();

                try {
                    Course removedCourse = removeCourseById(courseId);
                    System.out.println("Removed course: " + removedCourse.getTitle());
                } catch (NoSuchElementException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Invalid input. Please enter a valid course ID.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("No more elements available for input.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

}



