import kotlin.random.Random


// Held Class Definition
open class Held {

    var defValue: Double
    var impactForce: Double
    var speed: Int
    var name: String
    var healthPoints: Double
    var theFin: Boolean = false


    constructor(name: String, healthPoints: Double, impactForce: Double, speed: Int, defValue: Double){
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


    open fun attack (gladiator: Feind){}

    open fun sideStep (gladiator: Held){}
    open fun cure (gladiator: Held){}
    open fun protectiveSpell (gladiator: Held){}

    open fun subtractingHealthPoints (lost: Double, nameAtt: String) {
        var minus = lost * this.defValue
        this.healthPoints -=  minus
        println("$name hat ${minus} Lebenspunkte durch den Angriff von $nameAtt verloren!")

        if (this.healthPoints <= 0) {
            println("$name ist durch den Angriff von $nameAtt K.O. gegangen.")
            theFin = true
        }
    }



}



// Ritter Class Definition
class Ritter(name: String, healthPoints: Double, impactForce: Double, speed: Int, defValue: Double):Held(name, healthPoints, impactForce, speed, defValue){

    var iF:Double = impactForce


   /* fun getdV(): Double{
        return this.dV
    }

    */

    override fun attack (gladiator: Feind){
        val hit = Random.nextInt(1, 101)

        if (theFin) {
            println("$name ist K.O. und kann nicht angreifen!")
        } else {
            if (hit in 1..15) {
                println("$name hat verfehlt!")
            } else {
                gladiator.subtractingHealthPoints(iF, this.name)
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



// Helper Class Bag

/*
class Bag (healingPotion:Int, vitamine:Int, gladiator: Held):Ritter(gladiator.name,gladiator.healthPoints, gladiator.impactForce,gladiator.speed, gladiator.defValue){

    var applied:Boolean = false
   fun getHealing (healingPotion: Int, gladiator: Held):Boolean{

       gladiator.healthPoints = gladiator.healthPoints + (gladiator.healthPoints /2)

       applied = true
       return applied

   }

    fun getVitamine (healingPotion: Int, gladiator: Held): Boolean {
      gladiator.impactForce = gladiator.impactForce?.times(1.10)
        applied = true
        return applied
    }


}

 */