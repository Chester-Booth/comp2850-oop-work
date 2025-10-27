// Task 15.2.3

fun main() {
    // Write your main program here
    val account = SavingsAccount(0.018,"me")
    account.deposit(125000) // 100 is £1 bc pence

    repeat(5) { account.applyInterest() }

    println("interest balance is ${account.balance}")

    account.withdraw(5000)

    println("final balance is ${account.balance}")

}
