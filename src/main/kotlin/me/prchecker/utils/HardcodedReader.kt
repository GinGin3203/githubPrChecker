package me.prchecker.utils

import java.io.File

class HardcodedReader {
    companion object {
        fun readToken() = File("GITHUB_TOKEN").useLines { it.firstOrNull() }

        fun readOwner() = File("OWNER").useLines { it.firstOrNull() }

        fun readRepo() = File("REPO").useLines { it.firstOrNull() }
    }
}