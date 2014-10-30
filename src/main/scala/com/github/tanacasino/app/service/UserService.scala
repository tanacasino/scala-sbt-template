package com.github.tanacasino.app.service


final case class User(id: String, name: String, email: String)

class UserRepository {
  def findAll: List[User] = {
    List(User("1", "user1", "user1@example.com"),
      User("2", "user1", "user1@example.com"))
  }
}

class UserService(repo: UserRepository) {
  def findAll = repo.findAll
}

trait UserComponent {
  lazy val repo = new UserRepository
  lazy val service = new UserService(repo)
}
