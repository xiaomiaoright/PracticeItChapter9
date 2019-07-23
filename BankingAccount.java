import java.util.List;
import java.util.LinkedList;

public class BankingAccount {
    // BankingAccount object has 3 states: balance, historyTransaction, HistoryBalance
    private int balance;

    private List<String> historyTransaction;
    private List<String> historyBalance;

    // Constructor, to create a BankingAccount object
    public BankingAccount() {
        historyTransaction = new LinkedList<String>();
        historyBalance = new LinkedList<String>();
    }

    // Constructor, to create a BankingAccount object with a Startup object(balance)
    public BankingAccount(Startup s) {
        this.balance = s.startup_getBalance();
        historyTransaction = new LinkedList<String>();
        historyBalance = new LinkedList<String>();

        historyTransaction.add(valueToHistory(s.startup_getBalance())); //valueToHistory returns the String value of StartupBalance
        historyBalance.add(toString()); // toString() returns the String value of BankingAccout balance
    }

    // Behavior of BankingAccounting object with Debit object d: -->> update debit behavior of BankingAccount object
    // debit behavior: 公司存钱
    // Debit object: state balance, behavior Debit90 -- to set balance, behavior get_DebitBalance() -- to get balance
    public void debit(Debit d) {
        balance += d.debit_getBalance();

        historyTransaction.add(valueToHistory(d.debit_getBalance()));//valueToHistory returns the String value of Debit object balance
        historyBalance.add(toString()); // toString() returns the String value of BankingAccount balance
    }

    // Behavior of Banking Account object with Credit object c : -->> update credit behavior of BankingAccount object
    // credit behavior: 公司取钱
    // Credit object: state balance, behavior Credit() -- to set balance, behavior get_DebitBalance() -- to get balance
    public void credit(Credit c) {
        balance += c.credit_getBalance();

        historyTransaction.add(valueToHistory(c.credit_getBalance()));//valueToHistory returns the String value of Credit object balance
        historyBalance.add(toString());// toString() returns the String value of BankingAccount balance
    }

    // BankingAccount object behavior: BA.getBalance()
    public int getBalance() {
        return balance;
    }

    public boolean equals(Object o) {
        if(o instanceof BankingAccount) {
            return (this.getBalance() == ((BankingAccount) o).getBalance());
        }
        return false;
    }

    // transform int value to History String, return String
    private String valueToHistory(int value) {
        int absValue = Math.abs(value);
        return (value < 0 ? "(-" : "") + (absValue / 100) + "." + (absValue % 100 / 10) + (absValue % 100 % 10) + (value < 0 ? ")" : " ");
    }

    // transform balance (int) to String, return String
    public String toString() {
        int absBalance = Math.abs(balance);
        return (balance < 0 ? "-" : "") + "$" + (absBalance / 100) + "." + (absBalance % 100 / 10) + (absBalance % 100 % 10);
    }

    // historyBalanceToString() behavior --> return the historyBalance behavior of BankingAccount object
    public String historyBalanceToString() {
        /*int maxLength = 0;
        for(String piece : historyBalance) {
            maxLength = Math.max(maxLength, piece.length());
        }*/
        int maxLength = 8;

        String build = "";
        for(int i = 0; i < historyBalance.size(); i++) {
            for(int j = 0; j < maxLength - historyBalance.get(i).length(); j++) {
                build += " ";
            }
            build += historyBalance.get(i);
            if(i != historyBalance.size() - 1) {
                build += "\n";
            }
        }

        return build;
    }

    public String historyTransactionToString() {
        String total = toString() + " ";

        int maxLength = 0;
        for(String piece : historyTransaction) {
            maxLength = Math.max(maxLength, piece.length() + 2);
        }
        maxLength = Math.max(maxLength, total.length() + 2);

        String build = "";
        for(int i = 0; i < historyTransaction.size() - 1; i++) {
            for(int j = 0; j < maxLength - historyTransaction.get(i).length(); j++) {
                build += " ";
            }
            build += historyTransaction.get(i);
            build += "\n";
        }

        build += "+";
        for(int i = 0; i < maxLength - (historyTransaction.get(historyTransaction.size() - 1).length() + 1); i++) {
            build += " ";
        }
        build += historyTransaction.get(historyTransaction.size() - 1);
        build += "\n";

        for(int i = 0; i < maxLength; i++) {
            build += "-";
        }
        build += "\n";

        for(int i = 0; i < maxLength - total.length(); i++) {
            build += " ";
        }
        build += total;

        return build;
    }

    public class Credit {
        private int balance;

        public Credit(int balance) {
            this.balance = balance;
        }

        public int credit_getBalance() {
            return balance;
        }
    }

    public class Debit {
        private int balance;

        public Debit(int balance) {
            this.balance = balance;
        }

        public int debit_getBalance() {
            return balance;
        }
    }

    public class Startup {
        private int balance;

        public Startup(int balance) {
            this.balance = balance;
        }

        public int startup_getBalance() {
            return balance;
        }
    }
}
