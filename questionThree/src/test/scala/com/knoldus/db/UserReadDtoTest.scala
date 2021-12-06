package com.knoldus.db

import org.scalatest.flatspec.AnyFlatSpec

/* In the below class we are executing the test cases for UserReadDtoTest
  * to check if user exist in the database or not
 */
class UserReadDtoTest extends AnyFlatSpec {

  /* Here in each test cases we are declaring
   * an object of class for calling the method
   * and then in method's parameter we are passing values to assert them */

  "User" should "exist" in{
    val userReadDto = new UserReadDto
    val result = userReadDto.getUserByName("Lakshay")
    assert(!result.isEmpty)
  }

  "User" should "not exist" in{
    val userReadDto = new UserReadDto
    val result = userReadDto.getUserByName("Shitij")
    assert(result.isEmpty)
  }

}
