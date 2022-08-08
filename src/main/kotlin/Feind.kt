import kotlin.random.Random


// Feind Class Definition
open class Feind {
    var defValue: Double
    var impactForce: Double
    var speed: Int
    var name: String
    var healthPoints: Double
    var theFin: Boolean = false

    constructor(name: String, healthPoints: Double,impactForce: Double, speed: Int, defValue: Double){
        this.name = name
        this.healthPoints = healthPoints
        this.defValue = defValue
        this.impactForce =impactForce
        this.speed = speed
    }

    fun setHealthpoints(healthPoints: Double){
        this.healthPoints = healthPoints
    }

    internal fun getHealthPoints(): Double{
        return this.healthPoints
    }
    internal fun getName(): String{
        return this.name
    }

    open fun attack (gladiator: Held){}

    open fun sideStep (gladiator: Feind){}
    open fun curseMagic (gladiator: Held){}


    fun subtractingHealthPoints (lost: Double, nameAtt: String) {
        var minus = lost * this.defValue
        this.healthPoints -=  minus
        println("$name hat ${minus} Lebenspunkte durch den Angriff von $nameAtt verloren!")

        if (this.healthPoints <= 0) {
            println("$name ist durch den Angriff von $nameAtt K.O. gegangen.")
            theFin = true
        }
    }




}



// Witch Class Definition

open class Witch (name: String, healthPoints: Double, impactForce: Double, speed: Int, defValue: Double):Feind (name, healthPoints, impactForce, speed, defValue){

    var iF:Double = impactForce
    var dV:Double = defValue


    override fun attack (gladiator: Held){
        val hit = Random.nextInt(1, 101)

        if (theFin) {
            println("$name ist K.O. und kann nicht angreifen!")
        } else {
            if (hit in 1..15) {
                println("$name hat verfehlt!")
            } else {
                gladiator.subtractingHealthPoints(this.impactForce, this.name)
            }
        }
    }
    override fun sideStep (gladiator: Feind){}
    override fun curseMagic (gladiator: Held){}

}


// Helper Class Definition

class Helper (name: String, ):Witch(name, healthPoints = 70.0, impactForce = 20.0, speed = 8,70.0){

}