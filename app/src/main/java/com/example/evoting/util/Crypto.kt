package com.example.evoting.util

import android.annotation.SuppressLint
import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

class Crypto {
    private val aesSecretKey = "llDtedoYXsH4oZbAOg2qN2RbhVe9laSS"
    private val aesIV = "KjkSlsMCnPv421aj"

    @SuppressLint("NewApi")
    fun encrypt(text: String): String{
        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        val keySpec = SecretKeySpec(aesSecretKey.toByteArray(), "AES")
        val ivSpec = IvParameterSpec(aesIV.toByteArray())
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec)
        val encryptedBytes = cipher.doFinal(text.toByteArray())
        return Base64.getEncoder().encodeToString(encryptedBytes)
    }

}