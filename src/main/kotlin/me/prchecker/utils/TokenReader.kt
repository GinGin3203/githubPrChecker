package me.prchecker.utils

import java.io.File

class TokenReader {
    companion object {
        fun readToken() = File("GITHUB_TOKEN").useLines { it.firstOrNull() }
    }
}