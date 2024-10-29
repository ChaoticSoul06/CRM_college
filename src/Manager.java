//Searching for a student record
// Editing a student record
// Managing multiple student records

import java.util.Scanner;

class Student{
    int id;
    int rn;

    public Student(int id, int rn) {
        this.id = id;
        this.rn = rn;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRn() {
        return rn;
    }

    public void setRn(int rn) {
        this.rn = rn;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", rn=" + rn +
                '}';
    }
}

public class Manager {
    Student[] students;
    int count;
    public Manager(int cap){
        students = new Student[cap];
        count=0;

    }
    public void search(int id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getId() == id) {
                System.out.println(students[i]);
                break;
            } else {
                System.out.println("Not found");
            }
        }
    }
        public void add(Student student){
            if(count<students.length){
                students[count++] = student;
        }else{
                System.out.println("Overflow");
            }
    }
    public void display(){
        if(count==0){
            System.out.println("No data");
        }
        for(int i=0;i<count;i++){
            System.out.println(students[i]);
        }
    }
    public void delete(int id) {
        //find the index of the element you wanna delete, delete element with the index that matches the index of
        // the element to be deleted(set to null), shift all elements to the left(from that point do index-1)
        boolean found = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i].getId() == id) {
                students[i] = null;
                found = true;
                break;
            }

        }
        if (!found) {
            System.out.println("Not found");
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager(5);

        int choice;
        do {
            System.out.println("Enter choice: 1-add,2-display, 3-search");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter id, rn");
                    int id = scanner.nextInt();
                    int rn = scanner.nextInt();
                    manager.add(new Student(id, rn));
                    break;
                case 2:
                    System.out.println("Displaying");
                    manager.display();
                    break;
                case 3:
                    System.out.println("Enter id:");
                    int searchId = scanner.nextInt();
                    manager.search(searchId);
                    break;
                case 4:
                    System.out.println("Enter id:");
                    int delId = scanner.nextInt();
                    manager.delete(delId);
                default:
                    System.out.println("dfdfsdf");
            }
        } while (choice != 5);
    }
}
