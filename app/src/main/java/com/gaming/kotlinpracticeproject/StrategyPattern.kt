package com.gaming.kotlinpracticeproject

interface PaymentStrategy{
    fun pay(amount: Double)
}

class CreditCardPayment(
    private val cardNumber: String,
    private val cvv: String
): PaymentStrategy{
    override fun pay(amount: Double) {
        println("Card-Details number:$cardNumber || cvv:$cvv")
        println("Paying $amount with Credit Card")
    }
}

class PayPalPayment(
    private val email:String
) : PaymentStrategy{
    override fun pay(amount: Double) {
        println("Email id:$email")
        println("paying $amount with Paypal")
    }
}

class ShoppingCard(private val paymentStrategy: PaymentStrategy){
    fun checkout(amount: Double){
        paymentStrategy.pay(amount)
    }
}

// Usage
fun main(){
    val creditCardPayment = CreditCardPayment("1234-5678","123")
    val payPalPayment = PayPalPayment("user@example.com")

    val cart1 = ShoppingCard(creditCardPayment)
    val cart2 = ShoppingCard(payPalPayment)

    cart1.checkout(100.0)
    cart2.checkout(50.0)
}