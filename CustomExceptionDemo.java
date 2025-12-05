// 1. Проверяемое исключение (checked)
class PaymentException extends Exception {
    private double amount;
    private String account;
    
    public PaymentException(String message, double amount, String account) {
        super(message);
        this.amount = amount;
        this.account = account;
    }
    
    public double getAmount() { return amount; }
    public String getAccount() { return account; }
    
    @Override
    public String toString() {
        return String.format("PaymentException[сумма=%.2f, счет=%s, сообщение=%s]", 
                           amount, account, getMessage());
    }
}

// 2. Непроверяемое исключение (unchecked)
class InsufficientFundsException extends RuntimeException {
    private double balance;
    private double required;
    
    public InsufficientFundsException(double balance, double required) {
        super(String.format("Недостаточно средств. Баланс: %.2f, требуется: %.2f", 
                          balance, required));
        this.balance = balance;
        this.required = required;
    }
    
    public double getBalance() { return balance; }
    public double getRequired() { return required; }
    public double getShortage() { return required - balance; }
}

// 3. Иерархия исключений
abstract class BankException extends Exception {
    private String accountNumber;
    
    public BankException(String message, String accountNumber) {
        super(message);
        this.accountNumber = accountNumber;
    }
    
    public String getAccountNumber() { return accountNumber; }
}

class AccountBlockedException extends BankException {
    public AccountBlockedException(String accountNumber) {
        super("Счет заблокирован", accountNumber);
    }
}

class InvalidAccountException extends BankException {
    public InvalidAccountException(String accountNumber) {
        super("Недействительный номер счета", accountNumber);
    }
}

// 4. Использование
class BankAccount {
    private String number;
    private double balance;
    private boolean blocked;
    
    public BankAccount(String number, double balance) {
        this.number = number;
        this.balance = balance;
    }
    
    public void withdraw(double amount) throws InsufficientFundsException, 
                                                AccountBlockedException {
        if (blocked) {
            throw new AccountBlockedException(number);
        }
        if (amount > balance) {
            throw new InsufficientFundsException(balance, amount);
        }
        balance -= amount;
    }
    
    public void transfer(BankAccount to, double amount) throws PaymentException {
        if (blocked) {
            throw new PaymentException("Счет отправителя заблокирован", amount, number);
        }
        if (to.isBlocked()) {
            throw new PaymentException("Счет получателя заблокирован", amount, to.getNumber());
        }
        if (amount > balance) {
            throw new PaymentException("Недостаточно средств", amount, number);
        }
        
        this.balance -= amount;
        to.deposit(amount);
    }
    
    public void deposit(double amount) {
        this.balance += amount;
    }
    
    public void block() { this.blocked = true; }
    public boolean isBlocked() { return blocked; }
    public String getNumber() { return number; }
    public double getBalance() { return balance; }
}

// 5. Тестирование
public class CustomExceptionDemo {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("1234567890", 1000.0);
        BankAccount account2 = new BankAccount("0987654321", 500.0);
        
        // Тестирование непроверяемого исключения
        System.out.println("=== 1. InsufficientFundsException ===");
        try {
            account1.withdraw(1500.0);
        } catch (InsufficientFundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
            System.out.println("Не хватает: " + e.getShortage());
        } catch (AccountBlockedException e) {
            System.out.println("Счет заблокирован: " + e.getAccountNumber());
        }
        
        // Тестирование проверяемого исключения
        System.out.println("\n=== 2. PaymentException ===");
        try {
            account1.transfer(account2, 800.0);
            System.out.println("Перевод успешен");
        } catch (PaymentException e) {
            System.out.println("Ошибка перевода: " + e.getMessage());
            System.out.println("Сумма: " + e.getAmount());
            System.out.println("Счет: " + e.getAccount());
        }
        
        // Тестирование блокировки счета
        System.out.println("\n=== 3. AccountBlockedException ===");
        account1.block();
        try {
            account1.withdraw(100.0);
        } catch (InsufficientFundsException | AccountBlockedException e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }
        
        // Цепочка исключений (cause)
        System.out.println("\n=== 4. Исключение с причиной ===");
        try {
            processTransaction(account1, account2, 2000.0);
        } catch (PaymentException e) {
            System.out.println("Основная ошибка: " + e.getMessage());
            if (e.getCause() != null) {
                System.out.println("Причина: " + e.getCause().getMessage());
            }
        }
    }
    
    static void processTransaction(BankAccount from, BankAccount to, double amount) 
            throws PaymentException {
        try {
            from.transfer(to, amount);
        } catch (PaymentException e) {
            // Создаем новое исключение с причиной
            PaymentException wrapped = new PaymentException(
                "Ошибка обработки транзакции", amount, from.getNumber());
            wrapped.initCause(e);
            throw wrapped;
        }
    }
}
