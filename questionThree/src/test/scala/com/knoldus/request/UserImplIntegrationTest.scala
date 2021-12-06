package com.knoldus.request

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.User
import com.knoldus.validator.{EmailValidator, UserValidator}
import org.scalatest.flatspec.AnyFlatSpec

/* In the below class we are performing Integration Testing for UserImpl,
* where we are creating an object for CompanyReadDto and EmailValidator class,
* then we creating an object for UserValidator class where we are passing above two objects as parameter,
* And, then we are making an object for UserImpl class passing above object created as parameter,
* Finally we are accessing createUser,
* in its parameter we are passing the value defined in each test cases
 */
class UserImplIntegrationTestextends extends AnyFlatSpec {
  val companyReadDto = new CompanyReadDto
  val emailValidator = new EmailValidator
  val userValidator = new UserValidator(companyReadDto, emailValidator)
  val userImpl = new UserImpl(userValidator)

  "User" should "be valid" in {
    val lakshayUser : User = User("Lakshay", "Mukhija", 21, 6000000, "Software Developer" ,"Knoldus", "lakshay.mukhija@knoldus.com")
    val result =  userImpl.createUser(lakshayUser)
    assert(!result.isEmpty)
}

  "User" should "be invalid as it company does not exists in DB" in {
    val shitijUser : User = User("Shitij", "Narang", 24, 5000000, "Software Developer" ,"Grapecity", "shitijnarang404@gmail.com")
    val result =  userImpl.createUser(shitijUser)
    assert(result.isEmpty)
}

  "User" should "be invalid as email id is invalid" in {
    val lakshayUser : User = User("Lakshay","Mukhija", 21, 6000000, "Software Developer" ,"Knoldus", "lakshay.mukhija...knoldus.com")
    val result = userImpl.createUser(lakshayUser)
    assert(result.isEmpty)
}

  "User" should "be invalid as email id is invalid and company does not exists in DB" in {
    val lakshayUser : User = User("Lakshay", "Mukhija", 21, 6000000, "Software Devloper" ,"Knoldus", "lakshay@knoldus.xyz")
    val result =  userImpl.createUser(lakshayUser)
    assert(result.isEmpty)
}
}