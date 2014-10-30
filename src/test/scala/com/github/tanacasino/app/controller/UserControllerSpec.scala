package com.github.tanacasino.app.controller

import com.github.tanacasino.app.service.{User, UserRepository, UserService}
import org.scalatest.FunSpec


class UserControllerSpec extends FunSpec {

  object UserController extends UserController {
    override lazy val repo: UserRepository = new UserRepository {
      override def findAll: List[User] = {
        List(User("1", "user1", "user1@example.com"),
             User("2", "user2", "user2@example.com"),
             User("3", "user3", "user3@example.com"))
      }
    }
  }


  describe("UserController") {
    describe("list users") {
      it("should have 3 people") {
        assert(UserController.list.size == 3)
      }
    }
  }


}