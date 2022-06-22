import java.io.*;
import java.util.*;

// Acessing a customer through an array is much quiker than the BST because you have direct acess to arrays
// However, it is important to keep a BST as well for the sake of redundancy.
// If we dont have an acctNo or something were to go wrong with the array for whatever reason,
// we can rely on the BST to find the information we need and vice versa.
public class drive {
    public static void main(String[] args) throws FileNotFoundException {

        BST bst = new BST();
        Customer[] acctDB = new Customer[1000];

        loadCustomers(bst, acctDB);
        // menu(bst, acctDB);
        BST.InOrder(bst);
    }

    public static void loadCustomers(BST tree, Customer[] acctDB) throws FileNotFoundException {
        File inputFile = new File("FileOne.txt");
        Scanner input = new Scanner(inputFile);

        while (input.hasNextLine()) {
            Customer x = new Customer(input.next(), input.next(), input.next());

            // insert into bst & acctDB
            BST.Insert(tree, x);
            int index = Integer.parseInt(x.acctNo);
            acctDB[index] = x;
        }

        input.close();
    }

    public static void menu(BST tree, Customer[] acctDB) {
        String s = "WHAT CAN I DO YA FOR?\n" +
                "1) MAKE A DEPOSIT\n" +
                "2) MAKE A WITHDRAWAL\n" +
                "3) CHECK BALANCE\n" +
                "4) OPEN A NEW ACCOUNT\n" +
                "5) CLOSE EXISTING ACCOUNT\n" +
                "6) LOOK UP BY ACCOUNT NUMBER\n" +
                "7) EXIT\n";
        System.out.print(s);

        Customer c = new Customer();
        Scanner console = new Scanner(System.in);
        int i = console.nextInt();

        switch (i) {
            case 1:
                System.out.println("DEPOSIT");
                System.out.println("Enter the name of the account holder.");

                c.first = console.next();
                c.last = console.next();
                c = BST.search(tree, c);
                System.out.println("How much woulu you like to deposit?");

                c.deposit(console.nextDouble());
                System.out.println(c.toString());
                System.out.println();
                menu(tree, acctDB);

            case 2:
                System.out.println("WITHDRAWAL");
                System.out.println("Enter the name of the account holder.");

                c.first = console.next();
                c.last = console.next();
                c = BST.search(tree, c);
                System.out.println("How much woulu you like to withdrawal?");

                c.withdrawal(console.nextDouble());
                System.out.println(c.toString());
                System.out.println();
                menu(tree, acctDB);
                break;
            case 3:
                System.out.println("CHECK BALANCE");
                System.out.println("Enter the name of the account holder.");

                c.first = console.next();
                c.last = console.next();
                c = BST.search(tree, c);
                System.out.println(c.toString());
                System.out.println();

                menu(tree, acctDB);
                break;
            case 4:
                System.out.println("NEW ACCOUNT");
                System.out.println("Enter the name of the account holder.");
                c.first = console.next();
                c.last = console.next();

                System.out.println("Enter four digit account number");
                c.acctNo = console.next();
                BST.Insert(tree, c);

                System.out.println();

                menu(tree, acctDB);

                break;
            case 5:
                System.out.println("CLOSE ACCOUNT");
                System.out.println("Enter the name of the account holder.");
                c.first = console.next();
                c.last = console.next();
                c = BST.search(tree, c);
                BST.delete(tree, c);
                System.out.println();

                menu(tree, acctDB);

                break;
            case 6:
                System.out.println("ENTER ACCOUNT NUMBER");
                int index = Integer.parseInt(console.next());
                c = acctDB[index];
                System.out.println(c);
                menu(tree, acctDB);
                break;

            case 7:

                System.out.println("EXIT");
                System.out.println("Goodby.");
                break;

        }
    }

}
