package com.example.w1d3_rxjavademo.network.model

data class Airline(val id: Int, val name: String, val logo: String) {
    override fun toString(): String {
        return "Airline(id=$id, name='$name', logo='$logo')"
    }
}
data class Price(val price: Float, val seats: String, val currency: String,
                 val flightNumber: String,
                 val from: String, val to: String) {
    override fun toString(): String {
        return "Price(price=$price, seats='$seats', currency='$currency', flightNumber='$flightNumber', from='$from', to='$to')"
    }
}

data class Ticket(val from: String, val to: String,
                  val departure: String, val arrival: String, val duration: String, val instructions: String,
                  val flightNumber: String,
                  val numberOfStops: Int,
                  val airline: Airline, var price: Price?
) {
    override fun equals(other: Any?): Boolean {
        if (other === this) {
            return true
        }
        return if (other !is Ticket) {
            false
        } else flightNumber.equals(other.flightNumber, ignoreCase = true)
    }

    override fun hashCode(): Int {
        var hash = 3
        hash = 53 * hash + flightNumber.hashCode()
        return hash
    }

    override fun toString(): String {
        return "Ticket(from='$from', to='$to', departure='$departure', arrival='$arrival', duration='$duration', instructions='$instructions', flightNumber='$flightNumber', numberOfStops=$numberOfStops, airline=$airline, price=$price)"
    }

}