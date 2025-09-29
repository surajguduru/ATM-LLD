# ATM Class Diagram

```mermaid
classDiagram
class ATMController {
    - CardReader cardReader
    - CashDispenser cashDispenser
    - BankService bankService
    - Map<Action, Class<Transaction>> transactionMap
    +processTransaction(Action action)
}

class CardReader {
    +validateCard(): boolean
}

class CashDispenser {
    - Map<Denomination, Integer> cash
    - CashDispensingStrategy strategy
    +dispenseCash(amount: double)
    +hasSufficientCash(amount: double)
}

class CashDispensingStrategy {
    <<interface>>
    +dispense(amount: double, cash: Map<Denomination, Integer>): Map<Denomination, Integer>
}

class BankService {
    +validatePIN(pin: int): boolean
    +getBalance(accountId: String): double
    +debit(accountId: String, amount: double)
    +getStatement(accountId: String): String
}

class Keyboard {
    <<interface>>
    +getInput(): String
}

class DigitalKeyboard {
    +getInput(): String
}

class PhysicalKeyboard {
    +getInput(): String
}

class Action {
    <<enumeration>>
    WITHDRAW_CASH
    CHECK_BALANCE
    GET_STATEMENT
    DEPOSIT_CASH
}


class Transaction {
    <<interface>>
    +execute()
    +setState(TransactionState state)
    +getController(): ATMController
}

class WithdrawTransaction {
    - TransactionState state
    - ATMController atmController
    +execute()
    +setState(state: TransactionState)
    +getController(): ATMController
}

class CheckBalanceTransaction {
    - TransactionState state
    - ATMController atmController
    +execute()
    +setState(state: TransactionState)
    +getController(): ATMController
}

class GetStatementTransaction {
    - TransactionState state
    - ATMController atmController
    +execute()
    +setState(state: TransactionState)
    +getController(): ATMController
}

class TransactionState {
    <<interface>>
    +handle(transaction: Transaction)
}

class CardInserted
class CardValidated
class PINValidated
class FetchingBalance
class FetchingStatement
class CashDispensed
class StatementDisplayed
class TransactionComplete


%% Relationships
ATM --> ATMController
ATM --> Keyboard
ATMController --> CardReader
ATMController --> CashDispenser
ATMController --> BankService
CashDispenser --> CashDispensingStrategy
Keyboard <|.. DigitalKeyboard
Keyboard <|.. PhysicalKeyboard
Transaction <|.. WithdrawTransaction
Transaction <|.. CheckBalanceTransaction
Transaction <|.. GetStatementTransaction
Transaction --> TransactionState
TransactionState <|.. CardInserted
TransactionState <|.. CardValidated
TransactionState <|.. PINValidated
TransactionState <|.. FetchingBalance
TransactionState <|.. FetchingStatement
TransactionState <|.. CashDispensed
TransactionState <|.. StatementDisplayed
TransactionState <|.. TransactionComplete
