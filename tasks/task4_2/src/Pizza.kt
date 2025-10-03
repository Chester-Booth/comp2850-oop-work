fun main(){
    println("PIZZA MENU\n\n\t(a) Margherita\n\t(b) Quattro Stagioni\n\t(c) Seafood\n\t(d) Hawaiian\n\nChoose your pizza (a-d):" )
    val input = readln().lowercase()
    if (input.length == 1 && input[0] in 'a'..'d'){
        println("Order Accepted")
    }
    else{
        println("Invalid Order")
    }

}