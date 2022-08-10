import kotlin.random.Random


// Held Class Definition
abstract class Held {

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


    internal fun setHealthpoints(healthPoints: Double){
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
    open fun cureHeld (gladiator: Held){}
    open fun protectiveSpell (gladiator: Held){}
    open fun magicTrunk (gladiator: Held){}


    open fun subtractingHealthPoints (lost: Double, nameAtt: String) {
        var minus = lost * this.defValue
        this.healthPoints -=  minus
        println("")
        println("")
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
    var neuHP:Double = healthPoints


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
                println()
                println("$name hat verfehlt!")
            } else {
                gladiator.subtractingHealthPoints(impactForce, name)
                println("Restleben von ${gladiator.name} nach heiligen Schwertangriff   ${gladiator.healthPoints}")
                bildNumber.printBild(4)
            }
        }
    }
    override fun sideStep (gladiator: Held){}


    override fun protectiveSpell (gladiator: Held){}
    override fun magicTrunk (gladiator: Held){
        impactForce *= 1.10
        println(" $name hat neue Angrifswert   $impactForce")
        bildNumber.printBild(4)

    }

    override fun cureHeld (gladiator: Held){
        healthPoints *=1.50
        println("$name wurde geheilt, und hat  $healthPoints Punkte Restleben")
        bildNumber.printBild(4)

    }
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