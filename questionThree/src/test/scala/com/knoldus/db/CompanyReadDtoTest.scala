package com.knoldus.db

import org.scalatest.flatspec.AnyFlatSpec;

/* In the below class we are executing the test cases for CompanyReadDtoTest
  * to check if company exist in the database or not
 */

class CompanyReadDtoTest extends AnyFlatSpec  {

  /* Here in each test cases we are declaring
   * an object of class for calling the method
   * and then in method's parameter we are passing values to assert them */

  "Company" should "exist" in{
    val companyReadDto = new CompanyReadDto
    val result = companyReadDto.getCompanyByName("Knoldus")
    assert(!result.isEmpty)
  }

  "Company" should "not exist" in{
    val companyReadDto = new CompanyReadDto
    val result = companyReadDto.getCompanyByName("Google")
    assert(result.isEmpty)
  }

}
