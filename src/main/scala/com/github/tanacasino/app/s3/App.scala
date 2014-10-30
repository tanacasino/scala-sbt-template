package com.github.tanacasino.app.s3

import awscala.Region


object App {

  def main(args: Array[String]) {
    implicit val region = Region.Tokyo
    // Authentication without keys (Use SessionCredential or Env variables or Property)
    implicit val s3 = awscala.s3.S3()
    val buckets = s3.buckets
    buckets.foreach(println)
  }

}
