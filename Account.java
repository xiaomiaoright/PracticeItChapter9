public class Account {
    public boolean __processCalled;

    public Account(Client c) {
        __processCalled = false;
    }

    public boolean process(Transaction t) {
        __processCalled = true;
        return t.value() > -100 && t.value() < 1000000;
    }

}
