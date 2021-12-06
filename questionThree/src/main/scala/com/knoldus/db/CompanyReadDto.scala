package com.knoldus.db

import com.knoldus.models.Company
import scala.collection.immutable.HashMap

class CompanyReadDto {
  val knoldusCompany: Company= Company("knoldus","knoldus@gmail.com","Noida")
  val olaCompany: Company= Company("OLA","ola@gmail.com","Bangalore")
  val companies: HashMap[String, Company] = HashMap("Knoldus"-> knoldusCompany, "OLA"-> olaCompany )

  def getCompanyByName(name: String): Option[Company] = companies.get(name)


}
