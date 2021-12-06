package com.knoldus.questionOneTest

import org.scalatest.flatspec.AnyFlatSpec
import com.knoldus.questionOne.Password

/* In this class we are running our test cases for password class so that
  * we can check isPasswordValid method is executing correctly or not
 */
class PasswordTest extends AnyFlatSpec {

  "password" should "be valid" in {
    val password = new Password()
    assert(password.isPasswordValid("Lak@12300"))

  }

  "password" should "invalid if we have any blank space/tabs" in {
    val password = new Password()
    assert(!password.isPasswordValid("Lakshay Mukhija@123"))
  }

  "password" should "invalid if we do not have at least one digit" in {
    val password = new Password()
    assert(!password.isPasswordValid("Laks@Muk"))
  }

  "password" should "invalid if it is less than length 8" in {
    val password = new Password()
    assert(!password.isPasswordValid("LakshayMuk34"))
  }

  "password" should "invalid if we do not have at least one lowercase" in {
    val password = new Password()
    assert(!password.isPasswordValid("LAKSHAY@123"))
  }

  "password" should "invalid if it is more than length 15" in {
    val passowrd = new Password()
    assert(!passowrd.isPasswordValid("LakshayMukhija@123"))
  }

  "password" should "invalid if we do not have at least one Uppercase " in {
    val password = new Password()
    assert(!password.isPasswordValid("lakshaymukija@1234"))
  }

  "password" should "invalid if we do not have any special symbol" in {
    val password = new Password()
    assert(!password.isPasswordValid("lakshay1234"))
  }
}
