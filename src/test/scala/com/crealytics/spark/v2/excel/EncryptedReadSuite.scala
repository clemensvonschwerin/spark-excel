/** Copyright 2016 - 2021 Martin Mauch (@nightscape)
  *
  * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
  * the License. You may obtain a copy of the License at
  *
  * http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
  * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
  * specific language governing permissions and limitations under the License.
  */
package com.crealytics.spark.v2.excel

import com.holdenkarau.spark.testing.DataFrameSuiteBase
import org.apache.spark.sql._
import org.apache.spark.sql.types._
import org.scalatest.funsuite.AnyFunSuite

import scala.collection.JavaConverters._

object EncryptedReadSuite {
  val simpleSchema = StructType(
    List(
      StructField("A", IntegerType, true),
      StructField("B", IntegerType, true),
      StructField("C", IntegerType, true),
      StructField("D", IntegerType, true)
    )
  )

  val expectedData = List(Row(1, 2, 3, 4)).asJava
}

class EncryptedReadSuite extends AnyFunSuite with DataFrameSuiteBase with ExcelTestingUtilities {
  import EncryptedReadSuite._

  lazy val expected = spark.createDataFrame(expectedData, simpleSchema)

  test("read encrypted xslx file") {
    val df = readFromResources(
      spark,
      path = "simple_encrypted.xlsx",
      options = Map(
        "dataAddress" -> "Sheet1!A1",
        "treatEmptyValuesAsNulls" -> true,
        "workbookPassword" -> "fooba",
        "inferSchema" -> true
      )
    )
    assertDataFrameEquals(expected, df)
  }

  test("read encrypted xls file") {
    val df = readFromResources(
      spark,
      path = "simple_encrypted.xls",
      options = Map(
        "dataAddress" -> "Sheet1!A1",
        "treatEmptyValuesAsNulls" -> true,
        "workbookPassword" -> "fooba",
        "inferSchema" -> true
      )
    )
    assertDataFrameEquals(expected, df)
  }
}
