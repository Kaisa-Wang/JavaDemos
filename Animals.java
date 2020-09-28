import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Animals {
    public static void main(String[] args) {
        ArrayList<Animal> list = new ArrayList<>();

        
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("------------");
            System.out.println("1.添加动物信息");
            System.out.println("2.修改动物信息");
            System.out.println("3.删除动物信息");
            System.out.println("4.查询动物信息");
            System.out.println("5.按年龄排列");
            System.out.println("6.打印所有动物信息");
            System.out.println("7.退出菜单");
            System.out.println("------------");
            System.out.println("请输入您的选择");

            int choice = in.nextInt();
            if(choice == 7) break;

            switch (choice) {
                case 1:
                    add(list);
                    break;
                case 2:
                    modify(list);
                    break;
                case 3:
                    delete(list);
                    break;
                case 4:
                    find(list);
                    break;
                case 5:
                    Sort(list);
                    break;
                case 6:
                    Traverse(list);
                    break;
                default:
                    System.out.println("您输入了错误选择！");
            }
        }
    }

    public static void add(ArrayList<Animal> list){
        boolean choice = true;
        while(choice){
            System.out.println("请输入动物种类");
            Scanner in = new Scanner(System.in);
            String species = in.nextLine();
            System.out.println("请输入动物性别(M/F):");

            char gender = in.next().charAt(0);
            System.out.println("请输入动物年龄");

            int age = in.nextInt();
            list.add(new Animal(species,gender,age));
            System.out.println("是否继续录入(true/false)?");
            choice = in.nextBoolean();
        }

    }

    public static void modify(ArrayList<Animal> list){
        System.out.println("请选择您要修改的动物：");
        Traverse(list);
        Scanner in = new Scanner(System.in);
        int choice1 = in.nextInt();
        System.out.println("请输入您要修改的信息：");
        System.out.println("1.修改动物种类");
        System.out.println("2.修改动物性别");
        System.out.println("3.修改动物年龄");
        int choice2 = in.nextInt();
        switch (choice2){
            case 1:
                Animal a1 = list.get(choice1-1);
                System.out.println("请输入种类：");
                String species = in.nextLine();
                a1.setSpecies(species);
                break;
            case 2:
                Animal a2 = list.get(choice1-1);
                System.out.println("请输入性别(M/F)：");
                char gender = in.next().charAt(0);
                a2.setGender(gender);
                break;
            case 3:
                Animal a3 = list.get(choice1-1);
                System.out.println("请输入年龄：");
                int age = in.nextInt();
                a3.setAge(age);
            default:
                System.out.println("您输入了错误选择！");
        }
    }

    public static void delete(ArrayList<Animal> list){
        Traverse(list);
        System.out.println("请选择您要删除的动物：");
        Scanner in = new Scanner(System.in);
        int choice1 = in.nextInt();
        list.remove(choice1-1);
    }

    public static void find(ArrayList<Animal> list){
        Scanner in = new Scanner(System.in);
        System.out.println("请输入您要查找的动物种类：");
        String species = in.nextLine();
        for(Animal a:list){
            if(a.equals(species)){
                System.out.println(a);
            }
        }

    }

    public static void Sort(ArrayList<Animal> list){
        System.out.println("升序or降序(A/D)");
        Scanner in = new Scanner(System.in);
        char choice = in.next().charAt(0);
        Animal temp = list.get(0);
        if(choice=='A') {
            for(int i = 0; i < list.size()-1; i++){
                for(int j = i+1; j < list.size(); j++){
                    if(list.get(i).getAge()>list.get(j).getAge()){
                        temp = list.get(j);
                        list.set(j,list.get(i));
                        list.set(i,temp);
                    }
                }
            }
        } else if(choice == 'D'){
            for(int i = 0; i < list.size()-1; i++){
                for(int j = i+1; j < list.size(); j++){
                    if(list.get(i).getAge()<list.get(j).getAge()){
                        temp = list.get(j);
                        list.set(j,list.get(i));
                        list.set(i,temp);
                    }
                }
            }
        }
        System.out.println("排序后动物信息：");
        Traverse(list);
    }



    public static void Traverse(ArrayList<Animal> list){
        if(list.size()==0){
            System.out.println("您还未录入动物信息！");
        }else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(i + 1 + ":" + list.get(i));
            }
        }
    }
}