package HelloWorld;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
 
	public static void main(String[] args) throws NoSuchMethodException, ScriptException, IOException, InterruptedException {
		SpringApplication.run(Application.class, args);
		runNode();
	}
	public static void runNode() throws IOException, InterruptedException {
		
		String commands = "node index.js";
		File dir = new File("C:\\Users\\verbe\\eclipse-workspace\\MP3Speler\\src\\main\\resources\\templates");
		Process process = Runtime.getRuntime().exec(commands, null, dir);
		

		
		
		
	}
}