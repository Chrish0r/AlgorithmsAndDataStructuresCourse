package aufgaben;

public class Faculty {

    public static void main(String[] args) {
        int n = 5;
        System.out.println("The facualty of " + n + " is " + new Faculty().computeFaculty(n) + System.lineSeparator());

        System.out.println("The facualty of " + n + " is " + new Faculty().computeFacultyIter(n));
    }

    private int computeFacultyIter(int n) {
        int faculty = 1;
        for(int i = 1; i <= n ; i++) {
            faculty *= i;
        }
        return  faculty;
    }

    private int computeFaculty(int n) {
        if(n == 1) {
            return 1;
        } else {
            return computeFaculty(n-1) * n;
        }
    }
}
