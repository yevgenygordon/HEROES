import kotlin.random.Random


// Feind Class Definition
open class Feind {
    var name: String
    var healthPoints: Double
    var theFin: Boolean = false

    constructor(name: String, healthPoints: Double){
        this.name = name
        this.healthPoints = healthPoints
    }

    open fun attack (gladiator: Held){}

    open fun sideStep (gladiator: Feind){}
    open fun curseMagic (gladiator: Held){}

    open fun subtractingHealthPoints (lost: Int, nameAtt: String) {
        this.healthPoints -= lost
        println("$name hat $lost Trefferpunkte durch den Angriff von $nameAtt verloren!")

        if (this.healthPoints <= 0) {
            println("$name ist durch den Angriff von $nameAtt K.O. gegangen.")
            theFin = true
        }
    }




}



// Witch Class Definition

open class Witch (name: String, healthPoints: Double, impactForce: Double, speed: Int, defValue: Double):Feind (name, healthPoints){
    override  fun attack (gladiator: Held){
        val hit = Random.nextInt(1, 101)

        if (this.healthPoints < 0) {
            println("$name ist K.O. und kann nicht angreifen!")
        } else {
            if (hit in 1..30) {
                println("$name hat verfehlt!")
            } else {
                gladiator.subtractingHealthPoints(30, this.name)
            }
        }
    }
    override fun sideStep (gladiator: Feind){}
    override fun curseMagic (gladiator: Held){}

}


// Helper Class Definition

class Helper (name: String, ):Witch(name, healthPoints = 70.0, impactForce = 20.0, speed = 8,70.0){


    fun createHelper (badChoiceListe: MutableList<Any>):String {
        when (this.name) {

            "Dark Lord" -> { }
            "Gini" -> {}
            "Elf Tormentor" -> {}
            "Mermaid Witch" -> {}
            "Dungeon Necromanker" -> {}

        }

        return "ok"
    }


    override  fun attack (gladiator: Held){
        val hit = Random.nextInt(1, 101)

        if (this.healthPoints < 0) {
            println("$name ist K.O. und kann nicht angreifen!")
        } else {
            if (hit in 1..30) {
                println("$name hat verfehlt!")
            } else {
                gladiator.subtractingHealthPoints(30, this.name)
            }
        }
    }



}