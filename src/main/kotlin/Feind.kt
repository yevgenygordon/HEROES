import kotlin.random.Random


// Feind Class Definition
open class Feind {
    var defValue: Double
    var impactForce: Double
    var speed: Int
    var name: String
    var healthPoints: Double
    var theFin: Boolean = false
    var nHname: String? = null
    var countDown:Int = 0
    var changeOrNo:Boolean = false

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
    open fun changeName (gladiator: Held) {}





    fun subtractingHealthPoints (lost: Double, nameAtt: String) {
        var minus = lost * this.defValue
        this.healthPoints -=  minus

        println("")
        println("$name hat ${minus} Lebenspunkte durch den Angriff von $nameAtt verloren!")
        println("Restleben von ${name} nach Schwertangriff der Dunkelheit   ${healthPoints}")

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

    override fun changeName (gladiator: Held){
        nHname = gladiator.name
        val nListe:MutableList<String> = mutableListOf("Antipasti","GetBusy","Username","Obi-LAN Kenobi","Regenfrida","Unique Name","Relative Performance","FritzchenBox","Connecto Patronum","Der Gerät","Jutta-Jessica")

        if (theFin){ println("$name ist K.O. und kann nicht demoralisieren!") }
        else {

            gladiator.name = nListe.random()
            println("${nHname} wurde von $name  demoralisiert, und heist jetzt   ${gladiator.name}")}
           changeOrNo = true

    }






}


// Helper Class Definition

class Helper (name: String, ):Witch(name, healthPoints = 70.0, impactForce = 70.0, speed = 8,0.7){

}