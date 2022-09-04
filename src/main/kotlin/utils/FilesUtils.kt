package utils

import com.oracle.tools.packager.IOUtils.copyFile
import java.io.File
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths

class FilesUtils {
    companion object {
        fun readFile(path: String): String {
            val encoded = Files.readAllBytes(Paths.get(path))
            return String(encoded, StandardCharsets.UTF_8)
        }
        fun copy(file: File, path: String) {
            copyFile(file, File(path))
        }
    }
}