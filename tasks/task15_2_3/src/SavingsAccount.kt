// Task 15.2.3

// Implement SavingsAccount class here
class SavingsAccount(val rate: Double, holder: String) : BankAccount(holder){
    fun applyInterest(){
        val interest = rate * balance.toDouble()
       deposit(interest.toInt())
    }
}