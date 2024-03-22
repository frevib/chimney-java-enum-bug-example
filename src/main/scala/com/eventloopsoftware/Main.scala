package com.eventloopsoftware

import com.eventlooopsoftware.*
import io.scalaland.chimney.dsl.*
import io.scalaland.chimney.javacollections.*

object Main {
  def main(args: Array[String]): Unit = {
    val personJava = new PersonJava("scala")
    val personScala = PersonScala("scala")

    val resultJavaToScala = javaToScala(personJava)
    val resultScalaToJava = scalaToJava(personScala)


    println(resultJavaToScala.name)
    println(resultScalaToJava.getName)
  }

  // works
  def javaToScala(personJava: PersonJava) = personJava.into[PersonScala].enableBeanGetters.transform

  // doesn't work
  // also, enableBeanSetters or withFieldComputed doesn't help
  def scalaToJava(personScala: PersonScala) = personScala.into[PersonJava].transform

  // works
  def scalaToJavaConstructor(personScala: PersonScala) = personScala
    .into[PersonJava]
    .withConstructor { (name: String) => new PersonJava(name) }
    .transform


}
