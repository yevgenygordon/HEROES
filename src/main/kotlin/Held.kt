import kotlin.random.Random


// Held Class Definition
open class Held {
    var name: String
    var healthPoints: Double
    var theFin: Boolean = false


    constructor(name: String, healthPoints: Double){
        this.name = name
        this.healthPoints = healthPoints
    }

    open fun attack (gladiator: Feind){}

    open fun sideStep (gladiator: Held){}
    open fun cure (gladiator: Held){}
    open fun protectiveSpell (gladiator: Held){}

    open fun subtractingHealthPoints (lost: Int, nameAtt: String) {
        this.healthPoints -= lost
        println("$name hat $lost Lebenspunkte durch den Angriff von $nameAtt verloren!")

        if (this.healthPoints <= 0) {
            println("$name ist durch den Angriff von $nameAtt K.O. gegangen.")
            theFin = true
        }
    }



}



// Ritter Class Definition
class Ritter(name: String, healthPoints: Double, impactForce:Double, speed: Int, defValue: Double):Held(name, healthPoints){



    override fun attack (gladiator: Feind){
        val hit = Random.nextInt(1, 101)

        if (theFin) {
            println("$name ist K.O. und kann nicht angreifen!")
        } else {
            if (hit in 1..30) {
                println("$name hat verfehlt!")
            } else {
                gladiator.subtractingHealthPoints(21, this.name)
            }
        }
    }
    override fun sideStep (gladiator: Held){}
    override fun cure (gladiator: Held) {
        val aidkit = Random.nextInt(40, 100)
        healthPoints = healthPoints + aidkit

    }
    override fun protectiveSpell (gladiator: Held){}
}

