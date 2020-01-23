package com.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("file:{{inputPath}}?antInclude=*.csv"
				+ "&readLock=changed&readLockTimeout=15000&readLockMinAge=10s&move={{processedPath}}${file:name}&moveFailed={{errorPath}}${file:name}")
						.convertBodyTo(String.class).to("file:{{outputPath}}?fileName=${file:onlyname.noext}.txt")
						.end();

	}

}
