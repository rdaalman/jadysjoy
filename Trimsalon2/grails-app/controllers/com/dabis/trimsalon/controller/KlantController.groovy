package com.dabis.trimsalon.controller

class KlantController {

    def scaffold = com.dabis.trimsalon.model.Klant
	
	def logout = {
		flash.message = "Goodbye ${session.user.login}"
		session.user = null
		redirect(controller:"user", action:"login")
	  }
	
	def beforeInterceptor = [action:this.&auth]
		
	def auth() {
		if(!session.user) {
		  redirect(controller:"user", action:"login")
		  return false
		}
    }
	
	}