package com.project.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Delete {
	public static void delete(Path path) {
		try {
			Files.delete(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
