package com.example.zoomodule
import io.github.serpro69.kfaker.Faker

import jdk.jfr.Unsigned

class Zoo (val name: String, val address: String, val animals: MutableList<Animal>) {
    override fun toString(): String{

        val animalString = StringBuilder()

        for (animal in animals){
            animalString.append(animal.toString())
        }
            return "Ime: " + name + ", naslov: " + address + animalString + "\n"
    }
}

class Animal (val age: Int, val name: String,  val species: Species):Comparable<Animal>{
    override fun compareTo(other: Animal): Int {
       return this.age - other.age
    }

    override fun toString(): String {
        return "\n" + "Ime: " + name + ", starost: " + age + ", vrsta: " + species.name
    }
}

class Species (val name: String){
}

fun generateAge( min: Int, max: Int ): Int{
 return(min..max).random()
}

fun main() {

    val faker = Faker()
    val zooAnimals = mutableListOf<Animal>()

    for(i in 1..5){
        val age = generateAge(1, 15)
        val animalName = faker.name.firstName()
        val speciesName = faker.animal.name()
        val animal = Animal(age, animalName, Species(speciesName))
        zooAnimals.add(animal)
    }

    val zivalskiVrt = Zoo("Živalski vrt Ljubljana", "Ulica živali 10", zooAnimals)
    println(zivalskiVrt)
}