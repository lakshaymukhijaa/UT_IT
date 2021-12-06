package com.knoldus.request

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company
import com.knoldus.validator.{CompanyValidator, EmailValidator}
import org.scalatest.flatspec.AnyFlatSpec

/* In the below class we are performing Integration Testing for CompanyImpl,
* where we are creating an object for CompanyReadDto and EmailValidator class,
* then we creating an object for CompanyValidator class where we are passing above two objects as parameter,
* And, then we are making an object for CompanyImpl class passing above object created as parameter,
* Finally we are accessing createCompany,
* in its parameter we are passing the value defined in each test cases
 */
class CompanyImplIntegrationTest extends AnyFlatSpec {
  val companyReadDto = new CompanyReadDto
  val emailValidator = new EmailValidator
  val companyValidator = new CompanyValidator(companyReadDto, emailValidator)
  val companyImpl = new CompanyImpl(companyValidator)


  "Company" should "be valid" in {
    val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
    val result =  companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }

  "Company" should "be invalid as it already exists in DB" in {
    val googleCompany: Company = Company("Google", "google@gmail.com", "Noida")
    val result =  companyImpl.createCompany(googleCompany)
    assert(!result.isEmpty)
  }

  "Company" should "be invalid as email id is invalid" in {
    val knoldusCompany: Company = Company("Knoldus", "knoldusgmail.com", "Noida")
    val result =  companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }

  "Company" should "be invalid as email id is invalid and company already exists in DB" in {
    val knoldusCompany: Company = Company("knoldus", "knoldusgmail.com", "Noida")
    val result =  companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }


}
