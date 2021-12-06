package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company
import org.mockito.MockitoSugar.{mock, when}

/* In the below class, for each test case
* we are mocking CompanyReadDto and EmailValidator upon which CompanyValidator depends,
* Then, While creating an object for CompanyValidator class we passed on the mocked parameter.
* And, then we are matching our arguments combinations by using stub methods (when, thenReturn) using Mockito functions.
* Finally, we are creating a variable in which we are accessing the companyIsValid method
* with the help of object created, then in the parameters we are passing knoldusCompany
 */

class CompanyValidatorTest extends org.scalatest.flatspec.AnyFlatSpec {
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

  val mockedCompanyReadDto = mock[CompanyReadDto]
  val mockedEmail = mock[EmailValidator]


  "Company" should "be a valid as company does not exist in DB and email is valid" in{

    when(mockedCompanyReadDto.getCompanyByName(knoldusCompany.name)) thenReturn(None)
    when(mockedEmail.emailIdIsValid(knoldusCompany.emailId)) thenReturn(true)

    val companyValidator = new CompanyValidator(mockedCompanyReadDto, mockedEmail)
    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(result)

  }

  "Company" should "be a invalid because company does not exist in DB but email is invalid" in{

    when(mockedCompanyReadDto.getCompanyByName(knoldusCompany.name)) thenReturn(None)
    when(mockedEmail.emailIdIsValid(knoldusCompany.emailId)) thenReturn(false)

    val companyValidator = new CompanyValidator(mockedCompanyReadDto, mockedEmail)
    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(!result)
  }

  "Company" should "be a invalid because company exist in the DB and email is valid" in{

    when(mockedCompanyReadDto.getCompanyByName(knoldusCompany.name)) thenReturn(Option(knoldusCompany))
    when(mockedEmail.emailIdIsValid(knoldusCompany.emailId)) thenReturn(true)

    val companyValidator = new CompanyValidator(mockedCompanyReadDto, mockedEmail)
    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(!result)

  }

  "Company" should "be a invalid because company exist and email invalid" in{

    when(mockedCompanyReadDto.getCompanyByName(knoldusCompany.name)) thenReturn(Option(knoldusCompany))
    when(mockedEmail.emailIdIsValid(knoldusCompany.emailId)) thenReturn(false)

    val companyValidator = new CompanyValidator(mockedCompanyReadDto, mockedEmail)
    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(!result)

  }
}
