/*
 * Copyright 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.appengine.java8;

import com.google.appengine.api.utils.SystemProperty;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// With @WebServlet annotation the webapp/WEB-INF/web.xml is no longer required.
@WebServlet(name = "HelloAppEngine", value = "/hello")
public class HelloAppEngine extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    Properties properties = System.getProperties();
    
    Logger logger = Logger.getLogger(HelloAppEngine.class.getName());
    
    logger.info("TEST");
    
    System.out.println("Logging Start");
    System.out.println("A TRACE Message");
    System.out.println("A DEBUG Message");
    System.out.println("An INFO Message");
    System.out.println("A WARN Message");
    System.out.println("An ERROR Message");

    response.setContentType("text/plain");
    response.getWriter().println("Hello App Engine - Standard using "
            + SystemProperty.version.get() + " Java "
            + properties.get("java.specification.version"));
  }

  public static String getInfo() {
	  
	    System.out.println("Logging Start 2");
	    System.out.println("A TRACE Message");
	    System.out.println("A DEBUG Message");
	    System.out.println("An INFO Message");
	    System.out.println("A WARN Message");
	    System.out.println("An ERROR Message");
    return "Version: " + System.getProperty("java.version")
          + " OS: " + System.getProperty("os.name")
          + " User: " + System.getProperty("user.name");
  }

}
