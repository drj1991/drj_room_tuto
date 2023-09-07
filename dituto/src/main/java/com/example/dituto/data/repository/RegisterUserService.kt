package com.example.dituto.data.repository

class RegisterUserService(
    private val emailService: EmailService,
    private val userService: UserService
) {
    fun createUser(name: String, email: String) {
        userService.saveUser(name, email)
        emailService.sendEmail(email)
    }
}