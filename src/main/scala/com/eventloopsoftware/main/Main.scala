package com.eventloopsoftware.main

import com.eventloopsoftware.javaenum.EnumJava
import io.scalaland.chimney.dsl.*

// uncomment this line and the code will compile...
//val enumJava = EnumJava.ONE

object Main {
  def main(args: Array[String]): Unit = {
    val enumJ: EnumJava = args.headOption.map(it => EnumJava.valueOf(it)).getOrElse(throw new IllegalArgumentException)
    val result = chimneyTransform(enumJ)
    println(result)
  }

  def chimneyTransform(enumJava: EnumJava) = enumJava.transformInto[SealedTraitScala]
}


sealed trait SealedTraitScala
object SealedTraitScala {
  case object ONE extends SealedTraitScala
  case object TWO extends SealedTraitScala
  case object THREE extends SealedTraitScala
}