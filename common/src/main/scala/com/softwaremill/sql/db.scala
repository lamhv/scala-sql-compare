package com.softwaremill.sql

import org.flywaydb.core.Flyway

trait DbSetup {
  val connectionString = "jdbc:postgresql:mom_baby"

  def dbSetup(): Unit = {
    val flyway = Flyway.configure().cleanDisabled(false)
      .dataSource(connectionString, "lamhv", "lamhv@123").load()
    //flyway.setDataSource(connectionString, "lamhv", "lamhv@123")
    flyway.clean()
    flyway.migrate()
  }
}