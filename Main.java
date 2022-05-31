import java.io.IOException;
import java.util.Scanner;
import java.io.IOException;

class WrongStudentName extends Exception { }
class WrongAge extends Exception { }

class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            try {
                int ex = menu();
                switch(ex) {
                    case 1: exercise1(); break;
                    case 2: exercise2(); break;
                    case 3: exercise3(); break;
                    default: return;
                }
            } catch(IOException e) {

            } catch(WrongStudentName e) {
                System.out.println("Bledne imie studenta!");
            } catch(WrongAge e) {
                System.out.println("Zły wiek!");
            }
          
        }
    }

    public static int menu() {
        System.out.println("Wcisnij:");
        System.out.println("1 - aby dodac studenta");
        System.out.println("2 - aby wypisac wszystkich studentow");
        System.out.println("3 - aby wyszukac studenta po imieniu");
        System.out.println("0 - aby wyjsc z programu");
        return scan.nextInt();
    }

    public static String ReadName() throws WrongStudentName, WrongAge {
        scan.nextLine();
        System.out.println("Podaj imie: ");
        String name = scan.nextLine();
        if(name.contains(" "))
            throw new WrongStudentName();

        return name;
    }

    public static void exercise1() throws IOException, WrongStudentName, WrongAge {
        var name = ReadName();
        System.out.println("Podaj wiek: ");
        var age = scan.nextInt();
        scan.nextLine();
      if(age>100 || age<0)
            throw new WrongAge();
        System.out.println("Podaj date urodzenia DD-MM-YYYY");
        var date = scan.nextLine();
        (new Service1()).addStudent(new Student(name, age, date));
    }

    public static void exercise2() throws IOException {
        var students = (new Service1()).getStudents();
        for(Student current : students) {
            System.out.println(current.ToString());
        }
    }

    public static void exercise3() throws IOException {
        scan.nextLine();
        System.out.println("Podaj imie: ");
        var name = scan.nextLine();
        var wanted = (new Service1()).findStudentByName(name);
        if(wanted == null)
            System.out.println("Nie znaleziono...");
        else {
            System.out.println("Znaleziono: ");
            System.out.println(wanted.ToString());
        }
    }
}