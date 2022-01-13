package revision.wp11;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Wp11Application {

	private static final String DEFAULT_PORT = "3000";
	private static final Logger logger = LoggerFactory.
	getLogger(Wp11Application.class);

	public static void main(String[] args) {

		// SpringApplication.run(Wp11Application.class, args);
		SpringApplication app = new SpringApplication(Wp11Application.class);
		

		ApplicationArguments cliArg = new DefaultApplicationArguments(args);
		List<String> cliOpts = cliArg.getOptionValues("port");
		

		String port = null;
		if (cliOpts == null || cliOpts.get(0)== null){
			//retriever from os env variable
			port = System.getenv("PORT");

			if (port == null)
			 port = DEFAULT_PORT;

		} else {
			port = cliOpts.get(0);
		}

		if (port != null){
			app.setDefaultProperties(Collections.singletonMap("server.port", port));
		}
		
		app.run(args);
		logger.info("portNumber is: " + port);
		logger.info("cliOpts is: " + cliOpts);
		
	}

}
