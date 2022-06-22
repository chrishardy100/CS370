public class Customer implements Comparable<Customer> {
    String last, first, acctNo;
    double balance = 0.0;

    // CONSTRUCTORS
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public Customer() {
        this.first = "JOHN";
        this.last = "DOE";
        this.acctNo = "000";
        this.balance = 0.0;
    }

    public Customer(String last, String first) {
        this.first = first;
        this.last = last;
        this.acctNo = "000";
        this.balance = 0.0;
    }

    public Customer(String last, String first, String acctNo) {
        this.first = first;
        this.last = last;
        this.acctNo = acctNo;
        this.balance = 0.0;
    }

    public Customer(String first, String last, String acctNo, double balance) {
        this.first = first;
        this.last = last;
        this.acctNo = acctNo;
        this.balance = balance;

    }

    // MEMBER METHODS
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public double deposit(double amount) {
        return this.balance += amount;
    }

    public double withdrawal(double amount) {
        if (balance - amount >= 0)
            this.balance -= amount;
        else
            System.out.println("I'm sorry Dave. I'm afraid I can't to that. ");
        return this.balance;

    }

    public boolean equals(String other) {

        return this.acctNo == other;
    }

    public int compareTo(Customer other) {
        int value = this.last.compareTo(other.last);

        if (value != 0)
            return value;
        else
            return this.first.compareTo(other.first);

    }

    public String toString() {
        return last + ", " + first + ", " + acctNo + ", $" + String.valueOf(balance);
    }

    // SETS & GETS
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void setFirst(String first) {
        this.first = first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getFirst() {
        return this.first;
    }

    public String getLast() {
        return this.last;
    }

    public String getAcctNo() {
        return this.acctNo;
    }

}
