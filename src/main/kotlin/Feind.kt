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

    open fun diversion (gladiator: Held) {}
    open fun curseMagic (gladiator: Held) {}


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
                gladiator.subtractingHealthPoints(impactForce, name)
                println("Restleben von ${gladiator.name} nach Schwertangriff der Dunkelheit   ${gladiator.healthPoints}")
            }
        }
    }
    override fun diversion (gladiator: Held){
            if (theFin){ println("$name ist K.O. und kann nicht ablenken!") }
            else { gladiator.defValue *= 1.40
                println("Konzentration von ${gladiator.name} nach Ablenkung von $name     ${gladiator.defValue}")
            }
    }
    override fun curseMagic (gladiator: Held){
        if (theFin){ println("$name ist K.O. und kann nicht fluchen!") }
        else {gladiator.healthPoints *= 0.20
            println("Restleben von ${gladiator.name} nach TodesFluch von $name     ${gladiator.healthPoints}")}

        }




}


// Helper Class Definition

class Helper (name: String, ):Witch(name, healthPoints = 70.0, impactForce = 70.0, speed = 8,0.7){

}