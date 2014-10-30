package com.github.tanacasino.app.controller

import com.github.tanacasino.app.service.UserComponent


trait UserController extends UserComponent {

  def list = {
    service.findAll
  }

}

object UserController extends UserController
