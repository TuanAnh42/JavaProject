/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author AnhTH
 */
public class StudentBo implements IMethod<Student>{

    private List<Student> list;

    public StudentBo() {
        list = new ArrayList<>();
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }
    @Override
    public boolean add() {
        Student student = new Student();
        student.input();
        return this.list.add(student);
    }

    @Override
    public void display() {
        if(this.list.isEmpty()){
            System.out.println("List Student Empty!!!");
        }
        for(Student student : this.list){
            student.display();
        }
    }

    @Override
    public boolean update(String rollNumber) {
        System.out.println("Please Enter the rollnumber: ");
        Scanner scanner = new Scanner(System.in);
        rollNumber = scanner.nextLine().trim();
        int index = getIndex(rollNumber);
        if (index >= 0) {
            Student student = new Student();
            student.input();
            list.set(index, student);
            return true;
        }
        return false;
        
    }

    @Override
    public boolean remove(String rollNumber) {
        Scanner scanner = new Scanner(System.in);
        rollNumber = scanner.nextLine().trim();
            for (Student str : list) {
            if (str.getName().equalsIgnoreCase(rollNumber)) {
                str.display();
            }
            }
        int index= getIndex(rollNumber);
        if(index>=0){
            list.remove(index);
            return true;
        }
        return false;
    }
    

    @Override
    
    public List<Student> search(String text) {
        
        List<Student> list1 = new ArrayList<>();
        for(Student stu : list ){
            if(stu.getName().toLowerCase().contains(text.toLowerCase())){
                list1.add(stu);
            }
        }
        return list1;
        
    }

    @Override
    public void sort() {
        Collections.sort(list, (Student s1, Student s2) -> {
            return s1.getName().compareTo(s2.getName());
        });
    }

    @Override
    public void find() {
        int count=0;
//       List<Student> find1= new ArrayList<>();      
            for(Student s1: list){
                String[] s= s1.getName().split(" ");
                String name = s[s.length-1];
                if(name.toLowerCase().startsWith("a")){
                    count +=1;
                    s1.display();
                }
                System.out.println("co"+count+"hoc sinh");
            }
       
       
}

    @Override
    public void maxmark() {
        double max=0;
        for(Student s3:list){
            double mark= s3.getMark();
            if(mark>max){
                max=mark;
                
            }          
        }
        for(Student s3:list){
            if(s3.getMark()==max){
                s3.display();
            }
        }
    }

    private int getIndex(String rollNumber) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRollNumber().equalsIgnoreCase(rollNumber.trim())) {
                return i;
            }
        }
        return -1;
    }
}
