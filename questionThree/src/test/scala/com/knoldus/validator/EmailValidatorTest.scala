package com.knoldus.validator

import org.scalatest.flatspec.AnyFlatSpec

/* In the below class we are executing the test cases for EmailValidator
  * to check if email is valid or invalid
 */
class EmailValidatorTest extends AnyFlatSpec{

  /* Here in each test cases we are declaring
   * an object of class for calling the method
   * and then in method's parameter we are passing values to assert them */

  val emailValidator = new EmailValidator()

  "Email" should "be valid" in {
    val result : Boolean = emailValidator.emailIdIsValid("lakshaymukhija@gmail.com")
    assert(result==true)
  }

  "Email" should "be invalid because @ does not exist " in {
    val result : Boolean = emailValidator.emailIdIsValid("lakshaymukhijagmail.com")
    assert(result==false)
  }

  "Email" should "be invalid because it cannot contain space/tabs" in {
    val result : Boolean = emailValidator.emailIdIsValid("lakshaymukhija  @gmail.com")
    assert(result==false)
  }

  "Email" should "be invalid because of invalid top domain" in {
    val result : Boolean = emailValidator.emailIdIsValid("lakshaymukhija@gmail.xyzy")
    assert(result==false)
  }

  "Email" should "be invalid because email cannot start from any special symbol" in {
    val result : Boolean = emailValidator.emailIdIsValid("-gmail.com")
    assert(result==false)
  }

}
