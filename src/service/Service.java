package service;

import exception.NoSuchElementException;
import model.Course;
import exception.UserNotFoundException;

public interface Service {
     void addNewCourse();
     void listCourse();
     Course findCourseById(Integer id) throws UserNotFoundException;
     void findID();
     Course findCourseByTitle(String title)throws UserNotFoundException;
     void findByTitle() throws  NoSuchElementException;
     Course removeCourseById(Integer id) throws  NoSuchElementException;
     void  removeById();
}
