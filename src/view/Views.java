package view;


import exception.NoSuchElementException;
import exception.UserNotFoundException;
import service.ServiceImpl;

import java.util.Scanner;

public class Views {
    public static  void myView() throws NoSuchElementException, UserNotFoundException {
        ServiceImpl service = new ServiceImpl();
        Scanner sc = new Scanner(System.in);

        System.out.println("""
                \s
                  ██╗    ██╗███████╗██╗     ██╗      ██████╗ ██████╗ ███╗   ███╗    ████████╗ ██████╗      ██████╗███████╗████████╗ █████╗ ██████╗\s
                  ██║    ██║██╔════╝██║     ██║     ██╔════╝██╔═══██╗████╗ ████║    ╚══██╔══╝██╔═══██╗    ██╔════╝██╔════╝╚══██╔══╝██╔══██╗██╔══██╗
                  ██║ █╗ ██║█████╗  ██║     ██║     ██║     ██║   ██║██╔████╔██║       ██║   ██║   ██║    ██║     ███████╗   ██║   ███████║██║  ██║
                  ██║███╗██║██╔══╝  ██║     ██║     ██║     ██║   ██║██║╚██╔╝██║       ██║   ██║   ██║    ██║     ╚════██║   ██║   ██╔══██║██║  ██║
                  ╚███╔███╔╝███████╗███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║       ██║   ╚██████╔╝    ╚██████╗███████║   ██║   ██║  ██║██████╔╝
                   ╚══╝╚══╝ ╚══════╝╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝       ╚═╝    ╚═════╝      ╚═════╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═════╝                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              \s

                """);
        System.out.println("-".repeat(62));
        System.out.println("1. Add New Course ");
        System.out.println("2. List Course ");
        System.out.println("3. Find Course By Id");
        System.out.println("4. Find Course By Title");
        System.out.println("5. Remover Course By Id");
        System.out.println("-".repeat(62));
        while (true) {
            System.out.print("Insert option  ->");
            int cho;
            cho = sc.nextInt();
            switch (cho) {
                case 1:
                    service.addNewCourse();
                    break;
                case 2:
                    service.listCourse();
                    break;
                case 3:
                    service.findID();
                    break;
                case 4:
                    service.findByTitle();
                    break;
                case 5:
                    service.removeById();
                    break;

                default:
                    System.out.println("invalid choice");
            }
        }
    }
    }
