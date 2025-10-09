import kotlin.system.exitProcess

// Task 7.7.2: contact database, using a map
fun main(){

    val database = mutableMapOf<String,String>()

    while(true) {
        //input name and handle exit
        println("Enter a users Contact Name:\n(-1 to exit)")
        val contactName = readln()
        if (contactName == "-1") exitProcess(1)

        // read/write
        if (contactName in database.keys){
            println("${contactName}: ${database[contactName]}")
        }
        else{
            println("Adding user: Enter Phone Number:")
            val phoneNumber = readln()
            database[contactName] = phoneNumber
        }

    }
}