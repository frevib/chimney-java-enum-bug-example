
import com.eventlooopsoftware.javaenum.{EnumJava, PersonJava}
import io.scalaland.chimney.Transformer
import io.scalaland.chimney.dsl.*
import io.scalaland.chimney.javacollections.*
import io.scalaland.chimney.javacollections.internal.TransformOrUpcast

// uncomment this line and the code will compile...
//val enumJava = EnumJava.ONE
//val enumJava1 = List(EnumJava.ONE)
//

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
given Transformer[Int, java.lang.Integer] = sInt => sInt
given Transformer[String, java.lang.String] = sString => sString

//given Transformer[java.util.Optional[PersonJava], Option[PersonScala]] = 

//implicit def totalTransformerFromJavaOptionalToScalaOption[A, B](implicit
//                                                                 aToB: TransformOrUpcast[A, B]
//                                                                ): Transformer[java.util.Optional[A], Option[B]] =
//  optional => optional.map[Option[B]](a => Some(aToB.transform(a))).orElseGet(() => None)

//implicit private val intToString: Transformer[EnumJava, SealedTraitScala] = it => it.transformInto[SealedTraitScala]

object Main {
  def main(args: Array[String]): Unit = {

//    implicit val cfg = TransformerConfiguration.default.enableBeanSetters

    val enumJava4 = EnumJava.ONE
    //    val geit = com.eventlooopsoftware.javaenum.PersonJava()
    val number = 1

    val enumJ: EnumJava = args.headOption.map(it => EnumJava.valueOf(it)).getOrElse(throw new IllegalArgumentException)
    val enumJOptional: java.util.Optional[EnumJava] = args.headOption.map(it => java.util.Optional.of(EnumJava.valueOf(it))).getOrElse(throw new IllegalArgumentException)
    //    val optionalListEnum: java.util.Optional[java.util.List[EnumJava]] = java.util.Optional.of(java.util.Arrays.asList(EnumJava.ONE))
    val optionalListInt: java.util.Optional[java.util.List[java.lang.Integer]] = java.util.Optional.of(java.util.Arrays.asList(java.lang.Integer.valueOf(1)))
    val listScala = List(1, 3, 5)

    val result = chimneyTransform(enumJ)
    val resultOption = chimneyTransformOption(java.util.Optional.of(number))
    //    val resultOptionListEnum = chimneyTransformOptionListEnum(optionalListEnum)
    val resultOptionListInt = chimneyTransformOptionListInt(optionalListInt)
    val resultList = chimneyTransformListScala(listScala)
    val resultEnumScala: EnumJava = chimneyTransformEnumScala(SealedTraitScala.TWO)

//    val resultObjectScala: PersonJava = chimneyTransformComplexObjectScala(PersonScala(name = "henk", age = 33))
    println(resultEnumScala)

    val jList = java.util.Optional.of(323).toScala
    
  }

  def chimneyTransform(enumJava: EnumJava) = enumJava.transformInto[SealedTraitScala]

  //    def chimneyTransformOption(enumJava: java.util.Optional[EnumJava]) = enumJava.transformInto[Option[SealedTraitScala]]
  def chimneyTransformOption(number: java.util.Optional[java.lang.Integer]) = number.transformInto[Option[Int]]

  def chimneyTransformOptionEnum(number: java.util.Optional[EnumJava]) = {
    //      val enumJava4 = EnumJava.ONE
    number.map(it => it.transformInto[SealedTraitScala]).transformInto[Option[SealedTraitScala]]
  }

  def chimneyTransformListInt(number: java.util.List[java.lang.Integer]) = number.transformInto[List[Int]]

  //  def chimneyTransformListEnumScala(number: java.util.List[EnumJava]) = number.transformInto[List[SealedTraitScala]]

//  def chimneyTransformComplexObjectScalaSetters(personScala: PersonScala) = personScala.into[PersonJava]
//    .enableBeanSetters
////    .enableBeanGetters
//    .withFieldComputed(_.name, _.name)
////    .withFieldComputed(_.age, it => Int.box(it.age))
//    .transform

  def chimneyTransformComplexObjectScalaConstructor(person: PersonJava) = person.transformInto[PersonScala]

  def chimneyTransformComplexToJava(person: PersonScala) = person.transformInto[PersonJava]

//  def chimneyTransformComplexObjectScala(person: PersonScala): PersonJava = person.into[PersonJava]
//    .withConstructor {
//      (name: String, age: Int) => new PersonJava(name, age)
//    }
//    //    .withFieldComputed(_.age, it => Int.box(it.age))
//    //    .withFieldComputed(_.name, _.name)
//    .transform

  //  def chimneyTransformOptionalComplexObject(personJava: java.util.Optional[PersonJava]) = personJava.transformInto[Option[PersonScala]]

  def chimneyTransformListScala(number: List[Int]) = number.transformInto[java.util.List[java.lang.Integer]]

  def chimneyTransformEnumScala(enumScala: SealedTraitScala): EnumJava = enumScala.transformInto[EnumJava]

  //  def chimneyTransformListEnumScala(enumScala: List[SealedTraitScala]): java.util.List[EnumJava] = (enumScala: List[SealedTraitScala]).transformInto[java.util.List[EnumJava]]


  //  def chimneyTransformOptionListEnum(optionListEnum: java.util.Optional[java.util.List[EnumJava]]) = {
  ////    val aap = SealedTraitScala.ONE
  ////    val geit = EnumJava.ONE
  //    optionListEnum.transformInto[Option[List[SealedTraitScala]]]
  //  }

  def chimneyTransformOptionListInt(optionListEnum: java.util.Optional[java.util.List[java.lang.Integer]]) =
    optionListEnum.transformInto[Option[List[Int]]]
    
    
    
}


