
import com.eventlooopsoftware.javaenum.EnumJava
import io.scalaland.chimney.Transformer
import io.scalaland.chimney.dsl.*
import io.scalaland.chimney.javacollections.*

// uncomment this line and the code will compile...
//val enumJava = EnumJava.ONE

import scala.collection.compat.*
import scala.collection.immutable.{ListMap, ListSet, SortedMap}
import scala.jdk.CollectionConverters.*
import scala.jdk.OptionConverters.*


sealed trait SealedTraitScala

object SealedTraitScala {
  case object ONE extends SealedTraitScala

  case object TWO extends SealedTraitScala

  case object THREE extends SealedTraitScala
}

given Transformer[java.lang.Integer, Int] = jInt => jInt.toInt

object Main {
  def main(args: Array[String]): Unit = {

    //    val enumJava = EnumJava.ONE
    val number = 1

    val enumJ: EnumJava = args.headOption.map(it => EnumJava.valueOf(it)).getOrElse(throw new IllegalArgumentException)
    val enumJOptional: java.util.Optional[EnumJava] = args.headOption.map(it => java.util.Optional.of(EnumJava.valueOf(it))).getOrElse(throw new IllegalArgumentException)
    val optionalListEnum: java.util.Optional[java.util.List[EnumJava]] = java.util.Optional.of(java.util.Arrays.asList(EnumJava.ONE))
    val optionalListInt: java.util.Optional[java.util.List[java.lang.Integer]] = java.util.Optional.of(java.util.Arrays.asList(java.lang.Integer.valueOf(1)))
    val result = chimneyTransform(enumJ)
    val resultOption = chimneyTransformOption(java.util.Optional.of(number))
    //    val resultOptionListEnum = chimneyTransformOptionListEnum(optionalListEnum)
    val resultOptionListInt = chimneyTransformOptionListInt(optionalListInt)
    println(result)

    val jList = java.util.Optional.of(323).toScala
  }

  def chimneyTransform(enumJava: EnumJava) = enumJava.transformInto[SealedTraitScala]

  //  def chimneyTransformOption(enumJava: java.util.Optional[EnumJava]) = enumJava.transformInto[Option[SealedTraitScala]]
  def chimneyTransformOption(number: java.util.Optional[java.lang.Integer]) = number.transformInto[Option[Int]]

  def chimneyTransformList(number: java.util.List[java.lang.Integer]) = number.transformInto[List[Int]]



//    def chimneyTransformOptionListEnum(optionListEnum: java.util.Optional[java.util.List[EnumJava]]) = {
//      val aap = SealedTraitScala.ONE
//      val geit = EnumJava.ONE
//      optionListEnum.transformInto[Option[List[SealedTraitScala]]]
//    }

  def chimneyTransformOptionListInt(optionListEnum: java.util.Optional[java.util.List[java.lang.Integer]]) =
    optionListEnum.transformInto[Option[List[Int]]]
}


